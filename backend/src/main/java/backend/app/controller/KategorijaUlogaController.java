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

import backend.app.model.KategorijaUloga;
import backend.app.service.KategorijaUlogaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/kategorijaUloga")
public class KategorijaUlogaController {

    @Autowired
    KategorijaUlogaService kategorijaUlogaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<KategorijaUloga>> getKategorijaUloga() {
        return new ResponseEntity<Iterable<KategorijaUloga>>(kategorijaUlogaService.getKategorijaUloga(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<KategorijaUloga> getKategorijaUlogaById(@PathVariable Long id) {
        Optional<KategorijaUloga> kategorijaUloga = kategorijaUlogaService.getKategorijaUlogaById(id);
        if(kategorijaUloga.isPresent()) {
            return new ResponseEntity<KategorijaUloga>(kategorijaUloga.get(), HttpStatus.OK);
        }
        return new ResponseEntity<KategorijaUloga>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<KategorijaUloga> addKategorijaUloga(@RequestBody KategorijaUloga kategorijaUloga) {
    	kategorijaUlogaService.addKategorijaUloga(kategorijaUloga);
        return new ResponseEntity<KategorijaUloga>(kategorijaUloga, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<KategorijaUloga> updateKategorijaUloga(@PathVariable Long id, @RequestBody KategorijaUloga kategorijaUloga) {
    	kategorijaUlogaService.updateKategorijaUloga(id, kategorijaUloga);
        return new ResponseEntity<KategorijaUloga>(kategorijaUloga, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<KategorijaUloga> removeKategorijaUloga(@PathVariable Long id) {
        try {
        	kategorijaUlogaService.removeKategorijaUloga(id);
        }catch (Exception e) {
            return new ResponseEntity<KategorijaUloga>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<KategorijaUloga>(HttpStatus.NO_CONTENT);
    }

}
