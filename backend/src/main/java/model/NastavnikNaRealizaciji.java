package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class NastavnikNaRealizaciji {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Integer brojCasova;

	@ManyToOne(cascade=CascadeType.ALL)
	private TipNastave tipNastave;

	@ManyToOne(cascade=CascadeType.ALL)
	private Nastavnik nastavnik;

	@ManyToOne(cascade=CascadeType.ALL)
	private RealizacijaPredmeta realizacijaPredmeta;

	public NastavnikNaRealizaciji() {}

	public NastavnikNaRealizaciji(Integer brojCasova, TipNastave tipNastave, Nastavnik nastavnik, RealizacijaPredmeta realizacijaPredmeta){
		this.brojCasova = brojCasova;
		this.tipNastave = tipNastave;
		this.nastavnik = nastavnik;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Integer getBrojCasova(){
		return brojCasova;
	}

	public void setBrojCasova(Integer brojCasova){
		this.brojCasova = brojCasova;
	}
	
	public TipNastave getTipNastave(){
		return tipNastave;
	}

	public void setTipNastave(TipNastave tipNastave){
		this.tipNastave = tipNastave;
	}
	
	public Nastavnik getNastavnik(){
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik){
		this.nastavnik = nastavnik;
	}
	
	public RealizacijaPredmeta getRealizacijaPredmeta(){
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta){
		this.realizacijaPredmeta = realizacijaPredmeta;
	}
	
}