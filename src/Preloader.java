import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator; 
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*; 

public class Preloader {
    SingletonDB DB = SingletonDB.getInstance();
    public Preloader(){}

    public void load() throws FileNotFoundException, IOException, ParseException{
        Object obj = new JSONParser().parse(new FileReader("books.json"));
        JSONObject jo = (JSONObject) obj;

        JSONArray bookJsonArray = (JSONArray) jo.get("books");

        Iterator itr = bookJsonArray.iterator();
        while (itr.hasNext())
        {
            Iterator itrAux = ((Map) itr.next()).entrySet().iterator();
            while (itrAux.hasNext()){
                
                Map.Entry pair = (Entry) itrAux.next();
                String author = ((String) pair.getValue());
                pair = (Entry) itrAux.next();
                String title = ((String) pair.getValue());
                pair = (Entry) itrAux.next();
                String Category = ((String) pair.getValue());

                BookCategory bookCategory = DB.getBookCategories(Category);
                if(bookCategory != null){
                    Book book = new Book (title, author, bookCategory);
                    bookCategory.addBook(book);
                }else{
                    bookCategory = new BookCategory(Category);
                    this.DB.addCategory(bookCategory);
                }

                Book book = new Book (title, author, bookCategory);
                
                Integer randomInt = ThreadLocalRandom.current().nextInt(1, 4);

                for(Integer i = 0; i <= randomInt;i++){
                    BookCopy bookCopy = new BookCopy(""+(randomInt+i)+"C", title);
                    book.addCopy(bookCopy);
                }

                this.DB.addBook(book);
            }
        }
    }

}