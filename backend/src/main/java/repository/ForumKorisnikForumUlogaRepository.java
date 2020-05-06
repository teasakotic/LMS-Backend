package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ForumKorisnikForumUloga;

@Repository
public interface ForumKorisnikForumUlogaRepository extends JpaRepository<ForumKorisnikForumUloga, Long> {

}
