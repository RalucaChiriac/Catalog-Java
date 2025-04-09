package model;

public class Elev extends Persoana {
    private Clasa clasa;

    public Elev(String nume, String prenume, Clasa clasa) {
        super(nume, prenume);
        this.clasa = clasa;
    }

    public Clasa getClasa() {
        return clasa;
    }
}
