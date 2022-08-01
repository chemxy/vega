import {doPostFile, doGet} from './HTTPRequestAPI.js';
import { debugLog } from '../utils.js';

export function fetchusers(url, headers){
	debugLog(headers);
	return doGet(url, headers['authorization'])
}

export function enableAccount(url, headers){
	debugLog(headers);
	debugLog(url);
	return doGet(url, headers['authorization'])
}

export function changeRole(url,headers){
	debugLog(url);
	return doGet(url, headers['authorization'])
}