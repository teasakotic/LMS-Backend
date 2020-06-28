package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.TipZvanja;
import backend.app.repository.TipZvanjaRepository;

@Service
public class TipZvanjaService {

    @Autowired
    private TipZvanjaRepository tipZvanjaRepo;

    public TipZvanjaService() {
    }

    public Iterable<TipZvanja> getTipZvanja() {
        return tipZvanjaRepo.findAll();
    }

    public Optional<TipZvanja> getTipZvanjaById(Long id) {
        return tipZvanjaRepo.findById(id);
    }

    public void addTipZvanja(TipZvanja tipZvanja) {
    	tipZvanjaRepo.save(tipZvanja);
    }

    public void removeTipZvanja(Long id) {
        Optional<TipZvanja> tipZvanja = tipZvanjaRepo.findById(id);
        tipZvanjaRepo.delete(tipZvanja.get());
    }

	public void updateTipZvanja(Long id, TipZvanja tipZvanja) {
		Optional<TipZvanja> tzv = tipZvanjaRepo.findById(id);
		if(tzv.isPresent()) {
			tipZvanja.setId(tzv.get().getId());
			tipZvanjaRepo.save(tipZvanja);
		}
	}

}
