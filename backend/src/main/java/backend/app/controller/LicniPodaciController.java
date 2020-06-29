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

import backend.app.model.LicniPodaci;
import backend.app.service.LicniPodaciService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/licniPodaci")
public class LicniPodaciController {

	@Autowired
	LicniPodaciService licniPodaciService;

	@JsonView(HideOptionalProperties.class)
	@RequestMapping()
	public ResponseEntity<Iterable<LicniPodaci>> getLicniPodaci() {
		return new ResponseEntity<Iterable<LicniPodaci>>(licniPodaciService.getLicniPodaci(), HttpStatus.OK);
	}

	@JsonView(HideOptionalProperties.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<LicniPodaci> getLicniPodaciById(@PathVariable Long id) {
		Optional<LicniPodaci> licniPodaci = licniPodaciService.getLicniPodaciById(id);
		if (licniPodaci.isPresent()) {
			return new ResponseEntity<LicniPodaci>(licniPodaci.get(), HttpStatus.OK);
		}
		return new ResponseEntity<LicniPodaci>(HttpStatus.NOT_FOUND);
	}
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	public ResponseEntity<LicniPodaci> getLicniPodaciByUsername(@PathVariable String username) {
		Optional<LicniPodaci> licniPodaci = licniPodaciService.getLicniPodaciByUsername(username);
		if (licniPodaci.isPresent()) {
			return new ResponseEntity<LicniPodaci>(licniPodaci.get(), HttpStatus.OK);
		}
		return new ResponseEntity<LicniPodaci>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<LicniPodaci> addLicniPodaci(@RequestBody LicniPodaci licniPodaci) {
		licniPodaciService.addLicniPodaci(licniPodaci);
		return new ResponseEntity<LicniPodaci>(licniPodaci, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<LicniPodaci> updateLicniPodaci(@PathVariable Long id,
			@RequestBody LicniPodaci licniPodaci) {
		licniPodaciService.updateLicniPodaci(id, licniPodaci);
		return new ResponseEntity<LicniPodaci>(licniPodaci, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<LicniPodaci> removePLicniPodaci(@PathVariable Long id) {
		try {
			licniPodaciService.removeLicniPodaci(id);
		} catch (Exception e) {
			return new ResponseEntity<LicniPodaci>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<LicniPodaci>(HttpStatus.NO_CONTENT);
	}

}
