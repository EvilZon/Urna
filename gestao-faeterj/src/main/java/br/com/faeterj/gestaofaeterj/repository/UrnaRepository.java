package br.com.faeterj.gestaofaeterj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.faeterj.gestaofaeterj.model.Urna;

@Repository 
public interface UrnaRepository extends JpaRepository<Urna, Long> {

}
