package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;

import utils.ViewUtils.ShowIzborniPredmet;
import utils.ViewUtils.ShowPohadjanjePredmeta;
import utils.ViewUtils.ShowStudentNaGodini;

@XmlRootElement
@Entity
@Where(clause = "obrisan = 'false'")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@JsonView(ShowPohadjanjePredmeta.class)
	@OneToMany(mappedBy="student")
	private Set<PohadjanjePredmeta> pohadjanjePredmeta;
	
	@JsonView(ShowIzborniPredmet.class)
	@OneToMany(mappedBy="student")
	private Set<IzborniPredmet> izborniPredmet;

	@ManyToOne(cascade=CascadeType.ALL)
	private Adresa adresa;

	@JsonView(ShowStudentNaGodini.class)
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL)
	private Set<StudentNaGodini> studentNaGodini;

	@ManyToOne(cascade=CascadeType.ALL)
	private RegistrovaniKorisnik registrovaniKorisnik;

	@ManyToOne(cascade=CascadeType.ALL)
	private LicniPodaci licniPodaci;
	
	@NotNull
	private Boolean obrisan = false;

	public Student() {}
	
	public Student(Long id, String ime, String prezime, String email) {
		this.id = id;
		this.licniPodaci.setIme(ime);
		this.licniPodaci.setPrezime(prezime);
		this.registrovaniKorisnik.setEmail(email);
	}

	public Student(Set<PohadjanjePredmeta> pohadjanjePredmeta, Set<IzborniPredmet> izborniPredmet, Adresa adresa, Set<StudentNaGodini> studentNaGodini,
			RegistrovaniKorisnik registrovaniKorisnik, LicniPodaci licniPodaci, Boolean obrisan) {
		super();
		this.pohadjanjePredmeta = pohadjanjePredmeta;
		this.izborniPredmet = izborniPredmet;
		this.adresa = adresa;
		this.studentNaGodini = studentNaGodini;
		this.registrovaniKorisnik = registrovaniKorisnik;
		this.licniPodaci = licniPodaci;
		this.obrisan = obrisan;
	}
	
	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Set<PohadjanjePredmeta> getPohadjanjePredmeta(){
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(Set<PohadjanjePredmeta> pohadjanjePredmeta){
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}
	
	public Set<IzborniPredmet> getIzborniPredmet() {
		return izborniPredmet;
	}

	public void setElectiveSubjectAttendances(Set<IzborniPredmet> izborniPredmet) {
		this.izborniPredmet = izborniPredmet;
	}

	public Adresa getAdresa(){
		return adresa;
	}

	public void setAdresa(Adresa adresa){
		this.adresa = adresa;
	}
	
	public Set<StudentNaGodini> getStudentNaGodini(){
		return studentNaGodini;
	}

	public void setStudentNaGodini(Set<StudentNaGodini> studentNaGodini){
		this.studentNaGodini = studentNaGodini;
	}
	
	public RegistrovaniKorisnik getRegistrovaniKorisnik(){
		return registrovaniKorisnik;
	}

	public void setAccountData(RegistrovaniKorisnik registrovaniKorisnik){
		this.registrovaniKorisnik = registrovaniKorisnik;
	}
	
	public LicniPodaci getLicniPodaci(){
		return licniPodaci;
	}

	public void setPersonalData(LicniPodaci licniPodaci){
		this.licniPodaci = licniPodaci;
	}

	public Boolean getObrisan() {
		return obrisan;
	}

	public void setDeleted(Boolean obrisan) {
		this.obrisan = obrisan;
	}
	
}
