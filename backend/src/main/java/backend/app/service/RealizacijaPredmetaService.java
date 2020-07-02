package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Nastavnik;
import backend.app.model.RealizacijaPredmeta;
import backend.app.repository.RealizacijaPredmetaRepository;

@Service
public class RealizacijaPredmetaService {

    @Autowired
    private RealizacijaPredmetaRepository realizacijaPredmetaRepo;

    public RealizacijaPredmetaService() {
    }

    public Iterable<RealizacijaPredmeta> getRealizacijaPredmeta() {
        return realizacijaPredmetaRepo.findAll();
    }
    
    public Iterable<RealizacijaPredmeta> getRealizacijaPredmetaByGodinaStudijaId(Long id) {
        return realizacijaPredmetaRepo.findByGodinaStudijaId(id);
    }

    public Optional<RealizacijaPredmeta> getRealizacijaPredmetaById(Long id) {
        return realizacijaPredmetaRepo.findById(id);
    }

    public void addRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
    	realizacijaPredmetaRepo.save(realizacijaPredmeta);
    }

    public void removeRealizacijaPredmeta(Long id) {
        Optional<RealizacijaPredmeta> realizacijaPredmeta = realizacijaPredmetaRepo.findById(id);
        realizacijaPredmetaRepo.delete(realizacijaPredmeta.get());
    }

    public void updateRealizacijaPredmeta(Long id, RealizacijaPredmeta realizacijaPredmeta) {
        Optional<RealizacijaPredmeta> Re = realizacijaPredmetaRepo.findById(id);
        if(Re.isPresent()) {
        	realizacijaPredmeta.setId(Re.get().getId());
        	realizacijaPredmetaRepo.save(realizacijaPredmeta);
        }
    }
    
    public Iterable<Nastavnik> getNastavnikeKojiDrzeVezbe(Long predmetId) {
        return realizacijaPredmetaRepo.findNastavnikeKojiDrzeVezbe(predmetId);
    }

   // public Iterable<RealizacijaPredmeta> getNastavnikUsername(String username) {
     //   return realizacijaPredmetaRepo.findByNastavnikUsername(username);
    //}

}
