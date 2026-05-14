
import java.util.Scanner;

public class ApprovalQueueMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApprovalQueue queue = new ApprovalQueue(10);
        int choice;

        do {
            System.out.println("\n===  Student Course Registration Forms (KRS) ===");
            System.out.println("1. Enqueue Student");
            System.out.println("2. Process KRS (2 students)");
            System.out.println("3. Display Front");
            System.out.println("4. Display All Data");
            System.out.println("5. Queue Size");
            System.out.println("6. Check Rear of The Queue");
            System.out.println("7. Show Front 2 Students");
            System.out.println("8. Show Processed Count");
            System.out.println("9. Show Remaining Students");
            System.out.println("10. Clear");
            System.out.println("0. Exit");
            System.out.print("Choose a menu: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("NIM : ");
                    String nim = sc.nextLine();
                    System.out.print("Name : ");
                    String name = sc.nextLine();
                    System.out.print("Study Program : ");
                    String studyProgram = sc.nextLine();
                    System.out.print("Class : ");
                    String className = sc.nextLine();
                    Approval app = new Approval(nim, name, studyProgram, className);
                    queue.enqueue(app);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.print();
                    break;
                case 5:
                    System.out.println("Queue size: " + queue.size);
                    break;
                case 6:
                    queue.viewRear();
                    break;
                case 7:
                    queue.viewFrontTwo();
                    break;
                case 8:
                    queue.countProcessed();
                    break;
                case 9:
                    queue.remaining();
                    break;
                case 10:
                    queue.clear();
                    break;
                case 0:
                    System.out.println("Thanks!");
                    break;
                default:
                    System.out.println("Invalid menu!");
            }
        } while (choice != 0);
    }
}
