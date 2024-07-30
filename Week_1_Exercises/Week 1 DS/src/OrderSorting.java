import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Order class
class Order {
    private int orderId;
    private String customerName;
    private double orderAmount;

    public Order(int orderId, String customerName, double orderAmount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderAmount = orderAmount;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", customerName=" + customerName + ", orderAmount=" + orderAmount + "]";
    }
}

// SortStrategy interface
interface SortStrategy {
    void sort(List<Order> orders);
}

// Sort by Order ID strategy
class SortByOrderId implements SortStrategy {
    public void sort(List<Order> orders) {
        Collections.sort(orders, new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                return Integer.compare(o1.getOrderId(), o2.getOrderId());
            }
        });
    }
}

// Sort by Customer Name strategy
class SortByCustomerName implements SortStrategy {
    public void sort(List<Order> orders) {
        Collections.sort(orders, new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                return o1.getCustomerName().compareTo(o2.getCustomerName());
            }
        });
    }
}

// Sort by Order Amount strategy
class SortByOrderAmount implements SortStrategy {
    public void sort(List<Order> orders) {
        Collections.sort(orders, new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                return Double.compare(o1.getOrderAmount(), o2.getOrderAmount());
            }
        });
    }
}

// OrderSorter class
class OrderSorter {
    private SortStrategy sortStrategy;

    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sortOrders(List<Order> orders) {
        sortStrategy.sort(orders);
    }
}

// Main class
public class OrderSorting {
    public static void main(String[] args) {
        // Create a list of orders
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Alice", 250.0));
        orders.add(new Order(2, "Bob", 150.0));
        orders.add(new Order(3, "Charlie", 350.0));
        orders.add(new Order(4, "Dave", 50.0));
        orders.add(new Order(5, "Eve", 450.0));

        // Create an OrderSorter
        OrderSorter orderSorter = new OrderSorter();

        // Sort by Order ID
        orderSorter.setSortStrategy(new SortByOrderId());
        orderSorter.sortOrders(orders);
        System.out.println("Sorted by Order ID:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Sort by Customer Name
        orderSorter.setSortStrategy(new SortByCustomerName());
        orderSorter.sortOrders(orders);
        System.out.println("Sorted by Customer Name:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Sort by Order Amount
        orderSorter.setSortStrategy(new SortByOrderAmount());
        orderSorter.sortOrders(orders);
        System.out.println("Sorted by Order Amount:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
