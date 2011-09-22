package info.ahlberg.spring.controller;

import info.ahlberg.spring.domain.Contact;
import info.ahlberg.spring.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/")
	String index(Model model) {
		model.addAttribute("msg", "A nice message");
		
		model.addAttribute("contacts", contactService.findAll());

		return "index";
	}


	@RequestMapping("/add")
	String add(@RequestParam String name, Model model) {
		model.addAttribute("msg", "A nice message");

		Contact contact = new Contact();
		contact.setName(name);
		contactService.save(contact);

		model.addAttribute("contacts", contactService.findAll());

		return "index";
	}
}