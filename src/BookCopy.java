import java.time.LocalDate;

public class BookCopy {
    private String copyID;
    private boolean isAvailable;
    private LocalDate returnDate;

    public BookCopy(String copyID) {
        this.copyID = copyID;
        this.isAvailable = true; 
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable() {
        if(LocalDate.now().isAfter(returnDate)){
            this.isAvailable = true;
        }
    }

    public void setReturnDate(){
        this.returnDate = LocalDate.now().plusDays(7);
        this.isAvailable = false;
    }

    public LocalDate getReturnDate(){return this.returnDate;}

    public String getCopyID() {
        return copyID;
    }
}
