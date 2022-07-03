import { Form, Button, Row, Col } from 'react-bootstrap';
const UserRegistrationForm = (props) => {
	return (
		<Row>
			<Col className="mx-auto" xs={6}>
				<Form>
					<Form.Group className="mb-3">
						<Form.Label id="user-registration-name-label">NAME</Form.Label>
						<Form.Control type="email" id="user-registration-name-input" />
					</Form.Group>
					<Form.Group className="mb-3">
						<Form.Label id="user-registration-email-label">EMAIL</Form.Label>
						<Form.Control type="email" id="user-registration-email-input" />
					</Form.Group>
					<Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
						<Form.Label id="user-registration-message-label">MESSAGE</Form.Label>
						<Form.Control as="textarea" rows={3} id="user-registration-message-input" />
					</Form.Group>
					<Button variant="primary" type="submit" id="user-registration-submit-button">
						Submit
					</Button>
				</Form>
			</Col>
		</Row>
	);
}
export default UserRegistrationForm;