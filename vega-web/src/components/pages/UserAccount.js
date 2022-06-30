import { useState, useContext } from 'react';
import { useHistory } from "react-router-dom";
import { Button, Row, Col } from 'react-bootstrap';
import SimplePageLayout from '../templates/SimplePageLayout.js';
import ListRoundedImages from '../UI/molecules/ListRoundImages.js';
import { UserContext } from '../../auth/UserProvider.js';


const UserAccount = (props) => {
	const { user, setUserInfo, logout } = useContext(UserContext);
	const history = useHistory();

	const logoutAndRouteChange = () => {
		logout();
		history.push("/");
	}

	return (
		<SimplePageLayout>
			<Row>
				<Col sm={6} id="account-container">
					<p>Hello,</p>
					<p id="account-username">{user.username}</p>
					<Button id="account-signout-button" onClick={logoutAndRouteChange} size="sm">signout</Button>
				</Col>
			</Row>
		</SimplePageLayout>
	);
}
export default UserAccount;