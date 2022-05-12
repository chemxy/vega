import {doPostFile, doGet} from './HTTPRequestAPI.js';

export function uploader(url, data, headers){
	return doPostFile(url, data, headers);
}
export function listFiles(url, headers){
	console.log(headers);
	return doGet(url, headers['authorization'])
}

export function fetchcontent(url, headers){
	return doGet(url, headers['authorization'])
}