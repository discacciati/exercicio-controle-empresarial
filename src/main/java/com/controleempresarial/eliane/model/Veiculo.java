package com.controleempresarial.eliane.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    private TipoVeiculo tipo;
    private String placa;
    private String marca;
    private String anoFabricacao;
    private String anoModelo;
    private LocalDate dataCompra;
    private Boolean ipvaVencido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;



}
