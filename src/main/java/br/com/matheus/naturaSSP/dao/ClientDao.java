package br.com.matheus.naturaSSP.dao;

import br.com.matheus.naturaSSP.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {

    Client findByNumberOrEmail(String email, String number);

}
