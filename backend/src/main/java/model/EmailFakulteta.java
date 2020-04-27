package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EmailFakulteta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(cascade=CascadeType.ALL)
	private Email email;
	@ManyToOne(cascade=CascadeType.ALL)
	private Fakultet fakultet;
	
	public EmailFakulteta() {
		super();
	}
	
	public EmailFakulteta(Email email, Fakultet fakultet) {
		super();
		this.email = email;
		this.fakultet = fakultet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}
	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}
	
}



