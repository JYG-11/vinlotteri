package no.experisacademy.vinlotteri.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class VinlotteriService {

    public String hentLodd(int loddnummer) {
        return String.format(
                "Loddnummer %d eies av Ola som kan kontaktes på 123",
                loddnummer);
    }

    public String kjopLodd(String navn, int tlf, int loddnummer) {
        return String.format(
                "Loddnummer %d har blitt kjøpt av %s som kan kontaktes på %d",
                loddnummer,
                navn,
                tlf);
    }
}