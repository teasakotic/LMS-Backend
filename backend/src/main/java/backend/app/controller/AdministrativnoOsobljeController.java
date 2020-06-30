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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;

import backend.app.model.AdministrativnoOsoblje;
import backend.app.model.GodinaStudija;
import backend.app.model.Student;
import backend.app.service.AdministrativnoOsobljeService;
import backend.app.service.FajlService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/administrativnoOsoblje")
public class AdministrativnoOsobljeController {

    @Autowired
    AdministrativnoOsobljeService administrativnoOsobljeService;

    @Autowired
    FajlService fajlService;
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<AdministrativnoOsoblje>> getAdministrativnoOsoblje() {
        return new ResponseEntity<Iterable<AdministrativnoOsoblje>>(administrativnoOsobljeService.getAdministrativnoOsoblje(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<AdministrativnoOsoblje> getAdministrativnoOsobljeById(@PathVariable Long id) {
        Optional<AdministrativnoOsoblje> administrativnoOsoblje = administrativnoOsobljeService.getAdministrativnoOsobljeById(id);
        if(administrativnoOsoblje.isPresent()) {
            return new ResponseEntity<AdministrativnoOsoblje>(administrativnoOsoblje.get(), HttpStatus.OK);
        }
        return new ResponseEntity<AdministrativnoOsoblje>(HttpStatus.NOT_FOUND);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/username/{username}", method=RequestMethod.GET)
    public ResponseEntity<AdministrativnoOsoblje> getAdministrativnoOsobljeByUsername(@PathVariable String username) {
        Optional<AdministrativnoOsoblje> administrativnoOsoblje = administrativnoOsobljeService.getAdministrativnoOsobljeByUsername(username);
        if(administrativnoOsoblje.isPresent()) {
            return new ResponseEntity<AdministrativnoOsoblje>(administrativnoOsoblje.get(), HttpStatus.OK);
        }
        return new ResponseEntity<AdministrativnoOsoblje>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/{username}", method=RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AdministrativnoOsoblje> updateAdministrativnoOsoblje(@PathVariable String username, @RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String admStfStr) throws IOException {
    	AdministrativnoOsoblje admStf = new ObjectMapper().readValue(admStfStr, AdministrativnoOsoblje.class);
		if(file.isPresent()) {
			fajlService.saveProfileImage(file.get(), "administrativno_osoblje_" + admStf.getRegistrovaniKorisnik().getUsername(), admStf.getLicniPodaci());
		}
		administrativnoOsobljeService.updateAdministrativnoOsoblje(username, admStf);
        return new ResponseEntity<AdministrativnoOsoblje>(admStf, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<AdministrativnoOsoblje> removeAdministrativnoOsoblje(@PathVariable Long id) {
        try {
        	administrativnoOsobljeService.removeAdministrativnoOsoblje(id);
        }catch (Exception e) {
            return new ResponseEntity<AdministrativnoOsoblje>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<AdministrativnoOsoblje>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@Secured("ROLE_ADMINISTRATOR")
	public ResponseEntity<AdministrativnoOsoblje> addAAdministrativnoOsoblje(@RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String admStfStr) throws IOException {
    	AdministrativnoOsoblje admStf = new ObjectMapper().readValue(admStfStr, AdministrativnoOsoblje.class);
		if(fajl.isPresent()) {
			fajlService.saveProfileImage(file.get(), "administrativno_osoblje_" + admStf.getRegistrovaniKorisnik().getUsername(), admStf.getLicniPodaci());
		}
		administrativnoOsobljeService.addAdministrativnoOsoblje(admStf);
		return new ResponseEntity<AdministrativnoOsoblje>(admStf, HttpStatus.CREATED);
	}
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/upis/{godinaStudijaId}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Student>> getStudentiZaUpisUNarednuGodinu(@PathVariable Long godinaStudijaId) {
        return new ResponseEntity<Iterable<Student>>(administrativnoOsobljeService.getStudentiZaUpisUNarednuGodinu(godinaStudijaId), HttpStatus.OK);
    }

    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/upis/{studentId}", method=RequestMethod.PUT)
    public ResponseEntity<Boolean> upisStudenataUNarednuGodinu(@PathVariable Long studentId, @RequestBody GodinaStudija godinaStudija) {
    	return new ResponseEntity<Boolean>(administrativnoOsobljeService.upisStudenataUNarednuGodinu(studentId, godinaStudija), HttpStatus.OK);
    }

}
