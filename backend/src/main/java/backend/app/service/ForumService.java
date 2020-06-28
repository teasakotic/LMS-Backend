package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Forum;
import backend.app.repository.ForumRepository;

@Service 
public class ForumService {

	@Autowired
	ForumRepository forumRepo;
	
	public Iterable<Forum> getForum() {
		return forumRepo.findAll();
	}
	
	public Optional<Forum> getOne(Long id) {
		return forumRepo.findById(id);
	}
	
	public void addForum(Forum forum) {
		forumRepo.save(forum);
	}
	
	public void removeForum(Long id) {
		Optional<Forum> forr= forumRepo.findById(id);
		if(forr.isPresent()) {
			forumRepo.delete(forr.get());
		}
	}
	
	public void updateForum(Long id, Forum forum) {
		Optional<Forum> forr = forumRepo.findById(id);
		if(forr.isPresent()) {
			forum.setId(forr.get().getId());
			forumRepo.save(forum);
		}
	}

}
