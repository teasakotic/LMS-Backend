package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TelefoniFakulteta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade=CascadeType.ALL)
	private Fakultet fakultet;
	@ManyToOne(cascade=CascadeType.ALL)
	private Telefon telefon;
	
	public TelefoniFakulteta() {
		super();
	}

	public TelefoniFakulteta(Fakultet fakultet, Telefon telefon) {
		super();
		this.fakultet = fakultet;
		this.telefon = telefon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public Telefon getTelefon() {
		return telefon;
	}

	public void setTelefon(Telefon telefon) {
		this.telefon = telefon;
	}
	
}
