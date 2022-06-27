import { Button, Container, Row } from 'react-bootstrap';
import { useHistory } from "react-router-dom";
import Footer from '../UI/organisms/Footer.js';
import Header from '../UI/organisms/Header.js';
import ListNewsDetails from '../UI/organisms/ListNewsDetails.js';

const BlogPageLayout = ({ listOfNews }) => {
	const history = useHistory();

	function onAdd() {
		history.push({
			pathname: '/add-news'
		});
	}
	return (
		<Container className="d-flex flex-column min-vh-100 justify-content-between">
			<Row>
				<Header />
				<Button onClick={onAdd}>Add</Button>
				<ListNewsDetails listOfNews={listOfNews} />
			</Row>
			<Footer />
		</Container>
	);
}
export default BlogPageLayout;