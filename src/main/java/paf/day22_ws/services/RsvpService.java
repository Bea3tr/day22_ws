package paf.day22_ws.services;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

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
        return rsvpRepo.getRsvpByName(name);
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

    public Rsvp formToRsvp(MultiValueMap<String, String> form) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date sql_cd = null;
        try {
            java.util.Date cd = df.parse(form.getFirst("confirmation_date"));
            sql_cd = new Date(cd.getTime());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return new Rsvp(form.getFirst("fullname"), form.getFirst("email"), form.getFirst("phone"),
            sql_cd, form.getFirst("comments"));
    }
}
