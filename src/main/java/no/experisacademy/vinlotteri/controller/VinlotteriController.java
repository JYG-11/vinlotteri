package no.experisacademy.vinlotteri.controller;

import no.experisacademy.vinlotteri.service.VinlotteriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
class VinlotteriController {
    private final VinlotteriService vinlotteriService;

    @Autowired
    public VinlotteriController(VinlotteriService vinlotteriService) {
        this.vinlotteriService = vinlotteriService;
    }

    @GetMapping("/hent")
    public ResponseEntity<String> hentLodd(@RequestParam int loddnummer) {
        return vinlotteriService.hentLodd(loddnummer);
    }

    @PostMapping("/kjop")
    public ResponseEntity<String> kjopLodd(@RequestParam String navn,
                           @RequestParam int tlf,
                           @RequestParam int loddnummer) {
        return vinlotteriService.kjopLodd(navn, tlf, loddnummer);
    }
}