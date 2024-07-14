import java.util.ArrayList;
import java.util.List;

public class Category {
    private String category;
    private List<Category> subcategories;

    public Category(String category) {
        this.category = category;
        this.subcategories =  new ArrayList<>();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Category subcategory) {
        subcategories.add(subcategory);
    }

    
}
