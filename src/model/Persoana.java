package model;

public abstract class Persoana {
    protected String nume;
    protected String prenume;

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume() {
        return nume;
    }

    public String getNumeComplet() {
        return nume + " " + prenume;
    }
}
