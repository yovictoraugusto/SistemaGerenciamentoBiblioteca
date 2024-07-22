import java.util.ArrayList;

public class Tester {
    public Tester(){}
    SingletonDB db = SingletonDB.getInstance();
    LibraryFacade lb = new LibraryFacade();
        

    public void userTest(){
        // All types of User
        StudentUserType student = new StudentUserType("Student", "student_email@teste.com", "student_number");
        TeacherUserType teacher = new TeacherUserType("Genivaldo", "teacher_email@teste.com", "1240028922");
        EmployeeUserType employee = new EmployeeUserType("Employee", "employee_email@teste.com", "123456789");

        // Simple methods
        System.out.println("Student smartphone number:\t" + student.getCelular());
        System.out.println("Teacher name:\t" + teacher.getName());
        System.out.println("Employee email:\t" + employee.getEmail());
    }

    public void loanTest(){
        BookCategory categoryTest = new BookCategory("Testing");
        Book teste = new Book("loanToEmployee", "me", categoryTest);
        EmployeeUserType employee = new EmployeeUserType("Employee", "employee_email@teste.com", "123456789");
        lb.registerUser(employee);
        lb.addBook(teste);

        // Not gonna work because there is not Book Copy
        System.out.println("Trying to loan a book, but it's not possible since there is no BookCopy");
        lb.LoanBook("loanToEmployee", "123456789");

        // Adding new book copy
        BookCopy testeCopy = new BookCopy("123", "loanToEmployee");
        teste.addCopy(testeCopy);
        lb.LoanBook("loanToEmployee", "123456789");

        System.out.println("\nReading notifications!\n");
        employee.readNotifications();
    }

    @SuppressWarnings("unchecked")
    public void searchBookTest(){
        BookCategory categoryTest = new BookCategory("Testing");
        Book teste = new Book("searchTest", "me", categoryTest);
        EmployeeUserType employee = new EmployeeUserType("Employee", "employee_email@teste.com", "123456789");
        lb.registerUser(employee);
        lb.addBook(teste);

        System.out.println("Searching a book by it's wrong name");
        Book search = (Book) lb.searchBook("sea2rchTest", null, null);
        if (search != null){System.out.println(search.getTitle());}

        System.out.println("Searching a book by it's right name");
        search = (Book) lb.searchBook("searchTest", null, null);
        System.out.println("Book title:\t" + search.getTitle());

        ArrayList<Book> searchArray = (ArrayList<Book>) lb.searchBook(null, "me", null);
        System.out.println("Doing a search by it's author");
        String authorTest = searchArray.get(0).getAuthor();
        System.out.println(authorTest);

        System.out.println("Doing a search by it's category");
        searchArray = (ArrayList<Book>) lb.searchBook(null, null, "Testing");
        String categoryStringTest = searchArray.get(0).getCategory().getCategory();
        System.out.println(categoryStringTest);
    }

    public void searchUserTest(){
        BookCategory categoryTest = new BookCategory("Testing");
        Book teste = new Book("searchTest", "me", categoryTest);
        EmployeeUserType employee = new EmployeeUserType("SearchEmployee", "employee_email@teste.com", "123456789");
        lb.registerUser(employee);
        lb.addBook(teste);

        System.out.println("Searching by user 'SearchEmployee' wrong nCelular");
        User user = lb.searchUser("12345678");
        if(user != null){System.out.println(user.getCelular());}
        
        System.out.println("Searching by user 'SearchEmployee' right nCelular");
        user = lb.searchUser("123456789");
        if(user != null){System.out.println(user.getCelular());}
    }

    public void categoryTest(){
        BookCategory categoryTest = new BookCategory("Testing");
        Book teste = new Book("CategoryTest", "me", categoryTest);
        lb.addBook(teste);
        categoryTest.addBook(teste);
        lb.addCategory(categoryTest);

        System.out.println("Getting a list of books that it's in the category 'Testing'");
        ArrayList<Book> listBook = categoryTest.getBooks();
        Book bookTest = listBook.get(0);

        System.out.println("List book size: " + listBook.size());
        System.out.println("Book finded: " + bookTest.getTitle());
    }


    public static void main(String[] args) {
    }
}
