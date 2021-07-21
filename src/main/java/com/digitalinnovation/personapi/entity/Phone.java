package com.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.*;

@Entity // está mencionando que essa classe é uma entidade e ela será passada para o banco de dados
@Data // cria os gets e os sets automaticamente
@Builder
@AllArgsConstructor // cria um construtor que pede todos os parametros
@NoArgsConstructor // cria um construtor que não pede parametros
public class Phone {

    @Id // informa para o banco que essa variavel é um ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pedir para o banco realizar a colocação de valores no ID automaticamente, de forma que incrementa a cada nova adição
    private Long id;

    @Enumerated(EnumType.STRING) // infomra de quais forma deve ser inserido o valor no banco de dados
    @Column(nullable = false) // para deixar claro que esse dados é obrigatorio, e não pode esta null
    private PhoneType type;

    @Column(nullable = false)
    private String number;

}
