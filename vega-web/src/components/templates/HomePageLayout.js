import Header from '../UI/organisms/Header.js';
import Footer from '../UI/organisms/Footer.js';
import MainPageCarousel from '../UI/organisms/MainPageCarousel.js';
import {Container, Row} from 'react-bootstrap';

const HomePageLayout = (props) => {
	return(
		<Container className="d-flex flex-column min-vh-100 justify-content-between">
			<Row>
				<Header />
				<MainPageCarousel />
			</Row>
			<Row>
				<Footer />
			</Row>
		</Container>
		);
}
export default HomePageLayout;