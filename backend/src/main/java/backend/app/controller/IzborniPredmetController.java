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

import backend.app.model.IzborniPredmet;
import backend.app.service.IzborniPredmetService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/izborniPredmet")
public class IzborniPredmetController {

    @Autowired
    IzborniPredmetService izborniPredmetService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<IzborniPredmet>> getIzborniPredmet() {
        return new ResponseEntity<Iterable<IzborniPredmet>>(izborniPredmetService.getIzborniPredmet(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<IzborniPredmet> getIzborniPredmetById(@PathVariable Long id) {
        Optional<IzborniPredmet> izborniPredmet = izborniPredmetService.getIzborniPredmetById(id);
        if(izborniPredmet.isPresent()) {
            return new ResponseEntity<IzborniPredmet>(izborniPredmet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<IzborniPredmet>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<IzborniPredmet> addIzborniPredmet(@RequestBody IzborniPredmet izborniPredmet) {
    	izborniPredmetService.addIzborniPredmet(izborniPredmet);
        return new ResponseEntity<IzborniPredmet>(izborniPredmet, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<IzborniPredmet> updateIzborniPredmet(@PathVariable Long id, @RequestBody IzborniPredmet izborniPredmet) {
    	izborniPredmetService.updateIzborniPredmet(id, izborniPredmet);
        return new ResponseEntity<IzborniPredmet>(izborniPredmet, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<IzborniPredmet> removeIzborniPredmet(@PathVariable Long id) {
        try {
        	izborniPredmetService.removeIzborniPredmet(id);
        }catch (Exception e) {
            return new ResponseEntity<IzborniPredmet>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<IzborniPredmet>(HttpStatus.NO_CONTENT);
    }

}