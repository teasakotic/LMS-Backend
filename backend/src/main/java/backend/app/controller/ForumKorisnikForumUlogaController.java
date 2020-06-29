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

import backend.app.model.ForumKorisnikForumUloga;
import backend.app.service.ForumKorisnikForumUlogaService;
import backend.app.utils.ViewUtils.HideOptionalProperties;


@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/forumKorisnikForumUloga")
public class ForumKorisnikForumUlogaController {

    @Autowired
    ForumKorisnikForumUlogaService forumKorisnikForumUlogaService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<ForumKorisnikForumUloga>> getForumKorisnikForumUloga() {
        return new ResponseEntity<Iterable<ForumKorisnikForumUloga>>(forumKorisnikForumUlogaService.getForumKorisnikForumUloga(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<ForumKorisnikForumUloga> getForumKorisnikForumUlogaById(@PathVariable Long id) {
        Optional<ForumKorisnikForumUloga> forumKorisnikForumUloga = forumKorisnikForumUlogaService.getForumKorisnikForumUlogaById(id);
        if(forumKorisnikForumUloga.isPresent()) {
            return new ResponseEntity<ForumKorisnikForumUloga>(forumKorisnikForumUloga.get(), HttpStatus.OK);
        }
        return new ResponseEntity<ForumKorisnikForumUloga>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<ForumKorisnikForumUloga> addForumKorisnikForumUloga(@RequestBody ForumKorisnikForumUloga forumKorisnikForumUloga) {
    	forumKorisnikForumUlogaService.addForumKorisnikForumUloga(forumKorisnikForumUloga);
        return new ResponseEntity<ForumKorisnikForumUloga>(forumKorisnikForumUloga, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<ForumKorisnikForumUloga> updateForumKorisnikForumUloga(@PathVariable Long id, @RequestBody ForumKorisnikForumUloga forumKorisnikForumUloga) {
    	forumKorisnikForumUlogaService.updateForumKorisnikForumUloga(id, forumKorisnikForumUloga);
        return new ResponseEntity<ForumKorisnikForumUloga>(forumKorisnikForumUloga, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<ForumKorisnikForumUloga> removeForumKorisnikForumUloga(@PathVariable Long id) {
        try {
        	forumKorisnikForumUlogaService.removeForumKorisnikForumUloga(id);
        }catch (Exception e) {
            return new ResponseEntity<ForumKorisnikForumUloga>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ForumKorisnikForumUloga>(HttpStatus.NO_CONTENT);
    }

}
