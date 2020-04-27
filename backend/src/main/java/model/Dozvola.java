package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import utils.ViewUtils.ShowKorisnickaDozvola;

@Entity
public class Dozvola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String naziv;
	
	@JsonView(ShowKorisnickaDozvola.class)
	@OneToMany(mappedBy = "dozvola")
	private Set<KorisnickaDozvola> korisnickaDozvola;

	public Dozvola() {};
	
	public Dozvola(Long id, String naziv, Set<KorisnickaDozvola> korisnickaDozvola) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.korisnickaDozvola = korisnickaDozvola;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Set<KorisnickaDozvola> getKorisnici() {
		return korisnickaDozvola;
	}

	public void KorisnickaDozvola(Set<KorisnickaDozvola> korisnickaDozvola) {
		this.korisnickaDozvola = korisnickaDozvola;
	}
	
}