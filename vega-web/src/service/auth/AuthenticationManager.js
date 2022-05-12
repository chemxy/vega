import {doPost} from '../BaseAPI.js';

export function login(userInfo){
	console.log("In Auth", userInfo);
	return doPost("http://localhost:8000/api/login", userInfo);
}