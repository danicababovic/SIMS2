package registracija;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class KorisnikMenadzer {
    private final List<Korisnik> korisnici = new ArrayList<>();
    private static final String FILE_NAME = "korisnici.csv";

    public KorisnikMenadzer() { ucitajKorisnike(); }

    public void dodajKorisnika(Korisnik korisnik) {
        korisnici.add(korisnik);
        sacuvajKorisnika();
    }

    public List<Korisnik> getAllUsers() {
        return new ArrayList<>(korisnici);
    }

    public boolean izbrisiKorisnika(String email) {
        boolean removed = korisnici.removeIf(u -> u.getEmail().equalsIgnoreCase(email));
        if (removed) sacuvajKorisnika();
        return removed;
    }

    private void sacuvajKorisnika() {
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Korisnik u : korisnici) {
                out.println(u.getImeIPrezime() + "," + u.getEmail() + "," + u.getPassword());
            }
        } catch (IOException e) {
            System.err.println("Greška pri snimanju korisnika: " + e.getMessage());
        }
    }

    private void ucitajKorisnike() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    korisnici.add(new Korisnik(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.err.println("Greška pri učitavanju korisnika: " + e.getMessage());
        }
    }
}