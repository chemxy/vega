import { Row } from 'react-bootstrap'; 
import Logo from '../molecules/Logo.js';
import VenusNavBar from '../molecules/VenusNavBar.js';
const Header = (props) => {
	return (
		<Row>
			<Logo />
			<VenusNavBar />
		</Row>
		);
}
export default Header;