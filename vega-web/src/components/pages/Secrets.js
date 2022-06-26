import {useState, useContext, useEffect} from 'react';
import SimplePageLayout from '../templates/SimplePageLayout.js';
import {Form, Button, Row, Col} from 'react-bootstrap';
import {fileUploader, fetchFiles, fetchData} from '../../service/FileUpload/FileUploader.js';
import {UserContext} from '../../auth/UserProvider.js';

const Secrets = (props) => {

	const [selectedFile, setSelectedFile] = useState();
	const [isFilePicked, setIsFilePicked] = useState(false);

    const [secretName, setSecretName] = useState('');

	const {user} = useContext(UserContext);
	const [listOfFiles, setFiles] = useState([]);
	const [dataLoaded, setDataLoaded] = useState(false);
	const [content, setContent] = useState('');
	var uploadHTML;
	useEffect(() => {
		console.log("JWT is",user.jwt, dataLoaded)
			console.log("Inside useEffect")
			fetchFiles(user.jwt)
				.then(resp => {
					setDataLoaded(true);
					setFiles(resp)});


	}, [user])

	const changeHandler = (event) => {
		setSelectedFile(event.target.files[0]);
		setIsFilePicked(true);
	};

	const handleSubmission:function = (evt) => {
	    evt.preventDefault();
		const formData = new FormData();
		formData.append("file", selectedFile);
        window.alert(secretName);
	}

	const fetchFileData = (name) => {
		console.log(user.jwt)
		fetchData(name,user.jwt)
			.then(res => {
				setContent(res);
			})
	}

	if (user.role == "ROLE_ADMIN"){
		uploadHTML = (<Row>
				<Col className="mx-auto" xs={6}>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                        <Form.Label>SECRET NAME</Form.Label>
                        <Form.Control type="text" onChange={e => setSecretName(e.target.value)}/>
                    </Form.Group>
					<Form.Group controlId="formFile" className="mb-3">
    					<Form.Label>SECRET UPLOAD</Form.Label>
    					<Form.Control type="file" onChange={changeHandler} />
 					</Form.Group>
 					<Button variant="primary" type="submit" onClick={handleSubmission}>
    					Submit
  					</Button>
 				</Col>
			</Row>);
	}

	return (
		<SimplePageLayout>

			{uploadHTML}
			<Row mt="5">
				<Col sm={6}>
					<ul style={{"list-style-type":"none"}}></ul>
				</Col>
			</Row>
			<Row>
				<Col>
					{content}
				</Col>
			</Row>
		</SimplePageLayout>
		);
}

export default Secrets;