import bodyParser from 'body-parser';
import express from 'express';
import {uploader, listFiles, fetchcontent} from '../services/FileHandlerAPI.js';
import fileUpload from 'express-fileupload';
import debugLog from './utils.js';

let router = express();

//router.use(bodyParser.json({'limit':'20mb'}));

router.use(fileUpload({
  limits: { fileSize: 50 * 1024 * 1024 },
}));


router.post("/upload", (req,res) => {
	var formData = req.files;
    debugLog("Entered into File uploader", formData)
    uploader("http://localhost:8080/venus/admin/handlefileupload", formData, req.headers)
    		.then(response => {
    			debugLog("Response", response);
    			res.send(response);
    		})
    		.catch(error => {
    			debugLog("ERROR:", error);
    			res.send(error);
    		})
})

router.get("/listfiles", (req, res) => {
	debugLog("Entered list files");
	listFiles("http://localhost:8080/venus/files/listfiles", req.headers)
	.then(response => {
    	debugLog("Response", response);
    	res.send(response);
    })
    .catch(error => {
    	debugLog("ERROR:", error);
    	res.send(error);
    })
})

router.get("/fetchcontent", (req, res) => {
	debugLog("Fetch Content")
	const {name} = req.query
	debugLog(name)
	fetchcontent("http://localhost:8080/venus/files/fetch/"+name, req.headers)
	.then(response => {
    	debugLog("Response", response);
    	res.send(response);
    })
    .catch(error => {
    	debugLog("ERROR:", error);
    	res.send(error);
    })

})

export default router;