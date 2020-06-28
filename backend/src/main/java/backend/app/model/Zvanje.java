package backend.app.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Zvanje {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Date datumIzbora;

	@Column(nullable = false)
	private Date datumPrestanka;

	@ManyToOne(cascade=CascadeType.ALL)
	private NaucnaOblast naucnaOblast;

	@ManyToOne(cascade=CascadeType.ALL)
	private Nastavnik nastavnik;

	public Zvanje() {}

	public Zvanje(Date datumIzbora, Date datumPrestanka, NaucnaOblast naucnaOblast, Nastavnik nastavnik){
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.naucnaOblast = naucnaOblast;
		this.nastavnik = nastavnik;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Date getDatumIzbora(){
		return datumIzbora;
	}

	public void setDatumIzbora(Date datumIzbora){
		this.datumIzbora = datumIzbora;
	}
	
	public Date getDatumPrestanka(){
		return datumPrestanka;
	}

	public void setDatumPrestanka(Date datumPrestanka){
		this.datumPrestanka = datumPrestanka;
	}
	
	public NaucnaOblast getNaucnaOblast(){
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblast naucnaOblast){
		this.naucnaOblast = naucnaOblast;
	}
	
	public Nastavnik getNastavnik(){
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik){
		this.nastavnik = nastavnik;
	}
	
}