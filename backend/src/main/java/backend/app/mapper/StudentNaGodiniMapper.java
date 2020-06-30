package backend.app.mapper;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import backend.app.model.StudentNaGodini;
import backend.app.dto.StudentNaGodiniDTO;

@Component
public class StudentNaGodiniMapper implements Mapper<StudentNaGodini, StudentNaGodiniDTO>{

	@Autowired
	GodinaStudijaMapper ysMapper;
	
	@Override
	public StudentNaGodiniDTO toDTO(StudentNaGodini e) {
		if(e == null) return null;
		StudentNaGodiniDTO retVal = new StudentNaGodiniDTO();
		retVal.setBrojIndeksa(e.getBrojIndeksa());
		retVal.setDatumUpisa(e.getDatumUpisa());
		retVal.setGodinaStudija(ysMapper.toDTO(e.getGodinaStudija()));
		return retVal;
	}

	@Override
	public StudentNaGodini toEntity(StudentNaGodiniDTO edto) {
		return null;
	}

	@Override
	public Collection<StudentNaGodiniDTO> toDTO(Collection<StudentNaGodini> es) {
		if (es.size() == 0) return null;
		Collection<StudentNaGodiniDTO> godine= new ArrayList<StudentNaGodiniDTO>(es.size());
		for (StudentNaGodini e : es) {
			godine.add(toDTO(e));			
		}		
		return godine;
	}

	@Override
	public Collection<StudentNaGodini> toEntityList(Collection<StudentNaGodiniDTO> edtos) {
		return null;
	}

}
