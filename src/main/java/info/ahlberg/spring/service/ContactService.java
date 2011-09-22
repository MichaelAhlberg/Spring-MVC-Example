package info.ahlberg.spring.service;

import info.ahlberg.spring.domain.Contact;

public interface ContactService {

	Object findAll();

	void save(Contact contact);

}
