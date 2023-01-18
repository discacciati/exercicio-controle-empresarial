package com.controleempresarial.eliane.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fornecedor;
    private String categoria;

    @Column(unique = true)
    private String numeroNF;
    private String valorNF;
    private LocalDate dataVencimento;
    private Boolean pago;


}
