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
public class Administrator {

	@NotNull
	private Boolean obrisan = false;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private LicniPodaci licniPodaci;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private RegistrovaniKorisnik registrovaniKorisnik;
	

	public Administrator() {}
	
	public Administrator(LicniPodaci licniPodaci, RegistrovaniKorisnik registrovaniKorisnik, Boolean obrisan) {
		super();
		this.licniPodaci = licniPodaci;
		this.registrovaniKorisnik = registrovaniKorisnik;
		this.obrisan = obrisan;
	}

	public LicniPodaci getLicniPodaci() {
		return licniPodaci;
	}

	public void setLicniPodaci(LicniPodaci licniPodaci) {
		this.licniPodaci = licniPodaci;
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

	public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik){
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public Boolean getObrisan() {
		return obrisan;
	}

	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	
	
	}
