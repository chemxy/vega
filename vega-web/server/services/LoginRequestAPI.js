import {doPost} from './HTTPRequestAPI.js';

export function login(url, data){
	return doPost(url, data);
}