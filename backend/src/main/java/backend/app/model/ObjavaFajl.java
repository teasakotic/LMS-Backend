package backend.app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ObjavaFajl {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(length=128, nullable = false)
	private String opis;

	@Column(length=128, nullable = false)
	private String url;

	@ManyToOne(cascade=CascadeType.ALL)
	private Objava objava;

	public ObjavaFajl() {}

	public ObjavaFajl(String opis, String url, Objava objava){
		this.opis = opis;
		this.url = url;
		this.objava = objava;
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
	
	public String getUrl(){
		return url;
	}

	public void setUrl(String url){
		this.url = url;
	}
	
	public Objava getObjava(){
		return objava;
	}

	public void setObjava(Objava objava){
		this.objava = objava;
	}
	
}