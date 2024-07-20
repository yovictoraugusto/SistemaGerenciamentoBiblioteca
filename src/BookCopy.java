import java.time.LocalDate;

public class BookCopy {
    private String copyID;
    private boolean isAvailable;
    private LocalDate returnDate;
    private String title;

    public BookCopy(String copyID, String title) {
        this.copyID = copyID;
        this.isAvailable = true;
        this.title = title;
    }

    public String getTitle(){
        return title;
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
