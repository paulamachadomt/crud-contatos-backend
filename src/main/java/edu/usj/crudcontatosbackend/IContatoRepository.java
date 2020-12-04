package edu.usj.crudcontatosbackend;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IContatoRepository extends CrudRepository<ContatoEntity, Long>{
    List<ContatoEntity> findAll();
    List<ContatoEntity> findByNomeContainingIgnoreCase(String nome);
}
