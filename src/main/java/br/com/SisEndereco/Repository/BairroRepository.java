package br.com.SisEndereco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SisEndereco.Domain.Bairro;

@Repository
public interface BairroRepository extends JpaRepository<Bairro, Integer> {
}
