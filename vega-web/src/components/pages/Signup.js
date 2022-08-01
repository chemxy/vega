import { useState, useContext, useEffect } from 'react';
import { Button, Form } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { domain } from '../../models/constants';
import { doPost } from "../../service/BaseAPI";
import debugLog from '../../server/utils';

const Signup = (props) => {
    const history = useHistory();
    let [username, setUsername] = useState('');
    let [firstname, setFirstname] = useState('');
    let [lastname, setLastname] = useState('');
    let [password, setPassword] = useState('');

    function doSignup() {
        const body = {
            "username": username,
            "firstname": firstname,
            "lastname": lastname,
            "password": password
        }
        doPost("http://" + domain + ":8000/api/venus/register", body).then(res => {
            debugLog(res)
        })
        history.push({
            pathname: '/login',
        });


    }

    function doCancel() {
        history.push({
            pathname: '/login',
        });
    }

    return (
        <Form className="m-5">
            <Form.Group className="">
                <Form.Label>Username</Form.Label>
                <div>
                    <textarea className="w-75" onChange={e => setUsername(e.target.value)} value={username} />
                </div>
            </Form.Group>
            <Form.Group className="">
                <Form.Label>First Name</Form.Label>
                <div >
                    <textarea className="w-75" onChange={e => setFirstname(e.target.value)} value={firstname} />
                </div>
            </Form.Group>
            <Form.Group className="">
                <Form.Label>Last Name</Form.Label>
                <div>
                    <textarea className="w-75" onChange={e => setLastname(e.target.value)} value={lastname} />
                </div>
            </Form.Group>
            <Form.Group className="">
                <Form.Label>Password</Form.Label>
                <div>
                    <textarea className="w-75" onChange={e => setPassword(e.target.value)} value={password} />
                </div>
            </Form.Group>
            <button className="btn btn-outline-success" type="submit" onClick={doSignup}>
                Submit
            </button>
            <button className="btn btn-outline-danger ms-2" type="submit" onClick={doCancel}>
                Cancel
            </button>
        </Form>
    );
}

export default Signup;