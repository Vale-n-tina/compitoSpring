package com.example.compitoSpring.runners;


import com.example.compitoSpring.edificio.Edificio;
import com.example.compitoSpring.edificio.EdificioRepository;
import com.example.compitoSpring.postazione.Postazione;
import com.example.compitoSpring.postazione.PostazioneRepository;
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


    }


}
