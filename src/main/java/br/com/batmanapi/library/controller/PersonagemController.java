package br.com.batmanapi.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.batmanapi.library.model.Personagem;
import br.com.batmanapi.library.service.PersonagemService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personagem")
public class PersonagemController {
    @Autowired
    private PersonagemService service;

    @GetMapping
    public List<Personagem> findAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Personagem personagem) {
        try {
            return new ResponseEntity<>(service.save(personagem), HttpStatus.CREATED);
        } catch (IllegalArgumentException iae) {
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro inesperado. Por favor, tente novamente mais tarde.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        Optional<Personagem> personagem = service.findById(id);
        if (personagem.isPresent()) {
            return new ResponseEntity<>(personagem.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Personagem não encontrado.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        if (service.delete(id)) {
            return new ResponseEntity<>("Personagem excluído com sucesso.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Personagem não encontrado.", HttpStatus.NOT_FOUND);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Personagem personagem) {
        try {
            personagem.setId(id);
            return new ResponseEntity<>(service.update(personagem), HttpStatus.OK);
        } catch (IllegalArgumentException iae) {
            return new ResponseEntity<>(iae.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Ocorreu um erro inesperado. Por favor, tente novamente mais tarde.",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // Adicione outros métodos conforme necessário
}
