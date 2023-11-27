package no.experisacademy.vinlotteri.model;

public class Eier {
    private String navn;
    private int tlf;

    public Eier(String navn, int tlf) {
        this.navn = navn;
        this.tlf = tlf;
    }

    public String getNavn() {
        return navn;
    }

    public int getTlf() {
        return tlf;
    }
}
