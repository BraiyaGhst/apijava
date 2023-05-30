package br.com.batmanapi.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.batmanapi.library.model.Personagem;
import br.com.batmanapi.library.model.Validation;
import br.com.batmanapi.library.repository.PersonagemRepository;

@Service
public class PersonagemService {
    @Autowired
    private PersonagemRepository repository;

    public List<Personagem> findAll() {
        return repository.findAll();
    }

    public Personagem save(Personagem personagem) throws IllegalArgumentException {
        if (!Validation.nameValidation(personagem.getNome())) {
            throw new IllegalArgumentException("O nome do personagem é inválido. Ele deve conter de 3 a 50 caracteres!");
        }
        // Adicione outras validações, se necessário

        return repository.save(personagem);
    }

    public Optional<Personagem> findById(int id) {
        return repository.findById(id);
    }

    public boolean delete(int id) {
        Optional<Personagem> existingPersonagem = repository.findById(id);
        if (existingPersonagem.isPresent()) {
            repository.delete(existingPersonagem.get());
            return true;
        }
        return false;
    }
    
    public Personagem update(Personagem personagem) throws IllegalArgumentException {
        Optional<Personagem> existingPersonagem = repository.findById(personagem.getId());
        if (existingPersonagem.isPresent()) {
            if (!Validation.nameValidation(personagem.getNome())) {
                throw new IllegalArgumentException("O nome do personagem é inválido. Ele deve conter de 3 a 50 caracteres!");
            }
            // Adicione outras validações, se necessário

            return repository.save(personagem);
        }
        throw new IllegalArgumentException("Personagem não encontrado.");
    }

    // Adicione outros métodos de serviço, se necessário
}
