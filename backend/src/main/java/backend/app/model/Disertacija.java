package backend.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Disertacija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String naslov;
	
	@Column(length=128, nullable = false)
	private Date datumAplikacije;
	
	@Column(length=128, nullable = false)
	private Date datumOdbrane;
	
	@ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
	private Nastavnik mentor;
	
	@OneToOne(fetch = FetchType.LAZY)
	private StudentNaGodini studentNaGodini;
	
	@OneToOne(fetch = FetchType.EAGER)
	private DatotekaZaDisertaciju datotekaZaDisertaciju;
	
	public Disertacija() {}

	public Disertacija(Long id, String naslov, Date datumAplikacije, Date datumOdbrane, Nastavnik mentor,
			StudentNaGodini studentNaGodini, DatotekaZaDisertaciju datotekaZaDisertaciju) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.datumAplikacije = datumAplikacije;
		this.datumOdbrane = datumOdbrane;
		this.mentor = mentor;
		this.studentNaGodini = studentNaGodini;
		this.datotekaZaDisertaciju = datotekaZaDisertaciju;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public Date getDatumAplikacije() {
		return datumAplikacije;
	}

	public void setDatumAplikacije(Date datumAplikacije) {
		this.datumAplikacije = datumAplikacije;
	}

	public Date getDatumOdbrane() {
		return datumOdbrane;
	}

	public void setDatumOdbrane(Date datumOdbrane) {
		this.datumOdbrane = datumOdbrane;
	}

	public Nastavnik getMentor() {
		return mentor;
	}

	public void setMentor(Nastavnik mentor) {
		this.mentor = mentor;
	}

	public StudentNaGodini getStudentNaGodini() {
		return studentNaGodini;
	}

	public void setStudentNaGodini(StudentNaGodini studentNaGodini) {
		this.studentNaGodini = studentNaGodini;
	}

	public DatotekaZaDisertaciju getDatotekaZaDisertaciju() {
		return datotekaZaDisertaciju;
	}

	public void setDatotekaZaDisertaciju(DatotekaZaDisertaciju datotekaZaDisertaciju) {
		this.datotekaZaDisertaciju = datotekaZaDisertaciju;
	}
	
	
	
} 