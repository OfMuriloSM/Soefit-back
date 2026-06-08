package br.edu.ifce.soefit.repository;

import br.edu.ifce.soefit.model.FichaTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaTreinoRepository extends JpaRepository<FichaTreino, Long> {
}