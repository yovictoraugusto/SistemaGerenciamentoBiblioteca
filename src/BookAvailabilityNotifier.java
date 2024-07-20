import java.util.ArrayList;

public class BookAvailabilityNotifier {
    
    SingletonDB DB = SingletonDB.getInstance();

    public void setNotification(String message){
        ArrayList<User> users = DB.getUsers();
        for (User user: users){
            user.notifications.add(message);
        }

        System.out.println("New Notification to All Users!");
    }
}
