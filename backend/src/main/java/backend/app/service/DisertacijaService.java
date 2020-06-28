package backend.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.repository.DisertacijaRepository;

@Service
public class DisertacijaService {
	
	@Autowired
	DisertacijaRepository disRepo;
	
	public ArrayList<Object> findDisertacijaByStudentId(Long studentId){
		return disRepo.findByStudentNaGodiniStudentId(studentId);
	}

}
