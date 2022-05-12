import {ListGroup} from 'react-bootstrap';
const VenusListGroup = ({header , list}) => {
	const listItems = list.map((l, index) => <ListGroup.Item key={index}>{l}</ListGroup.Item>);
	return (
		<ListGroup variant="flush">
			<ListGroup.Item><b>{header}</b></ListGroup.Item>
			{listItems}
		</ListGroup>
	);

}
export default VenusListGroup;