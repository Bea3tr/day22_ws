package paf.day22_ws.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import paf.day22_ws.models.Rsvp;
import paf.day22_ws.services.RsvpService;

@RestController
@RequestMapping("/api")
public class RsvpRestController {
    
    @Autowired
    private RsvpService rsvpSvc;

    @GetMapping(path="/rsvps", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rsvp>> getRsvps() {
        List<Rsvp> rsvps = rsvpSvc.getRsvps();
        return ResponseEntity.ok().body(rsvps);
    }

    @GetMapping(path="/rsvp", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rsvp>> getRsvpsByName(@RequestParam String name) {
        List<Rsvp> rsvps = rsvpSvc.getRsvpByName(name);
        return ResponseEntity.ok().body(rsvps);
    }

    @PostMapping(path="/rsvp", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> insertRsvp(@RequestBody MultiValueMap<String, String> form) {
        boolean inserted = rsvpSvc.insertNewRsvp(rsvpSvc.formToRsvp(form));
        return ResponseEntity.status(201).body(inserted);
    }

    @PutMapping(path="/rsvp/{email}", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> updateRsvp(@PathVariable String email, @ModelAttribute Rsvp rsvp) {
        boolean updated = rsvpSvc.updateRsvp(email, rsvp);
        return ResponseEntity.status(201).body(updated);
    }    
    
    @GetMapping(path="/rsvps/count", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getCount() {
        int count = rsvpSvc.getCountPeopleWRsvp();
        return ResponseEntity.status(201).body(count);
    }
}
