import java.util.ArrayList;
import java.util.Optional;

public class LibraryFacade {
    private SingletonDB DB = SingletonDB.getInstance();
    private Library LB = new Library();
    // Register new User
    // Consultar informações de livros 
    // Devolução de livros
    // Consultar informações sobre o usuários
    // Busca por livro (implementado em SingletonDB)

    public void LoanBook(String title, String nCelular){
        LB.loanBook(title, nCelular);
    }

    public void ReturnBook(BookCopy bk){
        LB.returnBook(bk);
    }

    public Object searchBook(String title, String author, String category){
        if(title != null){
            Book bk = (Book) DB.searchBook(Optional.of(title), null, null);
            return bk;
        }
        
        ArrayList bks = (ArrayList) DB.searchBook(Optional.ofNullable(title), Optional.ofNullable(author), Optional.ofNullable(category));
        return bks;
    }

    public User searchUser(String nCelular){
        return DB.searchUser(nCelular);
    }

}
