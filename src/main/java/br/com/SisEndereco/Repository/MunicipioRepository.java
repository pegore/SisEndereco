package br.com.SisEndereco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SisEndereco.Domain.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {
}
