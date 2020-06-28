package backend.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ForumKorisnikForumUloga {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade=CascadeType.ALL)
	private ForumKorisnik korisnik;

	@ManyToOne(cascade=CascadeType.ALL)
	private Uloga uloga;

	public ForumKorisnikForumUloga() {}

	public ForumKorisnikForumUloga(ForumKorisnik korisnik, Uloga uloga){
		this.korisnik = korisnik;
		this.uloga = uloga;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public ForumKorisnik getKorisnik(){
		return korisnik;
	}

	public void setKorisnik(ForumKorisnik korisnik){
		this.korisnik = korisnik;
	}
	
	public Uloga getUloga(){
		return uloga;
	}

	public void setUloga(Uloga uloga){
		this.uloga = uloga;
	}
	
}