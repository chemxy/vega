import { domain } from '../../models/constants.js';
import { doPost } from '../BaseAPI.js';
export function login(userInfo) {
	console.log("In Auth///////", userInfo);
	return doPost("http://" + domain + ":8000/api/login", userInfo);
}