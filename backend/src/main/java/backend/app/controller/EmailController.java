package backend.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.model.Email;
import backend.app.service.EmailService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Email>> getEmail() {
        return new ResponseEntity<Iterable<Email>>(emailService.getEmail(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        Optional<Email> email= emailService.getEmailById(id);
        if(email.isPresent()) {
            return new ResponseEntity<Email>(email.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Email>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Email> addEmail(@RequestBody Email email) {
    	emailService.addEmail(email);
        return new ResponseEntity<Email>(email, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Email> updateEmail(@PathVariable Long id, @RequestBody Email email) {
    	emailService.updateEmail(id, email);
        return new ResponseEntity<Email>(email, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Email> removeEmail(@PathVariable Long id) {
        try {
        	emailService.removeEmail(id);
        }catch (Exception e) {
            return new ResponseEntity<Email>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Email>(HttpStatus.NO_CONTENT);
    }

}