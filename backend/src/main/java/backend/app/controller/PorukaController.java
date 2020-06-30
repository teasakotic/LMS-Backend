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

import backend.app.model.Poruka;
import backend.app.service.PorukaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/poruka")
public class PorukaController {

    @Autowired
    PorukaService porukaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Poruka>> getPoruka() {
        return new ResponseEntity<Iterable<Poruka>>(porukaService.getPoruka(), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/korisnik/{username}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Poruka>> getPorukaByUser(@PathVariable String username) {
        return new ResponseEntity<Iterable<Poruka>>(porukaService.getPorukaByUser(username), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Poruka> getPorukaById(@PathVariable Long id) {
        Optional<Poruka> poruka = porukaService.getPorukaById(id);
        if(poruka.isPresent()) {
            return new ResponseEntity<Poruka>(poruka.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Poruka>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Poruka> addPoruka(@RequestBody Poruka poruka) {
    	porukaService.addPoruka(poruka);
        return new ResponseEntity<Poruka>(poruka, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Poruka> updatePoruka(@PathVariable Long id, @RequestBody Poruka poruka) {
    	porukaService.updatePoruka(id, poruka);
        return new ResponseEntity<Poruka>(poruka, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Poruka> removePoruka(@PathVariable Long id) {
        try {
        	porukaService.removePoruka(id);
        }catch (Exception e) {
            return new ResponseEntity<Poruka>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Poruka>(HttpStatus.NO_CONTENT);
    }

}

