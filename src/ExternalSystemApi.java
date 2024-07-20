public class ExternalSystemApi {
    public ExternalSystemApi() {}

    public String findBooksTitle(String title){
        return ("Searching for books by the title externally: " + title);
    }

    public String findBooksAuthor(String author){
        return ("Searching for books by the author externally: "+ author);
    }

    public String findBooksCategory(String category){
        return ("Searching for books by the category externally:"+ category);
    }
}
