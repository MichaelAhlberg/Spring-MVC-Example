package info.ahlberg.spring;

import org.springframework.stereotype.Repository;


@Repository
public class ContactDAOWithJPA extends GenericDAOWithJPA<Contact, Long> implements ContactDAO {

}
