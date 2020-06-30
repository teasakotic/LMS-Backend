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

import backend.app.model.Tema;
import backend.app.service.TemaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/tema")
public class TemaController {

    @Autowired
    TemaService temaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Tema>> getTema() {
        return new ResponseEntity<Iterable<Tema>>(temaService.getTema(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Tema> getTemaById(@PathVariable Long id) {
        Optional<Tema> tema = temaService.getTemaById(id);
        if(tema.isPresent()) {
            return new ResponseEntity<Tema>(tema.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Tema>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Tema> addTema(@RequestBody Tema tema) {
    	temaService.addTema(tema);
        return new ResponseEntity<Tema>(tema, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Tema> updateTema(@PathVariable Long id, @RequestBody Tema tema) {
    	temaService.updateTema(id, tema);
        return new ResponseEntity<Tema>(tema, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Tema> removeTema(@PathVariable Long id) {
        try {
        	temaService.removeTema(id);
        }catch (Exception e) {
            return new ResponseEntity<Tema>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Tema>(HttpStatus.NO_CONTENT);
    }

}
