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

import backend.app.model.Telefon;
import backend.app.service.TelefonService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/telefon")
public class TelefonController {

    @Autowired
    TelefonService telefonService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Telefon>> getTelefon() {
        return new ResponseEntity<Iterable<Telefon>>(telefonService.getTelefon(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Telefon> getTelefonById(@PathVariable Long id) {
        Optional<Telefon> telefon = telefonService.getTelefonById(id);
        if(telefon.isPresent()) {
            return new ResponseEntity<Telefon>(telefon.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Telefon>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Telefon> addTelefon(@RequestBody Telefon telefon) {
    	telefonService.addTelefon(telefon);
        return new ResponseEntity<Telefon>(telefon, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Telefon> updateTelefon(@PathVariable Long id, @RequestBody Telefon telefon) {
    	telefonService.updateTelefon(id, telefon);
        return new ResponseEntity<Telefon>(telefon, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Telefon> removeTelefon(@PathVariable Long id) {
        try {
        	telefonService.removeTelefon(id);
        }catch (Exception e) {
            return new ResponseEntity<Telefon>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Telefon>(HttpStatus.NO_CONTENT);
    }

}