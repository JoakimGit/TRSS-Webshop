package dat19c.kea.trsswebshop.Model;

import javax.persistence.*;

@Entity
public class OrderLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderLineItem_id;
    private String name;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderLineItem() {
    }

    public OrderLineItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public OrderLineItem(Long orderLineItem_id, String name, double price) {
        this.orderLineItem_id = orderLineItem_id;
        this.name = name;
        this.price = price;
    }

    public Long getOrderLineItem_id() {
        return orderLineItem_id;
    }

    public void setOrderLineItem_id(Long orderLineItem_id) {
        this.orderLineItem_id = orderLineItem_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderLineItem{" +
                "orderLineItem_id=" + orderLineItem_id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", order=" + order +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderLineItem)) return false;

        OrderLineItem other = (OrderLineItem) o;
        return orderLineItem_id != null && orderLineItem_id.equals(other.getOrderLineItem_id());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
