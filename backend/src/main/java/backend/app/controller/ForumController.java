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

import backend.app.model.Forum;
import backend.app.service.ForumService;
import backend.app.utils.ViewUtils.HideOptionalProperties;



@CrossOrigin(origins={"http://localhost:4200"})
@RestController
@RequestMapping("/forum")
public class ForumController {

    @Autowired
    ForumService forumService;

    @JsonView(HideOptionalProperties.class)
    @RequestMapping()
    public ResponseEntity<Iterable<Forum>> getForum() {
        return new ResponseEntity<Iterable<Forum>>(forumService.getForum(), HttpStatus.OK);
    }

    @JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Forum> getForumById(@PathVariable Long id) {
        Optional<Forum> forum = forumService.getForumById(id);
        if(forum.isPresent()) {
            return new ResponseEntity<Forum>(forum.get(), HttpStatus.OK);
        }
        return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="", method=RequestMethod.POST)
    public ResponseEntity<Forum> addForum(@RequestBody Forum forum) {
        forumService.addForum(forum);
        return new ResponseEntity<Forum>(forum, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Forum> updateForum(@PathVariable Long id, @RequestBody Forum forum) {
        forumService.updateForum(id, forum);
        return new ResponseEntity<Forum>(forum, HttpStatus.CREATED);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Forum> removeForum(@PathVariable Long id) {
        try {
            forumService.removeForum(id);
        }catch (Exception e) {
            return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Forum>(HttpStatus.NO_CONTENT);
    }

}
