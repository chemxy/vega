import SimplePageLayout from '../templates/SimplePageLayout.js';
import { fetchuser, enableAccount, changeAccountRole } from '../../service/AdminPanel/AdminPanel.js';
import { UserContext } from '../../auth/UserProvider.js';
import { useState, useContext, useEffect } from 'react';

import { Form, Button, Row, Col, Table } from 'react-bootstrap';
import { debugLog } from '../../utils.js';

const AdminPanel = (props) => {
	const { user } = useContext(UserContext);
	const [listOfUsers, setUsers] = useState([]);
	useEffect(() => {
		debugLog("Inside useEffect")
		fetchuser(user.jwt)
			.then(resp => {
				setUsers(resp)
			});


	}, [user]);

	const enableUser = (username) => {
		debugLog("Enable User called with", username)
		enableAccount(username, user.jwt)
			.then(resp =>
				debugLog("User enabled"))
	}


	const changeRole = (evt, username) => {
		debugLog(evt.target.value, username)
		var role = evt.target.value
		changeAccountRole(username, role, user.jwt)
			.then(resp =>
				debugLog("Changed Roles"))
	}

	const listOfUsersHTML = () => {
		if (listOfUsers.length) {
			return listOfUsers.map((user) => <tr><td>{user.firstName}</td><td>{user.lastName}</td><td>{user.username}</td><td onClick={() => enableUser(user.username)}>
				<a id="admin-enable-user" href="#">Enable User</a></td>
				<td>
					<Form.Select id="admin-assign-role-dropbox" aria-label="Floating label select example" onChange={(evt) => changeRole(evt, user.username)}>
						<option>Open this select menu</option>
						<option value="ROLE_STAFF">STAFF</option>
						<option value="ROLE_USER">USER</option>
					</Form.Select>
				</td></tr>)
		}
	}

	return (
		<SimplePageLayout>
			<Table>
				<thead>
					<tr id="admin-users-table-header">
						<td id="admin-users-table-header-first-name">First Name</td>
						<td id="admin-users-table-header-last-name">Last Name</td>
						<td id="admin-users-table-header-username">Username</td>
						<td id="admin-users-table-header-enable-user"></td>
						<td id="admin-users-table-header-assign-role"></td>
					</tr>
				</thead>
				<tbody>
					{listOfUsersHTML()}
				</tbody>
			</Table>
		</SimplePageLayout>
	)
}
export default AdminPanel;