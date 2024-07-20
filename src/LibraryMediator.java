import java.util.Optional;

public interface LibraryMediator {
    public Object CoordinateSearch(Optional<String> title, Optional<String> author, Optional<String> category);
    public BookCopy CoordinateLoan(String title, String nCelular);
    public void CoordinateReturn(BookCopy bk);
}
