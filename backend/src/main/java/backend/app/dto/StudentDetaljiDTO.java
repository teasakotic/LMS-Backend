package backend.app.dto;

import java.util.Collection;
import backend.app.dto.StudentNaGodiniDTO;

public class StudentDetaljiDTO {
		
		private Long id;
		private String ime, prezime, email, putanjaProfilneSlike;
		
		private Collection<StudentNaGodiniDTO> studentNaGodini;
		
		public StudentDetaljiDTO() {}

		public StudentDetaljiDTO(Long id, String ime, String prezime, String email, String putanjaProfilneSlike,
				Collection<StudentNaGodiniDTO> studentNaGodini) {
			super();
			this.id = id;
			this.ime = ime;
			this.prezime = prezime;
			this.email = email;
			this.putanjaProfilneSlike = putanjaProfilneSlike;
			this.studentNaGodini = studentNaGodini;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getIme() {
			return ime;
		}

		public void setIme(String ime) {
			this.ime = ime;
		}

		public String getPrezime() {
			return prezime;
		}

		public void setPrezime(String prezime) {
			this.prezime = prezime;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPutanjaProfilneSlike() {
			return putanjaProfilneSlike;
		}

		public void setPutanjaProfilneSlike(String putanjaProfilneSlike) {
			this.putanjaProfilneSlike = putanjaProfilneSlike;
		}

		public Collection<StudentNaGodiniDTO> getStudentNaGodini() {
			return studentNaGodini;
		}

		public void setStudentNaGodini(Collection<StudentNaGodiniDTO> studentNaGodini) {
			this.studentNaGodini = studentNaGodini;
		}	

	
		}
