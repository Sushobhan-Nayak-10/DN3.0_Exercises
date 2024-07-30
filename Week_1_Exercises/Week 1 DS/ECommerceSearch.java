import java.util.ArrayList;
import java.util.List;

// Product class
class Product {
    private int productId;
    private String productName;
    private double price;

    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
    }
}

// SearchStrategy interface
interface SearchStrategy {
    List<Product> search(List<Product> products, String searchTerm);
}

// Search by product name strategy
class SearchByName implements SearchStrategy {
    public List<Product> search(List<Product> products, String searchTerm) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(searchTerm.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
}

// Search by price range strategy
class SearchByPriceRange implements SearchStrategy {
    private double minPrice;
    private double maxPrice;

    public SearchByPriceRange(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public List<Product> search(List<Product> products, String searchTerm) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }
}

// SearchContext class
class SearchContext {
    private SearchStrategy searchStrategy;

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public List<Product> search(List<Product> products, String searchTerm) {
        return searchStrategy.search(products, searchTerm);
    }
}

// Main class
public class ECommerceSearch {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 999.99));
        products.add(new Product(2, "Smartphone", 599.99));
        products.add(new Product(3, "Tablet", 399.99));
        products.add(new Product(4, "Smartwatch", 199.99));
        products.add(new Product(5, "Headphones", 49.99));

        // Create a search context
        SearchContext searchContext = new SearchContext();

        // Search by name
        searchContext.setSearchStrategy(new SearchByName());
        List<Product> nameSearchResults = searchContext.search(products, "smart");
        System.out.println("Search by name results:");
        for (Product product : nameSearchResults) {
            System.out.println(product);
        }

        // Search by price range
        searchContext.setSearchStrategy(new SearchByPriceRange(100, 500));
        List<Product> priceRangeSearchResults = searchContext.search(products, "");
        System.out.println("Search by price range results:");
        for (Product product : priceRangeSearchResults) {
            System.out.println(product);
        }
    }
}
