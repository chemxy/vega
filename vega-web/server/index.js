import auth from './auth/AuthenticationManager.js';
import fileUploader from './controller/FileUploadController.js';
import adminPanel from './controller/AdminPanelController.js'
import express from 'express';
import { config } from 'dotenv';
import cors from 'cors';
import bodyParser from 'body-parser';
import fs from 'fs'
import { doPost } from './services/HTTPRequestAPI.js';

const app = express();
const port = 8000;
const env = config();

//app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.json({ limit: '50mb' }));

if (process.env.NODE_ENV === 'development') {
  var corsOptions = {
    origin: 'http://localhost:3000',
    optionsSuccessStatus: 200
  };
  app.use(cors(corsOptions));
}

app.get('/', (req, res) => {
  res.send('Hello World!')
});


app.use("/api/login", auth);
app.use("/api/venus", fileUploader)
app.use("/api/venus/admin", adminPanel)


app.get("/api/venus/get-news", (req, res) => {
  let newsList;
  fs.readFile('./newsList.json', "utf8", (err, jsonString) => {
    if (err) {
      console.log("File read failed:", err);
      return;
    }
    newsList = jsonString;
    // console.log(newsList);
    // console.log("sending news list")
    res.send(newsList)
  })
})

app.post("/api/venus/edit-news", (req, res) => {
  let newsList;
  fs.readFile('./newsList.json', "utf8", (err, jsonString) => {
    if (err) {
      console.log("File read failed:", err);
      return;
    }
    newsList = JSON.parse(jsonString);
    // console.log(newsList);
    const id = req.body.id;
    const modifiedNews = req.body.content;
    newsList[id] = modifiedNews;
    // console.log(newsList)
    fs.writeFile("./newsList.json", JSON.stringify(newsList), err => {
      if (err) console.log("Error writing file:", err);
      res.send('OK: news updated');
    });
  })
})

app.post("/api/venus/add-news", (req, res) => {
  let newsList;
  fs.readFile('./newsList.json', "utf8", (err, jsonString) => {
    if (err) {
      console.log("File read failed:", err);
      return;
    }
    newsList = JSON.parse(jsonString);
    // console.log(newsList);
    const newsToAdd = req.body;
    newsList.push(newsToAdd);
    // console.log(newsList)
    fs.writeFile("./newsList.json", JSON.stringify(newsList), err => {
      if (err) console.log("Error writing file:", err);
      res.send('OK: news added');
    });
  })
})

app.post("/api/venus/delete-news", (req, res) => {
  let newsList = [];
  fs.readFile('./newsList.json', "utf8", (err, jsonString) => {
    if (err) {
      console.log("File read failed:", err);
      return;
    }
    let originalNewsList = JSON.parse(jsonString);
    // console.log(newsList);
    const newsId = req.body.id;
    for (let i = 0; i < originalNewsList.length; i++) {
      if (i != newsId) {
        newsList.push(originalNewsList[i]);
      }
    }
    // console.log(newsList)
    fs.writeFile("./newsList.json", JSON.stringify(newsList), err => {
      if (err) console.log("Error writing file:", err);
      res.send('OK: news deleted');
    });
  })
})

app.post("/api/venus/register", (req, res) => {

  doPost('http://localhost:8080/venus/register', req.body).then(res => {
    res.send(res);
  })
    .catch(error => {
      console.log("ERROR:", error);
      res.send(error);
    })
})

app.listen(port, () => {
  console.log(process.env.API_URL);
  console.log(`Example app listening on port ${port}!`)
});