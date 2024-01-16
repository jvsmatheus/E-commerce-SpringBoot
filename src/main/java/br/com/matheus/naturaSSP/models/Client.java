package br.com.matheus.naturaSSP.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cliente")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private int idClient;
    @Column(name = "nome_cliente", length = 100, nullable = false)
    private String name;
    @Column(name = "email_cliente", length = 100, nullable = false)
    private String email;
    @Column(name = "telefone_cliente", length = 20, nullable = false)
    private String number;
    @Column(name = "cep_cliente", length = 10, nullable = false)
    private String cep;
    @Column(name = "logradouro", length = 100, nullable = false)
    private String address;
    @Column(name = "numero", length = 10, nullable = false)
    private String addressNumber;
    @Column(name = "complemento", length = 70)
    private String complement;
    @Column(name = "bairro", length = 50, nullable = false)
    private String neighborhood;
    @Column(name = "cidade", length = 100, nullable = false)
    private String city;
    @Column(name = "estado", length = 2, nullable = false)
    private String state;

    public Client() {
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
