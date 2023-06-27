import React, { useState } from 'react'
import { Button, Form } from 'react-bootstrap';

export const AddMundoForm = ({cadastraMundo}) => {
  
    const [nome, setNome] = useState("");
    const [descricao, setDescricao] = useState("");

    const handleSubmit = e => {
        e.preventDefault();

        cadastraMundo(nome, descricao);

        setNome("");
        setDescricao("");
    }

    return (
    <div className='mundo-form-wrap'>
    <Form onSubmit={handleSubmit} className="campos-form">
        <Form.Group>
            <h3>Mundo</h3>
            <Form.Group className='mb-3'>
                <Form.Control type='text' 
                placeholder='Nome'
                onChange={(e) => setNome(e.target.value)}
                />
            </Form.Group>
            <Form.Group className='mb-3'>
                <Form.Control type='text' 
                placeholder='Descrição'
                onChange={(e) => setDescricao(e.target.value)}
                />
            </Form.Group>
            <Button type='submit'>Cadastrar</Button>
        </Form.Group>
    </Form>
    </div>
  )
}
