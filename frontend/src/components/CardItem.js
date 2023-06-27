import React from 'react'
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCheck, faPencil, faTrash } from '@fortawesome/free-solid-svg-icons'


const CardItem = ({ data, deleteMundo, selecionaMundo}) => {
  return (
    <Card className="card-item" style={ {width: '350px', margin: '10px'} } key={data.id}>
      <Card.Body>
        <Card.Title>{data.nome}</Card.Title>
        <Card.Text>{data.descricao}</Card.Text>
        <Button variant='primary' style={{ margin: '10px', backgroundColor: '#2ad151' }} onClick={(e) => selecionaMundo(data.id_mundo)}><FontAwesomeIcon icon={faCheck}/> Selecionar</Button>
        <Button variant='primary' style={{ marginLeft: '50px', backgroundColor: '#de871d' }}><FontAwesomeIcon icon={faPencil}/></Button>
        <Button type='submit' variant='primary' style={{ margin: '10px', backgroundColor: '#de3737' }} onClick={(e) => deleteMundo(data.id_mundo)}><FontAwesomeIcon icon={faTrash}/></Button>
      </Card.Body>
    </Card>
  );
};

export default CardItem;
