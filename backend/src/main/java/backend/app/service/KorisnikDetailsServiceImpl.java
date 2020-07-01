package backend.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.app.model.KorisnickaDozvola;
import backend.app.model.RegistrovaniKorisnik;


@Service
public class KorisnikDetailsServiceImpl implements UserDetailsService {
	@Autowired
	RegistrovaniKorisnikService registrovaniKorisnikService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<RegistrovaniKorisnik> registrovaniKorisnik = registrovaniKorisnikService.getRegistrovaniKorisnikByUsername(username);
		
		if(registrovaniKorisnik.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for(KorisnickaDozvola korDozvola : registrovaniKorisnik.get().getKorisnickaDozvola()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(korDozvola.getDozvola().getNaziv()));
			}
			
			return new org.springframework.security.core.userdetails.User(registrovaniKorisnik.get().getUsername(), registrovaniKorisnik.get().getLozinka(), grantedAuthorities);
		}
		
		return null;
	}
}
