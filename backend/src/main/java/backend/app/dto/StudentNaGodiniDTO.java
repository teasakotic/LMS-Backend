package backend.app.dto;

import java.util.Date;

public class StudentNaGodiniDTO {
	private Date datumUpisa;
	private String brojIndeksa;
	private GodinaStudijaDTO godinaStudija;
	
	public Date getDatumUpisa() {
		return datumUpisa;
	}
	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public StudentNaGodiniDTO(Date datumUpisa, String brojIndeksa, GodinaStudijaDTO godinaStudija) {
		super();
		this.datumUpisa = datumUpisa;
		this.brojIndeksa = brojIndeksa;
		this.godinaStudija = godinaStudija;
	}
	public StudentNaGodiniDTO() {}
	
}
