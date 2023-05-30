package br.com.batmanapi.library.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.batmanapi.library.model.Hq;
import br.com.batmanapi.library.repository.HqRepository;

@RestController
@RequestMapping("/api")
public class HqController {

    @Autowired
    private HqRepository hqRepository;

    @PostMapping("/hq")
    public ResponseEntity<Hq> createHq(@RequestBody Hq hq) {
        Hq savedHq = hqRepository.save(hq);
        return ResponseEntity.ok(savedHq);
    }

    @GetMapping("/hq/{id}")
    public ResponseEntity<Hq> getHqById(@PathVariable int id) {
        Optional<Hq> hqOptional = hqRepository.findById(id);
        if (hqOptional.isPresent()) {
            Hq hq = hqOptional.get();
            return ResponseEntity.ok(hq);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/hq")
    public ResponseEntity<List<Hq>> getAllHqs() {
        List<Hq> hqs = hqRepository.findAll();
        return ResponseEntity.ok(hqs);
    }

    @PutMapping("/hq/{id}")
    public ResponseEntity<?> updateHq(@PathVariable int id, @RequestBody Hq updatedHq) {
        Optional<Hq> hqOptional = hqRepository.findById(id);
        if (hqOptional.isPresent()) {
            Hq hq = hqOptional.get();
            if (isHqUpdated(hq, updatedHq)) {
                hq.setTitulo(updatedHq.getTitulo());
                hq.setNomeAutor(updatedHq.getNomeAutor());
                hq.setDataLancamento(updatedHq.getDataLancamento());
                hq.setSinopse(updatedHq.getSinopse());
                hqRepository.save(hq);
                return ResponseEntity.ok("HQ atualizada com sucesso.");
            } else {
                return ResponseEntity.ok("Nenhuma alteração realizada na HQ.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("HQ não encontrada.");
        }
    }

    @DeleteMapping("/hq/{id}")
    public ResponseEntity<?> deleteHq(@PathVariable int id) {
        Optional<Hq> hqOptional = hqRepository.findById(id);
        if (hqOptional.isPresent()) {
            hqRepository.deleteById(id);
            return ResponseEntity.ok("HQ excluída com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("HQ não encontrada.");
        }
    }

    private boolean isHqUpdated(Hq existingHq, Hq updatedHq) {
        return !existingHq.getTitulo().equals(updatedHq.getTitulo())
                || !existingHq.getNomeAutor().equals(updatedHq.getNomeAutor())
                || !existingHq.getDataLancamento().equals(updatedHq.getDataLancamento())
                || !existingHq.getSinopse().equals(updatedHq.getSinopse());
    }
}
