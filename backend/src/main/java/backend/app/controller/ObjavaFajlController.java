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

import backend.app.model.ObjavaFajl;
import backend.app.service.ObjavaFajlService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/objavaFajl")
public class ObjavaFajlController {

    @Autowired
    ObjavaFajlService objavaFajlService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<ObjavaFajl>> getObjavaFajl() {
        return new ResponseEntity<Iterable<ObjavaFajl>>(objavaFajlService.getObjavaFajl(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<ObjavaFajl> getObjavaFajlById(@PathVariable Long id) {
        Optional<ObjavaFajl> objavaFajl = objavaFajlService.getObjavaFajlById(id);
        if(objavaFajl.isPresent()) {
            return new ResponseEntity<ObjavaFajl>(objavaFajl.get(), HttpStatus.OK);
        }
        return new ResponseEntity<ObjavaFajl>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<ObjavaFajl> addObjavaFajl(@RequestBody ObjavaFajl objavaFajl) {
    	objavaFajlService.addObjavaFajl(objavaFajl);
        return new ResponseEntity<ObjavaFajl>(objavaFajl, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<ObjavaFajl> updateObjavaFajl(@PathVariable Long id, @RequestBody ObjavaFajl objavaFajl) {
    	objavaFajlService.updateObjavaFajl(id, objavaFajl);
        return new ResponseEntity<ObjavaFajl>(objavaFajl, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<ObjavaFajl> removeObjavaFajl(@PathVariable Long id) {
        try {
        	objavaFajlService.removeObjavaFajl(id);
        }catch (Exception e) {
            return new ResponseEntity<ObjavaFajl>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ObjavaFajl>(HttpStatus.NO_CONTENT);
    }

}
