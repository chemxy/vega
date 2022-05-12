import {Container, Row} from 'react-bootstrap';
import Header from '../UI/organisms/Header.js';
import Footer from '../UI/organisms/Footer.js';
import ListNewsDetails from '../UI/organisms/ListNewsDetails.js'

const BlogPageLayout = ({listOfNews}) => {
	return(
		<Container className="d-flex flex-column min-vh-100 justify-content-between">
			<Row>
				<Header />
				<ListNewsDetails listOfNews={listOfNews}/>
			</Row>
			<Footer />
		</Container>
		);
}
export default BlogPageLayout;