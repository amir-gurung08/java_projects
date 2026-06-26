import java.util.Scanner;

public class StudentManagementSystem {
    static class students {
        String name;
        int roll;
        float marks;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        students[] student = new students[100];
        int size = 0;
        while (true) {
            System.out.println("<<---Menu--->>");
            System.out.println("1. Add Student");
            System.out.println("2. View all Students");
            System.out.println("3. Search Students");
            System.out.println("0. Exit");
            System.out.print("Option: ");

            int choice = scan.nextInt();scan.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Thanks for trying tool");
                    scan.close();
                    return;
                case 1:
                    student[size] = new students();
                    System.out.println("Enter Student Details: ");
                    System.out.print("Name: ");
                    student[size].name = scan.nextLine();
                    System.out.print("Roll Number: ");
                    student[size].roll = scan.nextInt(); scan.nextLine();
                    System.out.print("Marks: ");
                    student[size].marks = scan.nextFloat(); scan.nextLine();
                    size++;
                    
                    break;
                case 2:
                    for(int i = 0; i< size; i++){
                    System.out.println("<---Students Details--->");
                    System.out.println("Name: "+ student[i].name);
                    System.out.println("Roll Number: "+ student[i].roll);
                    System.out.println("Marks: "+ student[i].marks);
                    System.out.println("--------------------------------------------");
                }
                System.out.println("Press any key to Continue....");
                scan.nextLine();
                break;
                case 3:
                    System.out.println("<---Search Student Details--->");
                    System.out.print("Enter the id of student: ");
                    System.out.println("--------------------------------------------");
                    int id = scan.nextInt();scan.nextLine();
                    System.out.println("Name: "+ student[id].name);
                    System.out.println("Roll Number: "+ student[id].roll);
                    System.out.println("Marks: "+ student[id].marks);
                    System.out.println("--------------------------------------------");
                    break;
                default:
                    System.out.println("Enter Valid Option Please....");
                    break;
            }
        }
    }
}
