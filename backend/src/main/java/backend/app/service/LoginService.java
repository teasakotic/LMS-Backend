package backend.app.service;

import backend.app.model.KorisnickaDozvola;
import backend.app.model.RegistrovaniKorisnik;
import backend.app.repository.DozvolaRepository;
import backend.app.repository.RegistrovaniKorisnikRepository;
import backend.app.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;

@Service
public class LoginService {
	@Autowired
	RegistrovaniKorisnikService regS;

	@Autowired
	RegistrovaniKorisnikRepository regR;

	@Autowired
	DozvolaRepository pr;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	public ResponseEntity<HashMap<String, String>> login(RegistrovaniKorisnik regKorisnik) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(regKorisnik.getUsername(),
					regKorisnik.getLozinka());


			Authentication authentication = authenticationManager.authenticate(token);

			SecurityContextHolder.getContext().setAuthentication(authentication);

			UserDetails details = userDetailsService.loadUserByUsername(regKorisnik.getUsername());
			String userToken = tokenUtils.generateToken(details);

			HashMap<String, String> data = new HashMap<String, String>();
			data.put("token", userToken);
			
			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);
			
		}
		catch (InternalAuthenticationServiceException e) {
			System.out.println("Auth error");
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
		catch (UsernameNotFoundException e) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	}
	
	public void addDozvola(RegistrovaniKorisnik regKorisnik, String role) {
		regKorisnik = regR.save(regKorisnik);
		regKorisnik.setKorisnickaDozvola(new HashSet<KorisnickaDozvola>());
		regKorisnik.getKorisnickaDozvola().add(new KorisnickaDozvola(regKorisnik, pr.getByNaziv(role).get()));
		regR.save(regKorisnik);
	}
	
}
