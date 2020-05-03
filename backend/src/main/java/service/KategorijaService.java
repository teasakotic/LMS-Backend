package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Kategorija;
import repository.KategorijaRepository;

@Service 
public class KategorijaService {

	    @Autowired
	    private KategorijaRepository kategorijaRepo;

	    public KategorijaService() {
	    }

	    public Iterable<Kategorija> getKategorija() {
	        return kategorijaRepo.findAll();
	    }

	    public Optional<Kategorija> getKategorijaById(Long id) {
	        return kategorijaRepo.findById(id);
	    }

	    public void addKategorija(Kategorija kategorija) {
	        kategorijaRepo.save(kategorija);
	    }

	    public void removeKategorija(Long id) {
	        Optional<Kategorija> kategorija = kategorijaRepo.findById(id);
	        kategorijaRepo.delete(kategorija.get());
	    }

	    public void updateKategorija(Long id, Kategorija kategorija) {
	        Optional<Kategorija> kate = kategorijaRepo.findById(id);
	        if(kate.isPresent()) {
	            kategorija.setId(kate.get().getId());
	            kategorijaRepo.save(kategorija);
	        }
	    }

	} 

