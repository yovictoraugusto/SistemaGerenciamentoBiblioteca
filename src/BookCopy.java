public class BookCopy {
    private String copyID;
    private boolean isAvailable;

    public BookCopy(String copyID) {
        this.copyID = copyID;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getCopyID() {
        return copyID;
    }
}
