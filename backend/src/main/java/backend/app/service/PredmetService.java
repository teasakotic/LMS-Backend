package backend.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Ishod;
import backend.app.model.Predmet;
import backend.app.repository.IshodRepository;
import backend.app.repository.PredmetRepository;

@Service
public class PredmetService {

    @Autowired
    private PredmetRepository predmetRepo;
    @Autowired
    private IshodRepository ishodRepo;

    public PredmetService() {
    }

    public Iterable<Predmet> getPredmet() {
        return predmetRepo.findAll();
    }

    public Optional<Predmet> getPredmetById(Long id) {
        return predmetRepo.findById(id);
    }

    public void addPredmet(Predmet predmet) {
        predmetRepo.save(predmet);
    }
    
    public void removePredmet(Long id) {
    	Optional<Predmet> predmet = predmetRepo.findById(id);
    	Predmet s = predmet.get();
        s.setObrisan(true);
        predmetRepo.save(s);
    }

    public void updatePredmet(Long id, Predmet predmet) {
        Optional<Predmet> Pr = predmetRepo.findById(id);
        if(Pr.isPresent()) {
        	predmet.setId(Pr.get().getId());
        	predmetRepo.save(predmet);
        }
    }
    
    public Iterable<Optional<Predmet>> getPredmetByNaziv(String naziv){
    	return predmetRepo.findByNazivLike("%"+naziv+"%");
    }
    
    public ArrayList<Ishod> getSilabus(Long predmetId) {
    	return ishodRepo.findByPredmetIdEquals(predmetId);
    }
    
 
  //  public Iterable<Predmet> getPredusloviZaObaveznePredmeteByGodinaStudija(Long godinaStudijaId) {
    //    return predmetRepo.getPredusloviZaObaveznePredmeteByGodinaStudija(godinaStudijaId);
   // }


}
