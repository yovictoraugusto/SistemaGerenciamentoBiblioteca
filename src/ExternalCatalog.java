
public interface ExternalCatalog {
    String searchBooksByTitle(String title);
    String searchBooksByAuthor(String Author);
    String searchBooksByCategory(String Category);
}
