package LibraryManagementSystem;

// import java.math.BigInteger;
import java.util.Scanner;

class Book{
    String title;
    String author;
    int bookId;
    boolean isIssued;
    String issuedToName;
    String issuedDate;
    String returnDate;
    boolean newIsIssued;

    void display(){

        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Book ID: "+bookId);
        if (isIssued==true) {
            System.out.println("Status: Issued");
            System.out.println("Issued to: "+issuedToName);
            System.out.println("Issued on: "+issuedDate);
            System.out.println("-------------------");
        }
        else if(isIssued==false){
            // System.out.println("-------------------");
            System.out.println("Status: Available");
            System.out.println("-------------------");
        }
        else{
            System.out.print("Invalid input");
        }
    }

    void availableDisplay(){
        if (isIssued == false) {
            System.out.println("Title: "+title);
            System.out.println("Author: "+author);
            System.out.println("Book ID: "+bookId);
            System.out.println("Status: Available");
            System.out.println("-------------------");
        }
    }
    void issuedDisplay(){
        if (isIssued == true) {
            System.out.println("Title: "+title);
            System.out.println("Author: "+author);
            System.out.println("Book ID: "+bookId);
            System.out.println("Status: Issued");
            System.out.println("Issued to: "+issuedToName);
            System.out.println("Issued on: "+issuedDate);
            System.out.println("-------------------");
        }
    }
    
    // void remove(){
    //     title = "";
    //     author = "";
    //     bookId = ;
    // }
}


public class LibraryManagementSystem {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Book[] books = new Book[100];
        int size = 0;
        int BookId = 0;
        int avail;
        int issue;

