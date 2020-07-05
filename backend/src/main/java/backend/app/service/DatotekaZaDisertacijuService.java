package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.DatotekaZaDisertaciju;
import backend.app.repository.DatotekaZaDisertacijuRepository;


@Service 
public class DatotekaZaDisertacijuService {

	@Autowired
	DatotekaZaDisertacijuRepository datotekaZaDisertacijuRepo;
	
	public Iterable<DatotekaZaDisertaciju> getDatotekaZaDisertaciju() {
		return datotekaZaDisertacijuRepo.findAll();
	}
	
	public Optional<DatotekaZaDisertaciju> getDatotekaZaDisertacijuById(Long id) {
		return datotekaZaDisertacijuRepo.findById(id);
	}
	
	public void addDatotekaZaDisertaciju(DatotekaZaDisertaciju datotekaZaDisertaciju) {
		datotekaZaDisertacijuRepo.save(datotekaZaDisertaciju);
	}
	
	public void removeDatotekaZaDisertaciju(Long id) {
		Optional<DatotekaZaDisertaciju> dat = datotekaZaDisertacijuRepo.findById(id);
		if(dat.isPresent()) {
			datotekaZaDisertacijuRepo.delete(dat.get());
		}
	}
	public void updateDatotekaZaDisertaciju(Long id, DatotekaZaDisertaciju datotekaZaDisertaciju) {
		Optional<DatotekaZaDisertaciju> dat = datotekaZaDisertacijuRepo.findById(id);
		if(dat.isPresent()) {
			datotekaZaDisertaciju.setId(dat.get().getId());
			datotekaZaDisertacijuRepo.save(datotekaZaDisertaciju);
		}
	}

}