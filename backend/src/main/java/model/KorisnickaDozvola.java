package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KorisnickaDozvola {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private RegistrovaniKorisnik registrovaniKorisnik;
	
	@ManyToOne
	private Dozvola dozvola;
	
	public KorisnickaDozvola() {
	}
	
	public KorisnickaDozvola(RegistrovaniKorisnik registrovaniKorisnik, Dozvola dozvola) {
		super();
		this.registrovaniKorisnik = registrovaniKorisnik;
		this.dozvola = dozvola;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegistrovaniKorisnik getRegistrovaniKorisnik() {
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public Dozvola getDozvola() {
		return dozvola;
	}

	public void setDozvola(Dozvola dozvola) {
		this.dozvola = dozvola;
	}

	
}