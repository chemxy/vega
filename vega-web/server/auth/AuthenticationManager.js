import bodyParser from 'body-parser';
import express from 'express';
import { login } from '../services/LoginRequestAPI.js';
import { debugLog } from '../utils.js';

function authModule(req, res) {
	if (req.method == 'POST') {
		const userInfo = req.body;
		debugLog(userInfo);
		login("http://localhost:8080/venus/authenticate", userInfo)
			.then(response => {
				debugLog("Response", response);
				res.send(response);
			})
			.catch(error => {
				debugLog("ERROR:", error);
				res.send(error);
			})
	}
}

export default authModule;