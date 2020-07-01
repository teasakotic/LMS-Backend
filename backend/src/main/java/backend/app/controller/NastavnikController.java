package backend.app.controller;


import java.io.IOException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;

import backend.app.model.Nastavnik;
import backend.app.model.RealizacijaPredmeta;
import backend.app.service.FileService;
import backend.app.service.NastavnikService;

import backend.app.utils.ViewUtils.HideOptionalProperties;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/nastavnik")
public class NastavnikController {

    @Autowired
    NastavnikService nastavnikService;

    @Autowired
    FileService fileService;
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Nastavnik>> getNastavnik() {
        return new ResponseEntity<Iterable<Nastavnik>>(nastavnikService.getNastavnik(), HttpStatus.OK);
    }
    
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/fakultet/{fakultetId}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<Nastavnik>>> getNastavnikByFakultet(@PathVariable Long fakultetId) {
        return new ResponseEntity<Iterable<Optional<Nastavnik>>>(nastavnikService.getNastavnikByFakultet(fakultetId), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Nastavnik> getNastavnikById(@PathVariable Long id) {
        Optional<Nastavnik> nastavnik = nastavnikService.getNastavnikById(id);
        if(nastavnik.isPresent()) {
            return new ResponseEntity<Nastavnik>(nastavnik.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/username/{username}", method=RequestMethod.GET)
    public ResponseEntity<Nastavnik> getNastavnikByUsername(@PathVariable String username) {
        Optional<Nastavnik> nastavnik = nastavnikService.getNastavnikByUsername(username);
        if(nastavnik.isPresent()) {
            return new ResponseEntity<Nastavnik>(nastavnik.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/{username}", method=RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Nastavnik> updateNastavnik(@PathVariable String username, @RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String nastavnikStr) throws IOException {
    	Nastavnik nastavnik = new ObjectMapper().readValue(nastavnikStr, Nastavnik.class);
		if(file.isPresent()) {
			fileService.saveProfileImage(file.get(), "teacher_" + nastavnik.getRegistrovaniKorisnik().getUsername(), nastavnik.getLicniPodaci());
		}
		nastavnikService.updateNastavnik(username, nastavnik);
        return new ResponseEntity<Nastavnik>(nastavnik, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Nastavnik> removeNastavnik(@PathVariable Long id) {
        try {
        	nastavnikService.removeNastavnik(id);
        }catch (Exception e) {
            return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Nastavnik>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/findByName/{name}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<Nastavnik>>> getNastavnikByIme(@PathVariable String ime) {
        Iterable<Optional<Nastavnik>> nastavnik = nastavnikService.getNastavnikByIme(ime);
        return new ResponseEntity<Iterable<Optional<Nastavnik>>>(nastavnik, HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/findByJmbg/{jmbg}", method=RequestMethod.GET)
    public ResponseEntity<Nastavnik> getNastavnikByJmbg(@PathVariable String jmbg) {
        Optional<Nastavnik> nastavnik = nastavnikService.getNastavnikByJmbg(jmbg);
        if(nastavnik.isPresent()) {
            return new ResponseEntity<Nastavnik>(nastavnik.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Nastavnik>(HttpStatus.NOT_FOUND);
    }
    
    @JsonView(HideOptionalProperties.class)
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<Nastavnik> addNastavnik(@RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String nastavnikStr) throws IOException {
    	Nastavnik nastavnik = new ObjectMapper().readValue(nastavnikStr, Nastavnik.class);
		if(file.isPresent()) {
			fileService.saveProfileImage(file.get(), "nastavnik_" + nastavnik.getRegistrovaniKorisnik().getUsername(), nastavnik.getLicniPodaci());
		}
		nastavnikService.addNastavnik(nastavnik);
		return new ResponseEntity<Nastavnik>(nastavnik, HttpStatus.CREATED);
	}
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{username}/realizacijaPredmeta", method=RequestMethod.GET)
    public ResponseEntity<Iterable<RealizacijaPredmeta>> getRealizacijaPredmeta(@PathVariable String username) {
        return new ResponseEntity<Iterable<RealizacijaPredmeta>>(nastavnikService.getRealizacijaPredmeta(username), HttpStatus.OK);
    }

}
