package backend.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TelefoniUniverziteta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade=CascadeType.ALL)
	private Univerzitet univerzitet;
	@ManyToOne(cascade=CascadeType.ALL)
	private Telefon telefon;
	
	public TelefoniUniverziteta() {
		super();
	}

	public TelefoniUniverziteta(Univerzitet univerzitet, Telefon telefon) {
		super();
		this.univerzitet = univerzitet;
		this.telefon = telefon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public Telefon getTelefon() {
		return telefon;
	}

	public void setTelefon(Telefon telefon) {
		this.telefon = telefon;
	}
	
}