package backend.app.dto;

import java.util.Date;

public class GodinaStudijaDTO {

	private Long id;
	private int godina;
	private Date datumPocetka, datumKraja;
	private String studijskiProgramNaziv;
	private String fakultetNaziv;
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
	public String getStudijskiProgramNaziv() {
		return studijskiProgramNaziv;
	}
	public void setStudijskiProgramNaziv(String studijskiProgramNaziv) {
		this.studijskiProgramNaziv = studijskiProgramNaziv;
	}
	public String getFakultetNaziv() {
		return fakultetNaziv;
	}
	public void setFakultetNaziv(String fakultetNaziv) {
		this.fakultetNaziv = fakultetNaziv;
	}
	public GodinaStudijaDTO(Long id, int godina, Date datumPocetka, Date datumKraja, String studijskiProgramNaziv,
			String fakultetNaziv) {
		super();
		this.id = id;
		this.godina = godina;
		this.datumPocetka = datumPocetka;
		this.datumKraja = datumKraja;
		this.studijskiProgramNaziv = studijskiProgramNaziv;
		this.fakultetNaziv = fakultetNaziv;
	}

	public GodinaStudijaDTO() {}
}
