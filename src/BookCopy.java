public class BookCopy {
    private Integer copyID;
    private boolean isAvailable;

    public BookCopy(Integer copyID) {
        this.copyID = copyID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getCopyID() {
        return copyID;
    }
}
