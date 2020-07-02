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

import backend.app.utils.ViewUtils.ShowRealizacijaPredmeta;
import backend.app.utils.ViewUtils.ShowStudentNaGodini;

@Entity
public class GodinaStudija {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private int godina;
	
	@Column(nullable = false)
	private Date datumPocetka;
	
	@Column(nullable = false)
	private Date datumKraja;

	@JsonView(ShowRealizacijaPredmeta.class)
	@OneToMany(mappedBy="godinaStudija")
	private Set<RealizacijaPredmeta> realizacijaPredmeta;

	@ManyToOne(cascade=CascadeType.ALL)
	private StudijskiProgram studijskiProgram;
	
	@JsonView(ShowStudentNaGodini.class)
	@OneToMany(mappedBy="godinaStudija")
	private Set<StudentNaGodini> studentNaGodini;

	public GodinaStudija() {}

	public GodinaStudija(Long id, int godina, Date datumPocetka, Date datumKraja,
			Set<RealizacijaPredmeta> realizacijaPredmeta, StudijskiProgram studijskiProgram,
			Set<StudentNaGodini> studentNaGodini) {
		super();
		this.id = id;
		this.godina = godina;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.studijskiProgram = studijskiProgram;
		this.studentNaGodini = studentNaGodini;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Date getDatumKraja() {
		return datumKraja;
	}

	public void setDatumKraja(Date datumKraja) {
		this.datumKraja = datumKraja;
	}

	public Set<RealizacijaPredmeta> getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(Set<RealizacijaPredmeta> realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public Set<StudentNaGodini> getStudentNaGodini() {
		return studentNaGodini;
	}

	public void setStudentNaGodini(Set<StudentNaGodini> studentNaGodini) {
		this.studentNaGodini = studentNaGodini;
	}

	
}
