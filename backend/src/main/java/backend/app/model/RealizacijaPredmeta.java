package backend.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.utils.ViewUtils.ShowIshod;
import backend.app.utils.ViewUtils.ShowNastavniMaterijal;
import backend.app.utils.ViewUtils.ShowNastavnikNaRealizaciji;
import backend.app.utils.ViewUtils.ShowTerminNastave;

@Entity
public class RealizacijaPredmeta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@JsonView(ShowNastavnikNaRealizaciji.class)
	@OneToMany(mappedBy="realizacijaPredmeta")
	private Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji;
	
	@JsonView(ShowIshod.class)
	@OneToMany(mappedBy="realizacijaPredmeta")
	private Set<Ishod> ishod;
	
	@JsonView(ShowTerminNastave.class)
	@OneToMany(mappedBy="realizacijaPredmeta")
	private Set<TerminNastave> terminNastave;
	

	@ManyToOne(cascade=CascadeType.ALL)
	private Predmet predmet;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private GodinaStudija godinaStudija;
	
	@JsonView(ShowNastavniMaterijal.class)
	@OneToMany(mappedBy="realizacijaPredmeta")
	private Set<NastavniMaterijal> nastavniMaterijal;


	public RealizacijaPredmeta() {}

	public RealizacijaPredmeta(Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji, Set<Ishod> ishod, Set<TerminNastave> terminNastave,
			 Predmet predmet, GodinaStudija godinaStudija, Set<NastavniMaterijal> nastavniMaterijal) {
		super();
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
		this.ishod = ishod;
		this.terminNastave = terminNastave;
		this.predmet = predmet;
		this.godinaStudija = godinaStudija;
		this.nastavniMaterijal = nastavniMaterijal;
		
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Set<NastavnikNaRealizaciji> getNastavnikNaRealizaciji(){
		return nastavnikNaRealizaciji;
	}

	public void setNastavnikNaRealizaciji(Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji){
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}
	
	public Set<Ishod> getIshod() {
		return ishod;
	}

	public void setIshod(Set<Ishod> ishod) {
		this.ishod = ishod;
	}
	
	
	public Set<TerminNastave> getTerminNastave() {
		return terminNastave;
	}

	public void setTerminNastave(Set<TerminNastave> terminNastave) {
		this.terminNastave = terminNastave;
	}
	
	public Predmet getPredmet(){
		return predmet;
	}

	public void setPredmet(Predmet predmet){
		this.predmet = predmet;
	}
	
	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}


	public Set<NastavniMaterijal> getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(Set<NastavniMaterijal> nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}

	
}
