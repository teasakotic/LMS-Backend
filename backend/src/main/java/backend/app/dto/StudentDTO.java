package backend.app.dto;

public class StudentDTO {
	private Long id;
	private String email;
	private String ime;
	private String prezime;
	private String brTelefona;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getBrTelefona() {
		return brTelefona;
	}
	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}
	public StudentDTO() {
		super();

	}
	
	

}
