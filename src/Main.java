import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        Preloader loader = new Preloader();
        loader.load();
        SingletonDB db = SingletonDB.getInstance();
        LibraryFacade lb = new LibraryFacade();
        
        // System.out.println(db.getClass());
        // db.addBook(sapiens);
        // db.addBook(lotr);
        // ArrayList<Book> teste =  (ArrayList<Book>) LB.searchBook(null, "J.R.R. Tolkien", null);
        // for (Book example : teste){
        //     System.out.println(example.getTitle());
        // }
        ExternalCatalogAdapter searchExternal = new ExternalCatalogAdapter();
        
        Book teste = (Book) db.searchBook(Optional.of("1984"), Optional.empty(), Optional.empty());
        System.out.println(teste.getAuthor());

        ArrayList<Book> teste2 = (ArrayList<Book>) lb.searchBook(null, "George Orwell", null);
        System.out.println(teste2.get(0).getAuthor());

    }

}
