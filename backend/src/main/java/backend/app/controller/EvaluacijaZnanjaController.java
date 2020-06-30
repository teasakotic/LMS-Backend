package backend.app.controller;


import java.util.Collection;
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

import backend.app.dto.EvaluacijaZnanjaDTO;
import backend.app.model.EvaluacijaZnanja;
import backend.app.model.TipEvaluacije;
import backend.app.service.EvaluacijaZnanjaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/evaluacijaZnanja")
public class EvaluacijaZnanjaController {
	
	@Autowired
	EvaluacijaZnanjaService evaluacijaZnanjaService;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<EvaluacijaZnanja>> getEvaluacijaZnanja() {
        return new ResponseEntity<Iterable<EvaluacijaZnanja>>(evaluacijaZnanjaService.getEvaluacijaZnanja(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<EvaluacijaZnanja> getEvaluacijaZnanjaById(@PathVariable Long id) {
        Optional<EvaluacijaZnanja> evaluacijaZnanja = evaluacijaZnanjaService.getEvaluacijaZnanjaById(id);
        if(evaluacijaZnanja.isPresent()) {
            return new ResponseEntity<EvaluacijaZnanja>(evaluacijaZnanja.get(), HttpStatus.OK);
        }
        return new ResponseEntity<EvaluacijaZnanja>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<EvaluacijaZnanja> addEvaluacijaZnanja(@RequestBody EvaluacijaZnanja evaluacijaZnanja) {
    	evaluacijaZnanjaService.addEvaluacijaZnanja(evaluacijaZnanja);
        return new ResponseEntity<EvaluacijaZnanja>(evaluacijaZnanja, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<EvaluacijaZnanja> updateEvaluacijaZnanja(@PathVariable Long id, @RequestBody EvaluacijaZnanja evaluacijaZnanja) {
    	evaluacijaZnanjaService.updateEvaluacijaZnanja(id, evaluacijaZnanja);
        return new ResponseEntity<EvaluacijaZnanja>(evaluacijaZnanja, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<EvaluacijaZnanja> removeEvaluacijaZnanja(@PathVariable Long id) {
        try {
        	evaluacijaZnanjaService.removeEvaluacijaZnanja(id);
        }catch (Exception e) {
            return new ResponseEntity<EvaluacijaZnanja>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<EvaluacijaZnanja>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/tip", method=RequestMethod.GET)
    public ResponseEntity<Iterable<TipEvaluacije>> getTipEvaluacije() {
        return new ResponseEntity<Iterable<TipEvaluacije>>(evaluacijaZnanjaService.getTipEvaluacije(), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{studentId}/evaluacijaZnanja", method=RequestMethod.GET)
    public ResponseEntity<Collection<EvaluacijaZnanjaDTO>> getEvaluacijaZnanjaByStudent(@PathVariable Long studentId){
    	Collection<EvaluacijaZnanjaDTO> evaluacijaZnanja = evaluacijaZnanjaService.getEvaluacijaZnanjaByStudent(studentId);
    	if (evaluacijaZnanja.isEmpty()) return new ResponseEntity<Collection<EvaluacijaZnanjaDTO>>(HttpStatus.NO_CONTENT);
    	return new ResponseEntity<Collection<EvaluacijaZnanjaDTO>>(evaluacijaZnanja, HttpStatus.OK);
    }

    
    
}
