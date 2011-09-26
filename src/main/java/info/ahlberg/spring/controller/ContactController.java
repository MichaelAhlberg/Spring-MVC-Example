package info.ahlberg.spring.controller;

import info.ahlberg.spring.domain.Contact;
import info.ahlberg.spring.service.ContactService;

import java.beans.PropertyEditorSupport;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Contact.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                Long id = Long.parseLong(text);
                setValue(contactService.findById(id));
            }
        });
    }
    
    @RequestMapping("/")
    String index(Model model) {
        model.addAttribute("contacts", contactService.findAll());

        return "index";
    }

    @RequestMapping("/contacts")
    public @ResponseBody List<Contact> contacts(Model model) {
        return contactService.findAll();
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String addContact(Model model) {
        model.addAttribute("contact", new Contact());

        return "contact";
    }

    @RequestMapping(value="/contact/{contact}", method = RequestMethod.GET)
    public String showContact(@PathVariable("contact") Contact contact, Model model) {
        model.addAttribute("contact", contact);
        
        return "contact";
    }
    
    @RequestMapping(value="/contact/{contact}", method = RequestMethod.POST)
    public String updateContact(@PathVariable("contact") Contact originalContact, Contact contact, Model model) {
        originalContact.setFirstName(contact.getFirstName());
        originalContact.setLastName(contact.getLastName());
        
        model.addAttribute("contact", originalContact);

        contactService.update(originalContact);
        
        return "contact";
    }
    
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contactService.save(contact);

        model.addAttribute("msg", "Contact added");

        model.addAttribute("contacts", contactService.findAll());

        return "index";
    }
}
