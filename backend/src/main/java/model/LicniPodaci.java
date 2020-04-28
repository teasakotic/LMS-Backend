package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

	@Column(length=128)
	private String putanjaProfilneSlike;

	public LicniPodaci() {}

	public LicniPodaci(String ime, String prezime, String brTelefona, String putanjaProfilneSlike) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brTelefona = brTelefona;
		this.putanjaProfilneSlike = putanjaProfilneSlike;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
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

	public String getBrTelefona(){
		return brTelefona;
	}

	public void setBrTelefona(String brTelefona){
		this.brTelefona = brTelefona;
	}
	
	public String getPutanjaProfilneSlike(){
		return putanjaProfilneSlike;
	}

	public void setPutanjaProfilneSlike(String putanjaProfilneSlike){
		this.putanjaProfilneSlike = putanjaProfilneSlike;
	}
	
}