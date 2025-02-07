package com.example.compitoSpring.Service;


import com.example.compitoSpring.postazione.Postazione;
import com.example.compitoSpring.postazione.PostazioneRepository;
import com.example.compitoSpring.postazione.TipoPostazione;
import com.example.compitoSpring.prenotazioni.Prenotazione;
import com.example.compitoSpring.prenotazioni.PrenotazioneRepository;
import com.example.compitoSpring.utente.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioniService {
    @Autowired
    private PostazioneRepository postazioneRepository;
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    public List<Postazione> cercaPostazioni(TipoPostazione stato, String citta) {
        return postazioneRepository.findByStatoAndEdificio_Citta(stato, citta);
    }

    public boolean utenteHaUnaPrenotazione(Utente utente, LocalDate dataPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByUtenteAndDataPrenotazione(utente, dataPrenotazione);
        System.out.println("Numero di prenotazioni per l'utente nella data specificata: " + prenotazioni.size());
        return !prenotazioni.isEmpty();  // Quindi torna true se la lista non è vuota
    }

    public boolean postazioneLibera(Postazione postazione, LocalDate dataPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
        return prenotazioni.isEmpty();
    }

    public Prenotazione creaPrenotazione(Utente utente, Postazione postazione, LocalDate dataPrenotazione) {

        if (utenteHaUnaPrenotazione(utente, dataPrenotazione) && !postazioneLibera(postazione, dataPrenotazione)) {

            throw new IllegalArgumentException("L'utente ha già una prenotazione per questa data o la prenotazione non è disponibile");
        }
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setDataPrenotazione(dataPrenotazione);
        return prenotazioneRepository.save(prenotazione);

    }

}
