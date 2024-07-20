import java.util.Optional;

public class LibraryMediatorConcrete implements LibraryMediator {
    SingletonDB DB = SingletonDB.getInstance();
    // Coordena busca
    @Override
    public Object CoordinateSearch(Optional<String> title, Optional<String> author, Optional<String> category) {
        
    }

    // Coordena emprestimos
    // Coordena devoluções    

    
}
