import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class LibraryFacade {
    SingletonDB DB = SingletonDB.getInstance();
    // Register new User
    // Consultar informações de livros 
    // Devolução de livros
    // Consultar informações sobre o usuários
    // Busca por livro (implementado em SingletonDB)

    public void LoanBook(String Title){
        Book book = (Book) DB.searchBook(Title, null, null);
        List<BookCopy> books = book.getCopies();

        Stream <BookCopy> streamBook = books.stream();
        BookCopy availableBook = (BookCopy) streamBook.filter(bookcopy -> bookcopy.isAvailable() == true);

        if(availableBook != null){
            availableBook.setReturnDate();
            System.out.println("Loan Approved!\n Return Date:" + availableBook.getReturnDate());
        }
        else{
            System.out.println("Loan not approved! :( ");
        }

    }

}
