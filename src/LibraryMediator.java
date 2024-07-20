import java.util.Optional;

public interface LibraryMediator {
    public Object CoordinateSearchBook(Optional<String> title, Optional<String> author, Optional<String> category);
    public BookCopy CoordinateLoan(String title, String nCelular);
    public void CoordinateReturn(BookCopy bk);
    public User CoordinateSearchUser(String nCelular);
    public void CoordinateAddBook(Book bk);
    public void CoordinateRegisterUser(User user);
    public void CoordinateAddCategory(BookCategory bCategory);
}
