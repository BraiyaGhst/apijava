package br.com.batmanapi.library.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.batmanapi.library.model.Localizacao;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {

}
