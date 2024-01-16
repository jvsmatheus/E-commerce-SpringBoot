package br.com.matheus.naturaSSP.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_itempedido")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_seq")
    private int numSeq;
    @Column(name = "qntd_item", nullable = false)
    private int quantity;
    @Column(name = "preco_unitario", nullable = false)
    private double unityPrice;
    @Column(name = "preco_total", nullable = false)
    private double totalPrice;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @JsonIgnoreProperties("orderItem")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Product product;

    public OrderItem() {
    }

    public int getNumSeq() {
        return numSeq;
    }

    public void setNumSeq(int numSeq) {
        this.numSeq = numSeq;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnityPrice() {
        return unityPrice;
    }

    public void setUnityPrice(double unityPrice) {
        this.unityPrice = unityPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "numSeq=" + numSeq +
                ", quantity=" + quantity +
                ", unityPrice=" + unityPrice +
                ", totalPrice=" + totalPrice +
                ", order=" + order +
                ", product=" + product.getId() +
                '}';
    }
}
