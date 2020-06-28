package backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.app.model.TipZvanja;

@Repository
public interface TipZvanjaRepository extends JpaRepository<TipZvanja, Long> {

}
