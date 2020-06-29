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

import backend.app.model.EvaluacijaZnanjaIshod;
import backend.app.service.EvaluacijaZnanjaIshodService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/evaluacijaZnanjaIshod")

public class EvaluacijaZnanjaIshodController {
	@Autowired
	EvaluacijaZnanjaIshodService evaluacijaZnanjaIshodService;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<EvaluacijaZnanjaIshod>> getEvaluacijaZnanjaIshod() {
        return new ResponseEntity<Iterable<EvaluacijaZnanjaIshod>>(evaluacijaZnanjaIshodService.getEvaluacijaZnanjaIshod(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<EvaluacijaZnanjaIshod> getEvaluacijaZnanjaIshodById(@PathVariable Long id) {
        Optional<EvaluacijaZnanjaIshod> evaluacijaZnanjaIshod = evaluacijaZnanjaIshodService.getEvaluacijaZnanjaIshodById(id);
        if(evaluacijaZnanjaIshod.isPresent()) {
            return new ResponseEntity<EvaluacijaZnanjaIshod>(evaluacijaZnanjaIshod.get(), HttpStatus.OK);
        }
        return new ResponseEntity<EvaluacijaZnanjaIshod>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<EvaluacijaZnanjaIshod> addEvaluacijaZnanjaIshod(@RequestBody EvaluacijaZnanjaIshod evaluacijaZnanjaIshod) {
    	evaluacijaZnanjaIshodService.addEvaluacijaZnanjaIshod(evaluacijaZnanjaIshod);
        return new ResponseEntity<EvaluacijaZnanjaIshod>(evaluacijaZnanjaIshod, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<EvaluacijaZnanjaIshod> updateEvaluacijaZnanjaIshod(@PathVariable Long id, @RequestBody EvaluacijaZnanjaIshod evaluacijaZnanjaIshod) {
    	evaluacijaZnanjaIshodService.updateEvaluacijaZnanjaIshod(id, evaluacijaZnanjaIshod);
        return new ResponseEntity<EvaluacijaZnanjaIshod>(evaluacijaZnanjaIshod, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<EvaluacijaZnanjaIshod> removeEvaluacijaZnanjaIshod(@PathVariable Long id) {
        try {
        	evaluacijaZnanjaIshodService.removeEvaluacijaZnanjaIshod(id);
        }catch (Exception e) {
            return new ResponseEntity<EvaluacijaZnanjaIshod>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<EvaluacijaZnanjaIshod>(HttpStatus.NO_CONTENT);
    }
}
