package com.example.compitoSpring.postazione;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

    List<Postazione>findByStatoAndEdificio_Citta(TipoPostazione stato, String citta);
}
