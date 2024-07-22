import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String celular;
    private ArrayList<String> boxNotifications;
    private ArrayList<BookCopy> loanedBookCopies;

    public User(String name, String email, String celular){
        this.name = name;
        this.email = email;
        this.celular = celular;
        this.boxNotifications = new ArrayList<String>();
        this.loanedBookCopies = new ArrayList<BookCopy>();
    }

    public String getCelular(){return this.celular;}
    public String getName(){return this.name;}
    public String getEmail(){return this.email;}

    public Integer getLoanedQuantity(){
        return this.loanedBookCopies.size();
    }

    public void readNotifications(){
        for (String notification : boxNotifications){
            System.out.println(notification);
        }
    }

    public void addNotification(String msg){
        if(msg != null){this.boxNotifications.add(msg);}
    }
}
