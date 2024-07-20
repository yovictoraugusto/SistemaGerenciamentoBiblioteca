import java.util.Optional;

public interface LibraryMediator {
    public Object CoordinateSearch(Optional<String> title, Optional<String> author, Optional<String> category);
    
}
