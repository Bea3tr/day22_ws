package paf.day22_ws.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import paf.day22_ws.models.Rsvp;
import paf.day22_ws.models.exceptions.ResourceNotFoundException;
import paf.day22_ws.utils.Sql;

@Repository
public class RsvpRepository {
    
    @Autowired
    private JdbcTemplate template;

    public List<Rsvp> getRsvps() {
        List<Rsvp> rsvps = new LinkedList<>();
        rsvps = template.query(Sql.getAllRsvps, BeanPropertyRowMapper.newInstance(Rsvp.class));
        if(rsvps.isEmpty())
            throw new ResourceNotFoundException("No record in Rsvp table");
        return rsvps;
    }

    public List<Rsvp> getRsvpByName(String name) {
        List<Rsvp> rsvps = new LinkedList<>();
        rsvps = template.query(Sql.getRsvpByName, BeanPropertyRowMapper.newInstance(Rsvp.class), name);
        if(rsvps.isEmpty())
            throw new ResourceNotFoundException("No record in Rsvp table registered under " + name);
        return rsvps;
    }

    public boolean insertNewRsvp(Rsvp rsvp) {
        int rsvpCreated = 0;
        try {
            template.queryForObject(Sql.getRsvp, BeanPropertyRowMapper.newInstance(Rsvp.class),
                rsvp.getFullname(), rsvp.getEmail(), rsvp.getPhone(), rsvp.getConfirmation_date(), rsvp.getComments());
            rsvpCreated = 1;
            
        } catch (DataAccessException ex) {
             rsvpCreated = template.update(Sql.insertNewRsvp, rsvp.getFullname(), rsvp.getEmail(), 
                rsvp.getPhone(), rsvp.getConfirmation_date(), rsvp.getComments());
        }
        if(rsvpCreated > 0) {
            return true;
        }
        return false;
    }

    public boolean updateRsvp(String email, Rsvp rsvp) {
        int rsvpUpdated = template.update(Sql.updateRsvpByEmail, rsvp.getFullname(), rsvp.getEmail(), 
        rsvp.getPhone(), rsvp.getConfirmation_date(), rsvp.getComments(), email);
        if(rsvpUpdated <= 0) {
            throw new ResourceNotFoundException("No RSVP registered under email " + email);
        }
        return true;
    }

    public int getCountPeopleWRsvp() {
        int count = template.queryForRowSet(Sql.getPeopleWRsvp).getInt("count");
        return count;
    }
}
