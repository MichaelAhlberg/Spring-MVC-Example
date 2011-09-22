package info.ahlberg.spring.service;

import java.util.List;

import info.ahlberg.spring.domain.Contact;

public interface ContactService {

    List<Contact> findAll();

    void save(Contact contact);

}
