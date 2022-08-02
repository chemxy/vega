import { domain } from '../../models/constants.js';
import { doPost } from '../BaseAPI.js';
import { debugLog } from '../../utils.js';

export function login(userInfo) {
	debugLog("In Auth///////", userInfo);
	return doPost("http://" + domain + ":8000/api/login", userInfo);
}