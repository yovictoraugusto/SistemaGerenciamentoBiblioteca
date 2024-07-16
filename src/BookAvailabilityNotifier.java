public class BookAvailabilityNotifier {
    
    SingletonDB DB = SingletonDB.getInstance();

    public void setNotification(String message){
        for (User user: DB.users){
            user.notifications.add(message);
        }

        System.out.println("New Notification to All Users!");
    }



}
