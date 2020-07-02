package backend.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.utils.ViewUtils.ShowNastavnikNaRealizaciji;
import backend.app.utils.ViewUtils.ShowZvanje;

@Entity
@Where(clause = "obrisan = 'false'")
public class Nastavnik {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String biografija;

	@JsonView(ShowZvanje.class)
	@OneToMany(mappedBy="nastavnik")
	private Set<Zvanje> zvanje; 

	@ManyToOne(cascade=CascadeType.ALL)
	private Adresa adresa;

	@ManyToOne(cascade=CascadeType.ALL)
	private RegistrovaniKorisnik registrovaniKorisnik;

	@ManyToOne(cascade=CascadeType.ALL)
	private LicniPodaci licniPodaci;
	
	@JsonView(ShowNastavnikNaRealizaciji.class)
	@OneToMany(mappedBy="nastavnik")
	private Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji; 

	
	@NotNull
	private Boolean obrisan = false;

	public Nastavnik() {}

	public Nastavnik(Long id, String biografija, Set<Zvanje> zvanje, Adresa adresa,
			RegistrovaniKorisnik registrovaniKorisnik, LicniPodaci licniPodaci,
			Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji, @NotNull Boolean obrisan) {
		super();
		this.id = id;
		this.biografija = biografija;
		this.zvanje = zvanje;
		this.adresa = adresa;
		this.registrovaniKorisnik = registrovaniKorisnik;
		this.licniPodaci = licniPodaci;
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
		this.obrisan = obrisan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public Set<Zvanje> getZvanje() {
		return zvanje;
	}

	public void setZvanje(Set<Zvanje> zvanje) {
		this.zvanje = zvanje;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public RegistrovaniKorisnik getRegistrovaniKorisnik() {
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public LicniPodaci getLicniPodaci() {
		return licniPodaci;
	}

	public void setLicniPodaci(LicniPodaci licniPodaci) {
		this.licniPodaci = licniPodaci;
	}

	public Set<NastavnikNaRealizaciji> getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}

	public void setNastavnikNaRealizaciji(Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}

	public Boolean getObrisan() {
		return obrisan;
	}

	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}

	
}