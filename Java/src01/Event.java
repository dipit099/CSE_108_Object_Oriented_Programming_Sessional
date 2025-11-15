/* This class stores the following information about an event: name, starting date, location and list of students registered for the event. */

import java.sql.Date;

public class Event {
    private String eventName;
    private String eventDate; // store in the format YYYY-MM-DD
    private String eventLocation;
    private Student[] registeredStudents;
    int participantsAdded = 0; // variable to keep track of number of participants so far added

    // Task: Write code for the constructor below to initialize the member variables
    // properly
    public Event()
    {
         this.eventName = "a";
         this.eventDate = "a";
         this.eventLocation = "a";
         registeredStudents = new Student[100];

    }
    public Event(String eventName, String eventDate, String eventLocation, int maximumParticipants) {
        // write your code here
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        registeredStudents = new Student[maximumParticipants];
    }

    // Task: Write getters and setters for Event attributes as required
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public int getParticipantsAdded() {
        return participantsAdded;
    }

    // Task: Write your code for the function below. This functions adds a
    // participant to this event. Check for the following cases: (i) total
    // participant count does not exceed the maximum participant count, (ii) the
    // studentId is not already added.
    public void addParticipant(Student student) {
        // write your code here
        if (participantsAdded < registeredStudents.length) {
            String own_id = student.getId();
            for (int i = 0; i < participantsAdded; i++) {
                if (own_id.equals(registeredStudents[i].getId())) {
                    System.out.println("\nStudent Id has been added already.\n");
                    return;
                }
            }
            registeredStudents[participantsAdded] = student;
            System.out.println("\nStudent registration completed.\n");
            participantsAdded++;
        } else {
            System.out.println("\nMaximum participants reached.\n");
        }
    }

    // Task: Write code for the function below. This function shows the details of
    // an event. Make sure your output matches with the supplied sample output.
    public void showDetails() {
        // Write your code here
        System.out.println("Name: " + eventName);
        System.out.println("Date: " + eventDate);
        System.out.println("Location: " + eventLocation);
        System.out.println("Registered Participants:");
        for (int i = 0; i < participantsAdded; i++) {
            registeredStudents[i].showDetails();
            // System.out.println();

        }

    }

    // Task: Write code for the function below. This function check whether the
    // studentId in the argument has registered for this event or not. Return true
    // if registered, otherwise return false.
    public boolean isRegistered(String studentId) {
        // Write your code here
        for (int i = 0; i < participantsAdded; i++) {
            if (studentId.equals(registeredStudents[i].getId())) {
                // System.out.println("\nStudentId " + studentId + " Already registered\n");
                return true;
            }
        }
        return false;
    }

    // Task: Write code for the function below. This function removes a participant
    // from this event. Check for the following cases: (i) the student Id is not
    // regiseterd.
    public void removeParticipant(String studentId) {
        // Write your code here
        for (int i = 0; i < participantsAdded; i++) {
            if (studentId.equals(registeredStudents[i].getId())) {
                for (int j = i + 1; j < participantsAdded; j++) {
                    registeredStudents[j - 1] = registeredStudents[j];
                }
                System.out.println("\nSuccessfully removed id " + studentId + " from event Game Jam.");
                participantsAdded--;
                return;
            }
        }
        System.out.println("\nStudent Id not Found to Remove.");

    }

}