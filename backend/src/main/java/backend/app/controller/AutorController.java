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

import backend.app.model.Autor;
import backend.app.service.AutorService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    AutorService autorService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Autor>> getAutor() {
        return new ResponseEntity<Iterable<Autor>>(autorService.getAutor(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
        Optional<Autor> autor= autorService.getAutorById(id);
        if(autor.isPresent()) {
            return new ResponseEntity<Autor>(autor.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Autor>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Autor> addAutor(@RequestBody Autor autor) {
    	autorService.addAutor(autor);
        return new ResponseEntity<Autor>(autor, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
    	autorService.updateAutor(id, autor);
        return new ResponseEntity<Autor>(autor, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Autor> removeAutor(@PathVariable Long id) {
        try {
        	autorService.removeAutor(id);
        }catch (Exception e) {
            return new ResponseEntity<Autor>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Autor>(HttpStatus.NO_CONTENT);
    }

}