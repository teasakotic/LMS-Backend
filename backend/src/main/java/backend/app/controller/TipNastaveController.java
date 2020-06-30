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

import backend.app.model.TipNastave;
import backend.app.service.TipNastaveService;
import backend.app.utils.ViewUtils.HideOptionalProperties;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/tipNastave")
public class TipNastaveController {

    @Autowired
    TipNastaveService tipNastaveService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<TipNastave>> getTipNastave() {
        return new ResponseEntity<Iterable<TipNastave>>(tipNastaveService.getTipNastave(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<TipNastave> getTipNastaveById(@PathVariable Long id) {
        Optional<TipNastave> tipNastave = tipNastaveService.getTipNastaveById(id);
        if(tipNastave.isPresent()) {
            return new ResponseEntity<TipNastave>(tipNastave.get(), HttpStatus.OK);
        }
        return new ResponseEntity<TipNastave>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<TipNastave> addTipNastave(@RequestBody TipNastave tipNastave) {
    	tipNastaveService.addTipNastave(tipNastave);
        return new ResponseEntity<TipNastave>(tipNastave, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<TipNastave> updateTipNastave(@PathVariable Long id, @RequestBody TipNastave tipNastave) {
    	tipNastaveService.updateTipNastave(id, tipNastave);
        return new ResponseEntity<TipNastave>(tipNastave, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<TipNastave> removeTipNastave(@PathVariable Long id) {
        try {
        	tipNastaveService.removeTipNastave(id);
        }catch (Exception e) {
            return new ResponseEntity<TipNastave>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TipNastave>(HttpStatus.NO_CONTENT);
    }

}
