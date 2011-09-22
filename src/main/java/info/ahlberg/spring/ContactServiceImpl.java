package info.ahlberg.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDAO contactDAO;

	@Override
	public Object findAll() {
		return contactDAO.loadAll();
	}

	@Override
	@Transactional
	public void save(Contact contact) {
		contactDAO.persist(contact);
	}

}
