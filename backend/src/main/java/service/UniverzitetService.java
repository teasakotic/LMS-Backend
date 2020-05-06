package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Univerzitet;
import repository.UniverzitetRepository;

@Service
public class UniverzitetService {

    @Autowired
    private UniverzitetRepository univerzitetRepo;

    public UniverzitetService() {
    }

    public Iterable<Univerzitet> getUniverzitet() {
        return univerzitetRepo.findAll();
    }

    public Optional<Univerzitet> getUniverzitetById(Long id) {
        return univerzitetRepo.findById(id);
    }

    public void addUniverzitet(Univerzitet univerzitet) {
    	univerzitetRepo.save(univerzitet);
    }

    public void removeUniverzitet(Long id) {
        Optional<Univerzitet> univerzitet = univerzitetRepo.findById(id);
        univerzitetRepo.delete(univerzitet.get());
    }

	public void updateUniverzitet(Long id, Univerzitet univerzitet) {
		Optional<Univerzitet> uni = univerzitetRepo.findById(id);
		if(uni.isPresent()) {
			univerzitet.setId(uni.get().getId());
			univerzitetRepo.save(univerzitet);
		}
	}

}
