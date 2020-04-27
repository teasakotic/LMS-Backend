package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=158, nullable = false)
	private String ime;
	
	@Column(length=158, nullable = false)
	private String prezime;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private NastavniMaterijal nastavniMaterijal;

	public Autor() {
		super();
	}

	public Autor(String ime, String prezime, NastavniMaterijal nastavniMaterijal) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.nastavniMaterijal = nastavniMaterijal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public NastavniMaterijal getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(NastavniMaterijal nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}
}
