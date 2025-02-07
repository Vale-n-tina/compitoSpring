package com.example.compitoSpring.prenotazioni;

import com.example.compitoSpring.postazione.Postazione;
import com.example.compitoSpring.utente.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate dataPrenotazione;

    @ManyToOne
    private Utente utente;

    @ManyToOne
    private Postazione postazione;


}
