package backend.app.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.utils.ViewUtils.ShowIshod;
import backend.app.utils.ViewUtils.ShowPolaganje;

@Entity 
public class EvaluacijaZnanja {
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@Column
		private Date vremePocetka;
		
		@Column
		private Date vremeZavrsetka;
		
		@Column(nullable = false)
		private Integer bodovi;
		
		@Column(nullable = false)
		private Integer trajanjeUMinutima;
		
		@ManyToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
		private RealizacijaPredmeta realizacijaPredmeta;
		
		@ManyToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
		private TipEvaluacije tipEvaluacije;
		
		@JsonView(ShowPolaganje.class)
		@OneToMany(mappedBy="evaluacijaZnanja")
		private Set<Polaganje> polaganje;
		
		@JsonView(ShowIshod.class)
		@OneToMany(mappedBy="evaluacijaZnanja", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		private Set<EvaluacijaZnanjaIshod> silabus;

		public EvaluacijaZnanja() {
			super();
		}

		public EvaluacijaZnanja(Date vremePocetka, Date vremeZavrsetka, Integer bodovi, Integer trajanjeUMinutima,
				RealizacijaPredmeta realizacijaPredmeta, TipEvaluacije tipEvaluacije, Set<Polaganje> polaganje,
				Set<EvaluacijaZnanjaIshod > silabus) {
			super();
			this.vremePocetka = vremePocetka;
			this.vremeZavrsetka = vremeZavrsetka;
			this.bodovi = bodovi;
			this.trajanjeUMinutima = trajanjeUMinutima;
			this.realizacijaPredmeta = realizacijaPredmeta;
			this.tipEvaluacije = tipEvaluacije;
			this.polaganje = polaganje;
			this.silabus = silabus;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getVremePocetka() {
			return vremePocetka;
		}

		public void setVremePocetka(Date vremePocetka) {
			this.vremePocetka = vremePocetka;
		}

		public Date getVremeZavrsetka() {
			return vremeZavrsetka;
		}

		public void setVremeZavrsetka(Date vremeZavrsetka) {
			this.vremeZavrsetka = vremeZavrsetka;
		}

		public Integer getBodovi() {
			return bodovi;
		}

		public void setBodovi(Integer bodovi) {
			this.bodovi = bodovi;
		}
		
		public Integer getTrajanjeUMinutima() {
			return trajanjeUMinutima;
		}

		public void setTrajanjeUMinutima(Integer trajanjeUMinutima) {
			this.trajanjeUMinutima = trajanjeUMinutima;
		}

		public RealizacijaPredmeta getRealizacijaPredmeta() {
			return realizacijaPredmeta;
		}

		public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
			this.realizacijaPredmeta = realizacijaPredmeta;
		}

		public TipEvaluacije getTipEvaluacije() {
			return tipEvaluacije;
		}

		public void setTipEvaluacije(TipEvaluacije tipEvaluacije) {
			this.tipEvaluacije = tipEvaluacije;
		}

		public Set<Polaganje> getPolaganje() {
			return polaganje;
		}

		public void setPolaganje(Set<Polaganje> polaganje) {
			this.polaganje = polaganje;
		}

		public Set<EvaluacijaZnanjaIshod> getSilabus() {
			return silabus;
		}

		public void setSilabus(Set<EvaluacijaZnanjaIshod> silabus) {
			this.silabus = silabus;
		}

}
