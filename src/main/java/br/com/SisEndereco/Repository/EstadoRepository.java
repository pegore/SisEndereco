package br.com.SisEndereco.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.SisEndereco.Domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
