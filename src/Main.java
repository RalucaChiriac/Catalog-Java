// Main.java
import model.*;
import service.CatalogService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CatalogService service = new CatalogService();
        Scanner scanner = new Scanner(System.in);
        int opt;
        do {
            System.out.println("\n--- Meniu Catalog ---");
            System.out.println("1. Adauga elev");
            System.out.println("2. Adauga profesor");
            System.out.println("3. Atribuie materie unui profesor");
            System.out.println("4. Adauga nota elev");
            System.out.println("5. Afiseaza notele unui elev");
            System.out.println("6. Calculeaza media unui elev la o materie");
            System.out.println("7. Calculeaza media generala a unui elev");
            System.out.println("8. Afiseaza elevii unei clase");
            System.out.println("9. Afiseaza materiile unui profesor");
            System.out.println("10. Afiseaza catalogul unei clase pe modul");
            System.out.println("0. Iesire");
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt) {
                case 1 -> {
                    System.out.print("Nume: ");
                    String nume = scanner.nextLine();
                    System.out.print("Prenume: ");
                    String prenume = scanner.nextLine();
                    System.out.print("Clasa: ");
                    String denumire = scanner.nextLine();
                    Clasa clasa = new Clasa(denumire);
                    Elev elev = new Elev(nume, prenume, clasa);
                    service.adaugaElev(elev);
                    System.out.println("Elev adaugat.");
                }
                case 2 -> {
                    System.out.print("Nume profesor: ");
                    String nume = scanner.nextLine();
                    System.out.print("Prenume: ");
                    String prenume = scanner.nextLine();
                    Profesor p = new Profesor(nume, prenume);
                    service.adaugaProfesor(p);
                    System.out.println("Profesor adaugat.");
                }
                case 3 -> {
                    System.out.print("Nume profesor: ");
                    String nume = scanner.nextLine();
                    Profesor p = service.getProfesori().stream()
                            .filter(prof -> prof.getNume().equalsIgnoreCase(nume))
                            .findFirst().orElse(null);
                    if (p == null) {
                        System.out.println("Profesor inexistent.");
                        break;
                    }
                    System.out.print("Materie de atribuit: ");
                    String numeMaterie = scanner.nextLine();
                    Materie m = new Materie(numeMaterie);
                    service.atribuieMaterieProfesor(p, m);
                    System.out.println("Materie atribuita.");
                }
                case 4 -> {
                    System.out.print("Nume elev: ");
                    String numeElev = scanner.nextLine();
                    Elev e = service.getElevi().stream()
                            .filter(ev -> ev.getNumeComplet().equalsIgnoreCase(numeElev))
                            .findFirst().orElse(null);
                    if (e == null) {
                        System.out.println("Elev inexistent.");
                        break;
                    }
                    System.out.print("Materie: ");
                    String materie = scanner.nextLine();
                    Materie m = new Materie(materie);
                    System.out.print("Nota: ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Modul (1-5): ");
                    int mod = scanner.nextInt();
                    scanner.nextLine();
                    Modul modul = Modul.valueOf("MODULUL_" + mod);
                    service.adaugaNota(new Nota(e, m, nota, modul));
                    System.out.println("Nota adaugata.");
                }
                case 5 -> {
                    for (Elev e : service.getElevi()) {
                        System.out.println("Note pentru " + e.getNumeComplet() + ":");
                        service.getNoteElev(e).forEach(System.out::println);
                    }
                }
                case 6 -> {
                    System.out.print("Nume elev: ");
                    String numeElev = scanner.nextLine();
                    Elev e = service.getElevi().stream()
                            .filter(ev -> ev.getNumeComplet().equalsIgnoreCase(numeElev))
                            .findFirst().orElse(null);
                    if (e == null) {
                        System.out.println("Elev inexistent.");
                        break;
                    }
                    System.out.print("Materie: ");
                    String materie = scanner.nextLine();
                    Materie m = new Materie(materie);
                    System.out.println("Media: " + service.getMediaMaterie(e, m));
                }
                case 7 -> {
                    System.out.print("Nume elev: ");
                    String numeElev = scanner.nextLine();
                    Elev e = service.getElevi().stream()
                            .filter(ev -> ev.getNumeComplet().equalsIgnoreCase(numeElev))
                            .findFirst().orElse(null);
                    if (e == null) {
                        System.out.println("Elev inexistent.");
                        break;
                    }
                    System.out.println("Media generala: " + service.getMediaGenerala(e));
                }
                case 8 -> {
                    for (Clasa c : service.getClase()) {
                        System.out.println("Elevi in clasa " + c + ":");
                        service.getEleviClasa(c).forEach(e -> System.out.println(e.getNumeComplet()));
                    }
                }
                case 9 -> {
                    for (Profesor p : service.getProfesori()) {
                        System.out.println("Materii predate de " + p.getNume() + ":");
                        p.getMaterii().forEach(m -> System.out.println(m.getNume()));
                    }
                }
                case 10 -> {
                    for (Clasa c : service.getClase()) {
                        System.out.print("Modul (1-5) pentru clasa " + c + ": ");
                        int mod = scanner.nextInt();
                        scanner.nextLine();
                        Modul modul = Modul.valueOf("MODULUL_" + mod);
                        service.getCatalogClasaModul(c, modul).forEach(System.out::println);
                    }
                }
                case 0 -> System.out.println("La revedere!");
                default -> System.out.println("Optiune invalida!");
            }
        } while (opt != 0);
    }
}
