package com.example.obrestdatajpa.entities;

import javax.persistence.*;

@Entity
@Table(name = "lapto_caracteristica")
public class LaptopCaracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tamaño_pantalla")
    private Integer tamPantalla;

    @Column(name = "cantidad_ram")
    private Integer cantRam;

    @Column(name = "tipo_procesador")
    private String procesador;

    @Column(name = "tamaño_discoduro_hdd")
    private Integer tamDiscoHDD;

    @Column(name = "tamaño_discoduro_ssd")
    private Integer tamDiscoSSD;

    public LaptopCaracteristica(Integer tamPantalla, Integer cantRam, String procesador, Integer tamDiscoHDD, Integer tamDiscoSSD) {
        this.tamPantalla = tamPantalla;
        this.cantRam = cantRam;
        this.procesador = procesador;
        this.tamDiscoHDD = tamDiscoHDD;
        this.tamDiscoSSD = tamDiscoSSD;
    }

    public LaptopCaracteristica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTamPantalla() {
        return tamPantalla;
    }

    public void setTamPantalla(Integer tamPantalla) {
        this.tamPantalla = tamPantalla;
    }

    public Integer getCantRam() {
        return cantRam;
    }

    public void setCantRam(Integer cantRam) {
        this.cantRam = cantRam;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public Integer getTamDiscoHDD() {
        return tamDiscoHDD;
    }

    public void setTamDiscoHDD(Integer tamDiscoHDD) {
        this.tamDiscoHDD = tamDiscoHDD;
    }

    public Integer getTamDiscoSSD() {
        return tamDiscoSSD;
    }

    public void setTamDiscoSSD(Integer tamDiscoSSD) {
        this.tamDiscoSSD = tamDiscoSSD;
    }
}
