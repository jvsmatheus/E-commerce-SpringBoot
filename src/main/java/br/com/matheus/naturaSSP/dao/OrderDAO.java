package br.com.matheus.naturaSSP.dao;

import br.com.matheus.naturaSSP.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {

    ArrayList<Order> findAllByClient(Order order);
}
