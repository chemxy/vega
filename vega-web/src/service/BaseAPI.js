import { UserProvider } from '../auth/UserProvider.js';
import { debugLog } from '../utils.js';

function getUserToken() {
  return UserProvider;
}

export async function handleResponse(response, isBlob = false) {
  let result;
  if (isBlob) {
    result = await response.blob();
  } else {
    result = handleResult(await response.text());
  }
  if (response.ok) {
    return result;
  }
  // handle error
  return Promise.reject({
    code: response.status,
    message: result && result.message ? result.message : response.statusText
  });
}

export async function doGet(url, token) {
  const response = await fetch(url, {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + token,
      'Access-Control-Allow-Origin': '*'
    }
  });
  return await handleResponse(response);
}


export async function doPost(url, data) {
  debugLog('Request data:', data);
  const response = await fetch(url, {
    method: 'POST',
    headers: {
      "Content-Type": "application/json",
      'Access-Control-Allow-Origin': '*'
    },
    body: JSON.stringify(data),
  });
  return await handleResponse(response);
}

export async function doPostWithToken(url, data, token) {
  debugLog(getUserToken());
  debugLog('Request data:', data);
  const response = await fetch(url, {
    method: 'POST',
    headers: {
      'Authorization': 'Bearer ' + token,
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data),
  });

  return await handleResponse(response);
}

export async function doPostFile(url, data, token) {
  debugLog(getUserToken());
  debugLog('Request data:', data);
  const response = await fetch(url, {
    method: 'POST',
    headers: {
      'Authorization': 'Bearer ' + token,
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data),
  });

  return await handleResponse(response);
}

function handleResult(value) {
  try {
    return JSON.parse(value);
  } catch (error) {
    return value;
  }
}