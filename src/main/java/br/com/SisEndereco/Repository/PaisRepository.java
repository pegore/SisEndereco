package br.com.SisEndereco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SisEndereco.Domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
}
