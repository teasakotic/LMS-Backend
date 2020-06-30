package backend.app.controller;

import java.util.ArrayList;
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

import backend.app.model.StudijskiProgram;
import backend.app.service.StudijskiProgramService;
import backend.app.model.GodinaStudija;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/studijskiProgram")
public class StudijskiProgramController {

    @Autowired
    StudijskiProgramService studijskiProgramService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<StudijskiProgram>> getStudijskiProgram() {
        return new ResponseEntity<Iterable<StudijskiProgram>>(studijskiProgramService.getStudijskiProgram(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<StudijskiProgram> getStudijskiProgramById(@PathVariable Long id) {
        Optional<StudijskiProgram> studijskiProgram = studijskiProgramService.getStudijskiProgramById(id);
        if(studijskiProgram.isPresent()) {
            return new ResponseEntity<StudijskiProgram>(studijskiProgram.get(), HttpStatus.OK);
        }
        return new ResponseEntity<StudijskiProgram>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<StudijskiProgram> addStudijskiProgram(@RequestBody StudijskiProgram studijskiProgram) {
    	studijskiProgramService.addStudijskiProgram(studijskiProgram);
        return new ResponseEntity<StudijskiProgram>(studijskiProgram, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<StudijskiProgram> updateStudijskiProgram(@PathVariable Long id, @RequestBody StudijskiProgram studijskiProgram) {
    	studijskiProgramService.updateStudijskiProgram(id, studijskiProgram);
        return new ResponseEntity<StudijskiProgram>(studijskiProgram, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<StudijskiProgram> removeStudijskiProgram(@PathVariable Long id) {
        try {
        	studijskiProgramService.removeStudijskiProgram(id);
        }catch (Exception e) {
            return new ResponseEntity<StudijskiProgram>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<StudijskiProgram>(HttpStatus.NO_CONTENT);
    }
    
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/godinaStudija/{studijskiProgramId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<GodinaStudija>> getGodinaStudija(@PathVariable Long studijskiProgramId) {
        return new ResponseEntity<ArrayList<GodinaStudija>>(studijskiProgramService.getGodinaStudija(studijskiProgramId), HttpStatus.OK);
    }

}
