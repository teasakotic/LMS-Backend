package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.ForumKorisnik;

@Repository
public interface ForumKorisnikRepository extends JpaRepository<ForumKorisnik, Long> {

}
