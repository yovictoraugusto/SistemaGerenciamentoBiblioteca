import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Library {
    SingletonDB DB = SingletonDB.getInstance();

    public BookCopy LoanBook(Optional<String> Title)
    {
        Book book = (Book) DB.searchBook(Title, null, null);
        List<BookCopy> books = book.getCopies();

        Stream <BookCopy> streamBook = books.stream();
        BookCopy availableBook = (BookCopy) streamBook.filter(bookcopy -> bookcopy.isAvailable() == true);

        if(availableBook != null){
                availableBook.setReturnDate();
                System.out.println("Loan Approved!\n Return Date:" + availableBook.getReturnDate());
                return availableBook;
        }
        System.out.println("Loan not Approved! :(");
        return null;
       
    }

    

    public void returnBook(BookCopy bk){
        if (bk != null){
        bk.setAvailable();
        System.out.println("Book Returned");
        }
        else{System.out.println("Book invalid");}

    }
}
