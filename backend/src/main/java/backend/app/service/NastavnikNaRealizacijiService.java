package backend.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Nastavnik;
import backend.app.model.NastavnikNaRealizaciji;
import backend.app.model.Predmet;
import backend.app.repository.NastavnikNaRealizacijiRepository;

import java.sql.Date;
import java.util.Optional;

@Service
public class NastavnikNaRealizacijiService {

    @Autowired
    private NastavnikNaRealizacijiRepository nastavnikNaRealizacijiRepo;

    public NastavnikNaRealizacijiService() {
    }

    public Iterable<NastavnikNaRealizaciji> getNastavnikNaRealizaciji() {
        return nastavnikNaRealizacijiRepo.findAll();
    }
    
    public Iterable<Optional<NastavnikNaRealizaciji>> getNastavnikNaRealizacijiByGodinaStudija(Long godinaStudijaId) {
        return nastavnikNaRealizacijiRepo.getByGodinaStudija(godinaStudijaId);
    }

    public Optional<NastavnikNaRealizaciji> getNastavnikNaRealizacijiById(Long id) {
        return nastavnikNaRealizacijiRepo.findById(id);
    }

    public void addNastavnikNaRealizacijin(NastavnikNaRealizaciji nastavnikNaRealizaciji) {
    	nastavnikNaRealizacijiRepo.save(nastavnikNaRealizaciji);
    }

    public void removeNastavnikNaRealizaciji(Long id) {
        Optional<NastavnikNaRealizaciji> nastavnikNaRealizaciji = nastavnikNaRealizacijiRepo.findById(id);
        nastavnikNaRealizacijiRepo.delete(nastavnikNaRealizaciji.get());
    }

    public void updateNastavnikNaRealizaciji(Long id, NastavnikNaRealizaciji nastavnikNaRealizaciji) {
        Optional<NastavnikNaRealizaciji> Tea = nastavnikNaRealizacijiRepo.findById(id);
        if(Tea.isPresent()) {
        	nastavnikNaRealizaciji.setId(Tea.get().getId());
        	nastavnikNaRealizacijiRepo.save(nastavnikNaRealizaciji);
        }
    }
    
    public Iterable<Nastavnik> getNastavniciKojiDrzePredmete(Long predmetId) {
        return nastavnikNaRealizacijiRepo.findNastavniciKojiDrzePredmete(predmetId);
    }
    


}
