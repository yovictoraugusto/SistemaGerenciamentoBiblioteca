import java.util.ArrayList;
import java.util.Optional;

public class LibraryMediatorConcrete implements LibraryMediator {
    SingletonDB DB = SingletonDB.getInstance();
    Library LB = new Library();
    BookAvailabilityNotifier notifier = new BookAvailabilityNotifier();

    // Coordena busca
    @Override
    public Object CoordinateSearchBook(Optional<String> title, Optional<String> author, Optional<String> category) {

        if(title.isPresent()){
            Book book = (Book) DB.searchBook(title,Optional.empty(), Optional.empty());
            if (book != null){System.out.println("Book found!"); return book;}
        }

        @SuppressWarnings("unchecked")
        ArrayList<Book> booksSearch = (ArrayList<Book>) DB.searchBook(title, author, category);
        if(booksSearch != null){
            System.out.println("Book found!");
            return booksSearch;
        }
        System.out.println("Book not found!");
        return null;
    }

    // Coordena emprestimos
    @Override
    public BookCopy CoordinateLoan(String title, String nCelular) {
        BookCopy availableBook =  LB.loanBook(title, nCelular);
        if(availableBook != null){
            System.out.println("Loan Approved!\n Return Date:" + availableBook.getReturnDate());
            notifier.setNotification("Is unavailable!\nBook:" + availableBook.getTitle() + "\tCopy: " + availableBook.getCopyID());
        }else{
            System.out.println("Loan not Approved! :/");
        }
        return availableBook;
    }

    // Coordena devoluções
    @Override
    public void CoordinateReturn(BookCopy bk) {
        boolean returnStatus = LB.returnBook(bk);
        if(returnStatus == true){
            System.out.println("Book Returned");
            notifier.setNotification("Is available!\nBook:" + bk.getTitle() + "\tCopy: " + bk.getCopyID());
        }else{
            System.out.println("Book invalid");
        }   
    }

    @Override
    public User CoordinateSearchUser(String nCelular) {
        User user = DB.searchUser(nCelular);
        if(user != null){
            System.out.println("User Finded!");
            return user;
        }
        System.out.println("User not finded!");
        return null;
    }

    @Override
    public void CoordinateAddBook(Book bk) {
        boolean returnDB = DB.addBook(bk);
        if(returnDB == true){notifier.setNotification("New Book!\n" + bk.getTitle());}
    }

    @Override
    public void CoordinateRegisterUser(User user) {
        boolean returnDB =  DB.addUser(user);
        if(returnDB == true){System.out.println("User added successfully");}
        else{System.out.println("User not added");}
    }

    @Override
    public void CoordinateAddCategory(BookCategory bCategory) {
        boolean returnDB = DB.addCategory(bCategory);
        if(returnDB == true){System.out.println("Category added successfully");}
        else{System.out.println("Category not added");}
    }
}
