import {useState, useContext, useEffect} from 'react';
import SimplePageLayout from '../templates/SimplePageLayout.js';
import {Form, Button, Row, Col} from 'react-bootstrap';
import {fileUploader, fetchFiles, fetchData} from '../../service/FileUpload/FileUploader.js';
import {UserContext} from '../../auth/UserProvider.js';

const Resources = (props) => {	
	
	const [selectedFile, setSelectedFile] = useState();
	const [isFilePicked, setIsFilePicked] = useState(false);
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

	const handleSubmission = () => {
		const formData = new FormData();
		formData.append("file", selectedFile);
		fileUploader(formData, user.jwt)
			.then(res => {
				console.log("Response", res);
			})

	}

	const fetchFileData = (name) => {
		console.log(user.jwt)
		fetchData(name,user.jwt)
			.then(res => {
				setContent(res);
			})
	}

	const listOfFilesHTML = () => {
		if(listOfFiles.length){
			return listOfFiles.map((file) => <li onClick={() => fetchFileData(file)} style={{"cursor":"pointer"}}><a href="#">{file}</a></li>)
		}

	}

	if (user.role == "ROLE_ADMIN"){
		uploadHTML = (<Row>
				<Col className="mx-auto" xs={6}>
					<Form.Group controlId="formFile" className="mb-3">
    					<Form.Label>Resources Upload</Form.Label>
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
					<ul style={{"list-style-type":"none"}}>{listOfFilesHTML()}</ul>
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

export default Resources;