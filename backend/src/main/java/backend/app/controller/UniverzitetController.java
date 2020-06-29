package backend.app.controller;

import java.util.ArrayList;
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
import backend.app.model.Telefon;
import backend.app.model.Univerzitet;
import backend.app.service.UniverzitetService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/univerzitet")
public class UniverzitetController {

    @Autowired
    UniverzitetService univerzitetService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Univerzitet>> getUniverzitet() {
        return new ResponseEntity<Iterable<Univerzitet>>(univerzitetService.getUniverzitet(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Univerzitet> getUniverzitetById(@PathVariable Long id) {
        Optional<Univerzitet> univerzitet = univerzitetService.getUniverzitetById(id);
        if(univerzitet.isPresent()) {
            return new ResponseEntity<Univerzitet>(univerzitet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Univerzitet>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Univerzitet> addUniverzitet(@RequestBody Univerzitet univerzitet) {
    	univerzitetService.addUniverzitet(univerzitet);
        return new ResponseEntity<Univerzitet>(univerzitet, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Univerzitet> updateUniverzitet(@PathVariable Long id, @RequestBody Univerzitet univerzitet) {
    	univerzitetService.updateUniverzitet(id, univerzitet);
        return new ResponseEntity<Univerzitet>(univerzitet, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Univerzitet> removeUniverzitet(@PathVariable Long id) {
        try {
        	univerzitetService.removeUniverzitet(id);
        }catch (Exception e) {
            return new ResponseEntity<Univerzitet>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Univerzitet>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/telefoni/{univerzitetId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Telefon>> getTelefoniUniverziteta(@PathVariable Long univerzitetId) {
        return new ResponseEntity<ArrayList<Telefon>>(univerzitetService.getTelefoniUniverziteta(univerzitetId), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/emails/{univerzitetId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Email>> getEmailUniverziteta(@PathVariable Long univerzitetId) {
        return new ResponseEntity<ArrayList<Email>>(univerzitetService.getEmailUniverziteta(univerzitetId), HttpStatus.OK);
    }

}
