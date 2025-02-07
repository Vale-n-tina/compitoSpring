package com.example.compitoSpring.runners;

import com.example.compitoSpring.postazione.Postazione;
import com.example.compitoSpring.Service.PrenotazioniService;
import com.example.compitoSpring.postazione.PostazioneRepository;
import com.example.compitoSpring.postazione.TipoPostazione;
import com.example.compitoSpring.prenotazioni.Prenotazione;
import com.example.compitoSpring.utente.Utente;
import com.example.compitoSpring.utente.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class FindRunner implements CommandLineRunner {

    @Autowired
    private PrenotazioniService prenotazioniService;
    @Autowired
    private UtenteRepository UtenteRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;

    @Override
    public void run(String... args) throws Exception {


        System.out.println("-----Cercando postazioni private in Milano...-----");
        List<Postazione> postazioni = prenotazioniService.cercaPostazioni(TipoPostazione.PRIVATO, "Milano");
        postazioni.forEach(postazione -> System.out.println("POSTAZIONI TROVATE:" + " - " + postazione.getDescrizione() + " - " + postazione.getStato() + " - " + postazione.getEdificio().getCitta()));

        Utente utente7 = UtenteRepository.findById(1L).orElse(null);
        Postazione postazione7 = postazioneRepository.findById(1L).orElse(null);



        System.out.println("----Creare una prenotazione-----");
        try {
            Prenotazione prenotazione = prenotazioniService.creaPrenotazione(utente7, postazione7, LocalDate.of(2025, 04, 10));
            System.out.println("Prenotazione creata con successo");
            ;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
