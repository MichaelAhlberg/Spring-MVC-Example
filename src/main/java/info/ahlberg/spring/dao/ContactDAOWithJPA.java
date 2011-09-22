package info.ahlberg.spring.dao;

import info.ahlberg.spring.domain.Contact;

import org.springframework.stereotype.Repository;

@Repository
public class ContactDAOWithJPA extends GenericDAOWithJPA<Contact, Long> implements ContactDAO {

}
