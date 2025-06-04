package proxyPattern;

public class Order {
    private int orderId;
    private String ordername;
    private int price;

    public Order(int orderId, String ordername, int price) {
        this.orderId = orderId;
        this.ordername = ordername;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrdername() {
        return ordername;
    }

    public int getPrice() {
        return price;
    }
}