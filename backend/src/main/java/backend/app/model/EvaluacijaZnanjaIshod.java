package backend.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EvaluacijaZnanjaIshod {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String opis;

	@ManyToOne(cascade= {CascadeType.REFRESH, CascadeType.MERGE})
	private EvaluacijaZnanja evaluacijaZnanja;

	public EvaluacijaZnanjaIshod() {}

	public EvaluacijaZnanjaIshod(String opis, EvaluacijaZnanja evaluacijaZnanja) {
		super();
		this.opis = opis;
		this.evaluacijaZnanja = evaluacijaZnanja;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public String getOpis(){
		return opis;
	}

	public void setOpis(String opis){
		this.opis = opis;
	}

	public EvaluacijaZnanja getEvaluacijaZnanja() {
		return evaluacijaZnanja;
	}

	public void setEvaluacijaZnanja(EvaluacijaZnanja evaluacijaZnanja) {
		this.evaluacijaZnanja = evaluacijaZnanja;
	}
	
}
