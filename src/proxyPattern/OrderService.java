package proxyPattern;

public interface OrderService{
    void saveOrder(Order order);
    Order findByOrderId(int orderId);
}