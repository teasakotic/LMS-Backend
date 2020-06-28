package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Forum;

@Repository 
public interface ForumRepository extends JpaRepository<Forum, Long> {

}
