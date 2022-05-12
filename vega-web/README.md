## Frontend

Frontend is written using React framework. To start the application use below command.

`npm start`

This will deploy the applciation at 3000 port. 

## Images

All the images that are used in frontend applcation will be found under src/assets/images folder.

## Server

React frontend talks to backend which is written in nodejs "express.js". All the source code is under server folder.

To start the application, run below command in the terminal.

`npm start`

This will deploy the application at port 8000. The same configuration you can find in the file named "index.js" under the server folder. All the depedecies are declared in the package.json file. 

## Type of users (for login) 
- Public (can see only the public site)
- Registered users (user can register account and use scaled down pla.orm service)
- Staff
- Admin

## Admin Duties
- Enable Registered Users
- Can change Role of registered User to "Staff" or "User"
- Upload Files at Resource tab

## Staff
- Use Platform services
- Check resources tab to see uploaded files by admin


