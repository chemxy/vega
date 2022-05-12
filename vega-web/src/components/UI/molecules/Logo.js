import LogoImage from '../atoms/LogoImage.js';
import { Navbar, Container } from 'react-bootstrap'; 

const Logo = (props) => {
	return (
		<Navbar>
    		<Container>
	      		<Navbar.Brand href="#home">
	        		<LogoImage />
	      		</Navbar.Brand>
   			 </Container>
  		</Navbar>);
}
export default Logo;