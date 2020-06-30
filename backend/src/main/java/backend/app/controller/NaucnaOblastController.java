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

import backend.app.model.NaucnaOblast;
import backend.app.service.NaucnaOblastService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/naucnaOblast")
public class NaucnaOblastController {

    @Autowired
    NaucnaOblastService naucnaOblastService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<NaucnaOblast>> getNaucnaOblast() {
        return new ResponseEntity<Iterable<NaucnaOblast>>(naucnaOblastService.getNaucnaOblast(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<NaucnaOblast> getNaucnaOblastById(@PathVariable Long id) {
        Optional<NaucnaOblast> naucnaOblast = naucnaOblastService.getNaucnaOblastById(id);
        if(naucnaOblast.isPresent()) {
            return new ResponseEntity<NaucnaOblast>(naucnaOblast.get(), HttpStatus.OK);
        }
        return new ResponseEntity<NaucnaOblast>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<NaucnaOblast> addNaucnaOblast(@RequestBody NaucnaOblast naucnaOblast) {
    	naucnaOblastService.addNaucnaOblast(naucnaOblast);
        return new ResponseEntity<NaucnaOblast>(naucnaOblast, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<NaucnaOblast> updateNaucnaOblast(@PathVariable Long id, @RequestBody NaucnaOblast naucnaOblast) {
    	naucnaOblastService.updateNaucnaOblast(id, naucnaOblast);
        return new ResponseEntity<NaucnaOblast>(naucnaOblast, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<NaucnaOblast> removeNaucnaOblast(@PathVariable Long id) {
        try {
        	naucnaOblastService.removeNaucnaOblast(id);
        }catch (Exception e) {
            return new ResponseEntity<NaucnaOblast>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<NaucnaOblast>(HttpStatus.NO_CONTENT);
    }

}
