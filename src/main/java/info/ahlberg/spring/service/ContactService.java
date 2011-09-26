package info.ahlberg.spring.service;

import java.util.List;

import info.ahlberg.spring.domain.Contact;

public interface ContactService {

    List<Contact> findAll();

    Contact findById(Long id);
    
    void save(Contact contact);

    void update(Contact contact);

}
