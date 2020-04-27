package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Adresa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=158, nullable = false)
	private String broj;

	@Column(length=158, nullable = false)
	private String ulica;

	@ManyToOne(cascade=CascadeType.ALL)
	private Mesto mesto;

	public Adresa() {}
	
	public Adresa(String broj, String ulica, Mesto mesto){
		this.broj = broj;
		this.ulica = ulica;
		this.mesto = mesto;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public String getBroj(){
		return broj;
	}

	public void setBroj(String broj){
		this.broj = broj;
	}
	
	public String getUlica(){
		return ulica;
	}

	public void setUlica(String ulica){
		this.ulica = ulica;
	}
	
	public Mesto getMesto(){
		return mesto;
	}

	public void setMesto(Mesto mesto){
		this.mesto = mesto;
	}
	
	
	
	
	
	
	
}
