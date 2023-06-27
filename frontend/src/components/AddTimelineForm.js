import React, { useState } from 'react'
import { Button, Form, FormLabel } from 'react-bootstrap'

function AddTimelineForm({cadastraEvento}) {
  
    const [descricao, setDescricao] = useState("");
    const [dataInicio, setDataInicio] = useState("");
    const [dataFim, setDataFim] = useState("");
    const [tipo, setTipo] = useState("");
    const [impacto, setImpacto] = useState("");

    const handleSubmit = e => {
        e.preventDefault();
        cadastraEvento(descricao, dataInicio, dataFim, tipo, impacto);

        setDataInicio("");
        setDataFim("");
        setTipo("");
        setImpacto("");
        setDescricao("");
    }

const tipos = [
    { value: 'militar', label: 'Militar' },
    { value: 'combate', label: 'Combate' },
    { value: 'crime', label: 'Crime' },
    { value: 'conhecimento', label: 'Conhecimento' },
    { value: 'descoberta', label: 'Descoberta' },
    { value: 'expedicao', label: 'Expedição' },
    { value: 'dialogo', label: 'Diálogo' },
    { value: 'romance', label: 'Romance' },
    { value: 'debate', label: 'Debate' },
  ];

const impactos = [
    { value: 'grupo', label: 'Grupo' },
    { value: 'povoado', label: 'Povoado' },
    { value: 'vila', label: 'Vila' },
    { value: 'cidade', label: 'Cidade' },
    { value: 'regional', label: 'Regional' },
    { value: 'global', label: 'Global' },
  ];

return (
    <div className='timeline-form-wrap'>
        <Form onSubmit={handleSubmit} className='campos-form'>
            <h3>Eventos</h3>
            <Form.Group>
                <Form.Control 
                    as="textarea"
                    placeholder="Descrição"
                    onChange={(e) => setDescricao(e.target.value)}
                />
            </Form.Group>
            <Form.Group>
                <FormLabel>Data Inicio</FormLabel>
                <Form.Control 
                    type="date"
                    onChange={(e) => setDataInicio(e.target.value)}
                />
            </Form.Group>
            <Form.Group>
                <FormLabel>Data fim</FormLabel>
                <Form.Control 
                    type="date"
                    onChange={(e) => setDataFim(e.target.value)}
                />
            </Form.Group>
            <Form.Group>
                <FormLabel>Tipo</FormLabel>
                <Form.Control as="select" onChange={(e) => setTipo(e.target.value)}>
                    {tipos.map((option, index) => (
                        <option key={index} value={option.value}>
                            {option.label}
                        </option>
                    ))}
                </Form.Control> 
            </Form.Group>
            <Form.Group>
                <FormLabel>Impacto</FormLabel>
                <Form.Control as="select" onChange={(e) => setImpacto(e.target.value)}>
                    {impactos.map((option, index) => (
                        <option key={index} value={option.value}>
                            {option.label}
                        </option>
                    ))}
                </Form.Control>
            </Form.Group>
            <div id="btn-evento">
                <Button type="submit">Cadastrar</Button>
            </div>
        </Form>
    </div>
    
  )
}

export default AddTimelineForm