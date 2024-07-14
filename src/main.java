public class main {
    public static void main(String[] args) {
        // Criação de categorias
        BookCategory fiction = new BookCategory("Fiction");
        BookCategory fantasy = new BookCategory("Fantasy");
        BookCategory nonFiction = new BookCategory("Non-Fiction");
        BookCategory history = new BookCategory("History");

        fiction.setSubcategories(fantasy);
        nonFiction.setSubcategories(history);

        Book lotr = new Book("The Lord of the Rings", "J.R.R. Tolkien", fantasy);
        Book sapiens = new Book("Sapiens", "Yuval Noah Harari", history);

        lotr.addCopy(new BookCopy("LOTR-1"));
        lotr.addCopy(new BookCopy("LOTR-2"));
        sapiens.addCopy(new BookCopy("SAPIENS-1"));

        fantasy.addBook(lotr);
        history.addBook(sapiens);

        System.out.println("Category: " + fiction.getCategory());
        for (Category subcategory : fiction.getSubcategories()) {
            System.out.println("  Subcategory: " + subcategory.getCategory());
            if (subcategory instanceof BookCategory) {
                for (Book book : ((BookCategory) subcategory).getBooks()) {
                    System.out.println("    Book: " + book.getName() + " by " + book.getAuthor());
                    for (BookCopy copy : book.getCopies()) {
                        System.out.println("      Copy ID: " + copy.getCopyID() + " - Available: " + copy.isAvailable());
                    }
                }
            }
        }
    }
}
