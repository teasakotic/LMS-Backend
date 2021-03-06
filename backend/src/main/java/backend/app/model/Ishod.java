package backend.app.model;

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
public class Ishod {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String opis;
	
	@Column(nullable = false)
	private Integer nedelja;
	
	@Column(length=128)
	private String putanjaDoIkonice;

	@ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
	private Predmet predmet;
	@ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
	private RealizacijaPredmeta realizacijaPredmeta;
	
	@NotNull
	private Boolean obrisan = false;

	public Ishod() {}

	public Ishod(Long id, String opis, Integer nedelja, String putanjaDoIkonice, Predmet predmet,
			RealizacijaPredmeta realizacijaPredmeta, @NotNull Boolean obrisan) {
		super();
		this.id = id;
		this.opis = opis;
		this.nedelja = nedelja;
		this.putanjaDoIkonice = putanjaDoIkonice;
		this.predmet = predmet;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.obrisan = obrisan;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Integer getNedelja() {
		return nedelja;
	}

	public void setNedelja(Integer nedelja) {
		this.nedelja = nedelja;
	}

	public String getPutanjaDoIkonice() {
		return putanjaDoIkonice;
	}

	public void setPutanjaDoIkonice(String putanjaDoIkonice) {
		this.putanjaDoIkonice = putanjaDoIkonice;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
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
