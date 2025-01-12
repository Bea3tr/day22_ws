package paf.day22_ws.models;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Rsvp {

    private String fullname;
    private String email;
    private String phone;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date confirmation_date;
    private String comments;
    
    public String getFullname() {return fullname;}
    public void setFullname(String fullname) {this.fullname = fullname;}
    
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    
    public Date getConfirmation_date() {return confirmation_date;}
    public void setConfirmation_date(Date confirmation_date) {this.confirmation_date = confirmation_date;}
    
    public String getComments() {return comments;}
    public void setComments(String comments) {this.comments = comments;}
    
    public Rsvp() {}
    public Rsvp(String fullname, String email, String phone, Date confirmation_date, String comments) {
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.confirmation_date = confirmation_date;
        this.comments = comments;
    }
    
}
