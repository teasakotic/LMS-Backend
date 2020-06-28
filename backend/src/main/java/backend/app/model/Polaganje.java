package backend.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Polaganje {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	private Integer bodovi;
	
	@Column(length=128, nullable = true)
	private String napomena;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private EvaluacijaZnanja evaluacijaZnanja;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private StudentNaGodini studentNaGodini;

	public Polaganje() {
		super();
	}

	public Polaganje(Integer bodovi, String napomena, EvaluacijaZnanja evaluacijaZnanja, StudentNaGodini studentNaGodini) {
		super();
		this.bodovi = bodovi;
		this.napomena = napomena;
		this.evaluacijaZnanja = evaluacijaZnanja;
		this.studentNaGodini = studentNaGodini;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBodovi() {
		return bodovi;
	}

	public void setBodovi(Integer bodovi) {
		this.bodovi = bodovi;
	}

	public String getNapomena() {
		return napomena;
	}

	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}

	public EvaluacijaZnanja getEvaluacijaZnanja() {
		return evaluacijaZnanja;
	}

	public void setEvaluacijaZnanja(EvaluacijaZnanja evaluacijaZnanja) {
		this.evaluacijaZnanja = evaluacijaZnanja;
	}

	public StudentNaGodini getStudentNaGodini() {
		return studentNaGodini;
	}

	public void setStudentNaGodini(StudentNaGodini studentNaGodini) {
		this.studentNaGodini= studentNaGodini;
	}
	
}
