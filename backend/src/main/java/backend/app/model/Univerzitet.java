package backend.app.model;

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

import backend.app.utils.ViewUtils.ShowEmailUniverziteta;
import backend.app.utils.ViewUtils.ShowFakultet;
import backend.app.utils.ViewUtils.ShowTelefoniUniverziteta;

@Entity
public class Univerzitet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String naziv;

	@Column(nullable = false)
	private Date datumOsnivanja;

	@JsonView(ShowFakultet.class)
	@OneToMany(mappedBy="univerzitet")
	private Set<Fakultet> fakultet;

	@ManyToOne(cascade=CascadeType.ALL)
	private Adresa adresa;

	@ManyToOne(cascade=CascadeType.ALL)
	private Nastavnik rektor;
	
	@Column(length=128, nullable = false)
	private String opis;
	
	@JsonView(ShowTelefoniUniverziteta.class)
	@OneToMany(mappedBy="univerzitet")
	private Set<TelefoniUniverziteta> telefon;
	
	@JsonView(ShowEmailUniverziteta.class)
	@OneToMany(mappedBy="univerzitet")
	private Set<EmailUniverziteta> email;

	public Univerzitet() {}

	public Univerzitet(String naziv, Date datumOsnivanja, Set<Fakultet> fakultet, Adresa adresa, Nastavnik rektor,
			String opis, Set<TelefoniUniverziteta> telefon, Set<EmailUniverziteta> email) {
		super();
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.fakultet = fakultet;
		this.adresa = adresa;
		this.rektor = rektor;
		this.opis = opis;
		this.telefon = telefon;
		this.email = email;
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
	
	public Date getDatumOsnivanja(){
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja){
		this.datumOsnivanja = datumOsnivanja;
	}
	
	public Set<Fakultet> getFakultet(){
		return fakultet;
	}

	public void setFakultet(Set<Fakultet> fakultet){
		this.fakultet = fakultet;
	}
	
	public Adresa getAdresa(){
		return adresa;
	}

	public void setAdresa(Adresa adresa){
		this.adresa = adresa;
	}
	
	public Nastavnik getRektor(){
		return rektor;
	}

	public void setRektor(Nastavnik rektor){
		this.rektor = rektor;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Set<TelefoniUniverziteta> getTelefon() {
		return telefon;
	}

	public void setTelefon(Set<TelefoniUniverziteta> telefon) {
		this.telefon = telefon;
	}

	public Set<EmailUniverziteta> getEmail() {
		return email;
	}

	public void setEmail(Set<EmailUniverziteta> email) {
		this.email = email;
	}
	
}
