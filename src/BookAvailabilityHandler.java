import java.util.List;
import java.util.stream.Stream;

public class BookAvailabilityHandler {
    public BookAvailabilityHandler(){}

    public BookCopy verifyBook(Book bk){
        if(bk != null){
            List<BookCopy> books = bk.getCopies();

            Stream <BookCopy> streamBook = books.stream();
            BookCopy availableBook= streamBook
            .filter(bookcopy -> bookcopy.isAvailable() == true)
            .findFirst()
            .orElse(null);

            if(availableBook != null){return availableBook;}
    }
    return null;

    }
}
