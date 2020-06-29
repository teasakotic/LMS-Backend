package backend.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import backend.app.model.ForumKorisnik;
import backend.app.service.ForumKorisnikService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/forumKorisnik")
public class ForumKorisnikController {

    @Autowired
    ForumKorisnikService forumKorisnikService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<ForumKorisnik>> getForumKorisnik() {
        return new ResponseEntity<Iterable<ForumKorisnik>>(forumKorisnikService.getForumKorisnik(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<ForumKorisnik> getForumKorisnikById(@PathVariable Long id) {
        Optional<ForumKorisnik> forumKorisnik = forumKorisnikService.getForumKorisnikById(id);
        if(forumKorisnik.isPresent()) {
            return new ResponseEntity<ForumKorisnik>(forumKorisnik.get(), HttpStatus.OK);
        }
        return new ResponseEntity<ForumKorisnik>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<ForumKorisnik> addForumKorisnik(@RequestBody ForumKorisnik forumKorisnik) {
    	forumKorisnikService.addForumKorisnik(forumKorisnik);
        return new ResponseEntity<ForumKorisnik>(forumKorisnik, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<ForumKorisnik> updateForumKorisnik(@PathVariable Long id, @RequestBody ForumKorisnik forumKorisnik) {
    	forumKorisnikService.updateForumKorisnik(id, forumKorisnik);
        return new ResponseEntity<ForumKorisnik>(forumKorisnik, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<ForumKorisnik> removeForumKorisnik(@PathVariable Long id) {
        try {
        	forumKorisnikService.removeForumKorisnik(id);
        }catch (Exception e) {
            return new ResponseEntity<ForumKorisnik>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ForumKorisnik>(HttpStatus.NO_CONTENT);
    }

}