package service;

import model.*;

import java.util.*;
import java.util.stream.Collectors;

public class CatalogService {
    private List<Elev> elevi = new ArrayList<>();
    private List<Profesor> profesori = new ArrayList<>();
    private List<Nota> note = new ArrayList<>();
    private Set<Clasa> clase = new TreeSet<>(Comparator.comparing(Clasa::getDenumire));

    public void adaugaElev(Elev e) {
        elevi.add(e);
        clase.add(e.getClasa());
    }

    public void adaugaProfesor(Profesor p) {
        profesori.add(p);
    }

    public void atribuieMaterieProfesor(Profesor p, Materie m) {
        p.adaugaMaterie(m);
    }

    public void adaugaNota(Nota n) {
        note.add(n);
    }

    public List<Nota> getNoteElev(Elev e) {
        List<Nota> rezultat = new ArrayList<>();
        for (Nota n : note) {
            if (n.getElev().equals(e)) {
                rezultat.add(n);
            }
        }
        return rezultat;
    }

    public double getMediaMaterie(Elev e, Materie m) {
        double suma = 0;
        int count = 0;
        for (Nota n : note) {
            if (n.getElev().equals(e) && n.getMaterie().getNume().equalsIgnoreCase(m.getNume())) {
                suma += n.getValoare();
                count++;
            }
        }
        if (count == 0) return 0;
        return suma / count;
    }

    public double getMediaGenerala(Elev e) {
        double suma = 0;
        int count = 0;
        for (Nota n : note) {
            if (n.getElev().equals(e)) {
                suma += n.getValoare();
                count++;
            }
        }
        if (count == 0) return 0;
        return suma / count;
    }

    public List<Elev> getEleviClasa(Clasa c) {
        List<Elev> rezultat = new ArrayList<>();
        for (Elev e : elevi) {
            if (e.getClasa().getDenumire().equalsIgnoreCase(c.getDenumire())) {
                rezultat.add(e);
            }
        }
        return rezultat;
    }

    public Set<Materie> getMateriiProfesor(Profesor p) {
        return p.getMaterii();
    }

    public List<Nota> getCatalogClasaModul(Clasa c, Modul m) {
        List<Nota> rezultat = new ArrayList<>();
        for (Nota n : note) {
            if (n.getElev().getClasa().getDenumire().equalsIgnoreCase(c.getDenumire()) && n.getModul() == m) {
                rezultat.add(n);
            }
        }
        return rezultat;
    }

    public List<Elev> getElevi() {
        return elevi;
    }

    public List<Profesor> getProfesori() {
        return profesori;
    }

    public Set<Clasa> getClase() {
        return clase;
    }
}