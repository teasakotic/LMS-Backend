package model;

import java.sql.Date;
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

import utils.ViewUtils.ShowObjavaFajl;

@Entity
public class Objava {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Date vremePostavljanja;

	@Column(length=128, nullable = false)
	private String sadrzaj;

	@Column(nullable = false)
	private Boolean obrisan;

	@JsonView(ShowObjavaFajl.class)
	@OneToMany(mappedBy="objava")
	private Set<ObjavaFajl> prilog;

	@ManyToOne(cascade=CascadeType.ALL)
	private ForumKorisnik autor;

	@ManyToOne(cascade=CascadeType.ALL)
	private Tema tema;

	public Objava() {}

	public Objava(Date vremePostavljanja, String sadrzaj, Boolean obrisan, Set<ObjavaFajl> prilog, ForumKorisnik autor, Tema tema){
	this.vremePostavljanja = vremePostavljanja; 
	this.sadrzaj = sadrzaj; 
	this.obrisan = obrisan; 
	this.prilog = prilog; 
	this.autor = autor; 
	this.tema = tema; 
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Date getVremePostavljanja(){
		return vremePostavljanja;
	}

	public void setVremePostavljanja(Date vremePostavljanja){
		this.vremePostavljanja = vremePostavljanja;
	}
	
	public String getSadrzaj(){
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj){
		this.sadrzaj = sadrzaj;
	}
	
	public Boolean getObrisan(){
		return obrisan;
	}

	public void setObrisan(Boolean obrisan){
		this.obrisan = obrisan;
	}
	
	public Set<ObjavaFajl> getPrilog(){
		return prilog;
	}

	public void setPrilog(Set<ObjavaFajl> prilog){
		this.prilog = prilog;
	}
	
	public ForumKorisnik getAutor(){
		return autor;
	}

	public void setAutor(ForumKorisnik autor){
		this.autor = autor;
	}
	
	public Tema getTema(){
		return tema;
	}

	public void setTema(Tema tema){
		this.tema = tema;
	}
	
}