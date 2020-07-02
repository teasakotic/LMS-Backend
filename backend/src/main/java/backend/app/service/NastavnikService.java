package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import backend.app.model.Nastavnik;
//import backend.app.model.RealizacijaPredmeta;
import backend.app.repository.NastavnikRepository;
//import backend.app.repository.RealizacijaPredmetaRepository;

@Service
public class NastavnikService {

    @Autowired
    private NastavnikRepository nastavnikRepo;
    
 //   @Autowired
   // private RealizacijaPredmetaRepository realizacijaPredmetaRepo;
    
    @Autowired
    private LoginService loginServ;
    
    @Autowired
    private RegistrovaniKorisnikService regServ;
    
    @Autowired
    private AdresaService adresaServ;
    
    @Autowired
    private LicniPodaciService licniServ;
    
    @Autowired
	private PasswordEncoder passwordEncoder;

    public NastavnikService() {
    }

    public Iterable<Nastavnik> getNastavnik() {
        return nastavnikRepo.findAll();
    }
    
    public Iterable<Optional<Nastavnik>> getNastavnikByFakultet(Long fakultetId) {
        return nastavnikRepo.getAllByFakultet(fakultetId);
    }

    public Optional<Nastavnik> getNastavnikById(Long id) {
        return nastavnikRepo.findById(id);
    }
    
    public Optional<Nastavnik> getNastavnikByUsername(String username) {
        return nastavnikRepo.getByUsername(username);
    }

    public void addNastavnik(Nastavnik nastavnik) {
    	loginServ.addDozvola(nastavnik.getRegistrovaniKorisnik(), "ROLE_NASTAVNIK");
    	nastavnik.getRegistrovaniKorisnik().setLozinka(passwordEncoder.encode(nastavnik.getRegistrovaniKorisnik().getLozinka()));
    	nastavnikRepo.save(nastavnik);
    }

    public void removeNastavnik(Long id) {
        Optional<Nastavnik> nastavnik = nastavnikRepo.findById(id);
        Nastavnik t = nastavnik.get();
        t.setObrisan(true);
        nastavnikRepo.save(t);
    }

    public void updateNastavnik(String username, Nastavnik nastavnik) {
        Optional<Nastavnik> Tea = nastavnikRepo.getByUsername(username);
        if(Tea.isPresent()) {
        	nastavnik.setId(Tea.get().getId());
        	nastavnik.getRegistrovaniKorisnik().setLozinka(passwordEncoder.encode(nastavnik.getRegistrovaniKorisnik().getLozinka()));
            regServ.updateRegistrovaniKorisnik(nastavnik.getRegistrovaniKorisnik().getId(), nastavnik.getRegistrovaniKorisnik());
            adresaServ.updateAdresa(nastavnik.getAdresa().getId(), nastavnik.getAdresa());
            licniServ.updateLicniPodaci(nastavnik.getLicniPodaci().getId(), nastavnik.getLicniPodaci());
        }
    }
    
    public Iterable<Optional<Nastavnik>> getNastavnikByIme(String ime){
    	return nastavnikRepo.findNastavnikByIme("%"+ime+"%");
    }
    
    public Optional<Nastavnik> getNastavnikByJmbg(String jmbg){
    	return nastavnikRepo.findNastavnikByJmbg(jmbg);
    }
    
  //  public Iterable<RealizacijaPredmeta> getRealizacijaPredmeta(String username) {
    //    return realizacijaPredmetaRepo.findByNastavnikUsername(username);
    //}

}