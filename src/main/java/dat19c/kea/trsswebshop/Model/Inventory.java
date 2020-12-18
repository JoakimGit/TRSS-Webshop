package dat19c.kea.trsswebshop.Model;

import javax.persistence.*;

@Entity
public class Inventory {

    @Id
    private Long inventory_id;
    private String status;
    private int quantity;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    public Inventory() {
    }

    public void calculateStatus() {
        int amount = this.quantity;
        if (amount < 0) {
            System.out.println("Amount can't be negative");
        }

        if (amount == 0) {
            status = "Udsolgt";
        }
        else if (amount < 10 && amount > 0) {
            status = "Få tilbage";
        }
        else if (amount >= 10) {
            status = "På lager";
        }
    }

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory_id=" + inventory_id +
                ", status='" + status + '\'' +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
