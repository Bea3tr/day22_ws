package paf.day22_ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import paf.day22_ws.models.Rsvp;
import paf.day22_ws.services.RsvpService;

@Controller
@RequestMapping("/rsvp")
public class RsvpController {

    @Autowired
    private RsvpService rsvpSvc;

    @GetMapping("/insert")
    public String getInsert(Model model) {
        model.addAttribute("rsvp", new Rsvp());
        return "insert";
    }
    
}
