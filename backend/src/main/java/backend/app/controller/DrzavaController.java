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

import backend.app.model.Drzava;
import backend.app.service.DrzavaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/drzava")
public class DrzavaController {

    @Autowired
    DrzavaService drzavaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Drzava>> getCountries() {
        return new ResponseEntity<Iterable<Drzava>>(drzavaService.getDrzava(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Drzava> getDrzavaById(@PathVariable Long id) {
        Optional<Drzava> drzava= drzavaService.getDrzavaById(id);
        if(drzava.isPresent()) {
            return new ResponseEntity<Drzava>(drzava.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Drzava>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Drzava> addDrzava(@RequestBody Drzava drzava) {
    	drzavaService.addDrzava(drzava);
        return new ResponseEntity<Drzava>(drzava, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Drzava> updateDrzava(@PathVariable Long id, @RequestBody Drzava drzava) {
    	drzavaService.updateDrzava(id, drzava);
        return new ResponseEntity<Drzava>(drzava, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Drzava> removeDrzava(@PathVariable Long id) {
        try {
        	drzavaService.removeDrzava(id);
        }catch (Exception e) {
            return new ResponseEntity<Drzava>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Drzava>(HttpStatus.NO_CONTENT);
    }

}