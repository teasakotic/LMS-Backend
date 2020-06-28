package backend.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.utils.ViewUtils.ShowForumKorisnik;
import backend.app.utils.ViewUtils.ShowKategorija;



@Entity
public class Forum {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@JsonView(ShowForumKorisnik.class)
	@OneToMany(mappedBy="forum")
	private Set<ForumKorisnik> korisnik;

	@JsonView(ShowKategorija.class)
	@OneToMany(mappedBy="forum")
	private Set<Kategorija> kategorije;

	public Forum() {}

	public Forum(Set<ForumKorisnik> korisnik, Set<Kategorija> kategorije){
		this.korisnik = korisnik;
		this.kategorije = kategorije;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Set<ForumKorisnik> getKorisnik(){
		return korisnik;
	}

	public void setForumKorisnik(Set<ForumKorisnik> korisnik){
		this.korisnik = korisnik;
	}
	
	public Set<Kategorija> getKategorije(){
		return kategorije;
	}

	public void setKategorije(Set<Kategorija> kategorije){
		this.kategorije = kategorije;
	}
	
}