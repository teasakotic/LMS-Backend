package backend.app.dto;

import java.sql.Date;

public class EvaluacijaZnanjaDTO {
	private int ocena;
	private String predmet;
	private int godina;
	private String studijskiProgramIme;
	private int bodovi;
	private Date datum;
	private int ects;
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public String getPredmet() {
		return predmet;
	}
	public void setPredmet(String predmet) {
		this.predmet = predmet;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public String getStudijskiProgramIme() {
		return studijskiProgramIme;
	}
	public void setStudijskiProgramIme(String studijskiProgramIme) {
		this.studijskiProgramIme = studijskiProgramIme;
	}
	public int getBodovi() {
		return bodovi;
	}
	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public int getEcts() {
		return ects;
	}
	public void setEcts(int ects) {
		this.ects = ects;
	}
	public EvaluacijaZnanjaDTO(int ocena, String predmet, int godina, String studijskiProgramIme, int bodovi,
			Date datum, int ects) {
		super();
		this.ocena = ocena;
		this.predmet = predmet;
		this.godina = godina;
		this.studijskiProgramIme = studijskiProgramIme;
		this.bodovi = bodovi;
		this.datum = datum;
		this.ects = ects;
	}


	

}
