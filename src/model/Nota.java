package model;

public class Nota {
    private Elev elev;
    private Materie materie;
    private double valoare;
    private Modul modul;

    public Nota(Elev elev, Materie materie, double valoare, Modul modul) {
        this.elev = elev;
        this.materie = materie;
        this.valoare = valoare;
        this.modul = modul;
    }

    public Elev getElev() { return elev; }
    public Materie getMaterie() { return materie; }
    public double getValoare() { return valoare; }
    public Modul getModul() { return modul; }

    @Override
    public String toString() {
        return elev.getNumeComplet() + ", " + materie.getNume() + ", Nota: " + valoare + ", " + modul;
    }
}