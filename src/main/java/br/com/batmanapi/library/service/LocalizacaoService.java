package br.com.batmanapi.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.batmanapi.library.model.Localizacao;
import br.com.batmanapi.library.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {
    @Autowired
    private LocalizacaoRepository repository;

    public List<Localizacao> findAll() {
        return repository.findAll();
    }

    public Localizacao save(Localizacao localizacao) {
        return repository.save(localizacao);
    }

    public Optional<Localizacao> findById(int id) {
        return repository.findById(id);
    }

    public boolean delete(int id) {
        Optional<Localizacao> existingLocalizacao = repository.findById(id);
        if (existingLocalizacao.isPresent()) {
            repository.delete(existingLocalizacao.get());
            return true;
        }
        return false;
    }
    
    public Localizacao update(Localizacao localizacao) {
        Optional<Localizacao> existingLocalizacao = repository.findById(localizacao.getId());
        if (existingLocalizacao.isPresent()) {
            return repository.save(localizacao);
        }
        throw new IllegalArgumentException("Localizacao não encontrada.");
    }

    // Adicione outros métodos de serviço, se necessário
}

