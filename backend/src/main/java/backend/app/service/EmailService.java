package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Email;
import backend.app.repository.EmailRepository;


@Service 
public class EmailService {

	@Autowired
	EmailRepository emailRepo;
	
	public Iterable<Email> getEmail() {
		return emailRepo.findAll();
	}
	
	public Optional<Email> getEmailById(Long id) {
		return emailRepo.findById(id);
	}
	
	public void addEmail(Email email) {
		emailRepo.save(email);
	}
	
	public void removeEmail(Long id) {
		Optional<Email> em = emailRepo.findById(id);
		if(em.isPresent()) {
			emailRepo.delete(em.get());
		}
	}
	public void updateEmail(Long id, Email email) {
		Optional<Email> em = emailRepo.findById(id);
		if(em.isPresent()) {
			email.setId(em.get().getId());
			emailRepo.save(email);
		}
	}

}