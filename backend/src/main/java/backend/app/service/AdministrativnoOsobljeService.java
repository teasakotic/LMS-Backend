package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.app.model.AdministrativnoOsoblje;
import backend.app.model.GodinaStudija;
import backend.app.model.IzborniPredmet;
import backend.app.model.PohadjanjePredmeta;

import backend.app.model.RealizacijaPredmeta;
import backend.app.model.Student;
import backend.app.model.StudentNaGodini;
import backend.app.repository.AdministrativnoOsobljeRepository;

@Service
public class AdministrativnoOsobljeService {

    @Autowired
    private AdministrativnoOsobljeRepository administrativnoOsobljeRepo;

    @Autowired
    private LoginService loginServ;
    
   // @Autowired
    //private RegistrovaniKorisnikService korisnikServ;
    
    //@Autowired
    //private AdresaService adresaServ;
    
   // @Autowired
    //private LicniPodaciService licniServ;
    
    @Autowired
    private StudentService studentService;
    
    @Autowired
    private GodinaStudijaService godinaStudijaService;
    
    @Autowired
    private StudentNaGodiniService studentNaGodiniService;
    
    @Autowired
	private PasswordEncoder passwordEncoder;
    

    
    @Autowired
    private RealizacijaPredmetaService realizacijaPredmetaService;
    
    @Autowired
    private PohadjanjePredmetaService pohadjanjePredmetaService;
    
    public AdministrativnoOsobljeService() {
    }

    public Iterable<AdministrativnoOsoblje> getAdministrativnoOsoblje() {
        return administrativnoOsobljeRepo.findAll();
    }

    public Optional<AdministrativnoOsoblje> getAdministrativnoOsobljeById(Long id) {
        return administrativnoOsobljeRepo.findById(id);
    }
    
    //public Optional<AdministrativnoOsoblje> getAdministrativnoOsobljeByUsername(String username) {
      //  return administrativnoOsobljeRepo.getByUsername(username);
    //}

    public void addAdministrativnoOsoblje(AdministrativnoOsoblje administrativnoOsoblje) {
    	loginServ.addDozvola(administrativnoOsoblje.getRegistrovaniKorisnik(), "ROLE_ADMINISTRATIVNO_OSOBLJE");
    	administrativnoOsoblje.getRegistrovaniKorisnik().setLozinka(passwordEncoder.encode(administrativnoOsoblje.getRegistrovaniKorisnik().getLozinka()));
    	administrativnoOsobljeRepo.save(administrativnoOsoblje);
    }
    
    public void removeAdministrativnoOsoblje(Long id) {
        Optional<AdministrativnoOsoblje> administrativnoOsoblje = administrativnoOsobljeRepo.findById(id);
        AdministrativnoOsoblje a = administrativnoOsoblje.get();
        a.setObrisan(true);
        administrativnoOsobljeRepo.save(a);
    }

   // public void updateAdministrativnoOsoblje(String username, AdministrativnoOsoblje administrativnoOsoblje) {
     //   Optional<AdministrativnoOsoblje> Adm = administrativnoOsobljeRepo.getByUsername(username);
       // if(Adm.isPresent()) {
        //	administrativnoOsoblje.setId(Adm.get().getId());
        	//administrativnoOsoblje.getRegistrovaniKorisnik().setLozinka(passwordEncoder.encode(administrativnoOsoblje.getRegistrovaniKorisnik().getLozinka()));
            //korisnikServ.updateRegistrovaniKorisnik(administrativnoOsoblje.getRegistrovaniKorisnik().getId(), administrativnoOsoblje.getRegistrovaniKorisnik());
            //adresaServ.updateAdresa(administrativnoOsoblje.getAdresa().getId(), administrativnoOsoblje.getAdresa());
            //licniServ.updateLicniPodaci(administrativnoOsoblje.getLicniPodaci().getId(), administrativnoOsoblje.getLicniPodaci());
        //}
    //}
    
    
    
    
    
    public Boolean upisStudenataUNarednuGodinu(Long studentId, GodinaStudija godinaStudija) { 
    	Optional<Student> student = studentService.getStudentById(studentId);
        if(student.isPresent()) {
        	Optional<GodinaStudija> staraGodinaStudija = godinaStudijaService.getGodinaStudijaById(godinaStudija.getId());
        	Optional<GodinaStudija> novaGodinaStudija = godinaStudijaService.getNarednaGodinaStudijaByStudijskiProgram(godinaStudija.getId());
        	Optional<StudentNaGodini> studentNaGodini =studentNaGodiniService.getStudentNaGodiniByGodinaStudijaIdAndStudentId(staraGodinaStudija.get().getId(), student.get().getId());
        	studentNaGodini.get().setGodinaStudija(novaGodinaStudija.get());
        	studentNaGodiniService.updateStudentNaGodini(studentNaGodini.get().getId(), studentNaGodini.get());
        	
        	Iterable<RealizacijaPredmeta> realizacijaPredmeta = realizacijaPredmetaService.getRealizacijaPredmetaByGodinaStudijaId(novaGodinaStudija.get().getId());
        	for(RealizacijaPredmeta sr: realizacijaPredmeta) {
        		if(sr.getPredmet().getObavezan()) {
        			pohadjanjePredmetaService.addPohadjanjePredmeta(new PohadjanjePredmeta(null, student.get(), sr));
        		}
        		else if(!sr.getPredmet().getObavezan()) {
        			for(IzborniPredmet ip: student.get().getIzborniPredmet()) {
        				if(ip.getRealizacijaPredmeta().getId() == sr.getId()) {
        					pohadjanjePredmetaService.addPohadjanjePredmeta(new PohadjanjePredmeta(null, student.get(), sr));
        				}
        			}
        		}
        	}
        	return true;
        }
        return false;
    }
    

}
