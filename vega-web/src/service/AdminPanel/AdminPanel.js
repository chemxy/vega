import {doPostFile, doGet} from '../BaseAPI.js';

export function fetchuser(token){
	return doGet("http://localhost:8000/api/venus/admin/getusers", token)
}

export function enableAccount(username,token){
	return doGet("http://localhost:8000/api/venus/admin/enableuser?enable=true&username="+username, token)	
}

export function changeAccountRole(username, role, token){
	return doGet("http://localhost:8000/api/venus/admin/changerole?username="+username+"&role="+role, token)
}