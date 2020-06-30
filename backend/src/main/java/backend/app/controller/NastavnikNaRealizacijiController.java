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

import backend.app.model.Nastavnik;
import backend.app.model.NastavnikNaRealizaciji;
import backend.app.service.NastavnikNaRealizacijiService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/nastavnikNaRealizaciji")
public class NastavnikNaRealizacijiController {

    @Autowired
    NastavnikNaRealizacijiService nastavnikNaRealizacijiService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<NastavnikNaRealizaciji>> getNastavnikNaRealizaciji() {
        return new ResponseEntity<Iterable<NastavnikNaRealizaciji>>(nastavnikNaRealizacijiService.getNastavnikNaRealizaciji(), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/godinaStudija/{godinaStudijaId}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<NastavnikNaRealizaciji>>> getNastavnikNaRealizacijiByGodinaStudija(@PathVariable Long godinaStudijaId) {
        return new ResponseEntity<Iterable<Optional<NastavnikNaRealizaciji>>>(nastavnikNaRealizacijiService.getNastavnikNaRealizacijiByGodinaStudija(godinaStudijaId), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<NastavnikNaRealizaciji> getNastavnikNaRealizacijiById(@PathVariable Long id) {
        Optional<NastavnikNaRealizaciji> nastavnikNaRealizaciji = nastavnikNaRealizacijiService.getNastavnikNaRealizacijiById(id);
        if(nastavnikNaRealizaciji.isPresent()) {
            return new ResponseEntity<NastavnikNaRealizaciji>(nastavnikNaRealizaciji.get(), HttpStatus.OK);
        }
        return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<NastavnikNaRealizaciji> addNastavnikNaRealizaciji(@RequestBody NastavnikNaRealizaciji nastavnikNaRealizaciji) {
    	nastavnikNaRealizacijiService.addNastavnikNaRealizaciji(nastavnikNaRealizaciji);
        return new ResponseEntity<NastavnikNaRealizaciji>(nastavnikNaRealizaciji, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<NastavnikNaRealizaciji> updateNastavnikNaRealizaciji(@PathVariable Long id, @RequestBody NastavnikNaRealizaciji nastavnikNaRealizaciji) {
    	nastavnikNaRealizacijiService.updateNastavnikNaRealizaciji(id, nastavnikNaRealizaciji);
        return new ResponseEntity<NastavnikNaRealizaciji>(nastavnikNaRealizaciji, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<NastavnikNaRealizaciji> removeNastavnikNaRealizaciji(@PathVariable Long id) {
        try {
        	nastavnikNaRealizacijiService.removeNastavnikNaRealizaciji(id);
        }catch (Exception e) {
            return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<NastavnikNaRealizaciji>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="nastavniciKojiDrzePredmete/{predmetId}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Nastavnik>> getNastavniciKojiDrzePredmete(@PathVariable Long predmetId) {
        return new ResponseEntity<Iterable<Nastavnik>>(nastavnikNaRealizacijiService.getNastavniciKojiDrzePredmete(predmetId), HttpStatus.OK);
    }
    

}
