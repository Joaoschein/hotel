package br.com.hotel.hotel.persistence.repository;

import br.com.hotel.hotel.persistence.entity.Cliente;
import br.com.hotel.hotel.persistence.entity.Quarto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends MongoRepository<Quarto, String> {
    Quarto findByNumero(int numero);
}
