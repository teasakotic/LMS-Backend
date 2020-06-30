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

import backend.app.model.Ishod;
import backend.app.model.Predmet;
import backend.app.service.PredmetService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/predmet")
public class PredmetController {

    @Autowired
    PredmetService predmetService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Predmet>> getPredmet() {
        return new ResponseEntity<Iterable<Predmet>>(predmetService.getPredmet(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Predmet> getPredmetById(@PathVariable Long id) {
        Optional<Predmet> predmet = predmetService.getPredmetById(id);
        if(predmet.isPresent()) {
            return new ResponseEntity<Predmet>(predmet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Predmet> addPredmet(@RequestBody Predmet predmet) {
    	predmetService.addPredmet(predmet);
        return new ResponseEntity<Predmet>(predmet, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Predmet> updatePredmet(@PathVariable Long id, @RequestBody Predmet predmet) {
    	predmetService.updatePredmet(id, predmet);
        return new ResponseEntity<Predmet>(predmet, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Predmet> removePredmet(@PathVariable Long id) {
        try {
        	predmetService.removePredmet(id);
        }catch (Exception e) {
            return new ResponseEntity<Predmet>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Predmet>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/findByNazic/{naziv}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<Predmet>>> getPredmetByNaziv(@PathVariable String naziv) {
        Iterable<Optional<Predmet>> predmet = predmetService.getPredmetByNaziv(naziv);
        return new ResponseEntity<Iterable<Optional<Predmet>>>(predmet, HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/silabus/{predmetId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Ishod>> getilabus(@PathVariable Long predmetId) {
        return new ResponseEntity<ArrayList<Ishod>>(predmetService.getSilabus(predmetId), HttpStatus.OK);
    }

}
