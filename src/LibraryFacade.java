import java.util.ArrayList;
import java.util.Optional;

public class LibraryFacade {
    private LibraryMediatorConcrete mediator = new LibraryMediatorConcrete();
    // Register new User
    // Consultar informações de livros 
    // Devolução de livros
    // Consultar informações sobre o usuários
    // Busca por livro (implementado em SingletonDB)

    public void LoanBook(String title, String nCelular){
        mediator.CoordinateLoan(title, nCelular);
    }

    public void ReturnBook(BookCopy bk){
        mediator.CoordinateReturn(bk);
    }

    public Object searchBook(String title, String author, String category){
        if(title != null){
            Book bk = (Book) mediator.CoordinateSearchBook(Optional.of(title),Optional.empty(), Optional.empty());;
            return bk;
        }
        @SuppressWarnings("unchecked")
        ArrayList<Book> bks = (ArrayList<Book>) mediator.CoordinateSearchBook(Optional.ofNullable(title), Optional.ofNullable(author), Optional.ofNullable(category));
        return bks;
        
    }

    public User searchUser(String nCelular){
        return mediator.CoordinateSearchUser(nCelular);
    }

    public boolean addBook(Book bk){
        if(bk != null){
            mediator.CoordinateAddBook(bk);
            return true;
        }
        return false;
    }

    public boolean registerUser(User user){
        if(user != null){
            mediator.CoordinateRegisterUser(user);
            return true;
        }
        return false;
    }

    public boolean addCategory(BookCategory bCategory){
        if(bCategory != null){
            mediator.CoordinateAddCategory(bCategory);
            return true;}
        return false;
    }

}
