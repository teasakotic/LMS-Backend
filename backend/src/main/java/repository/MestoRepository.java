package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Mesto;

@Repository 
public interface MestoRepository extends JpaRepository<Mesto, Long> {

} 
