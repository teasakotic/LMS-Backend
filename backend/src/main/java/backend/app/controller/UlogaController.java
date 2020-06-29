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

import backend.app.model.Uloga;
import backend.app.service.UlogaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/uloga")
public class UlogaController {

    @Autowired
    UlogaService ulogaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Uloga>> getUloga() {
        return new ResponseEntity<Iterable<Uloga>>(ulogaService.getUloga(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Uloga> getUlogaById(@PathVariable Long id) {
        Optional<Uloga> uloga = ulogaService.getUlogaById(id);
        if(uloga.isPresent()) {
            return new ResponseEntity<Uloga>(uloga.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Uloga>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Uloga> addUloga(@RequestBody Uloga uloga) {
    	ulogaService.addUloga(uloga);
        return new ResponseEntity<Uloga>(uloga, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Uloga> updateUloga(@PathVariable Long id, @RequestBody Uloga uloga) {
    	ulogaService.updateUloga(id, uloga);
        return new ResponseEntity<Uloga>(uloga, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Uloga> removeUloga(@PathVariable Long id) {
        try {
        	ulogaService.removeUloga(id);
        }catch (Exception e) {
            return new ResponseEntity<Uloga>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Uloga>(HttpStatus.NO_CONTENT);
    }


}
