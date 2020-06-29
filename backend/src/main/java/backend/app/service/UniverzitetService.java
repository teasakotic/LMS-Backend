package backend.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Email;
import backend.app.model.EmailUniverziteta;
import backend.app.model.Telefon;
import backend.app.model.TelefoniUniverziteta;
import backend.app.model.Univerzitet;
import backend.app.repository.EmailUniverzitetaRepository;
import backend.app.repository.TelefoniUniverzitetaRepository;
import backend.app.repository.UniverzitetRepository;

@Service
public class UniverzitetService {

    @Autowired
    private UniverzitetRepository univerzitetRepo;
    @Autowired
    private TelefoniUniverzitetaRepository telefoniUniverzitetaRepo;
    @Autowired
    private EmailUniverzitetaRepository emailUniverzitetaRepo;
    
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
    
    public ArrayList<Telefon> getTelefoniUniverziteta(Long univerzitetId) {
    	ArrayList<TelefoniUniverziteta> telefoniId = telefoniUniverzitetaRepo.findByUniverzitetIdEquals(univerzitetId);
    	ArrayList<Telefon> telefoni = new ArrayList<Telefon>();
    	for(TelefoniUniverziteta p : telefoniId) {
    		telefoni.add(p.getTelefon());
    	}
    	return telefoni;
    }
    
    public ArrayList<Email> getEmailUniverziteta(Long univerzitetId) {
    	ArrayList<EmailUniverziteta> emailsId = emailUniverzitetaRepo.findByUniverzitetIdEquals(univerzitetId);
    	ArrayList<Email> emails = new ArrayList<Email>();
    	for(EmailUniverziteta p : emailsId) {
    		emails.add(p.getEmail());
    	}
    	return emails;
}
}