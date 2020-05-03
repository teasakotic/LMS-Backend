package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import utils.ViewUtils.ShowForumKorisnikForumUloga;
import utils.ViewUtils.ShowKategorijaUloga;

@Entity
public class Uloga {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String naziv;

	@JsonView(ShowForumKorisnikForumUloga.class)
	@OneToMany(mappedBy="uloga")
	private Set<ForumKorisnikForumUloga> korisnik;

	@JsonView(ShowKategorijaUloga.class)
	@OneToMany(mappedBy="uloga")
	private Set<KategorijaUloga> kategorijaUloga;

	public Uloga() {}

	public Uloga(String naziv, Set<ForumKorisnikForumUloga> korisnik, Set<KategorijaUloga> kategorijaUloga){
		this.naziv = naziv;
		this.korisnik = korisnik;
		this.kategorijaUloga = kategorijaUloga;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public String getNaziv(){
		return naziv;
	}

	public void setNaziv(String naziv){
		this.naziv = naziv;
	}
	
	public Set<ForumKorisnikForumUloga> getKorisnik(){
		return korisnik;
	}

	public void setKorisnik(Set<ForumKorisnikForumUloga> korisnik){
		this.korisnik = korisnik;
	}
	
	public Set<KategorijaUloga> getKategorijaUloga(){
		return kategorijaUloga;
	}

	public void setKategorijaUloga(Set<KategorijaUloga> kategorijaUloga){
		this.kategorijaUloga = kategorijaUloga;
	}
	
}
