package com.digitalinnovation.personapi.service;

import com.digitalinnovation.personapi.dto.MessageResponseDTO;
import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired // utilizado para pedir para depositar um PesonRepository. Criar uma dependencia
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person) { // o @RequestBody informa que o parametro deste metodo virá no corpo do POST do usuario
        Person savePerson = personRepository.save(person);
        return MessageResponseDTO // evita criar direto do construtor a classe, e com o bilder, ele permite de passar de uma forma mais capsulada, e fazer o tratamento do dados de entrada
                .builder()
                .message("Created person with ID " + savePerson.getId())
                .build();
    }
}
