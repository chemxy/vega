import {doPostFile, doGet} from './HTTPRequestAPI.js';
import { debugLog } from '../utils.js';

export function uploader(url, data, headers){
	return doPostFile(url, data, headers);
}
export function listFiles(url, headers){
	debugLog(headers);
	return doGet(url, headers['authorization'])
}

export function fetchcontent(url, headers){
	return doGet(url, headers['authorization'])
}