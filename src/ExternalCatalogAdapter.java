
public class ExternalCatalogAdapter implements ExternalCatalog {
    private ExternalSystemApi externalSistem;

    @Override
    public String searchBooksByTitle(String title){
        String externalBooks = externalSistem.findBooksTitle(title);
        return externalBooks;
    }

    @Override
    public String searchBooksByAuthor(String author){
        String externalBooks = externalSistem.findBooksTitle(author);
        return externalBooks;
    }

    @Override
    public String searchBooksByCategory(String category){
        String externalBooks = externalSistem.findBooksTitle(category);
        return externalBooks;
    }
}