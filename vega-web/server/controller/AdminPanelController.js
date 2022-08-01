import bodyParser from 'body-parser';
import express from 'express';
import {fetchusers, enableAccount, changeRole} from '../services/AdminPanelAPI.js';
import fileUpload from 'express-fileupload';
import debugLog from './utils.js';

let router = express();

//router.use(bodyParser.json({'limit':'20mb'}));

router.use(fileUpload({
  limits: { fileSize: 50 * 1024 * 1024 },
}));

router.get("/getusers", (req, res) => {
	debugLog("Entered list files");
	fetchusers("http://localhost:8080/venus/admin/fetchusers", req.headers)
	.then(response => {
    	debugLog("Response", response);
    	res.send(response);
    })
    .catch(error => {
    	debugLog("ERROR:", error);
    	res.send(error);
    })
})

router.get("/enableuser", (req, res) => {
	debugLog("Request: Enable User");
	const {username} = req.query;
	const {enable} = req.query;
	enableAccount(`http://localhost:8080/venus/admin/enableuser?username=${username}&enable=${enable}`, req.headers)
	.then(response => {
    	debugLog("Response", response);
    	res.send(response);
    })
    .catch(error => {
    	debugLog("ERROR:", error);
    	res.send(error);
    })
})

router.get("/changerole", (req, res) => {
	debugLog("Request: Change Role")
	const {username} = req.query;
	const {role} = req.query;
	changeRole(`http://localhost:8080/venus/admin/changerole?username=${username}&role=${role}`, req.headers)
	.then(response => {
		debugLog("Response", response);
		res.send(response);
	})
	.catch(error => {
		debugLog("ERROR:", error);
		res.send(error)
	})
})

export default router;