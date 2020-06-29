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

import backend.app.model.Adresa;
import backend.app.service.AdresaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/adresa")
public class AdresaController {

    @Autowired
    AdresaService adresaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Adresa>> getAdresa() {
        return new ResponseEntity<Iterable<Adresa>>(adresaService.getAdresa(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Adresa> getAdresaById(@PathVariable Long id) {
        Optional<Adresa> adresa = adresaService.getAdresaById(id);
        if(adresa.isPresent()) {
            return new ResponseEntity<Adresa>(adresa.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Adresa>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Adresa> addAdresa(@RequestBody Adresa adresa) {
    	adresaService.addAdresa(adresa);
        return new ResponseEntity<Adresa>(adresa, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Adresa> updateAdresa(@PathVariable Long id, @RequestBody Adresa adresa) {
    	adresaService.updateAdresa(id, adresa);
        return new ResponseEntity<Adresa>(adresa, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Adresa> removeAdresa(@PathVariable Long id) {
        try {
        	adresaService.removeAdresa(id);
        }catch (Exception e) {
            return new ResponseEntity<Adresa>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Adresa>(HttpStatus.NO_CONTENT);
    }

}
