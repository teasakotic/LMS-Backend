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

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.utils.ViewUtils.ShowObjava;

@Entity
public class Tema {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String naziv;
	
	@Column(nullable = false)
	private Boolean obrisan;

	@Column(nullable = false)
	private Boolean zakljucan;

	@ManyToOne(cascade=CascadeType.ALL)
	private Kategorija kategorija;

	@JsonView(ShowObjava.class)
	@OneToMany(mappedBy="objava")
	private Set<Objava> objava;

	@ManyToOne(cascade=CascadeType.ALL)
	private ForumKorisnik autor;

	

	public Tema() {}

	public Tema(String naziv, Boolean obrisan,  Kategorija kategorija, Set<Objava> objava, ForumKorisnik autor, Boolean zakljucan){
		this.naziv = naziv;
		this.obrisan = obrisan;
		this.kategorija = kategorija;
		this.objava = objava;
		this.autor = autor;
		this.zakljucan = zakljucan;
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
	
	public Boolean getObrisan(){
		return obrisan;
	}

	public void setObrisan(Boolean obrisan){
		this.obrisan = obrisan;
	}
	
	public Kategorija getKategorija(){
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija){
		this.kategorija = kategorija;
	}
	
	public Set<Objava> getObjava(){
		return objava;
	}

	public void setObjava(Set<Objava> objava){
		this.objava = objava;
	}
	
	public ForumKorisnik getAutor(){
		return autor;
	}

	public void setAutor(ForumKorisnik autor){
		this.autor = autor;
	}
	
	
	public Boolean getZakljucan(){
		return zakljucan;
	}

	public void setZakljucan(Boolean zakljucan){
		this.zakljucan = zakljucan;
	}
	
}