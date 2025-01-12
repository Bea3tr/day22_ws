package paf.day22_ws.utils;

public class Sql {

    public static final String getAllRsvps = "SELECT * FROM rsvp";
    public static final String getRsvpByName = "SELECT * FROM rsvp WHERE fullname = ?";
    public static final String insertNewRsvp = """
                                                INSERT INTO rsvp (fullname, email, phone, confirmation_date, comments)
                                                VALUES (?, ?, ?, ?, ?)
                                                """;
    public static final String updateRsvp = """
                                                UPDATE rsvp SET 
                                                    fullname = ?,
                                                    email = ?,
                                                    phone = ?,
                                                    confirmation_date = ?,
                                                    comments = ?
                                                    WHERE email = ?
                                                """;
    public static final String getPeopleWRsvp = "SELECT COUNT(DISTINCT fullname) from rsvp";
    
}
