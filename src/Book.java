import java.util.ArrayList;
import java.util.List;

public class Book {
    private String name;
    private String author;
    private BookCategory category;
    private List<BookCopy> copies;
    
    public Book(String name, String author, BookCategory category) {
        this.name = name;
        this.author = author;
        this.category = category;
        this.copies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookCategory getCategory(){
        return category;
    }

    public void setCategory(BookCategory newCategory){
        this.category = newCategory;
    }

    public List<BookCopy> getCopies() {
        return copies;
    }

    public void addCopy(BookCopy copy){
        copies.add(copy);
    }

    public BookCopy getAvailableCopy(){
        for(BookCopy copy: copies){
            if(copy.isAvailable() == true){
                return copy;
            }
        }
        return null;
    }

    public boolean isAvailable(){
        return getAvailableCopy() != null; //Há pelo menos uma cópia disponível
    }


    
}
