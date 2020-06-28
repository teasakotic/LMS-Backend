package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.Kategorija;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Long> {

}
