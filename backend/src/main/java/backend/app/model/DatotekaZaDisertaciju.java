package backend.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class DatotekaZaDisertaciju {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String url;
	
	@OneToOne(mappedBy = "objavaFajl")
	private Disertacija disertacija;

	public DatotekaZaDisertaciju(String url, Disertacija disertacija) {
		super();
		this.url = url;
		this.disertacija = disertacija;
	}
	public DatotekaZaDisertaciju() {}
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public Disertacija getDisertacija() {
			return disertacija;
		}

		public void setDisertacija(Disertacija disertacija) {
			this.disertacija = disertacija;
		}
		
}
