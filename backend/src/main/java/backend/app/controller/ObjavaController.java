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

import backend.app.model.Objava;
import backend.app.service.ObjavaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/objava")
public class ObjavaController {

    @Autowired
    ObjavaService objavaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Objava>> getObjava() {
        return new ResponseEntity<Iterable<Objava>>(objavaService.getObjava(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Objava> getObjavaById(@PathVariable Long id) {
        Optional<Objava> objava = objavaService.getObjavaById(id);
        if(objava.isPresent()) {
            return new ResponseEntity<Objava>(objava.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Objava>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Objava> addObjava(@RequestBody Objava objava) {
    	objavaService.addObjava(objava);
        return new ResponseEntity<Objava>(objava, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Objava> updateObjava(@PathVariable Long id, @RequestBody Objava objava) {
    	objavaService.updateObjava(id, objava);
        return new ResponseEntity<Objava>(objava, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Objava> removeObjava(@PathVariable Long id) {
        try {
        	objavaService.removeObjava(id);
        }catch (Exception e) {
            return new ResponseEntity<Objava>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Objava>(HttpStatus.NO_CONTENT);
    }

}
