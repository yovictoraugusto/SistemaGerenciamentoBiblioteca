import java.util.ArrayList;

public class BookCategory extends Category{
    private ArrayList<Book> books;
    
    public BookCategory(String category) {
        super(category);
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }
    
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    
}   
