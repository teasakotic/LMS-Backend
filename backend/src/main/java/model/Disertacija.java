package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;

@Entity
public class Disertacija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String naslov;
	
	@Column(length=128, nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date datumAplikacije;
	
	@Column(length=128, nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date datumOdbrane;
	
	@ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
	private Nastavnik mentor;
	
	@OneToOne(fetch = FetchType.LAZY)
	private StudentNaGodini studentNaGodini;
	
	@OneToOne(fetch = FetchType.EAGER)
	private DatotekaZaDisertaciju objavaFajl;
	
	public Disertacija() {}
	
	public Disertacija(String naslov, Date datumAplikacije, Date datumOdbrane, Nastavnik mentor,
			StudentNaGodini studentNaGodini, DatotekaZaDisertaciju objavaFajl) {
		super();
		this.naslov = naslov;
		this.datumAplikacije = datumAplikacije;
		this.datumOdbrane = datumOdbrane;
		this.mentor = mentor;
		this.studentNaGodini = studentNaGodini;
		this.objavaFajl = objavaFajl;
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

	public DatotekaZaDisertaciju getObjavaFajl() {
		return objavaFajl;
	}

	public void setObjavaFajl(DatotekaZaDisertaciju objavaFajl) {
		this.objavaFajl = objavaFajl;
	}
	
	
	
} 