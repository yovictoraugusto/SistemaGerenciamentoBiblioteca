import java.util.Optional;


public class Library {
    private SingletonDB DB = SingletonDB.getInstance();

    public Library() {
    }

    public BookCopy loanBook(String Title, String nCelular)
    {
        User user = DB.searchUser(nCelular);
        UserEligibiltyHandler EligibilityHandler = new UserEligibiltyHandler(); 

        if(EligibilityHandler.verifyUser(user))
        {
            Book book = (Book) DB.searchBook(Optional.of(Title), null, null);
            BookAvailabilityHandler AvailabilityHandler = new BookAvailabilityHandler();
            BookCopy availableBook = AvailabilityHandler.verifyBook(book);

            if(availableBook != null){
                availableBook.setReturnDate();
                return availableBook;
            }
        }
        return null;
    }   

    public boolean returnBook(BookCopy bk){
        if (bk != null){
            bk.setAvailable();
            return true;
        }
        else{return false;}

    }
}
