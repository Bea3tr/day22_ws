package paf.day22_ws.models;

import java.sql.Date;

public class Rsvp {

    private int id;
    private String fullname;
    private String email;
    private String phone;
    private Date confirmation_date;
    private String comments;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    
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
    public Rsvp(int id, String fullname, String email, String phone, Date confirmation_date, String comments) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.confirmation_date = confirmation_date;
        this.comments = comments;
    }
    
}
