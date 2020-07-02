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
import backend.app.model.RealizacijaPredmeta;
import backend.app.service.RealizacijaPredmetaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/realizacijaPredmeta")
public class RealizacijaPredmetaController {

    @Autowired
    RealizacijaPredmetaService realizacijaPredmetaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<RealizacijaPredmeta>> getRealizacijaPredmeta() {
        return new ResponseEntity<Iterable<RealizacijaPredmeta>>(realizacijaPredmetaService.getRealizacijaPredmeta(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<RealizacijaPredmeta> getRealizacijaPredmetaById(@PathVariable Long id) {
        Optional<RealizacijaPredmeta> realizacijaPredmeta = realizacijaPredmetaService.getRealizacijaPredmetaById(id);
        if(realizacijaPredmeta.isPresent()) {
            return new ResponseEntity<RealizacijaPredmeta>(realizacijaPredmeta.get(), HttpStatus.OK);
        }
        return new ResponseEntity<RealizacijaPredmeta>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<RealizacijaPredmeta> addRealizacijaPredmeta(@RequestBody RealizacijaPredmeta realizacijaPredmeta) {
    	realizacijaPredmetaService.addRealizacijaPredmeta(realizacijaPredmeta);
        return new ResponseEntity<RealizacijaPredmeta>(realizacijaPredmeta, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<RealizacijaPredmeta> updateRealizacijaPredmeta(@PathVariable Long id, @RequestBody RealizacijaPredmeta realizacijaPredmeta) {
    	realizacijaPredmetaService.updateRealizacijaPredmeta(id, realizacijaPredmeta);
        return new ResponseEntity<RealizacijaPredmeta>(realizacijaPredmeta, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<RealizacijaPredmeta> removeRealizacijaPredmeta(@PathVariable Long id) {
        try {
        	realizacijaPredmetaService.removeRealizacijaPredmeta(id);
        }catch (Exception e) {
            return new ResponseEntity<RealizacijaPredmeta>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<RealizacijaPredmeta>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/nastavnikeKojiDrzeVezbe/{predmetId}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Nastavnik>> getNastavnikeKojiDrzeVezbe(@PathVariable Long predmetId) {
        return new ResponseEntity<Iterable<Nastavnik>>(realizacijaPredmetaService.getNastavnikeKojiDrzeVezbe(predmetId), HttpStatus.OK);
    }
 //   @JsonView(HideOptionalProperties.class)
  //  @RequestMapping(value="/nastavnikUsername/{usernameId}", method=RequestMethod.GET)
   // public ResponseEntity<Iterable<RealizacijaPredmeta>> getNastavnikUsername(@PathVariable String usernameId) {
     //   return new ResponseEntity<Iterable<RealizacijaPredmeta>>(realizacijaPredmetaService.getNastavnikUsername(usernameId), HttpStatus.OK);
    //}

}
