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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.utils.ViewUtils.ShowPolaganje;

@Entity
public class StudentNaGodini {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Date datumUpisa;

	@Column(length=128, nullable = false)
	private String brojIndeksa;


	@ManyToOne(cascade=CascadeType.ALL)
	private Student student;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private GodinaStudija godinaStudija;
	
	
	@OneToOne(mappedBy = "studentNaGodini")
	private Disertacija disertacija;

	@JsonView(ShowPolaganje.class)
	@OneToMany(mappedBy="studentNaGodini")
	private Set<Polaganje> polaganje;
	
	public StudentNaGodini() {}

	public StudentNaGodini(Date datumUpisa, String brojIndeksa, Student student, GodinaStudija godinaStudija, 
			Disertacija disertacija, Set<Polaganje> polaganje ) {
		super();
		this.datumUpisa = datumUpisa; 
		this.brojIndeksa = brojIndeksa; 
		this.student = student; 
		this.godinaStudija = godinaStudija; 
		this.disertacija = disertacija; 
		this.polaganje = polaganje; 
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Date getDatumUpisa(){
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa){
		this.datumUpisa = datumUpisa;
	}
	
	public String getBrojIndeksa(){
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa){
		this.brojIndeksa = brojIndeksa;
	}
	
	public Student getStudent(){
		return student;
	}

	public void setStudent(Student student){
		this.student = student;
	}
	
	public GodinaStudija getGodinaStudija(){
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija){
		this.godinaStudija = godinaStudija;
	}
	
	public Disertacija getDisertacija() {
		return disertacija;
	}

	public void setDisertacija(Disertacija disertacija) {
		this.disertacija = disertacija;
	}
	

	public Set<Polaganje> getPolaganje() {
		return polaganje;
	}

	public void setPolaganje(Set<Polaganje> polaganje) {
		this.polaganje = polaganje;
	}

	
	
	
	
}