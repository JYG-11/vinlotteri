package no.experisacademy.vinlotteri.service;

import no.experisacademy.vinlotteri.model.Eier;
import no.experisacademy.vinlotteri.model.Lodd;
import no.experisacademy.vinlotteri.model.Vinlotteri;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VinlotteriService {

    private Vinlotteri vinlotteri = new Vinlotteri();

    public ResponseEntity<String> hentLodd(int loddnummer) {
        Lodd lodd = vinlotteri.hentEksisterendeLodd(loddnummer);

        if (lodd == null) {
            return new ResponseEntity<>(
                    "Et lodd med dette nummeret finnes ikke, vennligst velg et annet nummer",
                    HttpStatus.NOT_FOUND);
        }

        Eier eier = lodd.getEier();

        return new ResponseEntity<>(
                String.format("Loddnummer %d eies av %s som kan kontaktes på %d",
                        loddnummer,
                        eier.getNavn(),
                        eier.getTlf()),
                HttpStatus.OK);
    }

    public ResponseEntity<String> kjopLodd(String navn, int tlf, int loddnummer) {
        Lodd lodd = vinlotteri.hentEksisterendeLodd(loddnummer);

        if (lodd != null) {
            return new ResponseEntity<>(
                    "Loddet har allerede blitt kjøpt, vennligst velg et annet nummer",
                    HttpStatus.CONFLICT);
        }

        Eier eier = vinlotteri.hentEksisterendeEier(navn, tlf);

        if (eier == null) {
            eier = new Eier(navn, tlf);
            vinlotteri.leggTilEier(eier);
        }

        Lodd nyttLodd = new Lodd(loddnummer);
        nyttLodd.setEier(eier);
        vinlotteri.leggTilLodd(nyttLodd);

        return new ResponseEntity<>(
                "Gratulerer med nytt lodd! Til lykke i konkurransen!",
                HttpStatus.CREATED);
    }
}