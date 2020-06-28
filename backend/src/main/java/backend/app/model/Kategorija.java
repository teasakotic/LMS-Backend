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

import backend.app.utils.ViewUtils.ShowKategorijaUloga;
import backend.app.utils.ViewUtils.ShowTema;

@Entity
public class Kategorija {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Boolean obrisan;
	
	@Column(length=128, nullable = false)
	private String naziv;

	@JsonView(ShowKategorijaUloga.class)
	@OneToMany(mappedBy="kategorija")
	private Set<KategorijaUloga> kategorijaUloga;

	@JsonView(ShowTema.class)
	@OneToMany(mappedBy="kategorija")
	private Set<Tema> tema;

	@ManyToOne(cascade=CascadeType.ALL)
	private Forum forum;

	public Kategorija() {}

	public Kategorija(Boolean obrisan, String naziv, Set<KategorijaUloga> kategorijaUloga, Set<Tema> tema, Forum forum){
		this.obrisan = obrisan; 
		this.naziv = naziv;
		this.kategorijaUloga = kategorijaUloga; 
		this.tema = tema;
		this.forum = forum;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Boolean getObrisan(){
		return obrisan;
	}

	public void setObrisan(Boolean obrisan){
		this.obrisan = obrisan;
	}
	
	public String getNaziv(){
		return naziv;
	}

	public void setNaziv(String naziv){
		this.naziv = naziv;
	}
	
	
	public Set<KategorijaUloga> getKategorijaUloga(){
		return kategorijaUloga;
	}

	public void setKategorijaUloga(Set<KategorijaUloga> kategorijaUloga){
		this.kategorijaUloga = kategorijaUloga;
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
