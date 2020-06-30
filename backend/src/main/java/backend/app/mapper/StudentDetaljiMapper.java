package backend.app.mapper;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import backend.app.model.Student;
import backend.app.dto.StudentDetaljiDTO;

@Component
public class StudentDetaljiMapper implements Mapper<Student, StudentDetaljiDTO> {
	
	@Autowired
	StudentNaGodiniMapper studentNaGodiniMapper;

	@Override
	public StudentDetaljiDTO toDTO(Student e) {
		if (e == null) return null;
		
		StudentDetaljiDTO retVal = new StudentDetaljiDTO();
		retVal.setId(e.getId());
		retVal.setIme(e.getLicniPodaci().getIme());
		retVal.setPrezime(e.getLicniPodaci().getPrezime());
		retVal.setEmail(e.getRegistrovaniKorisnik().getEmail());
		retVal.setPutanjaProfilneSlike(e.getLicniPodaci().getPutanjaProfilneSlike());
		retVal.setStudentNaGodini(studentNaGodiniMapper.toDTO(e.getStudentNaGodini()));
		return retVal;
	}

	@Override
	public Student toEntity(StudentDetaljiDTO edto) {
		return null;
	}

	@Override
	public Collection<StudentDetaljiDTO> toDTO(Collection<Student> es) {
		if (es.size() == 0) return null;
		Collection<StudentDetaljiDTO> students= new ArrayList<StudentDetaljiDTO>(es.size());
		for (Student e : es) {
			students.add(toDTO(e));			
		}
		return students;
	}

	@Override
	public Collection<Student> toEntityList(Collection<StudentDetaljiDTO> edtos) {
		return null;
	}

}