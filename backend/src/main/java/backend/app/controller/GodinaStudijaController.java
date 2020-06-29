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

import backend.app.model.GodinaStudija;
import backend.app.model.Predmet;
import backend.app.service.GodinaStudijaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/godinaStudija")
public class GodinaStudijaController {

    @Autowired
    GodinaStudijaService godinaStudijaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<GodinaStudija>> getGodinaStudija() {
        return new ResponseEntity<Iterable<GodinaStudija>>(godinaStudijaService.getGodinaStudija(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<GodinaStudija> getGodinaStudijaById(@PathVariable Long id) {
        Optional<GodinaStudija> godinaStudija = godinaStudijaService.getGodinaStudijaById(id);
        if(godinaStudija.isPresent()) {
            return new ResponseEntity<GodinaStudija>(godinaStudija.get(), HttpStatus.OK);
        }
        return new ResponseEntity<GodinaStudija>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<GodinaStudija> addGodinaStudija(@RequestBody GodinaStudija godinaStudija) {
    	godinaStudijaService.addGodinaStudija(godinaStudija);
        return new ResponseEntity<GodinaStudija>(godinaStudija, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<GodinaStudija> updateGodinaStudija(@PathVariable Long id, @RequestBody GodinaStudija godinaStudija) {
    	godinaStudijaService.updateGodinaStudija(id, godinaStudija);
        return new ResponseEntity<GodinaStudija>(godinaStudija, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<GodinaStudija> removeGodinaStudija(@PathVariable Long id) {
        try {
        	godinaStudijaService.removeGodinaStudija(id);
        }catch (Exception e) {
            return new ResponseEntity<GodinaStudija>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<GodinaStudija>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/predmeti/{godinaStudijaId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Predmet>> getGodinaStudija(@PathVariable Long godinaStudijaId) {
        return new ResponseEntity<ArrayList<Predmet>>(godinaStudijaService.getPredmet(godinaStudijaId), HttpStatus.OK);
    }

}
