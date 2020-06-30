package backend.app.controller;

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

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import backend.app.model.Polaganje;
import backend.app.service.PolaganjeService;
import backend.app.utils.ViewUtils.HideOptionalProperties;

@SuppressWarnings("rawtypes")
@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/polaganje")
public class PolaganjeController {
	
	@Autowired
	PolaganjeService polaganjeService;
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping(value="/{studentId}", method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Polaganje>> getRegisterovaneEvaluacijeZnanjaByStudent(@PathVariable Long studentId){
		ArrayList<Polaganje> registerovaneEvaluacijeZnanja = polaganjeService.getRegisterovaneEvaluacijeZnanjaByStudentId(studentId);
		if(registerovaneEvaluacijeZnanja.size() == 0) return new ResponseEntity<ArrayList<Polaganje>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<ArrayList<Polaganje>>(registerovaneEvaluacijeZnanja, HttpStatus.OK);
	}
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<HttpStatus> registerEvaluacijeZnanjaByStudent(@RequestBody Map json){
		try {
			JSONObject jsonObj=new JSONObject(json);
			if (polaganjeService.registerEvaluacijaZnanja(jsonObj.getLong("evaluacijaZnanjaId"), jsonObj.getLong("realizacijaPredmetaId"), jsonObj.getString("studentUsername")))
				return new ResponseEntity<>(HttpStatus.CREATED);
			else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