        while (true) {
            System.out.println("<=====Menu=====>");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Edit Book Details");
            System.out.println("8. Display Library Statistics");
            System.out.println("0. Exit");
            System.out.print("Option: ");
            int choice = scan.nextInt();


            switch (choice) {
                case 0:
                    System.out.print("You Want to exit(Yes/No)?: ");
                    String exit = scan.next(); scan.nextLine();
                    if (exit.equals("Yes") || exit.equals("yes")) {
                        System.out.println("----------------------------");
                        System.out.println("Thank You For Using this Tool.");
                        System.out.println("----------------------------");
                        scan.close();
                        return;
                    }
                    else if(exit.equals("No") || exit.equals("no")){
                        break;
                    }
                    break;
                case 1:
                    System.out.println("<===Enter Book Details===>");
                    System.out.print("Title: ");
                    String newTitle1 = scan.next(); scan.nextLine();
                    System.out.print("Author: ");
                    String newAuthor1 = scan.next(); scan.nextLine();
                    System.out.print("Book ID: ");
                    int newbookId1 = scan.nextInt(); scan.nextLine();
                    boolean duplicate1 = false;
                    for(int i = 0; i< size;i++){
                        if (newbookId1 == books[i].bookId){
                            duplicate1 = true;
                            System.out.println("ID already exists");
                            break;
                        }
                    }
                    if (!duplicate1) {
                        books[size] = new Book();
                        books[size].title = newTitle1;
                        books[size].author = newAuthor1;
                        books[size].bookId = newbookId1;
                        size++;
                    }
                    break;

                    case 2:
                        for(int i = 0; i< size; i++){
                            books[i].display();
                            // System.out.println("Press enter to continue......");
                            // scan.nextLine();
                        }
                        break;

                    case 3:
                        System.out.println("<===Issuing Book===>");
                        System.out.print("Enter Book ID: ");
                        BookId = scan.nextInt(); scan.nextLine();
                        for(int i = 0; i < size; i++){
                            if (BookId == books[i].bookId) {
                                if(books[i].isIssued==false){
                                    System.out.println("-------------------");
                                    System.out.println("Book Is Available :)");
                                    System.out.println("-------------------");
                                    System.out.println("<==Assign To==>");
                                    System.out.print("Name: ");
                                    books[i].issuedToName = scan.next(); scan.nextLine();
                                    System.out.print("Date (YYYY-MM-DD): ");
                                    books[i].issuedDate = scan.next();
                                    books[i].isIssued = true;
                                    System.out.println("Issued Successfully XD");
                                    break;
                                }
                                else if(books[i].isIssued==true){
                                    System.out.println("-------------------");
                                    System.out.println("Book Is Not Available :(");
                                    System.out.println("Issued to: "+books[i].issuedToName);
                                    System.out.println("Issued on: "+books[i].issuedDate);
                                    System.out.println("-------------------");
                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        System.out.println("<===Book Return===>");
                        System.out.print("Enter Book ID: ");
                        BookId = scan.nextInt(); scan.nextLine();
                        for(int i = 0; i < size; i++){
                            if (BookId == books[i].bookId){
                                System.out.print("Return Date: ");
                                books[i].returnDate = scan.next();
                                System.out.println("Returned Successfully");
                                books[i].isIssued = false;
                                break;
                            }
                        }
                        break;
                    case 5:
                        System.out.println("<===Search Book===>");
                        System.out.println("1. Search Book by Id");
                        System.out.println("2. Search Book by Title");
                        System.out.println("3. Search Book by Author");
                        System.out.println("Option: ");
                        int search = scan.nextInt(); scan.nextLine();
                        switch (search) {
                            case 1:
                                System.out.print("Enter Book ID: ");
                                BookId = scan.nextInt(); scan.nextLine();
                                boolean idfound = false;
                                for(int i = 0; i < size; i++){
                                    if (BookId == books[i].bookId){
                                        idfound = true;
                                        System.out.println("-------------------");
                                        System.out.println("<===Book Found===>");
                                        System.out.println("-------------------");
                                        books[i].display();
                                        System.out.println("Press enter to continue......");
                                        scan.nextLine();
                                        break;
                                    }
                                }
                                if (!idfound) {
                                    System.out.println("-------------------");
                                    System.out.println("<===Enter Book Valid Id===>");
                                    System.out.println("-------------------");
                                }
                                break;

                            case 2:
                                System.out.print("Enter Book Title: ");
                                String bookTitle = scan.next(); scan.nextLine();
                                boolean titlefound = false;
                                for(int i = 0; i < size; i++){
                                    if (books[i].title.equals(bookTitle)){
                                        titlefound = true;
                                        System.out.println("-------------------");
                                        System.out.println("<===Book Found===>");
                                        System.out.println("-------------------");
                                        books[i].display();
                                        System.out.println("Press enter to continue......");
                                        scan.nextLine();
                                        break;
                                    }
                                }
                                if (!titlefound) {
                                    System.out.println("-------------------");
                                    System.out.println("<===Enter Book Valid Title===>");
                                    System.out.println("-------------------");
                                }
                            break;

                            case 3:
                                System.out.print("Enter Book Author: ");
                                String bookauthor = scan.next(); scan.nextLine();
                                boolean authorfound = false;
                                for(int i = 0; i < size; i++){
                                    if (books[i].author.equals(bookauthor)){
                                        authorfound = true;
                                        System.out.println("-------------------");
                                        System.out.println("<===Book Found===>");
                                        System.out.println("-------------------");
                                        books[i].display();
                                        System.out.println("Press enter to continue......");
                                        scan.nextLine();
                                    }
                                }
                                if (!authorfound) {
                                    System.out.println("-------------------");
                                    System.out.println("<===Enter Book Valid Author===>");
                                    System.out.println("-------------------");
                                }

                            break;
                            default:
                                System.out.println("-----------------------------");
                                System.out.println("Please Choose Valid Option");
                                System.out.println("-----------------------------");
                                break;
                        }
                        break;

                    case 6:
                        System.out.println("<===Delete Book===>");
                        System.out.println("Enter Book ID: ");
                        BookId = scan.nextInt(); scan.nextLine();
                        for(int i = 0; i < size; i++){
                            if (BookId == books[i].bookId) {
                                for(int j = i; j < size -1; j++){
                                    books[j] = books[j+1];
                                }
                                size--;
                                books[size] = null;
                                System.out.println("Book Removed Successfully");
                                break;
                            }
                        }
                        break;

                    case 7:
                        System.out.print("Enter Book ID: ");
                        BookId = scan.nextInt(); scan.nextLine();
                        for(int i = 0; i < size; i++){
                            if (BookId == books[i].bookId) {
                                boolean editing = true;
                                while (editing) {
                                System.out.println("Book Found");
                                System.out.println("<=====Edit Book Details=====>");
                                System.out.println("1. Edit Title");
                                System.out.println("2. Edit Author");
                                System.out.println("3. Edit Book ID");
                                System.out.println("4. Edit Status");
                                System.out.println("0. Cancel");
                                int edit = scan.nextInt(); scan.nextLine();
                                    
                                    switch (edit) {
                                        case 0:
                                            System.out.println("Back to menu");
                                            editing = false;
                                            break;
                                        case 1:
                                            System.out.println("<===Edit Title===>");
                                            System.out.println("New Title: ");
                                            String newTitle = scan.next(); scan.nextLine();
                                            books[i].title = newTitle;
                                            System.out.println("Title Changed Successfull");
                                            break;
                                        case 2:
                                            System.out.println("<===Edit Author===>");
                                            System.out.println("New Author: ");
                                            String newAuthor = scan.next(); scan.nextLine();
                                            books[i].author = newAuthor;
                                            System.out.println("Author Changed Successfull");
                                            break;
                                        case 3:
                                            System.out.println("<===Edit Book ID===>");
                                            System.out.println("New Book ID: ");
                                            int newBookId = scan.nextInt(); scan.nextLine();
                                            boolean duplicate = false;
                                            for(int j = 0; j< size;j++){
                                            if (books[j].bookId == newBookId){
                                                duplicate = true;
                                                System.out.println("The Book ID is already exists");
                                                break;
                                            }
                                        }
                                            if (!duplicate) {
                                                books[i].bookId = newBookId;
                                                System.out.println("Book ID Changed Successfull");
                                            }
                                            break;
                                        case 4:
                                            System.out.println("<===Edit Status===>");
                                            System.out.println("Available/Issued");
                                            System.out.println("Status(A/I): ");
                                            String newIsIssued = scan.next(); scan.nextLine();
                                            if (newIsIssued.equals("A")||newIsIssued.equals("a")) {
                                                boolean newIsIssued2 = false;
                                                if(books[i].isIssued!=newIsIssued2){
                                                    books[i].isIssued = newIsIssued2;
                                                System.out.println("Status Changed Successfull");
                                                // break;
                                                }
                                                else{
                                                    System.out.println("It is Already: "+newIsIssued);
                                                }
                                            }
                                            else if(newIsIssued.equals("I") || newIsIssued.equals("i")){
                                                boolean newIsIssued2 = true;
                                                if(books[i].isIssued!=newIsIssued2){
                                                    books[i].isIssued = newIsIssued2;
                                                System.out.println("Status Changed Successfull");
                                                // break;
                                                }
                                                else{
                                                    System.out.println("It is Already: "+newIsIssued);
                                                }
                                            }
                                            break;

                                            default:
                                                System.out.println("-----------------------------");
                                                System.out.println("Please Choose Valid Option");
                                                System.out.println("-----------------------------");
                                                break;
                                        }
                                        // break;
                                    }
                                    break;
                                }
                        }
                        break;
                    case 8:
                        avail = 0;
                        issue = 0;
                        for(int i = 0; i < size; i++){
                            if (books[i].isIssued==false) {
                                avail++;
                            }
                            else{
                                issue++;
                            }
                        }
                        System.out.println("<<===View Menu===>>");
                        System.out.println("1. Total Books: "+size);
                        System.out.println("2. Available Books  "+avail);
                        System.out.println("3. Issued Books  "+issue);
                        System.out.print("Option: ");
                        int viewOption = scan.nextInt(); scan.nextLine();
                        switch (viewOption) {
                            case 1:
                                for(int i = 0; i <size; i++){
                                    books[i].display();
                                }
                                break;
                            case 2:
                                for(int i = 0; i <size; i++){
                                    books[i].availableDisplay();
                                }
                                break;
                            case 3:
                                for(int i = 0; i <size; i++){
                                    books[i].issuedDisplay();
                                }
                                break;
                        
                            default:
                                System.out.println("-----------------------------");
                                System.out.println("Please Choose Valid Option");
                                System.out.println("-----------------------------");
                                break;
                        }
                    break;

                default:
                    System.out.println("-----------------------------");
                    System.out.println("Please Choose Valid Option");
                    System.out.println("-----------------------------");
                    break;
            }
        }
    }
}