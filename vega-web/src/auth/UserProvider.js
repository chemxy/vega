import React, { createContext, useState, useEffect } from 'react';
const UserContext = createContext({
  user :'',
  setUserInfo: () => {},
  logout: () => {}
});

const UserProvider = ({children}) => {
	// User is the name of the "data" that gets stored in context
  	const [user, setUser] = useState({ username: '', jwt:'' , role: ''});

  	useEffect(() => {
      const username =  window.localStorage.getItem("username");
      const jwt =  window.localStorage.getItem("jwt");
      const role =  window.localStorage.getItem("role");
      if(username && jwt){
        setUser({
          username: username,
          jwt: jwt,
          role: role
        })
      }
    }, [])

    // Login updates the user data with a name parameter
  	const setUserInfo = (name, jwt, role) => {
    	console.log("SetUserInfo called");
      setUser((user) => ({
      		username: name,
      		jwt: jwt,
          role: role
    	}));
      console.log(user)
      window.localStorage.setItem("username", name);
      window.localStorage.setItem("jwt", jwt);
      window.localStorage.setItem("role", role);
  	};
    // Get Logged in User info
    const getUserInfo = () => {
      return window.localStorage.getItem("jwt");
    }

  	// Logout updates the user data to default
  	const logout = () => {
    	setUser((user) => ({
      		username: '',
      		jwt: '',
          role: ''
    	}));
      window.localStorage.setItem("username", "");
      window.localStorage.setItem("jwt","");
      window.localStorage.setItem("role","");
  	};
    console.log("Rendering context provider");
	return (

    	<UserContext.Provider value={{ user, setUserInfo, logout }}>
      		{children}
    	</UserContext.Provider>
  	);
}

export {
  UserProvider, 
  UserContext
}