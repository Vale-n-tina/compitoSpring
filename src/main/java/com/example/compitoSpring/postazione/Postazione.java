package com.example.compitoSpring.postazione;

import com.example.compitoSpring.edificio.Edificio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descrizione;
    private StatoPostazione stato;
    private int numeroMaxPartecipanti;

    @ManyToOne
    private Edificio edificio;


}
