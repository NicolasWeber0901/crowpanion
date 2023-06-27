import React, { useEffect, useState } from 'react'
import NavbarComponent from '../components/NavbarComponent'
import AddTimelineForm from '../components/AddTimelineForm'
import { VerticalTimeline, VerticalTimelineElement } from 'react-vertical-timeline-component'
import "react-vertical-timeline-component/style.min.css";
import axios from 'axios';
import { Button } from 'react-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPencil, faScroll, faTrash } from '@fortawesome/free-solid-svg-icons';
import { Circles } from "react-loader-spinner";

function Timeline() {
  
    const [eventos, setEventos] = useState([]);
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = async () => {
        setIsLoading(true);
        try {
            const response = await axios.get('http://localhost:8080/eventos/listar');
            console.log(response.data)
            setEventos(response.data);
            setIsLoading(false);
        } catch (error) {
            console.log(error);
        }
    }

    const cadastraEvento = async (descricao, dataInicio, dataFim, tipo, impacto) => {
        
        var auxMundoData = sessionStorage.getItem('mundo');
        const mundoData = JSON.parse(auxMundoData);
        
        const evento = {
            "dataFim": dataFim, 
            "dataInicio": dataInicio,
            "descricao": descricao,
            "impacto": impacto,
            "tipo": tipo,
            "timeline_id": mundoData.id_mundo
        }

        try {
            const response = await axios.post('http://localhost:8080/eventos/cadastrar', evento);
            console.log(response.data);
            fetchData();
        } catch (error) {
            console.log(error);
        }
    }

    const deleteEvento = async id => {
        try {
            const response = await axios.delete(`http://localhost:8080/eventos/remover/${id}`);
            console.log(response.data);
            fetchData();
        } catch (error) {
            console.log(error);
        }
    }

    return (
    <div>
        <div>
            <NavbarComponent></NavbarComponent>
        </div>
        <div>
            <AddTimelineForm cadastraEvento={cadastraEvento}></AddTimelineForm>
        </div>
        <div>
            <h2 style={{color: "#ffff"}}>Timeline</h2>
            {
                isLoading ?
                <Circles color="#00BFFF" height={80} width={80} /> 
                :
                <VerticalTimeline>
                    {eventos.map((data) => (
                        <VerticalTimelineElement
                            key={data.id_evento}
                            dateClassName="data-evento"
                            iconStyle={{ background: "#9f6ccc" }}
                            icon={<FontAwesomeIcon icon={faScroll}/>}
                        >
                            <h3>{data.descricao}</h3>
                            <h6>{data.dataInicio} - {data.dataFim}</h6>
                            <h6>Tipo: {data.tipo}</h6>
                            <h6>Impacto: {data.impacto}</h6>
                            <Button variant='primary' style={{ marginLeft: '50px', backgroundColor: '#de871d' }}><FontAwesomeIcon icon={faPencil}/></Button>
                            <Button type='submit' variant='primary' style={{ margin: '10px', backgroundColor: '#de3737' }} onClick={(e) => deleteEvento(data.id_evento)}><FontAwesomeIcon icon={faTrash}/></Button>
                        </VerticalTimelineElement>
                    ))}
                </VerticalTimeline>
            }
            
        </div>
    </div>
  )
}

export default Timeline