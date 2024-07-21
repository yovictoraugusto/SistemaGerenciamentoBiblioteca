import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        Preloader loader = new Preloader();
        loader.load();
        // BookCategory fiction = new BookCategory("Fiction");
        // BookCategory fantasy = new BookCategory("Fantasy");
        // BookCategory nonFiction = new BookCategory("Non-Fiction");
        // BookCategory history = new BookCategory("History");

        // fiction.setSubcategories(fantasy);
        // nonFiction.setSubcategories(history);

        // Book lotr = new Book("The Lord of the Rings", "J.R.R. Tolkien", fantasy);
        // Book sapiens = new Book("Sapiens", "Yuval Noah Harari", history);

        // lotr.addCopy(new BookCopy("LOTR-1", lotr.getTitle())));
        // lotr.addCopy(new BookCopy("LOTR-2", lotr.getTitle()));
        // sapiens.addCopy(new BookCopy("SAPIENS-1"));

        // fantasy.addBook(lotr);
        // history.addBook(sapiens);

        // System.out.println("Category: " + fiction.getCategory());
        // for (Category subcategory : fiction.getSubcategories()) {
        //     System.out.println("  Subcategory: " + subcategory.getCategory());
        //     if (subcategory instanceof BookCategory) {
        //         for (Book book : ((BookCategory) subcategory).getBooks()) {
        //             System.out.println("    Book: " + book.getTitle() + " by " + book.getAuthor());
        //             for (BookCopy copy : book.getCopies()) {
        //                 System.out.println("      Copy ID: " + copy.getCopyID() + " - Available: " + copy.isAvailable());
        //             }
        //         }
        //     }
        // }

        SingletonDB db = SingletonDB.getInstance();
        LibraryFacade LB = new LibraryFacade();
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

        ArrayList<Book> teste2 = (ArrayList<Book>) LB.searchBook(null, "George Orwell", null);
        System.out.println(teste2.get(0).getAuthor());

    }

}
