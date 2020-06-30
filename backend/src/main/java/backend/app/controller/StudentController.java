package backend.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import backend.app.service.StudentService;

@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/studenti")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
//	@RequestMapping(method = RequestMethod.POST)
//	public 

}
