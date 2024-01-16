package br.com.matheus.naturaSSP.services.order;

import br.com.matheus.naturaSSP.dao.OrderDAO;
import br.com.matheus.naturaSSP.models.Order;
import br.com.matheus.naturaSSP.models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImp implements IOrderService{

    @Autowired
    private OrderDAO dao;

    @Override
    public Order createOrder(Order order) {
        try {
            double total = 0.00;
            /* Regras de negócio */

            for (OrderItem item : order.getOrderItem()) {
                System.out.println(item.getProduct());
                item.setUnityPrice(item.getProduct().getPrice());

                if (item.getQuantity() >= 5) { // 20% de desconto
                    item.setTotalPrice(item.getUnityPrice() * item.getQuantity() * 0.8);
                } else {
                    item.setTotalPrice(item.getUnityPrice() * item.getQuantity());
                }

                total += item.getTotalPrice();
            }
            /* ----------------- */

            for (OrderItem item : order.getOrderItem()) {
                item.setOrder(order);
            }
            order.setTotalValue(total);
            dao.save(order);
            return order;
        }
        catch (Exception ex) {
            System.out.println("DEBUG: " + ex.getMessage());
        }
        return null;
    }
}
