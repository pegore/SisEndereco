package br.com.SisEndereco.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.SisEndereco.Domain.Pais;

@Repository
public interface PaisRepository extends MongoRepository<Pais, Integer> {
}
