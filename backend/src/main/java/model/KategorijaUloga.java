package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class KategorijaUloga {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String procitan;

	@Column(length=128, nullable = false)
	private String napisan;

	@ManyToOne(cascade=CascadeType.ALL)
	private Kategorija kategorija;

	@ManyToOne(cascade=CascadeType.ALL)
	private Uloga uloga;

	public KategorijaUloga() {}

	public KategorijaUloga(String procitan, String napisan, Kategorija kategorija, Uloga uloga){
		this.procitan = procitan;
		this.napisan = napisan;
		this.kategorija = kategorija;
		this.uloga = uloga;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public String getProcitan(){
		return procitan;
	}

	public void setProcitan(String Procitan){
		this.procitan= Procitan;
	}
	
	public String getNapisan(){
		return napisan;
	}

	public void setNapisan(String napisan){
		this.napisan = napisan;
	}
	
	public Kategorija getKategorija(){
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija){
		this.kategorija = kategorija;
	}
	
	public Uloga getUloga(){
		return uloga;
	}

	public void setUloga(Uloga uloga){
		this.uloga = uloga;
	}
	
}