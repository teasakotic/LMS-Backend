package backend.app.mapper;



import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;
import org.xmlunit.util.Mapper;

import backend.app.dto.StudentDTO;
import backend.app.model.Student;


@Component
public class StudentMapper implements Mapper<Student, StudentDTO> {
	
	public Student toEntity(
 StudentDTO  studentDTO) {
		if (studentDTO == null) {
	    	return null;
		}
		Student retVal = new Student();

		retVal.setId(studentDTO.getId());
		return retVal;
	}
	
	public Collection<Student> toEntityList(Collection<StudentDTO> dtoList) {
	    if ( dtoList == null ) {
	        return null;
	    }
	    Collection<Student> collection = new ArrayList<Student>(dtoList.size());
	    for (StudentDTO student : dtoList) {
	        collection.add(toEntity(student));
	    }

	    return collection;
	}

	public StudentDTO toDTO(Student entity) {
		if (entity == null) {
		    return null;
		}

		StudentDTO retVal = new StudentDTO();

		retVal.setId(entity.getId());
		retVal.setEmail(entity.getRegistrovaniKorisnik().getEmail());
		retVal.setIme(entity.getLicniPodaci().getIme());
		retVal.setPrezime(entity.getLicniPodaci().getPrezime());
		retVal.setBrTelefona(entity.getLicniPodaci().getBrTelefona());

		return retVal;
	}

	
	public Collection<StudentDTO> toDtoList(Collection<Student> entityList) {
	    if ( entityList == null ) {
	        return null;
	    }

	    Collection<StudentDTO> collection = new ArrayList<StudentDTO>(entityList.size());
	    for (Student student : entityList) {
	        collection.add(toDTO(student));
	    }

	    return collection;
	}

	@Override
	public StudentDTO apply(Student from) {
		return null;
	}


}
