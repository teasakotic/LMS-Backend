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

import backend.app.model.TerminNastave;
import backend.app.service.TerminNastaveService;
import backend.app.utils.ViewUtils.HideOptionalProperties;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/terminNastave")
public class TerminNastaveController {
	@Autowired
	TerminNastaveService terminNastaveService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<TerminNastave>> getTerminNastave() {
        return new ResponseEntity<Iterable<TerminNastave>>(terminNastaveService.getTerminNastave(), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/godinaStudija/{godinaStudijaId}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<TerminNastave>>> getTerminNastaveByGodinaStudija(@PathVariable Long godinaStudijaId) {
        return new ResponseEntity<Iterable<Optional<TerminNastave>>>(terminNastaveService.getTerminNastaveByGodinaStudija(godinaStudijaId), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<TerminNastave> getTerminNastaveById(@PathVariable Long id) {
        Optional<TerminNastave> terminNastave = terminNastaveService.getTerminNastaveById(id);
        if(terminNastave.isPresent()) {
            return new ResponseEntity<TerminNastave>(terminNastave.get(), HttpStatus.OK);
        }
        return new ResponseEntity<TerminNastave>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<TerminNastave> addTerminNastave(@RequestBody TerminNastave terminNastave) {
    	terminNastaveService.addTerminNastave(terminNastave);
        return new ResponseEntity<TerminNastave>(terminNastave, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<TerminNastave> updateTerminNastave(@PathVariable Long id, @RequestBody TerminNastave terminNastave) {
    	terminNastaveService.updateTerminNastave(id, terminNastave);
        return new ResponseEntity<TerminNastave>(terminNastave, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<TerminNastave> removeTerminNastave(@PathVariable Long id) {
        try {
        	terminNastaveService.removeTerminNastave(id);
        }catch (Exception e) {
            return new ResponseEntity<TerminNastave>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TerminNastave>(HttpStatus.NO_CONTENT);
    }

}