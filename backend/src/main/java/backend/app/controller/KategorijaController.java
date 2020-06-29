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

import backend.app.model.Kategorija;
import backend.app.service.KategorijaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/kategorija")
public class KategorijaController {

    @Autowired
    KategorijaService kategorijaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Kategorija>> getKategorija() {
        return new ResponseEntity<Iterable<Kategorija>>(kategorijaService.getKategorija(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Kategorija> getKategorijaById(@PathVariable Long id) {
        Optional<Kategorija> kategorija = kategorijaService.getKategorijaById(id);
        if(kategorija.isPresent()) {
            return new ResponseEntity<Kategorija>(kategorija.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Kategorija>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Kategorija> addKategorija(@RequestBody Kategorija kategorija) {
    	kategorijaService.addKategorija(kategorija);
        return new ResponseEntity<Kategorija>(kategorija, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Kategorija> updateKategorija(@PathVariable Long id, @RequestBody Kategorija kategorija) {
    	kategorijaService.updateKategorija(id, kategorija);
        return new ResponseEntity<Kategorija>(kategorija, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Kategorija> removeKategorija(@PathVariable Long id) {
        try {
        	kategorijaService.removeKategorija(id);
        }catch (Exception e) {
            return new ResponseEntity<Kategorija>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Kategorija>(HttpStatus.NO_CONTENT);
    }

}
