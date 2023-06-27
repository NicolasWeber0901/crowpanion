import { useEffect, useState } from 'react';
import axios from 'axios';
import CardItem from '../components/CardItem';
import NavbarComponent from '../components/NavbarComponent';
import { AddMundoForm } from '../components/AddMundoForm';
import { useNavigate } from 'react-router-dom';
import { Circles } from "react-loader-spinner";

function Home() {
    
    const [mundos, setMundos] = useState([]);
    const [isLoading, setIsLoading] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        setIsLoading(true)
        try {
            const response = await axios.get('http://localhost:8080/mundos/listar');
            console.log(response.data)
            setMundos(response.data);
            setIsLoading(false)
        } catch (error) {
            console.log(error);
        }
    }
    
    const cadastraMundo = async (nome, descricao) => {
        const mundo = {
            "nome": nome,
            "descricao": descricao,
        }

        try {
            const response = await axios.post('http://localhost:8080/mundos/cadastrar', mundo);
            console.log(response.data);
            fetchData();
        } catch (error) {
            console.log(error);
        }
    }

    const deleteMundo = async id => {
        try {
            const response = await axios.delete(`http://localhost:8080/mundos/remover/${id}`);
            console.log(response.data);
            fetchData();
        } catch (error) {
            console.log(error);
        }
    }

    const selecionaMundo = function (id) {
        mundos.map((data) => {
                if(data.id_mundo === id) {
                    sessionStorage.setItem('mundo', JSON.stringify(data));
                    navigate('/timeline');
                }
            }
        );
    }

    return (
        <div>
            <div>
                <NavbarComponent></NavbarComponent>
            </div>
            <AddMundoForm cadastraMundo={cadastraMundo}></AddMundoForm>
            <div>
                {isLoading ? (
                    <Circles color="#00BFFF" height={80} width={80} />
                ) : (
                    mundos.map((data) => (
                        <CardItem data={data} deleteMundo={deleteMundo} selecionaMundo={selecionaMundo}/>
                    )
                ))}
                
            </div>
        </div>
    );
}

export default Home;