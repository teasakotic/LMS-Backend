package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NaucnaOblast {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String naziv;

	public NaucnaOblast() {}

	public NaucnaOblast(String naziv){
		this.naziv = naziv;
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
	
}