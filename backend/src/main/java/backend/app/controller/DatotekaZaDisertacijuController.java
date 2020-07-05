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

import backend.app.model.DatotekaZaDisertaciju;
import backend.app.service.DatotekaZaDisertacijuService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/datotekaZaDisertaciju")
public class DatotekaZaDisertacijuController {

    @Autowired
    DatotekaZaDisertacijuService datotekaZaDisertacijuService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<DatotekaZaDisertaciju>> getDatotekaZaDisertaciju() {
        return new ResponseEntity<Iterable<DatotekaZaDisertaciju>>(datotekaZaDisertacijuService.getDatotekaZaDisertaciju(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<DatotekaZaDisertaciju> getDatotekaZaDisertacijuById(@PathVariable Long id) {
        Optional<DatotekaZaDisertaciju> datotekaZaDisertaciju= datotekaZaDisertacijuService.getDatotekaZaDisertacijuById(id);
        if(datotekaZaDisertaciju.isPresent()) {
            return new ResponseEntity<DatotekaZaDisertaciju>(datotekaZaDisertaciju.get(), HttpStatus.OK);
        }
        return new ResponseEntity<DatotekaZaDisertaciju>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<DatotekaZaDisertaciju> addDatotekaZaDisertaciju(@RequestBody DatotekaZaDisertaciju datotekaZaDisertaciju) {
    	datotekaZaDisertacijuService.addDatotekaZaDisertaciju(datotekaZaDisertaciju);
        return new ResponseEntity<DatotekaZaDisertaciju>(datotekaZaDisertaciju, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<DatotekaZaDisertaciju> updateDatotekaZaDisertaciju(@PathVariable Long id, @RequestBody DatotekaZaDisertaciju datotekaZaDisertaciju) {
    	datotekaZaDisertacijuService.updateDatotekaZaDisertaciju(id, datotekaZaDisertaciju);
        return new ResponseEntity<DatotekaZaDisertaciju>(datotekaZaDisertaciju, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<DatotekaZaDisertaciju> removeDatotekaZaDisertaciju(@PathVariable Long id) {
        try {
        	datotekaZaDisertacijuService.removeDatotekaZaDisertaciju(id);
        }catch (Exception e) {
            return new ResponseEntity<DatotekaZaDisertaciju>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<DatotekaZaDisertaciju>(HttpStatus.NO_CONTENT);
    }

}