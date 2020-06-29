package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.ForumKorisnik;
import backend.app.repository.ForumKorisnikRepository;

@Service 
public class ForumKorisnikService {

	@Autowired
	ForumKorisnikRepository forumKorisnikRepo;
	
	public Iterable<ForumKorisnik> getForumKorisnik() {
		return forumKorisnikRepo.findAll();
	}
	
	public Optional<ForumKorisnik> getForumKorisnikById(Long id) {
		return forumKorisnikRepo.findById(id);
	}
	
	public void addForumKorisnik(ForumKorisnik forumKorisnik) {
		forumKorisnikRepo.save(forumKorisnik);
	}
	
	public void removeForumKorisnik(Long id) {
		Optional<ForumKorisnik> frm = forumKorisnikRepo.findById(id);
		if(frm.isPresent()) {
			forumKorisnikRepo.delete(frm.get());
		}
	}
	public void updateForumKorisnik(Long id, ForumKorisnik forumKorisnik) {
		Optional<ForumKorisnik> frm = forumKorisnikRepo.findById(id);
		if(frm.isPresent()) {
			forumKorisnik.setId(frm.get().getId());
			forumKorisnikRepo.save(forumKorisnik);
		}
	}

}
