/* This class stores information of a festival which are name, starting date and list of events that will take place during the festival. */
public class FestivalManager {
    private String name;
    private String startDate;
    private Event[] events;
    int eventsAdded = 0;

    // Task: Write code for the constructor below to initialize the member variables
    // properly
    public FestivalManager(String name, String startDate, int maxEventCount) {
        // write your code here
        this.name = name;
        this.startDate = startDate;
        events = new Event[maxEventCount];

    }

    // Task: Write code for the function below. This function adds an event to this
    // festival. Check for the following case: (i) total event count does not exceed
    // the maximum number of events allowed for this festival
    public void addEvent(Event e) {
        // write your code here
        if (eventsAdded < events.length) {
            events[eventsAdded] = e;
            eventsAdded++;
            System.out.println("\nEvent added successfully!");
        }

    }

    // Task: Write code for the function below. This function registers a student
    // for an event in this festival. Check for the following case: (i) event does
    // not exist
    public void registerStudent(String eventName, Student s) {
        // Write your code here

        for (int i = 0; i < eventsAdded; i++) {
            // System.out.println(eventName + " " + events[i].getEventName());

            if (eventName.equals(events[i].getEventName())) {
                events[i].addParticipant(s);

                return;
            }
        }

        System.out.println("Event does not exist");
    }

    // Task: Write code for the function below. The function shows the details of
    // this festival. Make sure the output matches with the supplied sample output.
    public void showDetails() {
        // Write your code here
        System.out.println("Festival Name: " + name);
        System.out.println("Festival Starting Date: " + startDate);
        System.out.println("Festival Events: ");
        for (int i = 0; i < eventsAdded; i++) {
            events[i].showDetails();

        }

    }
    public void showName() {
        // Write your code here
        // System.out.println("Festival Name: " + name);
        // System.out.println("Festival Starting Date: " + startDate);
        // System.out.println("Festival Events: ");
        for (int i = 0; i < eventsAdded; i++) {
        
        System.out.println(events[i].getEventName());

        }

    }

    // Task: Write code for the function below. This function shows details of the
    // event in the argument. Check for the following case: (i) event does not exist
    public void showEvent(String eventName) {
        // Write your code here
        for (int i = 0; i < eventsAdded; i++) {
            if (eventName.equals(events[i].getEventName())) {
                events[i].showDetails();
                return;
            }
        }
        System.out.println("Event does not exist");

    }
    public void event_on_participant()
    {
        
        
        for(int i=0; i<eventsAdded; i++)
        {
            // System.out.println("entering value "+i);
            for(int j=0; j<eventsAdded; j++)
            {
                if(events[i].getParticipantsAdded() <= events[j].getParticipantsAdded() )
                {

                   // System.out.println("swapping");                   
                    Event event_new = new Event();
                    event_new = events[j];
                    events[j] = events[i];
                    events[i] = event_new;
                    
                }
            }

        }       

    }
    public boolean event_delete(String eventName)
    {

        for (int i = 0; i < eventsAdded; i++) {
            if (eventName.equals(events[i].getEventName())) {
                for(int j=i+1; j<eventsAdded; j++)
                {
                    events[j-1]= events[j];
                }
                eventsAdded--;
                return true;
                
            }
        }
        return false;

        
    }

    // Task: Write code for the function below. This function shows details of the
    // events that will start on the date passed as its argument. Check for the
    // following case: (i) event does not exist
    public void showEventsOnDate(String eventDate) {
        // Write your code here
        System.out.println("Events on " + eventDate + " are:");
        for (int i = 0; i < eventsAdded; i++) {
            if (eventDate.equals(events[i].getEventDate())) {
                System.out.println(events[i].getEventName());
                return;
            }
        }
        System.out.println("Event does not exist");

    }

    // Task: Write code for the function below. This function shows the details of
    // the events with maximum number of participants. If there are multiple events,
    // show all.
    public void eventWithHighestParticipants() {
        // Write your code here
        System.out.println("Event with highest participants:");
        int max_participants = 0;
        for (int i = 0; i < eventsAdded; i++) {
            if (events[i].getParticipantsAdded() > max_participants) {
                max_participants = events[i].getParticipantsAdded();
            }
        }
        for (int i = 0; i < eventsAdded; i++) {
            if (events[i].getParticipantsAdded() == max_participants) {
                events[i].showDetails();
            }
        }
    }

    // Task: Write code for the function below. This function takes a student Id as
    // input and then lists all the events this particular student has registered
    // for. Make sure your output matches the supplied sample output.
    public void showEventsForStudent(String studentId) {
        // Write your code here
        System.out.println("Student " + studentId + " is registered in :");
        for (int i = 0; i < eventsAdded; i++) {
            if (events[i].isRegistered(studentId))
                System.out.println(events[i].getEventName());
        }
    }

    // Task: Write code for the function below. This functions takes an event's name
    // and a student's ID and then removes the student from the registered student
    // list of the event. Check for the following cases: (i) event does not exist,
    // (ii) student is not registered for the event
    public void cancelRegistration(String eventName, String studentId) {
        // Write your code here
        for (int i = 0; i < eventsAdded; i++) {
            if (eventName.equals(events[i].getEventName())) {
                events[i].removeParticipant(studentId);
                return;
            }
        }

    }
    
}
