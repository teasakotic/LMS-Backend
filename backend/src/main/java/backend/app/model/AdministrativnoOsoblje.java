package backend.app.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import javax.persistence.CascadeType;

import org.hibernate.annotations.Where;




@Entity
@Where(clause = "obrisan = 'false'")

public class AdministrativnoOsoblje {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@ManyToOne(cascade=CascadeType.ALL)
	private RegistrovaniKorisnik registrovaniKorisnik;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Adresa adresa;

	@ManyToOne(cascade=CascadeType.ALL)
	private LicniPodaci licniPodaci;
	
	@NotNull
	private Boolean obrisan = false;


	public AdministrativnoOsoblje() {}
	
	public AdministrativnoOsoblje(Adresa adresa, backend.app.model.RegistrovaniKorisnik registrovaniKorisnik, LicniPodaci licniPodaci, Boolean obrisan) {
		super();
		this.registrovaniKorisnik = registrovaniKorisnik;
		this.adresa = adresa;
		this.licniPodaci = licniPodaci;
		this.obrisan = obrisan;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	
	public RegistrovaniKorisnik getRegistrovaniKorisnik(){
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(RegistrovaniKorisnik RegistrovaniKorisnik){
		this.registrovaniKorisnik = RegistrovaniKorisnik;
	}
	public Adresa getAdresa(){
		return adresa;
	}

	public void setAdresa(Adresa adresa){
		this.adresa = adresa;
	}
	
	public LicniPodaci getLicniPodaci(){
		return licniPodaci;
	}

	public void setLicniPodaci(LicniPodaci licniPodaci){
		this.licniPodaci = licniPodaci;
	}

	public Boolean getObrisan() {
		return obrisan;
	}

	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}
	
}
	
