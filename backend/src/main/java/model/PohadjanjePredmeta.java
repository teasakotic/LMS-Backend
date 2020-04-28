package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PohadjanjePredmeta {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)
	private Integer konacnaOcena;

	@ManyToOne(cascade=CascadeType.ALL)
	private Student student;

	@ManyToOne(cascade=CascadeType.ALL)
	private RealizacijaPredmeta realizacijaPredmeta;

	public PohadjanjePredmeta() {}

	public PohadjanjePredmeta(Integer konacnaOcena, Student student, RealizacijaPredmeta realizacijaPredmeta){
		this.konacnaOcena = konacnaOcena;
		this.student = student;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
	
	public Integer getKonacnaOcena(){
		return konacnaOcena;
	}

	public void setKonacnaOcena(Integer konacnaOcena){
		this.konacnaOcena = konacnaOcena;
	}
	
	public Student getStudent(){
		return student;
	}

	public void setStudent(Student student){
		this.student = student;
	}
	
	public RealizacijaPredmeta getRealizacijaPredmeta(){
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta){
		this.realizacijaPredmeta = realizacijaPredmeta;
	}
	
}