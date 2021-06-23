package com.estudantes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;
import java.util.Optional;

import com.estudantes.entities.Estudante;
import com.estudantes.repository.EstudanteRepository;

@RestController
@CrossOrigin
@RequestMapping("/estudantes")          //localhost:8080/estudantes

public class EstudanteController {
    
    @Autowired
    private EstudanteRepository repo;

    //EndPoint 1
    //Devolve todos os Estudantes  
    //localhost:8080/estudantes  
    @GetMapping
    public List<Estudante> getEstudantes(){

        List<Estudante> lista = repo.findAll();

        return lista;
    }

    //EndPoint 2
    //Devolve um Estudante pelo id
    //localhost:8080/estudantes/{id} 
    //Exemplo //localhost:8080/estudantes/1     (Devolve o estudante com id 1) 
    @GetMapping("{id}")
    public Estudante getEstudante(@PathVariable Long id){

    Optional<Estudante> op = repo.findById(id); 
    Estudante estudante = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    return estudante;
    }

}
