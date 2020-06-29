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

import backend.app.model.Zvanje;
import backend.app.service.ZvanjeService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/zvanje")
public class ZvanjeController {

    @Autowired
    ZvanjeService zvanjeService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Zvanje>> getZvanje() {
        return new ResponseEntity<Iterable<Zvanje>>(zvanjeService.getZvanje(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Zvanje> getZvanjeById(@PathVariable Long id) {
        Optional<Zvanje> zvanje = zvanjeService.getZvanjeById(id);
        if(zvanje.isPresent()) {
            return new ResponseEntity<Zvanje>(zvanje.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Zvanje>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Zvanje> addZvanje(@RequestBody Zvanje zvanje) {
    	zvanjeService.addZvanje(zvanje);
        return new ResponseEntity<Zvanje>(zvanje, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Zvanje> updateZvanje(@PathVariable Long id, @RequestBody Zvanje zvanje) {
    	zvanjeService.updateZvanje(id, zvanje);
        return new ResponseEntity<Zvanje>(zvanje, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Zvanje> removeZvanje(@PathVariable Long id) {
        try {
        	zvanjeService.removeZvanje(id);
        }catch (Exception e) {
            return new ResponseEntity<Zvanje>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Zvanje>(HttpStatus.NO_CONTENT);
    }

}
