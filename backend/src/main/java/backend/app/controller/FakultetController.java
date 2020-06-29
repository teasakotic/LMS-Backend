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
import backend.app.model.Fakultet;
import backend.app.model.StudijskiProgram;
import backend.app.model.Telefon;
import backend.app.service.FakultetService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/fakultet")
public class FakultetController {

    @Autowired
    FakultetService fakultetService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Fakultet>> getFakultet() {
        return new ResponseEntity<Iterable<Fakultet>>(fakultetService.getFakultet(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Fakultet> getFakultetById(@PathVariable Long id) {
        Optional<Fakultet> fakultet = fakultetService.getFakultetById(id);
        if(fakultet.isPresent()) {
            return new ResponseEntity<Fakultet>(fakultet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Fakultet>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Fakultet> addFakultet(@RequestBody Fakultet fakultet) {
    	fakultetService.addFakultet(fakultet);
        return new ResponseEntity<Fakultet>(fakultet, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Fakultet> updateFakultet(@PathVariable Long id, @RequestBody Fakultet fakultet) {
    	fakultetService.updateFakultet(id, fakultet);
        return new ResponseEntity<Fakultet>(fakultet, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Fakultet> removeFakultet(@PathVariable Long id) {
        try {
        	fakultetService.removeFakultet(id);
        }catch (Exception e) {
            return new ResponseEntity<Fakultet>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Fakultet>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/studijskiProgrami/{fakultetId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<StudijskiProgram>> getStudijskiProgram(@PathVariable Long fakultetId) {
        return new ResponseEntity<ArrayList<StudijskiProgram>>(fakultetService.getStudijskiProgram(fakultetId), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/telefoni/{fakultetId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Telefon>> getTelefoniFakulteta(@PathVariable Long fakultetId) {
        return new ResponseEntity<ArrayList<Telefon>>(fakultetService.getTelefoniFakulteta(fakultetId), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/emails/{fakultetId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Email>> getEmailFakulteta(@PathVariable Long fakultetId) {
        return new ResponseEntity<ArrayList<Email>>(fakultetService.getEmailFakulteta(fakultetId), HttpStatus.OK);
    }

}
