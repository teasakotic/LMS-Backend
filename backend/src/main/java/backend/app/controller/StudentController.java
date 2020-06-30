package backend.app.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ObjectMapper;

import backend.app.mapper.StudentDetaljiMapper;
import backend.app.mapper.StudentMapper;
import backend.app.model.Student;
import backend.app.service.FileService;
import backend.app.service.StudentService;
import backend.app.utils.GeneratePDF;
import backend.app.utils.ViewUtils.HideOptionalProperties;
import backend.app.dto.StudentDTO;
import backend.app.dto.StudentDetaljiDTO;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    
    @Autowired
    FileService fileService;
    
    @Autowired
    StudentMapper studentMapper;
    
    @Autowired
    StudentDetaljiMapper studentDetaljiMapper;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Student>> getStudent() {
        return new ResponseEntity<Iterable<Student>>(studentService.getStudent(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/pdf", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> exportStudentToPDF() {

        ByteArrayInputStream bis = GeneratePDF.student((List<Student>)studentService.getStudent());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=student.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudentById(id);
        if(student.isPresent()) {
            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/username/{username}", method=RequestMethod.GET)
    public ResponseEntity<Student> getStudentByUsername(@PathVariable String username) {
        Optional<Student> student = studentService.getStudentByUsername(username);
        if(student.isPresent()) {
            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/{username}", method=RequestMethod.PUT, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Student> updateStudent(@PathVariable String username, @RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String studentStr) throws IOException {
    	Student student = new ObjectMapper().readValue(studentStr, Student.class);
    	if(file.isPresent()) {
			fileService.saveProfileImage(file.get(), "student_" + student.getRegistrovaniKorisnik().getUsername(), student.getLicniPodaci());
		}
    	studentService.updateStudent(username, student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Student> removeStudent(@PathVariable Long id) {
        try {
            studentService.removeStudent(id);
        }catch (Exception e) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(HttpStatus.NO_CONTENT);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/findByName/{name}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<Student>>> getStudentByIme(@PathVariable String ime) {
        Iterable<Optional<Student>> student = studentService.getStudentByIme(ime);
        return new ResponseEntity<Iterable<Optional<Student>>>(student, HttpStatus.OK);
    }
    
    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/findByJmbg/{jmbg}", method=RequestMethod.GET)
    public ResponseEntity<Student> getStudentByJmbg(@PathVariable String jmbg) {
        Optional<Student> student = studentService.getStudentByJmbg(jmbg);
        if(student.isPresent()) {
            return new ResponseEntity<Student>(student.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
    }
    
    @JsonView(HideOptionalProperties.class)
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAnyRole('ROLE_ADMINISTRATIVNO_OSOBLJE','ROLE_ADMINISTRATOR')")
	public ResponseEntity<Student> addStudent(@RequestPart("profileImage") Optional<MultipartFile> file, @RequestPart("data") String studentStr) throws IOException {
		Student student = new ObjectMapper().readValue(studentStr, Student.class);
		if(file.isPresent()) {
			fileService.saveProfileImage(file.get(), "student_" + student.getRegistrovaniKorisnik().getUsername(), student.getLicniPodaci());
		}
		studentService.addStudent(student);
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
	}

	@JsonView(HideOptionalProperties.class)
	@RequestMapping(value = "/search/", method = RequestMethod.GET)
	public ResponseEntity<Collection<StudentDTO>> searchStudent(@RequestParam(required = false) String ime,
			@RequestParam(required = false) String prezime, @RequestParam(required = false) String brojIndeksa,
			@RequestParam(required = false) String upis, @RequestParam(required = false) String prosecnaOcena) {

		Collection<Student> student = studentService.searchStudenti(ime, prezime, brojIndeksa, upis, prosecnaOcena);
		if(student.size()>0) {
			Collection<StudentDTO> pronadjiStudente= studentMapper.toDtoList(student);
			return new ResponseEntity<Collection<StudentDTO>>(pronadjiStudente, HttpStatus.OK);
		}
		else return new ResponseEntity<Collection<StudentDTO>>(HttpStatus.NO_CONTENT);

	}
	
	@JsonView(HideOptionalProperties.class)
	@RequestMapping(value="/detalji/{id}", method=RequestMethod.GET)
	public ResponseEntity<StudentDetaljiDTO> getStudentDetaljiById(@PathVariable Long id){
		Optional<Student> student = studentService.getStudentById(id);
		System.out.println(student.get().getLicniPodaci().getIme());
		if (student.isPresent()) return new ResponseEntity<StudentDetaljiDTO>(studentDetaljiMapper.toDTO(student.get()), HttpStatus.OK);
		return new ResponseEntity<StudentDetaljiDTO>(HttpStatus.NO_CONTENT);
		
	}

}
