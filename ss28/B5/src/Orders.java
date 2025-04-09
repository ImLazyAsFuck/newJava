import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private int orderId;
    private String customerName;
    private LocalDate orderDate;
    private List<OrderDetail> details = new ArrayList<>();

    public Orders() {
    }

    public Orders(String customerName, LocalDate orderDate) {
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public Orders(int orderId, String customerName, LocalDate orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    public void addDetail(OrderDetail detail) {
        this.details.add(detail);
    }
}
