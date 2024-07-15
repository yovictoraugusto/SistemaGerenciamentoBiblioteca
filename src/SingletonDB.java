import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SingletonDB {
    private SingletonDB(){}
    public static SingletonDB instance;
    public ArrayList<Book> books = new ArrayList<Book>();
    public ArrayList<Category> categories = new ArrayList<Category>();
    public ArrayList<User> users = new ArrayList<User>();

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

    public boolean AddCategory(Category category){
        if(this.categories.add(category))
        {return true;}
        else {return false;}
    }

    public boolean AddUser(User user){
        if(this.users.add(user))
        {return true;}
        else {return false;}
    }

    
    @SuppressWarnings("unlikely-arg-type")
    public Object searchBook(Optional<String> title, Optional<String> author, Optional<String> category){
        List<Book> PossibleBooks = new ArrayList<Book>();
        Optional<Book> book;
        if(title != null){
            book = books.stream()
                            .filter(item -> item.getTitle().equals(title))
                                .findFirst();
            return book;
        }
        if(author != null){
            PossibleBooks = books.stream()
                                    .filter(item -> item.getAuthor().equals(author))
                                        .collect(Collectors.toList());
        }
        if(category != null){
            PossibleBooks = books.stream()
                                    .filter(item -> item.getCategory().equals(category))
                                        .collect(Collectors.toList());
        }

        return PossibleBooks;
    }

    public Optional<User> searchUser(String nCelular){
        Optional<User> user;
        user = users.stream()
                            .filter(item -> item.getCelular().equals(nCelular))
                            .findFirst();
        return user;

    }
}


