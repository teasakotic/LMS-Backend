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

import backend.app.model.TipZvanja;
import backend.app.service.TipZvanjaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/tipZvanja")
public class TipZvanjaController {

    @Autowired
    TipZvanjaService tipZvanjaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<TipZvanja>> getTipZvanja() {
        return new ResponseEntity<Iterable<TipZvanja>>(tipZvanjaService.getTipZvanja(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<TipZvanja> getTipZvanjaById(@PathVariable Long id) {
        Optional<TipZvanja> tipZvanja = tipZvanjaService.getTipZvanjaById(id);
        if(tipZvanja.isPresent()) {
            return new ResponseEntity<TipZvanja>(tipZvanja.get(), HttpStatus.OK);
        }
        return new ResponseEntity<TipZvanja>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<TipZvanja> addTipZvanja(@RequestBody TipZvanja tipZvanja) {
    	tipZvanjaService.addTipZvanja(tipZvanja);
        return new ResponseEntity<TipZvanja>(tipZvanja, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<TipZvanja> updateTipZvanja(@PathVariable Long id, @RequestBody TipZvanja tipZvanja) {
    	tipZvanjaService.updateTipZvanja(id, tipZvanja);
        return new ResponseEntity<TipZvanja>(tipZvanja, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<TipZvanja> removeTipZvanja(@PathVariable Long id) {
        try {
        	tipZvanjaService.removeTipZvanja(id);
        }catch (Exception e) {
            return new ResponseEntity<TipZvanja>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TipZvanja>(HttpStatus.NO_CONTENT);
    }

}
