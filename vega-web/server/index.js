import auth from './auth/AuthenticationManager.js';
import fileUploader from './controller/FileUploadController.js';
import adminPanel from './controller/AdminPanelController.js'
import express from 'express';
import session from 'express-session'
import helmet from 'helmet';
import { config } from 'dotenv';
import cors from 'cors';
import bodyParser from 'body-parser';
import fs from 'fs'
import { doPost } from './services/HTTPRequestAPI.js';
import { debugLog } from './utils.js';

const app = express();
const port = 8000;
const env = config();

//app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.json({ limit: '50mb' }));
app.set('trust proxy', 1) // trust first proxy
app.use(session({
  secret: "secret",
  resave: false,
  saveUninitialized: true,
  cookie: {
      httpOnly: true,
      secure: true
  }
}))

/// Use Hemlmet middleware to handle App security (Headers).
//app.use(helmet());
app.use(  
  helmet.contentSecurityPolicy({
    directives: {
      "font-src": ["'self'"],
      "style-src": ["'self'"],
    },
  })
);
app.use(helmet.noSniff());
app.use(helmet.hidePoweredBy());
// if (process.env.NODE_ENV === 'development') {
var corsOptions = {
  origin: '*',
  methods: ['GET','POST'],
  optionsSuccessStatus: 200
};
debugLog("use cors")
app.use(cors(corsOptions));
// }

app.get('/', cors(corsOptions), (req, res) => {
  res.send('Hello World!')
});


app.use("/api/login", cors(corsOptions), auth);
app.use("/api/venus",cors(corsOptions), fileUploader)
app.use("/api/venus/admin", cors(corsOptions),adminPanel)


app.get("/api/venus/get-news", (req, res) => {
  let newsList;
  fs.readFile('./newsList.json', "utf8", (err, jsonString) => {
    if (err) {
      debugLog("File read failed:", err);
      return;
    }
    newsList = jsonString;
    // debugLog(newsList);
    // debugLog("sending news list")
    res.send(newsList)
  })
})

app.post("/api/venus/edit-news", (req, res) => {
  let newsList;
  fs.readFile('./newsList.json', "utf8", (err, jsonString) => {
    if (err) {
      debugLog("File read failed:", err);
      return;
    }
    newsList = JSON.parse(jsonString);
    // debugLog(newsList);
    const id = req.body.id;
    const modifiedNews = req.body.content;
    newsList[id] = modifiedNews;
    // debugLog(newsList)
    fs.writeFile("./newsList.json", JSON.stringify(newsList), err => {
      if (err) debugLog("Error writing file:", err);
      res.send('OK: news updated');
    });
  })
})

app.post("/api/venus/add-news", (req, res) => {
  let newsList;
  fs.readFile('./newsList.json', "utf8", (err, jsonString) => {
    if (err) {
      debugLog("File read failed:", err);
      return;
    }
    newsList = JSON.parse(jsonString);
    // debugLog(newsList);
    const newsToAdd = req.body;
    newsList.push(newsToAdd);
    // debugLog(newsList)
    fs.writeFile("./newsList.json", JSON.stringify(newsList), err => {
      if (err) debugLog("Error writing file:", err);
      res.send('OK: news added');
    });
  })
})

app.post("/api/venus/delete-news", (req, res) => {
  let newsList = [];
  fs.readFile('./newsList.json', "utf8", (err, jsonString) => {
    if (err) {
      debugLog("File read failed:", err);
      return;
    }
    let originalNewsList = JSON.parse(jsonString);
    // debugLog(newsList);
    const newsId = req.body.id;
    for (let i = 0; i < originalNewsList.length; i++) {
      if (i != newsId) {
        newsList.push(originalNewsList[i]);
      }
    }
    // debugLog(newsList)
    fs.writeFile("./newsList.json", JSON.stringify(newsList), err => {
      if (err) debugLog("Error writing file:", err);
      res.send('OK: news deleted');
    });
  })
})

app.post("/api/venus/register", (req, res) => {

  //Input Validation
  const {reqQuery} = req.params;  
  const validPattern = /^[A-Za-z]+$/;

  if(!reqQuery.match(validPattern)){
    return res.status(400).json({ err: "Invalid input."})
  }

  doPost('http://localhost:8080/venus/register', req.body).then(res => {
    res.send(res);
  })
    .catch(error => {
      debugLog("ERROR:", error);
      res.send(error);
    })
})

app.listen(port, () => {
  debugLog(process.env.API_URL);
  debugLog(`Example app listening on port ${port}!`)
});