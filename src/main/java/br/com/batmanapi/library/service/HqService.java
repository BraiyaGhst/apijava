package br.com.batmanapi.library.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.batmanapi.library.model.Hq;
import br.com.batmanapi.library.repository.HqRepository;

@Service
public class HqService {
    private final HqRepository hqRepository;

    @Autowired
    public HqService(HqRepository hqRepository) {
        this.hqRepository = hqRepository;
    }

    public List<Hq> getAllHqs() {
        return hqRepository.findAll();
    }

    public Optional<Hq> getHqById(int id) {
        return hqRepository.findById(id);
    }

    public Hq createHq(Hq hq) {
        return hqRepository.save(hq);
    }

    public Hq updateHq(int id, Hq updatedHq) {
        Optional<Hq> hqOptional = hqRepository.findById(id);
        if (hqOptional.isPresent()) {
            Hq hq = hqOptional.get();
            hq.setTitulo(updatedHq.getTitulo());
            hq.setNomeAutor(updatedHq.getNomeAutor());
            hq.setDataLancamento(updatedHq.getDataLancamento());
            hq.setSinopse(updatedHq.getSinopse());
            return hqRepository.save(hq);
        } else {
            throw new IllegalArgumentException("Hq não encontrado.");
        }
    }

    public void deleteHq(int id) {
        Optional<Hq> hqOptional = hqRepository.findById(id);
        if (hqOptional.isPresent()) {
            hqRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Hq não encontrado.");
        }
    }
}
