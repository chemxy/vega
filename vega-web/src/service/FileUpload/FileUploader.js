import { doPostFile, doGet } from '../BaseAPI.js';
import { domain } from '../../models/constants.js';
// import { console.log } from '../../../server/utils.js';

export function fileUploader(fileInfo, token) {
	console.log("In File Uploader", token);
	return doPostFile("http://" + domain + ":8000/api/venus/upload", fileInfo, token);
}

export function fetchFiles(token) {
	console.log("fetchFiles", token);
	return doGet("http://" + domain + ":8000/api/venus/listfiles", token)
}

export function fetchData(name, token) {
	return doGet("http://" + domain + ":8000/api/venus/fetchcontent?name=" + name, token)
}