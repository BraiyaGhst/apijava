package br.com.batmanapi.library.controller;

import br.com.batmanapi.library.model.Localizacao;
import br.com.batmanapi.library.service.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/localizacoes")
public class LocalizacaoController {
    @Autowired
    private LocalizacaoService localizacaoService;

    @GetMapping
    public ResponseEntity<List<Localizacao>> getAllLocalizacoes() {
        List<Localizacao> localizacoes = localizacaoService.findAll();
        return ResponseEntity.ok(localizacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localizacao> getLocalizacaoById(@PathVariable int id) {
        Optional<Localizacao> localizacaoOptional = localizacaoService.findById(id);
        if (localizacaoOptional.isPresent()) {
            Localizacao localizacao = localizacaoOptional.get();
            return ResponseEntity.ok(localizacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Localizacao> createLocalizacao(@RequestBody Localizacao localizacao) {
        Localizacao savedLocalizacao = localizacaoService.save(localizacao);
        return ResponseEntity.ok(savedLocalizacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Localizacao> updateLocalizacao(@PathVariable int id, @RequestBody Localizacao updatedLocalizacao) {
        Optional<Localizacao> localizacaoOptional = localizacaoService.findById(id);
        if (localizacaoOptional.isPresent()) {
            Localizacao localizacao = localizacaoOptional.get();
            localizacao.setCidade(updatedLocalizacao.getCidade());
            Localizacao updatedLocalizacaoEntity = localizacaoService.save(localizacao);
            return ResponseEntity.ok(updatedLocalizacaoEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocalizacao(@PathVariable int id) {
        boolean deleted = localizacaoService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
