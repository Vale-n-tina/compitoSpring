package com.example.compitoSpring.runners;


import com.example.compitoSpring.edificio.Edificio;
import com.example.compitoSpring.edificio.EdificioRepository;
import com.example.compitoSpring.postazione.Postazione;
import com.example.compitoSpring.postazione.PostazioneRepository;
import com.example.compitoSpring.postazione.TipoPostazione;
import com.example.compitoSpring.utente.Utente;
import com.example.compitoSpring.utente.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class createRunner implements CommandLineRunner {


    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {

        Edificio edificio1 = new Edificio();
        edificio1.setNome("Edificio 1");
        edificio1.setIndirizzo("Via Roma, 1");
        edificio1.setCitta("Milano");

        Edificio edificio2 = new Edificio();
        edificio2.setNome("Edificio 2");
        edificio2.setIndirizzo("Via Milano, 2");
        edificio2.setCitta("Roma");

        Edificio edificio3 = new Edificio();
        edificio3.setNome("Edificio 3");
        edificio3.setIndirizzo("Via Napoli, 3");
        edificio3.setCitta("Napoli");

        Edificio edificio4 = new Edificio();
        edificio4.setNome("Edificio 4");
        edificio4.setIndirizzo("Via Pascoli, 4");
        edificio4.setCitta("Viterbo");

        Edificio edificio5 = new Edificio();
        edificio5.setNome("Edificio 5");
        edificio5.setIndirizzo("Via Napoli, 5");
        edificio5.setCitta("Napoli");

        edificioRepository.save(edificio1);
        edificioRepository.save(edificio2);
        edificioRepository.save(edificio3);
        edificioRepository.save(edificio4);
        edificioRepository.save(edificio5);


        Postazione postazione1 = new Postazione();
        postazione1.setDescrizione("Postazione privata 1");
        postazione1.setStato(TipoPostazione.PRIVATO);
        postazione1.setNumeroMaxPartecipanti(20);
        postazione1.setEdificio(edificio1);
        postazioneRepository.save(postazione1);


        Postazione postazione2 = new Postazione();
        postazione2.setDescrizione("Postazione OpenSpace 2");
        postazione2.setStato(TipoPostazione.OPENSPACE);
        postazione2.setNumeroMaxPartecipanti(10);
        postazione2.setEdificio(edificio3);
        postazioneRepository.save(postazione2);

        Postazione postazione3 = new Postazione();
        postazione3.setDescrizione("Sala Riunioni 1");
        postazione3.setStato(TipoPostazione.SALA_RIUNIONI);
        postazione3.setNumeroMaxPartecipanti(15);
        postazione3.setEdificio(edificio4);
        postazioneRepository.save(postazione3);

        Postazione postazione4 = new Postazione();
        postazione4.setDescrizione("Sala Riunioni 2");
        postazione4.setStato(TipoPostazione.SALA_RIUNIONI);
        postazione4.setNumeroMaxPartecipanti(8);
        postazione4.setEdificio(edificio5);
        postazioneRepository.save(postazione4);

        Utente utente1 = new Utente();
        utente1.setUsername("user1");
        utente1.setNome("Mario");
        utente1.setCognome("rossi");
        utente1.setEmail("Mariorossi@gmail.com");
        utenteRepository.save(utente1);

        Utente utente2 = new Utente();
        utente2.setUsername("user2");
        utente2.setNome("Luca");
        utente2.setCognome("Bianchi");
        utente2.setEmail("lucabianchi@example.com");
        utenteRepository.save(utente2);

        Utente utente3 = new Utente();
        utente3.setUsername("user3");
        utente3.setNome("Giulia");
        utente3.setCognome("Verdi");
        utente3.setEmail("giuliaverdi@example.com");
        utenteRepository.save(utente3);

        Utente utente4 = new Utente();
        utente4.setUsername("user4");
        utente4.setNome("Francesco");
        utente4.setCognome("Neri");
        utente4.setEmail("francesconeri@example.com");
        utenteRepository.save(utente4);

        Utente utente5 = new Utente();
        utente5.setUsername("user5");
        utente5.setNome("Alessandra");
        utente5.setCognome("Gialli");
        utente5.setEmail("alessandragialli@example.com");
        utenteRepository.save(utente5);

    }


}
