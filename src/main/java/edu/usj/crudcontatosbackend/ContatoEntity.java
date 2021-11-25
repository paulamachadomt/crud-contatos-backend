package edu.usj.crudcontatosbackend;

import javax.persistence.*;

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
    String email;
}
