package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class IzborniPredmet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade=CascadeType.ALL)
	private Student student;

	@ManyToOne(cascade=CascadeType.ALL)
	private RealizacijaPredmeta realizacijaPredmeta;

	public IzborniPredmet() {}

	public IzborniPredmet(Student student, RealizacijaPredmeta realizacijaPredmeta){
		this.student = student;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
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