import java.util.ArrayList;

public class User {
    public String name;
    public String email;
    public String celular;
    public ArrayList<String> notifications;
    public ArrayList<BookCopy> loanedBookCopies;

    public User(String name, String email, String celular){
        this.name = name;
        this.email = email;
        this.celular = celular;
        this.notifications = new ArrayList<String>();
        this.loanedBookCopies = new ArrayList<BookCopy>();
    }

    public String getCelular(){return this.celular;}

    public void readNotifications(){
        for (String notification : notifications){
            System.out.println(notification);
        }
    }
}
