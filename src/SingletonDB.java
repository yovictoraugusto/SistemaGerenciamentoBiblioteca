import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


public class SingletonDB {
    SingletonDB(){}
    private static SingletonDB instance;
    private ArrayList<Book> books = new ArrayList<Book>();
    public ArrayList<BookCategory> categories = new ArrayList<BookCategory>();
    private ArrayList<User> users = new ArrayList<User>();

    public static SingletonDB getInstance(){
        if (instance == null)
        {instance = new SingletonDB();}
        return instance;
    }

    public boolean addBook(Book book){
        if(this.books.add(book))
        {return true;}
        else {return false;}
    }

    public boolean addCategory(BookCategory category){
        if(this.categories.add(category))
        {return true;}
        else {return false;}
    }

    public boolean addUser(User user){
        if(this.users.add(user))
        {return true;}
        else {return false;}
    }

    
    @SuppressWarnings({ "unlikely-arg-type" })
    public Object searchBook(Optional<String> title, Optional<String> author, Optional<String> category){
        String authorString = author.orElse(null);
        String categoryString = category.orElse(null);
        String titleString = title.orElse(null);
        ArrayList<Book> PossibleBooks = new ArrayList<>();
        Book book;
        if(title.isPresent())
        {
            book = this.books.stream()
                        .filter(item -> item.getTitle().equals(titleString))
                        .findFirst().orElse(null);
            return book;
        }
        if(author.isPresent() && category.isPresent())
        {
            PossibleBooks =  (ArrayList<Book>) this.books.stream()
                            .filter(item -> item.getAuthor().equals(authorString))
                            .filter(item -> item.getCategory().equals(categoryString))
                            .collect(Collectors.toList());

                            return PossibleBooks;
        }
        if(category.isPresent())
        {
            PossibleBooks = (ArrayList<Book>) this.books.stream()
                            .filter(item -> item.getCategory().getCategory().equals(categoryString))
                            .collect(Collectors.toList());
        }

        if(author.isPresent())
        {
            PossibleBooks = (ArrayList<Book>) this.books.stream()
                            .filter(item -> item.getAuthor().equals(authorString))
                            .collect(Collectors.toList());

        }

        return PossibleBooks;
    }

    public User searchUser(String nCelular)
    {
        User user;
        user = users.stream()
                            .filter(item -> item.getCelular().equals(nCelular))
                            .findFirst().orElse(null);
        return user;
    }
    
    public ArrayList<User> getUsers()
    {return this.users;}

    public BookCategory getBookCategories(String categoryName){
        BookCategory category = this.categories.stream()
                        .filter(item -> item.getCategory().equals(categoryName))
                        .findFirst().orElse(null);
            return category;
    } 
}


