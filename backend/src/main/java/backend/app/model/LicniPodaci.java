package backend.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.utils.ViewUtils.ShowNastavnik;
import backend.app.utils.ViewUtils.ShowNastavnikNaRealizaciji;

@Entity
public class LicniPodaci {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String ime;
	
	@Column(length=128, nullable = false)
	private String prezime;

	@Column(length=128, nullable = false)
	private String brTelefona;
	
	@Column(length=128, nullable = false)
	private String jmbg;

	@Column(length=128)
	private String putanjaProfilneSlike;
	
	@JsonView(ShowNastavnik.class)
	@OneToMany(mappedBy="licniPodaci")
	private Set<Nastavnik> nastavnik;
	
	@JsonView(ShowNastavnikNaRealizaciji.class)
	@OneToMany(mappedBy="licniPodaci")
	private Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji;

	public LicniPodaci() {}

	public LicniPodaci(Long id, String ime, String prezime, String brTelefona, String jmbg, String putanjaProfilneSlike,
			Set<Nastavnik> nastavnik, Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.brTelefona = brTelefona;
		this.jmbg = jmbg;
		this.putanjaProfilneSlike = putanjaProfilneSlike;
		this.nastavnik = nastavnik;
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrTelefona() {
		return brTelefona;
	}

	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPutanjaProfilneSlike() {
		return putanjaProfilneSlike;
	}

	public void setPutanjaProfilneSlike(String putanjaProfilneSlike) {
		this.putanjaProfilneSlike = putanjaProfilneSlike;
	}

	public Set<Nastavnik> getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Set<Nastavnik> nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Set<NastavnikNaRealizaciji> getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}

	public void setNastavnikNaRealizaciji(Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}

	
}