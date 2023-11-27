package no.experisacademy.vinlotteri.model;

public class Lodd {
    private int nummer;
    private Vin vin;
    private Eier eier;

    public Lodd(int nummer) {
        this.nummer = nummer;
    }

    public int getNummer() {
        return nummer;
    }

    public Vin getVin() {
        return vin;
    }

    public Eier getEier() {
        return eier;
    }

    public void setVin(Vin vin) {
        this.vin = vin;
    }

    public void setEier(Eier eier) {
        this.eier = eier;
    }
}
