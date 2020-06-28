package backend.app.repository;

import java.util.Collection;

import backend.app.model.Student;

public interface RadNaStudentuRepository {
	Collection<Student> searchStudenti(String ime, String prezime, String brojIndeksa, String upis, String prosecnaOcena);

}
