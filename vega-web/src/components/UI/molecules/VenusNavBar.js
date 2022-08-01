import { useContext } from 'react';
import { Link } from 'react-router-dom';
import { Navbar, Nav, Container } from 'react-bootstrap';
import { UserContext } from '../../../auth/UserProvider.js';
// // import { console.log } from '../../../../server/utils.js';

const VenusNavBar = (props) => {
  const { user } = useContext(UserContext);
  var logout;
  var resources;
  var adminpanel;

  if (user.username && user.jwt) {
    console.log(user);
    logout = <Nav.Link href="/account">Logout</Nav.Link>;
  } else {
    logout = <Nav.Link href="/login">Login/SignUp</Nav.Link>;
  }

  if (user.role == "ROLE_STAFF" || user.role == "ROLE_ADMIN") {
    resources = <Nav.Link href="/resources">Resources</Nav.Link>;
  }

  if (user.role == "ROLE_ADMIN") {
    adminpanel = <Nav.Link href="/adminpanel">Admin</Nav.Link>
  }

  return (
    <Navbar bg="light" variant="light">
      <Container>
        <Nav className="w-100 ">
          <Nav.Link href="/platform" id="navbar-platform-tab">Platform</Nav.Link>
          <Nav.Link href="/news" id="navbar-news-tab">News & Events</Nav.Link>
          <Nav.Link href="/leadership" id="navbar-leadership-tab">Leadership</Nav.Link>
          {resources}
          <Nav.Link href="#pricing" id="navbar-pricing-tag">About us</Nav.Link>
          <Nav.Link href="/contactus">Contact us</Nav.Link>
          <Nav.Item className="float-right">
            {logout}
          </Nav.Item>
          {adminpanel}
        </Nav>
      </Container>
    </Navbar>
  );
}
export default VenusNavBar;