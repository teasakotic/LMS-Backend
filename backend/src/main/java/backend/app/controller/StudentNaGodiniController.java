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

import backend.app.model.StudentNaGodini;
import backend.app.service.StudentNaGodiniService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/studentNaGodini")
public class StudentNaGodiniController {

    @Autowired
    StudentNaGodiniService studentNaGodiniService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<StudentNaGodini>> getStudentNaGodini() {
        return new ResponseEntity<Iterable<StudentNaGodini>>(studentNaGodiniService.getStudentNaGodini(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<StudentNaGodini> getStudentNaGodiniById(@PathVariable Long id) {
        Optional<StudentNaGodini> studentNaGodini= studentNaGodiniService.getStudentNaGodiniById(id);
        if(studentNaGodini.isPresent()) {
            return new ResponseEntity<StudentNaGodini>(studentNaGodini.get(), HttpStatus.OK);
        }
        return new ResponseEntity<StudentNaGodini>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<StudentNaGodini> addStudentNaGodini(@RequestBody StudentNaGodini studentNaGodini) {
    	studentNaGodiniService.addStudentNaGodini(studentNaGodini);
        return new ResponseEntity<StudentNaGodini>(studentNaGodini, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<StudentNaGodini> updateStudentNaGodini(@PathVariable Long id, @RequestBody StudentNaGodini studentNaGodini) {
    	studentNaGodiniService.updateStudentNaGodini(id, studentNaGodini);
        return new ResponseEntity<StudentNaGodini>(studentNaGodini, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<StudentNaGodini> removeStudentNaGodini(@PathVariable Long id) {
        try {
        	studentNaGodiniService.removeStudentNaGodini(id);
        }catch (Exception e) {
            return new ResponseEntity<StudentNaGodini>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<StudentNaGodini>(HttpStatus.NO_CONTENT);
    }

}
