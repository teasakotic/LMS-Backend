package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import backend.app.model.TipNastave;
import backend.app.repository.TipNastaveRepository;

@Service 
public class TipNastaveService {

	@Autowired
	TipNastaveRepository tipNastaveRepo;
	
	public Iterable<TipNastave> getTipNastave() {
		return tipNastaveRepo.findAll();
	}
	
	public Optional<TipNastave> getOne(Long id) {
		return tipNastaveRepo.findById(id);
	}
	
	public void addTipNastave(TipNastave tipNastave) {
		tipNastaveRepo.save(tipNastave);
	}
	
    public void removeTipNastave(Long id) {
        Optional<TipNastave> tipNastave = tipNastaveRepo.findById(id);
        tipNastaveRepo.delete(tipNastave.get());
    }

    public void updateTipNastave(Long id, TipNastave tipNastave) {
        Optional<TipNastave> Nas = tipNastaveRepo.findById(id);
        if(Nas.isPresent()) {
            tipNastave.setId(Nas.get().getId());
            tipNastaveRepo.save(tipNastave);
        }
    }

}
