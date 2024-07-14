import java.util.ArrayList;
import java.util.List;
public class BookCategory extends Category{
    private List<Book> books;
    
    public BookCategory(String category) {
        super(category);
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
    
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
}   
