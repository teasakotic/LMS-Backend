package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.KategorijaUloga;

@Repository 
public interface KategorijaUlogaRepository extends JpaRepository<KategorijaUloga, Long> {

}
