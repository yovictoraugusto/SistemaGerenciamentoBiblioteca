import java.util.ArrayList;

public class User {
    public String name;
    public String email;
    public String celular;
    public ArrayList<String> boxNotifications;
    public ArrayList<BookCopy> loanedBookCopies;

    public User(String name, String email, String celular){
        this.name = name;
        this.email = email;
        this.celular = celular;
        this.boxNotifications = new ArrayList<String>();
        this.loanedBookCopies = new ArrayList<BookCopy>();
    }

    public String getCelular(){return this.celular;}

    public Integer getLoanedQuantity(){
        return this.loanedBookCopies.size();
    }

    public void readNotifications(){
        for (String notification : boxNotifications){
            System.out.println(notification);
        }
    }
}
