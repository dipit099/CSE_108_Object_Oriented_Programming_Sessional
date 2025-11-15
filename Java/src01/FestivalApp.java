
// cd C:\Users\UseR\Desktop\src01
// javac FestivalApp.java
// java FestivalApp "CSE Fest 2023" "2023-07-20" 10 < input.txt
// type input.txt | java FestivalApp "CSE Fest 2023" "2023-07-20" 10
import java.util.Scanner;

/* This is the driver class for this project. You need to run this class with three command line arguments corresponding to the name, starting date and maxinum number of allowed events of a festival. For exmaple run the below command from the termincal:
java FestivalApp "CSE Fest 2023" "2023-07-15" 10*/
public class FestivalApp {

    public static void main(String[] args) {
        
        //FestivalManager festivalManager = new FestivalManager(args[0], args[1], Integer.parseInt(args[2]));
         FestivalManager festivalManager = new FestivalManager("CSE Fest 2023", "2023-07-20", 10);

        int choice;
        Scanner scanner = new Scanner(System.in);

        do {
            // the following lines of code show a menu to take user's choice
            System.out.println("Menu:");
            System.out.println("1. Add an event");
            System.out.println("2. Register student in an event");
            System.out.println("3. View festival details");
            System.out.println("4. View specific event");
            System.out.println("5. View Event on Date");
            System.out.println("6. View event with maximum participants");
            System.out.println("7. View events for students");
            System.out.println("8. Cancel registration");
            System.out.println("9. Exit");
            System.out.print("Enter option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            // System.out.println(choice);

            switch (choice) {

                case 1:

                    // Write your code here
                    System.out.print("Enter event name: ");
                    String event_name = scanner.nextLine();
                    System.out.print("Enter event date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    System.out.print("Enter event location: ");
                    String location = scanner.nextLine();
                    System.out.print("Enter maximum participants: ");
                    int participant = scanner.nextInt();
                    Event event = new Event(event_name, date, location, participant);
                    festivalManager.addEvent(event);
                    // System.out.println(event_name +" "+ date +" "+ location +" "+ participant);
                    // System.out.println(event.getEventName());
                    break;

                case 2:// Register a student in an event
                    /*
                     * Task: read the name and id of a student and an event name. Then register the
                     * student in the event by calling the function:
                     * festivalManager.registerStudent(...)
                     */

                    // Write your code here
                    System.out.print("Enter student name: ");
                    String student_name = scanner.nextLine();

                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter event name: ");
                    event_name = scanner.nextLine();
                    Student s = new Student(student_name, id);
                    // System.out.println(student_name +" "+ id +" "+ event_name);
                    festivalManager.registerStudent(event_name, s);

                    break;

                case 3: // View festival details

                    festivalManager.showDetails();

                    break;

                case 4: 

                    // Write your code here
                    System.out.print("Enter event name: ");
                    event_name = scanner.nextLine();
                    festivalManager.showEvent(event_name);

                    break;
                case 5:
                    System.out.print("Enter event date (YYYY-MM-DD): ");
                    String event_date = scanner.nextLine();
                    festivalManager.showEventsOnDate(event_date);
                    break;

                case 6: // View event with maximum participants
                    festivalManager.eventWithHighestParticipants();
                    break;

                case 7: 

                    // Write your code here
                    System.out.print("Enter student ID: ");
                    id = scanner.nextLine();
                    festivalManager.showEventsForStudent(id);
                    break;

                case 8: 

                    // Write your code here
                    System.out.print("Enter student ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter event name: ");
                    event_name = scanner.nextLine();
                    festivalManager.cancelRegistration(event_name, id);
                    break;

                case 9:
                    System.out.println("Exiting the program.");
                    break;
                case 20:
                    event_name = scanner.nextLine();
                    if (festivalManager.event_delete(event_name) == true)
                    System.out.println("Event "+ event_name + " deleted successfully");
                    else
                    System.out.println("No event named "  + event_name+ " exists. Delete unsuccessful");                  

                    break;
                case 30:
                    System.out.println("The events in order:");
                    festivalManager.event_on_participant();
                    festivalManager.showName();
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        } while (choice != 9);

        scanner.close();
    }
}
