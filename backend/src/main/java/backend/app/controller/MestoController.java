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

import backend.app.model.Mesto;
import backend.app.service.MestoService;
import backend.app.utils.ViewUtils.HideOptionalProperties;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/mesto")
public class MestoController {

    @Autowired
    MestoService mestoService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Mesto>> getMesto() {
        return new ResponseEntity<Iterable<Mesto>>(mestoService.getMesto(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Mesto> getMestoById(@PathVariable Long id) {
        Optional<Mesto> mesto = mestoService.getMestoById(id);
        if(mesto.isPresent()) {
            return new ResponseEntity<Mesto>(mesto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Mesto>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Mesto> addMesto(@RequestBody Mesto mesto) {
    	mestoService.addMesto(mesto);
        return new ResponseEntity<Mesto>(mesto, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Mesto> updateMesto(@PathVariable Long id, @RequestBody Mesto mesto) {
    	mestoService.updateMesto(id, mesto);
        return new ResponseEntity<Mesto>(mesto, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Mesto> removeMesto(@PathVariable Long id) {
        try {
        	mestoService.removeMesto(id);
        }catch (Exception e) {
            return new ResponseEntity<Mesto>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Mesto>(HttpStatus.NO_CONTENT);
    }

}
