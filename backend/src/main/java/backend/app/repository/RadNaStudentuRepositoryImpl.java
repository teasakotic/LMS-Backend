package backend.app.repository;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import backend.app.model.LicniPodaci;
import backend.app.model.PohadjanjePredmeta;
import backend.app.model.Student;
import backend.app.model.StudentNaGodini;


@Repository
public class RadNaStudentuRepositoryImpl implements RadNaStudentuRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Collection<Student> searchStudenti(String ime, String prezime, String brojIndeksa, String upis, String prosecnaOcena) {

		Session session = entityManager.unwrap(Session.class);
		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Student> criteria = builder.createQuery(Student.class);

		Root<Student> myObjectRoot = criteria.from(Student.class);
		ArrayList<Predicate> predicates = new ArrayList<Predicate>();

		if (ime != null && ime != "") {
			Join<Student, LicniPodaci> joinLicniPodaci = myObjectRoot.join("licniPodaci");
			Predicate likeRestrictionIme = builder.and(builder.like(joinLicniPodaci.get("ime"), "%" + ime + "%"));
			predicates.add(likeRestrictionIme);
		};
		if (prezime != null && prezime != "") {
			Join<Student, LicniPodaci> joinLicniPodaci = myObjectRoot.join("licniPodaci");
			Predicate likeRestrictionPrezime = builder.and(builder.like(joinLicniPodaci.get("prezime"), "%" + prezime + "%"));
			predicates.add(likeRestrictionPrezime);
		};
		if (brojIndeksa != null && brojIndeksa != "") {
			Join<Student, LicniPodaci> joinLicniPodaci = myObjectRoot.join("licniPodaci");
			Predicate likeRestrictionBrojIndeksa = builder.and(builder.like(joinLicniPodaci.get("brojIndeksa"), "%" + brojIndeksa + "%"));
			predicates.add(likeRestrictionBrojIndeksa);
		};
		if (upis != null && upis != "") {
			try {
				int upisnaGodina = 0;
				upisnaGodina = Integer.parseInt(upis);
				Join<Student, StudentNaGodini> joinStudentNaGodini = myObjectRoot.join("studentNaGodinama");
				Predicate upisRestriction = builder.and(builder.equal(
						builder.function("GODINA", Integer.class, joinStudentNaGodini.get("DatumUpisa")), upisnaGodina));
				predicates.add(upisRestriction);

			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		if (prosecnaOcena != null && prosecnaOcena != "") {
			try {
				double avg = 0;
				avg = Double.parseDouble(prosecnaOcena);
				Join<Student, PohadjanjePredmeta> joinPohadjanjePredmeta = myObjectRoot.join("pohadjanjePredmeta");
				Subquery<Double> sub = criteria.subquery(Double.class);
				sub.select(builder.avg(joinPohadjanjePredmeta.get("konacnaOcena")));
				sub.from(PohadjanjePredmeta.class);
				sub.having(builder.equal(myObjectRoot.get("id"), joinPohadjanjePredmeta.get("student").get("id")));
				Predicate ocenaRestriction = builder.and(builder.equal(sub, avg));
				predicates.add(ocenaRestriction);

			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	
		Collection<Student> results = entityManager.createQuery(criteria.where(predicates.toArray(new Predicate[0]))).getResultList();
		return results;

	}

}
