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
				<div>
					<Button onClick={onAdd} className="w-10 mt-3 mb-2">Add News</Button>
				</div>
				<ListNewsDetails listOfNews={listOfNews} />
			</Row>
			<Footer />
		</Container>
	);
}
export default BlogPageLayout;