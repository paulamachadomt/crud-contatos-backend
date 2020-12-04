package edu.usj.crudcontatosbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ContatoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    
    String nome;
    String tipo;
    String telefone;
}
