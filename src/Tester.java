import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Tester {
    public Tester(){}
    SingletonDB db = SingletonDB.getInstance();
    LibraryFacade lb = new LibraryFacade();
        

    public void userTest() throws InterruptedException{
        System.out.println("We are going to create 3 diferent type of users: student, teacher and employee!");
        TimeUnit.SECONDS.sleep(6);

        // All types of User
        StudentUserType student = new StudentUserType("Student", "student_email@teste.com", "4002-8922");
        TeacherUserType teacher = new TeacherUserType("Genivaldo", "teacher_email@teste.com", "1240028922");
        EmployeeUserType employee = new EmployeeUserType("Employee", "employee_email@teste.com", "123456789");

        // Simple methods
        System.out.println("Student smartphone number:\t"+student.getCelular());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Teacher name:\t" + teacher.getName());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Employee email:\t" + employee.getEmail());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("That's it, we created 3 different types of users! :)\n");
        TimeUnit.SECONDS.sleep(3);
    }

    public void loanTest() throws InterruptedException{
        System.out.println("We are going to try to loan a book:\n\tTitle: 'loanToEmployee'\n\tAuthor: 'me'\n\tCategory: 'testing'");
        TimeUnit.SECONDS.sleep(7);
        BookCategory categoryTest = new BookCategory("Testing");
        Book teste = new Book("loanToEmployee", "me", categoryTest);
        EmployeeUserType employee = new EmployeeUserType("Employee", "employee_email@teste.com", "123456789");
        lb.registerUser(employee);
        TimeUnit.SECONDS.sleep(1);
        lb.addBook(teste);
        TimeUnit.SECONDS.sleep(2);

        System.out.println("There two test here:\n1- There is no BookCopy, so the book it's unavailable\n2- There is a BookCopy, so the book it's available!");
        TimeUnit.SECONDS.sleep(9);
        // Not gonna work because there is not Book Copy
        System.out.println("Trying to loan a book, but it's not possible since there is no BookCopy");
        TimeUnit.SECONDS.sleep(3);
        lb.LoanBook("loanToEmployee", "123456789");
        TimeUnit.SECONDS.sleep(3);

        // Adding new book copy
        BookCopy testeCopy = new BookCopy("123", "loanToEmployee");
        System.out.println("\nNow, the 2 case where it's a book available!");
        TimeUnit.SECONDS.sleep(5);
        teste.addCopy(testeCopy);
        lb.LoanBook("loanToEmployee", "123456789");
        TimeUnit.SECONDS.sleep(3);

        System.out.println("\nNow we are going to read the notifications that were sent!");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("\nReading notifications!\n");
        employee.readNotifications();
        System.out.println("\n\tThat's it! :)");
        TimeUnit.SECONDS.sleep(3);
    }

    @SuppressWarnings("unchecked")
    public void searchBookTest() throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("We are going to try to search a book:\n\tTitle: 'searchTest'\n\tAuthor: 'me'\n\tCategory: 'testing'");
        TimeUnit.SECONDS.sleep(6);
        BookCategory categoryTest = new BookCategory("Testing");
        Book teste = new Book("searchTest", "me", categoryTest);
        EmployeeUserType employee = new EmployeeUserType("Employee", "employee_email@teste.com", "123456789");
        lb.registerUser(employee);
        TimeUnit.SECONDS.sleep(2);
        lb.addBook(teste);
        TimeUnit.SECONDS.sleep(2);

        System.out.println("Searching a book by it's wrong name");
        TimeUnit.SECONDS.sleep(4);
        Book search = (Book) lb.searchBook("sea2rchTest", null, null);
        if (search != null){System.out.println(search.getTitle());}
        TimeUnit.SECONDS.sleep(4);

        System.out.println("Searching a book by it's right name");
        TimeUnit.SECONDS.sleep(3);
        search = (Book) lb.searchBook("searchTest", null, null);
        System.out.println("Book title:\t" + search.getTitle());
        TimeUnit.SECONDS.sleep(4);

        System.out.println("Doing a search by it's author");
        TimeUnit.SECONDS.sleep(2);
        ArrayList<Book> searchArray = (ArrayList<Book>) lb.searchBook(null, "me", null);
        TimeUnit.SECONDS.sleep(4);
        String authorTest = searchArray.get(0).getAuthor();
        System.out.println("Author: " + authorTest);
        TimeUnit.SECONDS.sleep(4);

        System.out.println("Doing a search by it's category");
        TimeUnit.SECONDS.sleep(4);
        searchArray = (ArrayList<Book>) lb.searchBook(null, null, "Testing");
        String categoryStringTest = searchArray.get(0).getCategory().getCategory();
        System.out.println("Category: " + categoryStringTest);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("That's it! :) ");
        TimeUnit.SECONDS.sleep(3);
    }

    public void searchUserTest() throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("We are going to search by a user:\n\tUsername: 'SearchEmployee'\n\temail: 'employee_email@teste.com'\n\tcelular: '123456789'");
        TimeUnit.SECONDS.sleep(7);
        BookCategory categoryTest = new BookCategory("Testing");
        Book teste = new Book("searchTest", "me", categoryTest);
        EmployeeUserType employee = new EmployeeUserType("SearchEmployee", "employee_email@teste.com", "123456789");
        lb.registerUser(employee);
        TimeUnit.SECONDS.sleep(2);
        lb.addBook(teste);
        TimeUnit.SECONDS.sleep(2);

        System.out.println("Searching by user 'SearchEmployee' wrong nCelular");
        TimeUnit.SECONDS.sleep(4);
        User user = lb.searchUser("12345678");
        if(user != null){System.out.println(user.getCelular());}
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Searching by user 'SearchEmployee' right nCelular");
        TimeUnit.SECONDS.sleep(4);
        user = lb.searchUser("123456789");
        TimeUnit.SECONDS.sleep(1);
        if(user != null){System.out.println(user.getCelular());}
        TimeUnit.SECONDS.sleep(4);
        System.out.println("That's it! :)");
        TimeUnit.SECONDS.sleep(2);
    }

    public void categoryTest() throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("We are going to create a new category and add a new book!");
        TimeUnit.SECONDS.sleep(4);
        BookCategory categoryTest = new BookCategory("Testing");
        Book teste = new Book("CategoryTest", "me", categoryTest);
        TimeUnit.SECONDS.sleep(2);
        lb.addBook(teste);
        TimeUnit.SECONDS.sleep(2);
        categoryTest.addBook(teste);
        TimeUnit.SECONDS.sleep(2);
        lb.addCategory(categoryTest);
        TimeUnit.SECONDS.sleep(2);

        System.out.println("Getting a list of books that it's in the category 'Testing'");
        TimeUnit.SECONDS.sleep(3);
        ArrayList<Book> listBook = categoryTest.getBooks();
        Book bookTest = listBook.get(0);
        TimeUnit.SECONDS.sleep(2);

        System.out.println("List book size: " + listBook.size());
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Book finded: " + bookTest.getTitle());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("That's it! :)");
    }


    public static void main(String[] args) {
    }
}
