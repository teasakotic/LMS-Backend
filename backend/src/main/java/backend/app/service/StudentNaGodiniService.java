package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.StudentNaGodini;
import backend.app.repository.StudentNaGodiniRepository;

@Service
public class StudentNaGodiniService {

    @Autowired
    private StudentNaGodiniRepository studentNaGodiniRepo;

    public StudentNaGodiniService() {
    }

    public Iterable<StudentNaGodini> getStudentNaGodini() {
        return studentNaGodiniRepo.findAll();
    }

    public Optional<StudentNaGodini> getStudentNaGodiniById(Long id) {
        return studentNaGodiniRepo.findById(id);
    }

    public void addStudentNaGodini(StudentNaGodini studentNaGodini) {
    	studentNaGodiniRepo.save(studentNaGodini);
    }

    public void removeStudentNaGodini(Long id) {
        Optional<StudentNaGodini> studentNaGodini = studentNaGodiniRepo.findById(id);
        studentNaGodiniRepo.delete(studentNaGodini.get());
    }

    public void updateStudentNaGodini(Long id, StudentNaGodini studentNaGodini) {
        Optional<StudentNaGodini> Stu = studentNaGodiniRepo.findById(id);
        if(Stu.isPresent()) {
        	studentNaGodini.setId(Stu.get().getId());
        	studentNaGodiniRepo.save(studentNaGodini);
        }
    }
    
    public Optional<StudentNaGodini> getStudentNaGodiniByGodinaStudijaIdAndStudentId(Long godinaStudijaId, Long studentId) {
        return studentNaGodiniRepo.findByGodinaStudijaIdAndStudentId(godinaStudijaId, studentId);
    }

}
