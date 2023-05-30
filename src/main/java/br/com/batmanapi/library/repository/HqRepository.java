package br.com.batmanapi.library.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.batmanapi.library.model.Hq;

@Repository
public interface HqRepository extends JpaRepository<Hq, Integer> {
    // Métodos adicionais, se necessário
}
