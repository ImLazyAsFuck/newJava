public class OrderDetail {
    private int detailId;
    private int orderId;
    private String productName;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public OrderDetail(int detailId, int orderId, String productName, int quantity) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
}
