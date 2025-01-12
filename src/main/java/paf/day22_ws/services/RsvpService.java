package paf.day22_ws.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import paf.day22_ws.models.Rsvp;
import paf.day22_ws.repositories.RsvpRepository;

@Service
public class RsvpService {
    
    @Autowired
    private RsvpRepository rsvpRepo;

    public List<Rsvp> getRsvps() {
        return rsvpRepo.getRsvps();
    }

    public List<Rsvp> getRsvpByName(String name) {
        return rsvpRepo.getRsvps();
    }

    public boolean insertNewRsvp(Rsvp rsvp) {
        return rsvpRepo.insertNewRsvp(rsvp);
    }

    public boolean updateRsvp(String email, Rsvp rsvp) {
        return rsvpRepo.updateRsvp(email, rsvp);
    }

    public int getCountPeopleWRsvp() {
        return rsvpRepo.getCountPeopleWRsvp();
    }
}
