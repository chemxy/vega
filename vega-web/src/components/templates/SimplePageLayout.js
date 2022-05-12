import Header from '../UI/organisms/Header.js';
import Footer from '../UI/organisms/Footer.js';
import Content from '../UI/organisms/Content.js';
import {Container, Row} from 'react-bootstrap';
import ListRoundImages from '../UI/molecules/ListRoundImages.js';
const SimplePageLayout = ({children}) => {
	return (
		<Container className="d-flex flex-column min-vh-100 justify-content-between">
			<Row>
				<Header />
				<Content>
					{children}
				</Content>
			</Row>
			<Footer />
		</Container>
		);
}
export default SimplePageLayout;