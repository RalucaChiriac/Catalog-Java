package model;

public class Clasa {
    private String denumire;

    public Clasa(String denumire) {
        this.denumire = denumire;
    }

    public String getDenumire() {
        return denumire;
    }

    @Override
    public String toString() {
        return denumire;
    }
}