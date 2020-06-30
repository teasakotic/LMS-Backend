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

import backend.app.model.RegistrovaniKorisnik;
import backend.app.service.RegistrovaniKorisnikService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/registrovaniKorisnik")
public class RegistrovaniKorisnikController {

    @Autowired
    RegistrovaniKorisnikService registrovaniKorisnikService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<RegistrovaniKorisnik>> getRegistrovaniKorisnik() {
        return new ResponseEntity<Iterable<RegistrovaniKorisnik>>(registrovaniKorisnikService.getRegistrovaniKorisnik(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<RegistrovaniKorisnik> getRegistrovaniKorisnikById(@PathVariable Long id) {
        Optional<RegistrovaniKorisnik> registrovaniKorisnik = registrovaniKorisnikService.getRegistrovaniKorisnikById(id);
        if(registrovaniKorisnik.isPresent()) {
            return new ResponseEntity<RegistrovaniKorisnik>(registrovaniKorisnik.get(), HttpStatus.OK);
        }
        return new ResponseEntity<RegistrovaniKorisnik>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<RegistrovaniKorisnik> addRegistrovaniKorisnik(@RequestBody RegistrovaniKorisnik registrovaniKorisnik) {
    	registrovaniKorisnikService.addRegistrovaniKorisnik(registrovaniKorisnik);
        return new ResponseEntity<RegistrovaniKorisnik>(registrovaniKorisnik, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<RegistrovaniKorisnik> updateRegistrovaniKorisnik(@PathVariable Long id, @RequestBody RegistrovaniKorisnik registrovaniKorisnik) {
    	registrovaniKorisnikService.updateRegistrovaniKorisnik(id, registrovaniKorisnik);
        return new ResponseEntity<RegistrovaniKorisnik>(registrovaniKorisnik, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<RegistrovaniKorisnik> removeRegistrovaniKorisnik(@PathVariable Long id) {
        try {
        	registrovaniKorisnikService.removeRegistrovaniKorisnik(id);
        }catch (Exception e) {
            return new ResponseEntity<RegistrovaniKorisnik>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<RegistrovaniKorisnik>(HttpStatus.NO_CONTENT);
    }

}
