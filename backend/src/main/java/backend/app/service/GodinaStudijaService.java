package backend.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.GodinaStudija;
import backend.app.model.Predmet;
import backend.app.repository.GodinaStudijaRepository;
import backend.app.repository.PredmetRepository;

@Service
public class GodinaStudijaService {

    @Autowired
    private GodinaStudijaRepository godinaStudijaRepo;
    @Autowired
    private PredmetRepository predmetRepo;
    @Autowired
    private GodinaStudijaService godinaStudijaService;

    public GodinaStudijaService() {
    }

    public Iterable<GodinaStudija> getGodinaStudija() {
        return godinaStudijaRepo.findAll();
    }

    public Optional<GodinaStudija> getGodinaStudijaById(Long id) {
        return godinaStudijaRepo.findById(id);
    }

    public void addGodinaStudija(GodinaStudija godinaStudija) {
    	godinaStudijaRepo.save(godinaStudija);
    }

    public void removeGodinaStudija(Long id) {
        Optional<GodinaStudija> godinaStudija = godinaStudijaRepo.findById(id);
        godinaStudijaRepo.delete(godinaStudija.get());
    }

    public void updateGodinaStudija(Long id, GodinaStudija godinaStudija) {
        Optional<GodinaStudija> God = godinaStudijaRepo.findById(id);
        if(God.isPresent()) {
        	godinaStudija.setId(God.get().getId());
        	godinaStudijaRepo.save(godinaStudija);
        }
    }

    public ArrayList<Predmet> getPredmet(Long godinaStudijaId) {
    	return predmetRepo.findByGodinaStudijaIdEquals(godinaStudijaId);
    }
    
    public Optional<GodinaStudija> getNarednaGodinaStudijaByStudijskiProgram(Long id) {
    	Optional<GodinaStudija> gs = godinaStudijaService.getGodinaStudijaById(id);
    	if(gs.isPresent()) {
    		GodinaStudija godinaStudija = gs.get();
    		int godina = godinaStudija.getYear();
    		godina = godina+1;
    		Optional<GodinaStudija> narednaGodinaStudija = godinaStudijaRepo.getNarednaGodinaStudija(godina, godinaStudija.getStudijskiProgram().getId());
    		return narednaGodinaStudija;
    	}
        return gs;
    }
}
