package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonView;

import utils.ViewUtils.ShowGodinaStudija;
import utils.ViewUtils.ShowIshod;
import utils.ViewUtils.ShowPredmet;

@Entity
@Where(clause = "obrisan = 'false'")
public class Predmet {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String naziv;

	@Column(nullable = false)
	private Integer espb;

	@Column(nullable = false)
	private Boolean obavezan;

	@Column(nullable = false)
	private Integer brojPredavanja;

	@Column(nullable = false)
	private Integer brojVezbi;

	@Column(nullable = false)
	private Integer drugiObliciNastave;

	@Column(nullable = false)
	private Integer istrazivackiRad;

	@Column(nullable = false)
	private Integer ostaliCasovi;

	@JsonView(ShowIshod.class)
	@OneToMany(mappedBy="predmet")
	private Set<Ishod> syllabus;
	
	@ManyToMany
    private Set<Predmet> preduslov;
	
	@JsonView(ShowPredmet.class)
	@ManyToMany(mappedBy="preduslov")
    private Set<Predmet> preduslovZa;

	@JsonView(ShowGodinaStudija.class)
	@ManyToOne(cascade=CascadeType.ALL)
	private GodinaStudija godinaStudija;
	
	@NotNull
	private Boolean obrisan = false;

	public Predmet() {}

	public Predmet(String naziv, Integer espb, Boolean obavezan, Integer brojPredavanja, Integer brojVezbi,
			Integer drugiObliciNastave, Integer istrazivackiRad, Integer ostaliCasovi, Set<Ishod> syllabus,
			Set<Predmet> preduslov, Set<Predmet> preduslovZa, GodinaStudija godinaStudija,
			Boolean obrisan) {
		super();
		this.naziv = naziv;
		this.espb = espb;
		this.obavezan = obavezan;
		this.brojPredavanja = brojPredavanja;
		this.brojVezbi = brojVezbi;
		this.drugiObliciNastave = drugiObliciNastave;
		this.istrazivackiRad = istrazivackiRad;
		this.ostaliCasovi = ostaliCasovi;
		this.syllabus = syllabus;
		this.preduslov = preduslov;
		this.preduslovZa = preduslovZa;
		this.godinaStudija = godinaStudija;
		this.obrisan = obrisan;
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
	
	public Integer getEspb(){
		return espb;
	}

	public void setEspb(Integer espb){
		this.espb = espb;
	}
	
	public Boolean getObavezan(){
		return obavezan;
	}

	public void setObavezan(Boolean obavezan){
		this.obavezan = obavezan;
	}
	
	public Integer getBrojPredavanja(){
		return brojPredavanja;
	}

	public void setBrojPredavanja(Integer brojPredavanja){
		this.brojPredavanja = brojPredavanja;
	}
	
	public Integer getBrojVezbi(){
		return brojVezbi;
	}

	public void setBrojVezbi(Integer brojVezbi){
		this.brojVezbi = brojVezbi;
	}
	
	public Integer getDrugiObliciNastave() {
		return drugiObliciNastave;
	}

	public void setOtherActivitiesNum(Integer drugiObliciNastave) {
		this.drugiObliciNastave = drugiObliciNastave;
	}

	public Integer getIstrazivackiRad(){
		return istrazivackiRad;
	}

	public void setIstrazivackiRad(Integer istrazivackiRad){
		this.istrazivackiRad = istrazivackiRad;
	}
	
	public Integer getOstaliCasovi(){
		return ostaliCasovi;
	}

	public void setOstaliCasovi(Integer ostaliCasovi){
		this.ostaliCasovi = ostaliCasovi;
	}
	
	public Set<Ishod> getSyllabus(){
		return syllabus;
	}

	public void setSyllabus(Set<Ishod> syllabus){
		this.syllabus = syllabus;
	}

	public Set<Predmet> getPreduslov() {
		return preduslov;
	}

	public void setPreduslov(Set<Predmet> preduslov) {
		this.preduslov = preduslov;
	}

	public Set<Predmet> getPreduslovZa() {
		return preduslovZa;
	}

	public void setPreduslovZa(Set<Predmet> preduslovZa) {
		this.preduslovZa = preduslovZa;
	}

	public GodinaStudija getGodinaStudija(){
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija){
		this.godinaStudija = godinaStudija;
	}

	public Boolean getObrisan() {
		return obrisan;
	}

	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}
	
}