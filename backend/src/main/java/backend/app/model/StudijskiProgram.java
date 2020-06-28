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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.utils.ViewUtils.ShowGodinaStudija;

@Entity
@Where(clause = "obrisan = 'false'")
public class StudijskiProgram {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String naziv;
	
	@Column(length=128, nullable = false)
	private String opis;

	@JsonView(ShowGodinaStudija.class)
	@OneToMany(mappedBy="studijskiProgram")
	private Set<GodinaStudija> godinaStudija;

	@ManyToOne(cascade= {CascadeType.REFRESH})
	private Nastavnik rektor;

	@ManyToOne(cascade= {CascadeType.REFRESH})
	private Fakultet fakultet;
	
	
	@NotNull
	private Boolean obrisan = false;

	public StudijskiProgram() {}

	public StudijskiProgram(String naziv,String opis, Set<GodinaStudija> godinaStudija, Nastavnik rektor, Fakultet fakultet,
			 Boolean obrisan) {
		super();
		this.naziv = naziv;
		this.opis = opis;
		this.godinaStudija = godinaStudija;
		this.rektor = rektor;
		this.fakultet = fakultet;
		this.obrisan = obrisan;
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
	
	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public Set<GodinaStudija> getGodinaStudija(){
		return godinaStudija;
	}

	public void setGodinaStudija(Set<GodinaStudija> godinaStudija){
		this.godinaStudija = godinaStudija;
	}
	
	public Nastavnik getRektor(){
		return rektor;
	}

	public void setRektor(Nastavnik rektor){
		this.rektor = rektor;
	}
	
	public Fakultet getFakultet(){
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet){
		this.fakultet = fakultet;
	}


	public Boolean getObrisan() {
		return obrisan;
	}

	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}
	
}
