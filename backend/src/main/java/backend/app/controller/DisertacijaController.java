package backend.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.service.DisertacijaService;
import backend.app.utils.ViewUtils.ShowDisertacija;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/disertacija")
public class DisertacijaController {
	
	@Autowired
	DisertacijaService disService;
	
	@JsonView(ShowDisertacija.class)
    @RequestMapping(value="/{studentId}", method=RequestMethod.GET)
    public ResponseEntity<ArrayList<Object>> getDisertacijaByStudentId(@PathVariable Long studentId) {
		ArrayList<Object> dis = disService.findDisertacijaByStudentId(studentId);
		if (dis.size() != 0) return new ResponseEntity<ArrayList<Object>>(dis, HttpStatus.OK);
        return new ResponseEntity<ArrayList<Object>>(HttpStatus.NO_CONTENT);
    }

}
