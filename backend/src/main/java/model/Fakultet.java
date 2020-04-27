package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import utils.ViewUtils.ShowStudijskiProgram;
import utils.ViewUtils.ShowTelefoniFakulteta;

@Entity
public class Fakultet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=150, nullable = false)
	private String ime;

	@ManyToOne(cascade=CascadeType.ALL)
	private Univerzitet univerzitet;

	@ManyToOne(cascade=CascadeType.ALL)
	private Adresa adresa;

	@ManyToOne(cascade=CascadeType.ALL)
	private Nastavnik dekan;

	@JsonView(ShowStudijskiProgram.class)
	@OneToMany(mappedBy="fakultet")
	private Set<StudijskiProgram> studijskiProgram;
	
	@Column(length=150, nullable = false)
	private String opis;
	
	@JsonView(ShowTelefoniFakulteta.class)
	@OneToMany(mappedBy="fakultet")
	private Set<TelefoniFakulteta> telefoniFakulteta;
	
	@JsonView(ShowTelefoniFakulteta.class)
	@OneToMany(mappedBy="fakultet")
	private Set<EmailFakulteta> emailFakulteta;
	

	public Fakultet() {}

	public Fakultet(String ime, Univerzitet univerzitet, Adresa adresa, Nastavnik dekan, Set<StudijskiProgram> studijskiProgram,
			String opis, Set<TelefoniFakulteta> telefoniFakulteta, Set<EmailFakulteta> emailFakulteta) {
		super();
		this.ime = ime;
		this.univerzitet = univerzitet;
		this.adresa = adresa;
		this.dekan = dekan;
		this.studijskiProgram = studijskiProgram;
		this.opis = opis;
		this.telefoniFakulteta = telefoniFakulteta;
		this.emailFakulteta = emailFakulteta;
		
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public String getIme(){
		return ime;
	}

	public void setIme(String ime){
		this.ime = ime;
	}
	
	public Univerzitet getUniverzitet(){
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet){
		this.univerzitet = univerzitet;
	}
	
	public Adresa getAdresa(){
		return adresa;
	}

	public void setAdresa(Adresa adresa){
		this.adresa = adresa;
	}
	
	public Nastavnik getDekan(){
		return dekan;
	}

	public void setDekan(Nastavnik dekan){
		this.dekan = dekan;
	}
	
	public Set<StudijskiProgram> getStudijskiProgram(){
		return studijskiProgram;
	}

	public void setStudijskiProgram(Set<StudijskiProgram> studijskiProgram){
		this.studijskiProgram = studijskiProgram;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Set<TelefoniFakulteta> getTelefoniFakulteta() {
		return telefoniFakulteta;
	}

	public void setPhones(Set<TelefoniFakulteta> telefoniFakulteta) {
		this.telefoniFakulteta = telefoniFakulteta;
	}

	public Set<EmailFakulteta> getEmailFakulteta() {
		return emailFakulteta;
	}

	public void setEmailFakulteta(Set<EmailFakulteta> emailFakulteta) {
		this.emailFakulteta = emailFakulteta;
	}

	
}