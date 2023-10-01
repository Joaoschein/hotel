package br.com.hotel.hotel.persistence.repository;

import br.com.hotel.hotel.persistence.entity.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

    Cliente findByCpf(String cpf);
}
