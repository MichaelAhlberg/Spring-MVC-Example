package info.ahlberg.spring.service;

import java.util.List;

import info.ahlberg.spring.dao.ContactDAO;
import info.ahlberg.spring.domain.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactDAO contactDAO;

    @Override
    public List<Contact> findAll() {
        return contactDAO.loadAll();
    }

    @Override
    @Transactional
    public void save(Contact contact) {
        contactDAO.persist(contact);
    }

}
