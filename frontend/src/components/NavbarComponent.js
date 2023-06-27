import React from 'react'
import { Container, Nav, Navbar } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faEarthAmericas } from '@fortawesome/free-solid-svg-icons'
import { faTimeline } from '@fortawesome/free-solid-svg-icons'
import { useNavigate } from 'react-router-dom';

function NavbarComponent() {

  const navigate = useNavigate();
  return (
    <Navbar bg='white' >
      <Container>
        <Navbar.Brand onClick={ (e) => navigate('/home')}>Crowpanion</Navbar.Brand>
        <Nav className='me-auto'>
          <Nav.Link onClick={ (e) => navigate('/home')}>
            <FontAwesomeIcon icon={faEarthAmericas}/> Mundos
          </Nav.Link>
          <Nav.Link onClick={ (e) => navigate('/timeline')}>
            <FontAwesomeIcon icon={faTimeline}/> Timeline
          </Nav.Link>
        </Nav>
      </Container>
    </Navbar>
  )
}

export default NavbarComponent;