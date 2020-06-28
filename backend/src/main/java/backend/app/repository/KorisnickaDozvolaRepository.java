package backend.app.repository;

import java.util.Set;

import backend.app.model.KorisnickaDozvola;

public interface KorisnickaDozvolaRepository {
	Set<KorisnickaDozvola> getByRegistrovaniKorisnikId(Long id);
}
