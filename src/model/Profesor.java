package model;

import java.util.HashSet;
import java.util.Set;

public class Profesor extends Persoana {
    private Set<Materie> materii = new HashSet<>();

    public Profesor(String nume, String prenume) {
        super(nume, prenume);
    }

    public void adaugaMaterie(Materie m) {
        materii.add(m);
    }

    public Set<Materie> getMaterii() {
        return materii;
    }
}
