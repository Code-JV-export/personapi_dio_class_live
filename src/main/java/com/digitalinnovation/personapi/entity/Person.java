package com.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true) // unique, nada mas é do que, o banco só ira cadastrar se o cpf for unico
    private String cpf;

    private LocalDate birthDate;

    // a anotação "@OneToMany" é de relcaionamento de tabelas (entidades), então ele cria uma tabela intermediaria chamada de PERSON-PHONE, onde a mesma ficará responsavel em guardar a conexão de uma pessoa com os seus telefones
    // o cascade permite adicionar os telefones sem que primeiro tenha que fazer uma instacia do Phone
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}) //cria uma tabela entre as duas tabelas, onde ira guardar as id dos dois
    private List<Phone> phones;
}
