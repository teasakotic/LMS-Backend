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

import utils.ViewUtils.ShowAutor;
import utils.ViewUtils.ShowFajl;

@Entity
public class NastavniMaterijal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String naziv;
	
	@JsonView(ShowAutor.class)
	@OneToMany(mappedBy="nastavniMaterijal")
	private Set<Autor> autor;

	@Column(nullable = false)
	private Date godinaIzdavanja; 
	
	@JsonView(ShowFajl.class)
	@OneToMany(mappedBy="nastavniMaterijal")
	private Set<Fajl> fajl;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private RealizacijaPredmeta realizacijaPredmeta;

	public NastavniMaterijal() {
		super();
	}

	public NastavniMaterijal(String naziv, Set<Autor> autor, Date godinaIzdavanja, Set<Fajl> fajl,
			RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.naziv = naziv;
		this.autor = autor;
		this.godinaIzdavanja = godinaIzdavanja;
		this.fajl = fajl;
		this.realizacijaPredmeta = realizacijaPredmeta;
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

	public Set<Autor> getAutor() {
		return autor;
	}

	public void setAutor(Set<Autor> autor) {
		this.autor = autor;
	}

	public Date getGodinaIzdavanja() {
		return godinaIzdavanja;
	}

	public void setGodinaIzdavanja(Date godinaIzdavanja) {
		this.godinaIzdavanja = godinaIzdavanja;
	}

	public Set<Fajl> getFajl() {
		return fajl;
	}

	public void setFajl(Set<Fajl> fajl) {
		this.fajl = fajl;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

}