package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Forum;

@Repository 
public interface ForumRepository extends JpaRepository<Forum, Long> {

}
