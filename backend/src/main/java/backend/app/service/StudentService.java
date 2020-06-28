package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.app.model.Student;
import backend.app.repository.RadNaStudentuRepositoryImpl;
import backend.app.repository.StudentRepository;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;
    
    @Autowired
    private RadNaStudentuRepositoryImpl radNaStudentuRepo;

    @Autowired
    private RegistrovaniKorisnikService regServ;
    
    @Autowired
    private AdresaService adresaServ;
    
    @Autowired
    private LicniPodaciService licniServ;

    @Autowired
    private LoginService loginServ;
    
    @Autowired
	private PasswordEncoder passwordEncoder;
    
    public StudentService() {
    }

    public Iterable<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }
    
    public Optional<Student> getStudentByUsername(String username) {
        return studentRepo.getByUsername(username);
    }

    public void addStudent(Student student) {
    	loginServ.addDozvola(student.getRegistrovaniKorisnik(), "ROLE_STUDENT");
    	student.getRegistrovaniKorisnik().setLozinka(passwordEncoder.encode(student.getRegistrovaniKorisnik().getLozinka()));
        studentRepo.save(student);
    }

    public void removeStudent(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        Student s = student.get();
        s.setObrisan(true);
        studentRepo.save(s);
    }

    public void updateStudent(String username, Student student) {
        Optional<Student> Stu = studentRepo.getByUsername(username);
        if(Stu.isPresent()) {
            student.setId(Stu.get().getId());
            student.getRegistrovaniKorisnik().setLozinka(passwordEncoder.encode(student.getRegistrovaniKorisnik().getLozinka()));
            regServ.updateRegistrovaniKorisnik(student.getRegistrovaniKorisnik().getId(), student.getRegistrovaniKorisnik());
            adresaServ.updateAdresa(student.getAdresa().getId(), student.getAdresa());
            licniServ.updateLicniPodaci(student.getLicniPodaci().getId(), student.getLicniPodaci());
        }
    }
    
    public Iterable<Optional<Student>> getStudentsByIme(String ime){
    	return studentRepo.findStudentsByIme("%"+ime+"%");
    }
    
    public Optional<Student> getStudentByJmbg(String jmbg){
    	return studentRepo.findStudentByJmbg(jmbg);
    }
    
    public Collection<Student> searchStudenti(String ime, String prezime, String brojIndeksa, String upis, String prosecnaOcena){    	
    	return radNaStudentuRepo.searchStudenti(ime, prezime, brojIndeksa, upis, prosecnaOcena);
		
    }

}
