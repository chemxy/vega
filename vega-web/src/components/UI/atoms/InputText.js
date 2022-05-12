import {Form} from 'react-bootstrap';
const InputText = ({label}) => {
	return (
		<Form.Group>
			<Form.Label>{label}</Form.Label>
    		<Form.Control type="text" />
		</Form.Group>
		);
}
export default InputText;