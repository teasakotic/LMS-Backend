package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.ForumKorisnikForumUloga;
import backend.app.repository.ForumKorisnikForumUlogaRepository;

@Service 
public class ForumKorisnikForumUlogaService {

	@Autowired
	ForumKorisnikForumUlogaRepository forumKorisnikForumUlogaRepo;
	
	public Iterable<ForumKorisnikForumUloga> getForumKorisnikForumUloga() {
		return forumKorisnikForumUlogaRepo.findAll();
	}
	
	public Optional<ForumKorisnikForumUloga> getForumKorisnikForumUlogaById(Long id) {
		return forumKorisnikForumUlogaRepo.findById(id);
	}
	
	public void addForumKorisnikForumUloga(ForumKorisnikForumUloga forumKorisnikForumUloga) {
		forumKorisnikForumUlogaRepo.save(forumKorisnikForumUloga);
	}
	
	public void removeForumKorisnikForumUloga(Long id) {
		Optional<ForumKorisnikForumUloga> fku= forumKorisnikForumUlogaRepo.findById(id);
		if(fku.isPresent()) {
			forumKorisnikForumUlogaRepo.delete(fku.get());
		}
	}
	
	public void updateForumKorisnikForumUloga(Long id, ForumKorisnikForumUloga forumKorisnikForumUloga) {
		Optional<ForumKorisnikForumUloga> fku = forumKorisnikForumUlogaRepo.findById(id);
		if(fku.isPresent()) {
			forumKorisnikForumUloga.setId(fku.get().getId());
			forumKorisnikForumUlogaRepo.save(forumKorisnikForumUloga);
		}
	}

}
