package no.experisacademy.vinlotteri.model;

import java.util.ArrayList;
import java.util.Objects;

public class Vinlotteri {
    private ArrayList<Lodd> loddliste = new ArrayList<>();
    private ArrayList<Eier> eiere = new ArrayList<>();
    private ArrayList<Vin> vinliste = new ArrayList<>();

    public void leggTilLodd(Lodd lodd) {
        loddliste.add(lodd);
    }

    public void leggTilEier(Eier eier) {
        eiere.add(eier);
    }

    public Lodd hentEksisterendeLodd(int nummer) {
        for (Lodd lodd : loddliste) {
            if (lodd.getNummer() == nummer) {
                return lodd;
            }
        }
        return null;
    }

    public Eier hentEksisterendeEier(String navn, int tlf) {
        for (Eier eier: eiere) {
            if (Objects.equals(eier.getNavn(), navn) && eier.getTlf() == tlf) {
                return eier;
            }
        }
        return null;
    }
}
