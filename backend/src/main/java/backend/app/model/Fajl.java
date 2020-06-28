package backend.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fajl {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String opis;
	
	@Column(length=128, nullable = false)
	private String url;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Poruka poruka;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private NastavniMaterijal nastavniMaterijal;

	public Fajl() {
		super();
	}

	public Fajl(String opis, String url, Poruka poruka, NastavniMaterijal nastavniMaterijal) {
		super();
		this.opis = opis;
		this.url = url;
		this.poruka = poruka;
		this.nastavniMaterijal = nastavniMaterijal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Poruka getPoruka() {
		return poruka;
	}

	public void setPoruka(Poruka poruka) {
		this.poruka = poruka;
	}

	public NastavniMaterijal getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(NastavniMaterijal nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}	

}

