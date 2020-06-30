package backend.app.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.utils.ViewUtils.ShowIshod;

@Entity
public class Poruka {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String sadrzaj;
	
	@Column(nullable = false)
	private Date datumPostavljanja;
	
	private String primalac;
	
	private String posiljalac;
	
	@JsonView(ShowIshod.class)
	@OneToMany(mappedBy="poruka")
	private Set<File> prilog;

	public Poruka() {
		super();
	}

	public Poruka(String sadrzaj, Date datumPostavljanja, String primalac, String posiljalac, Set<File> prilog) {
		super();
		this.sadrzaj = sadrzaj;
		this.datumPostavljanja = datumPostavljanja;
		this.primalac = primalac;
		this.posiljalac = posiljalac;
		this.prilog = prilog;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public Date getDatumPostavljanja() {
		return datumPostavljanja;
	}

	public void setDatumPostavljanja(Date datumPostavljanja) {
		this.datumPostavljanja = datumPostavljanja;
	}

	public String getPrimalac() {
		return primalac;
	}

	public void setPrimalac(String primalac) {
		this.primalac = primalac;
	}

	public String getPosiljalac() {
		return posiljalac;
	}

	public void setPosiljalac(String posiljalac) {
		this.posiljalac = posiljalac;
	}

	public Set<File> getPrilog() {
		return prilog;
	}

	public void setPrilog(Set<File> prilog) {
		this.prilog = prilog;
	}

}
