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

import backend.app.model.NastavniMaterijal;
import backend.app.service.NastavniMaterijalService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/nastavniMaterijal")
public class NastavniMaterijalController {

	@Autowired
	NastavniMaterijalService nastavniMaterijalService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<NastavniMaterijal>> getNastavniMaterijal() {
        return new ResponseEntity<Iterable<NastavniMaterijal>>(nastavniMaterijalService.getNastavniMaterijal(), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/predmet/{id}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<NastavniMaterijal>>> getNastavniMaterijalByPredmet(@PathVariable Long id) {
        return new ResponseEntity<Iterable<Optional<NastavniMaterijal>>>(nastavniMaterijalService.getNastavniMaterijalByPredmet(id), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<NastavniMaterijal> getNastavniMaterijalById(@PathVariable Long id) {
        Optional<NastavniMaterijal> nastavniMaterijal = nastavniMaterijalService.getNastavniMaterijalById(id);
        if(nastavniMaterijal.isPresent()) {
            return new ResponseEntity<NastavniMaterijal>(nastavniMaterijal.get(), HttpStatus.OK);
        }
        return new ResponseEntity<NastavniMaterijal>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<NastavniMaterijal> addNastavniMaterijal(@RequestBody NastavniMaterijal nastavniMaterijal) {
    	nastavniMaterijalService.addNastavniMaterijal(nastavniMaterijal);
        return new ResponseEntity<NastavniMaterijal>(nastavniMaterijal, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<NastavniMaterijal> updateNastavniMaterijal(@PathVariable Long id, @RequestBody NastavniMaterijal nastavniMaterijal) {
    	nastavniMaterijalService.updateNastavniMaterijal(id, nastavniMaterijal);
        return new ResponseEntity<NastavniMaterijal>(nastavniMaterijal, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<NastavniMaterijal> removeNastavniMaterijal(@PathVariable Long id) {
        try {
        	nastavniMaterijalService.removeNastavniMaterijal(id);
        }catch (Exception e) {
            return new ResponseEntity<NastavniMaterijal>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<NastavniMaterijal>(HttpStatus.NO_CONTENT);
    }

}