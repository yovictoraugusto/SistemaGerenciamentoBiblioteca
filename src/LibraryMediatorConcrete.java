import java.util.Optional;

public class LibraryMediatorConcrete implements LibraryMediator {
    SingletonDB DB = SingletonDB.getInstance();
    Library LB = new Library();
    BookAvailabilityNotifier notifier = new BookAvailabilityNotifier();

    // Coordena busca
    @Override
    public Object CoordinateSearch(Optional<String> title, Optional<String> author, Optional<String> category) {
        Object booksSearch = DB.searchBook(title, author, category);
        if(booksSearch != null){
            System.out.println("Book found!");
            return booksSearch;
        }
        System.out.println("Book not found!");
        return null;
    }

    // Coordena emprestimos
    @Override
    public BookCopy CoordinateLoan(String title, String nCelular) {
        BookCopy availableBook =  LB.loanBook(title, nCelular);
        if(availableBook != null){
            System.out.println("Loan Approved!\n Return Date:" + availableBook.getReturnDate());
            notifier.setNotification("Is unavailable!\nBook:" + availableBook.getTitle() + "\tCopy: " + availableBook.getCopyID());
        }else{
            System.out.println("Loan not Approved! :(");
        }
        return availableBook;
    }

    // Coordena devoluções
    @Override
    public void CoordinateReturn(BookCopy bk) {
        boolean returnStatus = LB.returnBook(bk);
        if(returnStatus == true){
            System.out.println("Book Returned");
            notifier.setNotification("Is available!\nBook:" + bk.getTitle() + "\tCopy: " + bk.getCopyID());
        }else{
            System.out.println("Book invalid");
        }   
    }
    
}
