package backend.app.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;

import backend.app.model.Ishod;
import backend.app.service.FajlService;
import backend.app.service.IshodService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/ishod")
public class IshodController {

    @Autowired
    IshodService ishodService;
    @Autowired
    FajlService fajlService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Ishod>> getIshod() {
        return new ResponseEntity<Iterable<Ishod>>(ishodService.getIshod(), HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/byPredmet/{id}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<Ishod>>> getIshodByPredmetId(@PathVariable Long id) {
        return new ResponseEntity<Iterable<Optional<Ishod>>>(ishodService.getIshodByPredmetId(id), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Ishod> getIshodById(@PathVariable Long id) {
        Optional<Ishod> ishod = ishodService.getIshodById(id);
        if(ishod.isPresent()) {
            return new ResponseEntity<Ishod>(ishod.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Ishod>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Ishod> addIshod(@RequestPart("icon") Optional<MultipartFile> file, @RequestPart("data") String topicStr) throws IOException {
    	Ishod ishod = new ObjectMapper().readValue(topicStr, Ishod.class);
    	Ishod savedIshod = ishodService.addIshod(ishod);
    	if(file.isPresent()) {
    		fajlService.saveIshodIcon(file.get(), "Ishod_" + savedIshod.getId(), savedIshod);
    		ishodService.updateIshod(savedIshod.getId(), savedIshod);
    	}
        return new ResponseEntity<Ishod>(savedIshod, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Ishod> updateIshod(@PathVariable Long id, @RequestBody Ishod ishod) {
    	ishodService.updateIshod(id, ishod);
        return new ResponseEntity<Ishod>(ishod, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Ishod> removeIshod(@PathVariable Long id) {
        try {
        	ishodService.removeIshod(id);
        }catch (Exception e) {
            return new ResponseEntity<Ishod>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Ishod>(HttpStatus.NO_CONTENT);
    }

}
