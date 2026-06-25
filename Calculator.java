import java.util.Scanner;
public class Calculator{
    public static int calculate(int num1, int num2, String op){
        if (op.equals("+")) {
            return num1 + num2;
        }
        else if(op.equals("/")){
            try{
                return num1 / num2;
            }catch(Exception e){
                System.out.println(num1+" Cannot be divided by Zero");
            }
        }
        else if(op.equals("-")){
            return num1 - num2;
        }
        else if(op.equals("*")){
            return num1 * num2;
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int result, num1, num2;
        while (true){
        System.out.println("<<----Menu---->>");
        System.out.println("1 . Addition");        
        System.out.println("2 . Division");      
        System.out.println("3 . Subtraction");        
        System.out.println("4 . Multiplication");        
        System.out.println("0 . Exit");        
        System.out.print("Option: ");        
        
        int choice = scan.nextInt(); scan.nextLine();
        switch (choice) {
            case 0:
                System.out.println("Thanks for using my tool");
                scan.close();
                return;
            case 1:
                System.out.print("Enter first number: ");
                num1 = scan.nextInt(); scan.nextLine();
                System.out.print("Enter Second number: ");
                num2 = scan.nextInt(); scan.nextLine();
                result = calculate(num1, num2, "+");
                System.out.println("The Addition of "+num1+" And "+num2+" is "+result);
                break;
        
            case 2:
                System.out.print("Enter first number: ");
                num1 = scan.nextInt(); scan.nextLine();
                System.out.print("Enter Second number: ");
                num2 = scan.nextInt(); scan.nextLine();
                result = calculate(num1, num2, "/");
                System.out.println("The Divison of "+num1+" And "+num2+" is "+result);
                break;
        
            case 3:
                System.out.print("Enter first number: ");
                num1 = scan.nextInt(); scan.nextLine();
                System.out.print("Enter Second number: ");
                num2 = scan.nextInt(); scan.nextLine();
                result = calculate(num1, num2, "-");
                System.out.println("The Subtraction of "+num1+" And "+num2+" is "+result);
                break;
        
            case 4:
                System.out.print("Enter first number: ");
                num1 = scan.nextInt(); scan.nextLine();
                System.out.print("Enter Second number: ");
                num2 = scan.nextInt(); scan.nextLine();
                result = calculate(num1, num2, "*");
                System.out.println("The Multiplication of "+num1+" And "+num2+" is "+result);
                break;
            default:
                System.out.println("Invalid Value");
                break;
        }
  
    }
    }
}