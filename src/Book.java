import java.util.List;

public class Book {
    private String name;
    private String author;
    // Categories
    private List<BookCopy> copies;
    
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
