package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import utils.ViewUtils.ShowForumKorisnikForumUloga;
import utils.ViewUtils.ShowObjava;
import utils.ViewUtils.ShowTema;

@Entity
public class ForumKorisnik {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@JsonView(ShowForumKorisnikForumUloga.class)
	@OneToMany(mappedBy="korisnik")
	private Set<ForumKorisnikForumUloga> uloga;

	@ManyToOne(cascade=CascadeType.ALL)
	private RegistrovaniKorisnik registrovaniKorisnik;

	@JsonView(ShowObjava.class)
	@OneToMany(mappedBy="autor")
	private Set<Objava> objava;

	@JsonView(ShowTema.class)
	@OneToMany(mappedBy="autor")
	private Set<Tema> tema;

	@ManyToOne(cascade=CascadeType.ALL)
	private Forum forum;

	public ForumKorisnik() {}

	public ForumKorisnik(Set<ForumKorisnikForumUloga> uloga, RegistrovaniKorisnik registrovaniKorisnik, Set<Objava> objava, Set<Tema> tema, Forum forum){
		this.uloga = uloga;
		this.registrovaniKorisnik = registrovaniKorisnik;
		this.objava = objava;
		this.tema = tema;
		this.forum = forum;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Set<ForumKorisnikForumUloga> getUloga(){
		return uloga;
	}

	public void setUloga(Set<ForumKorisnikForumUloga> uloga){
		this.uloga = uloga;
	}
	
	public RegistrovaniKorisnik getRegistrovaniKorisnik(){
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik){
		this.registrovaniKorisnik = registrovaniKorisnik;
	}
	
	public Set<Objava> getObjava(){
		return objava;
	}

	public void setObjava(Set<Objava> objava){
		this.objava = objava;
	}
	
	public Set<Tema> getTema(){
		return tema;
	}

	public void setTema(Set<Tema> tema){
		this.tema = tema;
	}
	
	public Forum getForum(){
		return forum;
	}

	public void setForum(Forum forum){
		this.forum = forum;
	}
	
}
