import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { faDragon} from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

function Login() {

    const [usuario, setUsuario] = useState('');
    const [senha, setSenha] = useState('');
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        try{
            const response = await axios.get('http://localhost:8080/usuarios/listar');

            for(let i = 0; i < response.data.length; i++) {
                if(usuario === response.data[i].login && senha === response.data[i].senha) {
                    sessionStorage.setItem('user', JSON.stringify(response.data[i]));
                    goToHome();
                }
            }
        } catch (e) {
            console.log(e)
        }
    }

    const goToHome = () => {
      navigate('/home');
    }

    return (
        <div className="login-form-wrap">
        <FontAwesomeIcon icon={faDragon} />
        <h2>Bem-vindo!</h2>
        <Form>
          <Form.Group className='mb-3' controlId='formBasicEmail'>
            <Form.Control type='text' 
            placeholder='Usuário'
            onChange={(e) => setUsuario(e.target.value)}
            />
          </Form.Group>

          <Form.Group className='mb-3' controlId='formBasicPassword'>
            <Form.Control type='password' 
            placeholder='Senha'
            onChange={(e) => setSenha(e.target.value)}
            />
          </Form.Group>
          <Button variant='primary' size='lg'
          onClick={(e) => handleLogin(e)}>Entrar</Button>
        </Form>
      </div>
    );
}

export default Login;