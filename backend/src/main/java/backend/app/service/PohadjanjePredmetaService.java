package backend.app.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.PohadjanjePredmeta;
import backend.app.model.Predmet;
import backend.app.model.Student;
import backend.app.repository.PohadjanjePredmetaRepository;

@Service
public class PohadjanjePredmetaService {

    @Autowired
    private PohadjanjePredmetaRepository pohadjanjePredmetaRepo;

    public PohadjanjePredmetaService() {
    }

    public Iterable<PohadjanjePredmeta> getPohadjanjePredmeta() {
        return pohadjanjePredmetaRepo.findAll();
    }

    public Optional<PohadjanjePredmeta> getPohadjanjePredmetaById(Long id) {
        return pohadjanjePredmetaRepo.findById(id);
    }

    public void addPohadjanjePredmeta(PohadjanjePredmeta pohadjanjePredmeta) {
    	pohadjanjePredmetaRepo.save(pohadjanjePredmeta);
    }

    public void removePohadjanjePredmeta(Long id) {
        Optional<PohadjanjePredmeta> pohadjanjePredmeta = pohadjanjePredmetaRepo.findById(id);
        pohadjanjePredmetaRepo.delete(pohadjanjePredmeta.get());
    }

    public void updatePohadjanjePredmeta(Long id, PohadjanjePredmeta pohadjanjePredmeta) {
        Optional<PohadjanjePredmeta> Poh = pohadjanjePredmetaRepo.findById(id);
        if(Poh.isPresent()) {
        	pohadjanjePredmeta.setId(Poh.get().getId());
        	pohadjanjePredmetaRepo.save(pohadjanjePredmeta);
        }
    }
    
    public Double getProsecnaOcena(Long studentId) {
        return pohadjanjePredmetaRepo.findProsecnaOcena(studentId);
    }
    
    public Iterable<Student> getStudentiKojiNisuPoloziliIspit(Long predmetId) {
        return pohadjanjePredmetaRepo.findStudentiKojiNisuPoloziliIspit(predmetId);
    }
    
    public ArrayList<Predmet> getTrenutniPredmeti(String username){
    	return pohadjanjePredmetaRepo.findTrenutniPredmeti(username);
    }
    
    public ArrayList<Object> getPolozenePredmete(String username){
    	return pohadjanjePredmetaRepo.findPolozenePredmete(username);
    }
    
    public ArrayList<Student> getStudentByPredmet(Long predmetId, String nastavnikUsername){
    	Date danas = new Date(0);
    	return pohadjanjePredmetaRepo.findStudentByPredmet(predmetId, danas, nastavnikUsername);
    }
    
}
