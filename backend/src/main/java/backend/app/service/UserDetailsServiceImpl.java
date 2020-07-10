package backend.app.service;

import backend.app.model.KorisnickaDozvola;
import backend.app.model.RegistrovaniKorisnik;
import backend.app.repository.RegistrovaniKorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    RegistrovaniKorisnikRepository rkRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<RegistrovaniKorisnik> korisnik = rkRepo.findByUsername(username);

        if(korisnik.isPresent())
        {
            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            for(KorisnickaDozvola kd: korisnik.get().getKorisnickaDozvola())
            {
                authorities.add(new SimpleGrantedAuthority(kd.getDozvola().getNaziv()));
            }
            return new User(korisnik.get().getUsername(), korisnik.get().getLozinka(), authorities);
        } else {
            return null;
        }
    }
}
