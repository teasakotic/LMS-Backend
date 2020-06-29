package backend.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.repository.GodinaStudijaRepository;
import backend.app.repository.StudijskiProgramRepository;
import backend.app.model.StudijskiProgram;
import backend.app.model.GodinaStudija;

@Service
public class StudijskiProgramService {

    @Autowired
    private StudijskiProgramRepository studijskiProgramRepo;
    @Autowired
    private GodinaStudijaRepository godinaStudijaRepo;

    public StudijskiProgramService() {
    }

    public Iterable<StudijskiProgram> getStudijskiProgram() {
        return studijskiProgramRepo.findAll();
    }

    public Optional<StudijskiProgram> getStudijskiProgramById(Long id) {
        return studijskiProgramRepo.findById(id);
    }

    public void addStudijskiProgram(StudijskiProgram studijskiProgram) {
    	studijskiProgramRepo.save(studijskiProgram);
    }
    
    public void removeStudijskiProgram(Long id) {
        Optional<StudijskiProgram> studijskiProgram= studijskiProgramRepo.findById(id);
        StudijskiProgram s = studijskiProgram.get();
        s.setObrisan(true);
        studijskiProgramRepo.save(s);
    }

    public void updateStudijskiProgram(Long id, StudijskiProgram studijskiProgram) {
        Optional<StudijskiProgram> Stu = studijskiProgramRepo.findById(id);
        if(Stu.isPresent()) {
        	studijskiProgram.setId(Stu.get().getId());
        	studijskiProgramRepo.save(studijskiProgram);
        }
    }
    
    
    public ArrayList<GodinaStudija> getGodinaStudija(Long studijskiProgramId) {
    	return godinaStudijaRepo.findByStudijskiProgramIdEquals(studijskiProgramId);
    }

}
