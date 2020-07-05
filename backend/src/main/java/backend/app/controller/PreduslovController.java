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

import backend.app.model.Preduslov;
import backend.app.service.PreduslovService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/preduslov")
public class PreduslovController {

    @Autowired
    PreduslovService preduslovService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Preduslov>> getPreduslov() {
        return new ResponseEntity<Iterable<Preduslov>>(preduslovService.getPreduslov(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Preduslov> getPreduslovById(@PathVariable Long id) {
        Optional<Preduslov> preduslov= preduslovService.getPreduslovById(id);
        if(preduslov.isPresent()) {
            return new ResponseEntity<Preduslov>(preduslov.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Preduslov>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Preduslov> addPreduslov(@RequestBody Preduslov preduslov) {
    	preduslovService.addPreduslov(preduslov);
        return new ResponseEntity<Preduslov>(preduslov, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Preduslov> updatePreduslov(@PathVariable Long id, @RequestBody Preduslov preduslov) {
    	preduslovService.updatePreduslov(id, preduslov);
        return new ResponseEntity<Preduslov>(preduslov, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Preduslov> removePreduslov(@PathVariable Long id) {
        try {
        	preduslovService.removePreduslov(id);
        }catch (Exception e) {
            return new ResponseEntity<Preduslov>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Preduslov>(HttpStatus.NO_CONTENT);
    }

}