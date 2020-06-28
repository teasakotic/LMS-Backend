package backend.app.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

@Entity
@Where(clause = "obrisan = 'false'")
public class TerminNastave {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String dan;
	
	@Column(nullable = false)
	private Date vremePocetka;
	
	@Column(nullable = false)
	private Date vremeKraja;
	
	@ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
	private RealizacijaPredmeta realizacijaPredmeta;
	
	@NotNull
	private Boolean obrisan = false;

	public TerminNastave() {
		super();
	}

	public TerminNastave(String dan, Date vremePocetka, Date vremeKraja, RealizacijaPredmeta realizacijaPredmeta,
			Boolean obrisan) {
		super();
		this.dan = dan;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = vremeKraja;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.obrisan = obrisan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDan() {
		return dan;
	}

	public void setDan(String dan) {
		this.dan = dan;
	}

	public Date getVremePocetka() {
		return vremePocetka;
	}

	public void setVremePocetka(Date vremePocetka) {
		this.vremePocetka = vremePocetka;
	}

	public Date getVremeKraja() {
		return vremeKraja;
	}

	public void setVremeKraja(Date vremeKraja) {
		this.vremeKraja = vremeKraja;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}


	public Boolean getObrisan() {
		return obrisan;
	}

	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}

}