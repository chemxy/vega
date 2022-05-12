import {useState, useContext} from 'react';
import UserRegistrationPageLayout from '../templates/UserRegistrationPageLayout.js';
import LoginUser from '../UI/organisms/LoginUser.js';
import {login} from '../../service/auth/AuthenticationManager.js';

import {UserContext} from '../../auth/UserProvider.js';
import  { Redirect } from 'react-router-dom'

const Login = (props) => {
	
	const { context } = props; 
	const {user, setUserInfo,logout} = useContext(UserContext);
	const [auth, setAuth] = useState(false);
	console.log("Userinfo", user);
	function onSubmit(userInfo){
		login(userInfo)
			.then(res => {
				console.log("Response", res);
				console.log(res.jwt);
				var role = res.authorities[0].authority;
				setUserInfo(userInfo.username, res.jwt, role)
				setAuth(true);
			})
	}

		if(!auth){
			return (
				<UserRegistrationPageLayout>
					<LoginUser onSubmit={onSubmit}/>
				</UserRegistrationPageLayout>
			);
		} else {
			return <Redirect to='/' />;
		}
}

export default Login;