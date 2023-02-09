package com.example.obrestdatajpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "laptops")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "precio")
    private Double precio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lapto_caracteristica")
    private LaptopCaracteristica laptopCaracteristicas;

    public Laptop(String marca, String modelo, Double precio, LaptopCaracteristica laptopCaracteristicas) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.laptopCaracteristicas = laptopCaracteristicas;
    }

    public Laptop(String marca, String modelo, Double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Laptop(Long id, String marca, String modelo, Double precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Laptop() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public LaptopCaracteristica getLaptopCaracteristicas() {
        return laptopCaracteristicas;
    }

    public void setLaptopCaracteristicas(LaptopCaracteristica laptopCaracteristicas) {
        this.laptopCaracteristicas = laptopCaracteristicas;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precio=" + precio +
                ", laptopCaracteristicas=" + laptopCaracteristicas +
                '}';
    }
}
