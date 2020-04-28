package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonView; 
import utils.ViewUtils.ShowMesto;

@Entity
public class Drzava {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String naziv;

	@JsonView(ShowMesto.class)
	@OneToMany(mappedBy="drzava")
	private Set<Mesto> mesta;
	
	

	public Drzava() {}
	

	public Drzava(String naziv, Set<Mesto> mesta){
		this.naziv = naziv;
		this.mesta = mesta;
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
	
	public Set<Mesto> getMesta(){
		return mesta;
	}

	public void setMesta(Set<Mesto> mesta){
		this.mesta = mesta;
	}
	
}



	
	