public class Main {

    // Product class definition
    public static class Product {
        private int productId;
        private String productName;
        private int quantity;
        private double price;

        // Constructor
        public Product(int productId, String productName, int quantity, double price) {
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters and Setters
        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create a Product object
        Product product = new Product(1, "Laptop", 10, 999.99);

        // Print product details
        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.println("Quantity: " + product.getQuantity());
        System.out.println("Price: $" + product.getPrice());
    }
}
