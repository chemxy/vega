import {doPostFile, doGet} from '../BaseAPI.js';

export function fileUploader(fileInfo, token){
	console.log("In File Uploader", token);
	return doPostFile("http://localhost:8000/api/venus/upload", fileInfo, token);
}

export function fetchFiles(token){
	console.log("fetchFiles", token);
	return doGet("http://localhost:8000/api/venus/listfiles", token)
}

export function fetchData(name, token){
	return doGet("http://localhost:8000/api/venus/fetchcontent?name="+name, token)
}