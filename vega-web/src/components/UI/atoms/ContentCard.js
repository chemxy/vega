import {Card} from 'react-bootstrap';
const ContentCard = ({heading, description}) => {
	return (
		<Card className="mb-3">
  			<Card.Body>
    			<Card.Title>{heading}</Card.Title>
    			<Card.Text>{description}</Card.Text>
  			</Card.Body>
		</Card>
		);
}
export default ContentCard;