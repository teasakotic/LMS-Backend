package backend.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mesto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String ime;

	@ManyToOne(cascade=CascadeType.ALL)
	private Drzava drzava;

	public Mesto() {}

	public Mesto(String ime, Drzava drzava){
		this.ime = ime; 
		this.drzava = drzava; 
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public String getIme(){
		return ime;
	}

	public void setIme(String ime){
		this.ime = ime;
	}
	
	public Drzava getDrzava(){
		return drzava;
	}

	public void setDrzava(Drzava drzava){
		this.drzava = drzava;
	}
	
}
