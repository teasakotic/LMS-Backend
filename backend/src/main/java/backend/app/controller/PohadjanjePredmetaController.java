package backend.app.controller;

import java.util.ArrayList;
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

import backend.app.mapper.StudentMapper;
import backend.app.model.PohadjanjePredmeta;
import backend.app.model.Predmet;
import backend.app.model.Student;
import backend.app.service.PohadjanjePredmetaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;
import backend.app.utils.ViewUtils.ShowGodinaStudija;
import backend.app.utils.ViewUtils.ShowStudent;
import backend.app.dto.StudentDTO;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/pohadjanjePredmeta")
public class PohadjanjePredmetaController {

    @Autowired
    PohadjanjePredmetaService pohadjanjePredmetaService;
    @Autowired
    StudentMapper studentMapper;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<PohadjanjePredmeta>> getPohadjanjePredmeta() {
        return new ResponseEntity<Iterable<PohadjanjePredmeta>>(pohadjanjePredmetaService.getPohadjanjePredmeta(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<PohadjanjePredmeta> getPohadjanjePredmetaById(@PathVariable Long id) {
        Optional<PohadjanjePredmeta> pohadjanjePredmeta = pohadjanjePredmetaService.getPohadjanjePredmetaById(id);
        if(pohadjanjePredmeta.isPresent()) {
            return new ResponseEntity<PohadjanjePredmeta>(pohadjanjePredmeta.get(), HttpStatus.OK);
        }
        return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<PohadjanjePredmeta> addPohadjanjePredmeta(@RequestBody PohadjanjePredmeta pohadjanjePredmeta) {
    	pohadjanjePredmetaService.addPohadjanjePredmeta(pohadjanjePredmeta);
        return new ResponseEntity<PohadjanjePredmeta>(pohadjanjePredmeta, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<PohadjanjePredmeta> updatePohadjanjePredmeta(@PathVariable Long id, @RequestBody PohadjanjePredmeta pohadjanjePredmeta) {
    	pohadjanjePredmetaService.updatePohadjanjePredmeta(id, pohadjanjePredmeta);
        return new ResponseEntity<PohadjanjePredmeta>(pohadjanjePredmeta, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<PohadjanjePredmeta> removePohadjanjePredmeta(@PathVariable Long id) {
        try {
        	pohadjanjePredmetaService.removePohadjanjePredmeta(id);
        }catch (Exception e) {
            return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<PohadjanjePredmeta>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/prosecnaOcena/{studentId}", method=RequestMethod.GET)
    public ResponseEntity<Double> getProsecnaOcena(@PathVariable Long studentId) {
        Double prosecnaOcena = pohadjanjePredmetaService.getProsecnaOcena(studentId);
        return new ResponseEntity<Double>(prosecnaOcena, HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/studentiKojiNisuPoloziliIspit/{predmetId}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Student>> getStudentiKojiNisuPoloziliIspit(@PathVariable Long predmetId) {
        return new ResponseEntity<Iterable<Student>>(pohadjanjePredmetaService.getStudentiKojiNisuPoloziliIspit(predmetId), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/predmeti/{studentUsername}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Predmet>> getTrenutniPredmetiId(@PathVariable String studentUsername) {
    	return new ResponseEntity<ArrayList<Predmet>>(pohadjanjePredmetaService.getTrenutniPredmeti(studentUsername), HttpStatus.OK);
    }
    
    @JsonView(ShowGodinaStudija.class)
    @RequestMapping(value="/polozeniPredmeti/{studentUsername}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Object>> getPolozeniPredmetiByStudentUsername(@PathVariable String studentUsername) {
    	return new ResponseEntity<ArrayList<Object>>(pohadjanjePredmetaService.getPolozenePredmete(studentUsername), HttpStatus.OK);
    }
    
    @JsonView(ShowStudent.class)
    @RequestMapping(value="/nastavnik/{nastavnikUsername}/{predmetId}/student", method=RequestMethod.GET)
    public ResponseEntity<Collection<StudentDTO>> getStudentByPredmet(@PathVariable String nastavnikUsername, @PathVariable Long predmetId){
    	Collection<Student> studenti = pohadjanjePredmetaService.getStudentByPredmet(predmetId, nastavnikUsername);
    	
    	return new ResponseEntity<Collection<StudentDTO>>(studentMapper.toDtoList(studenti), HttpStatus.OK);
    }
    
}
