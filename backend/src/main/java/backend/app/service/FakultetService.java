package backend.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Email;
import backend.app.model.EmailFakulteta;
import backend.app.model.Fakultet;
import backend.app.repository.EmailFakultetaRepository;
import backend.app.repository.FakultetRepository;
import backend.app.repository.StudijskiProgramRepository;
import backend.app.repository.TelefoniFakultetaRepository;
import backend.app.model.StudijskiProgram;
import backend.app.model.Telefon;
import backend.app.model.TelefoniFakulteta;
@Service 
public class FakultetService {

	@Autowired
	FakultetRepository fakultetRepo;
    @Autowired
    private StudijskiProgramRepository studijskiProgramRepo;
    @Autowired
    private TelefoniFakultetaRepository telefoniFakultetaRepo;
    @Autowired
    private EmailFakultetaRepository emailFakultetaRepo;
	
	public Iterable<Fakultet> getFakultet() {
		return fakultetRepo.findAll();
	}
	
	public Optional<Fakultet> getFakultetById(Long id) {
		return fakultetRepo.findById(id);
	}
	
	public void addFakultet(Fakultet fakultet) {
		fakultetRepo.save(fakultet);
	}
	
	public void removeFakultet(Long id) {
		Optional<Fakultet> faks = fakultetRepo.findById(id);
		if(faks.isPresent()) {
			fakultetRepo.delete(faks.get());
		}
	}
	public void updateFakultet(Long id, Fakultet fakultet) {
		Optional<Fakultet> faks = fakultetRepo.findById(id);
		if(faks.isPresent()) {
			fakultet.setId(faks.get().getId());
			fakultetRepo.save(fakultet);
		}
	}
	   public ArrayList<StudijskiProgram> getStudijskiProgram(Long fakultetId) {
	    	return studijskiProgramRepo.findByFakultetIdEquals(fakultetId);
	    }

	    public ArrayList<Telefon> getTelefoniFakulteta(Long fakultetId) {
	    	ArrayList<TelefoniFakulteta> telefoniId = telefoniFakultetaRepo.findByFakultetIdEquals(fakultetId);
	    	ArrayList<Telefon> telefoni = new ArrayList<Telefon>();
	    	for(TelefoniFakulteta p : telefoniId) {
	    		telefoni.add(p.getTelefon());
	    	}
	    	return telefoni;
	    }
	    
	    public ArrayList<Email> getEmailFakulteta(Long fakultetId) {
	    	ArrayList<EmailFakulteta> emailsId = emailFakultetaRepo.findByFakultetIdEquals(fakultetId);
	    	ArrayList<Email> emails = new ArrayList<Email>();
	    	for(EmailFakulteta p : emailsId) {
	    		emails.add(p.getEmail());
	    	}
	    	return emails;
	    }
	}