package br.com.batmanapi.library.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.batmanapi.library.model.Personagem;



@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {
    Optional<Personagem> findByNome(String nome);
    // Adicione outros métodos personalizados, se necessário

    Optional<Personagem> findById(int id);
}
