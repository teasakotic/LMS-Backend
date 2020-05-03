package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Kategorija;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija, Long> {

}
