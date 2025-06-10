package registracija;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//pocetak rada
public class RegistracijaController {
    private final RegistracijaView view;
    private final KorisnikMenadzer korisnikManager;

    public RegistracijaController(RegistracijaView view, KorisnikMenadzer userManager) {
        this.view = view;
        this.korisnikManager = userManager;
        addEventListeners();
    }

    private void addEventListeners() {
        view.registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegister();
            }
        });

        view.showUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleShowUsers();
            }
        });

        view.deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDeleteUser();
            }
        });
    }

    private void handleRegister() {
        String imeIPrezime = view.imeIPrezimeField.getText();
        String email = view.emailField.getText();
        String password = new String(view.passwordField.getPassword());

        Korisnik korisnik = new Korisnik(imeIPrezime, email, password);

        if (korisnik.validno()) {
            korisnikManager.dodajKorisnika(korisnik);
            view.prikaziPoruku("Uspešna registracija!");
            clearForm();
            handleShowUsers();
        } else {
            view.prikaziPoruku("Neispravni podaci za registraciju.");
        }
    }

    private void handleShowUsers() {
        StringBuilder sb = new StringBuilder();
        for (Korisnik u : korisnikManager.getAllUsers()) {
            sb.append("Ime i prezime: ").append(u.getImeIPrezime())
              .append(", Email: ").append(u.getEmail())
              .append("\n");
        }
        view.prikaziListuKorisnika(sb.length() > 0 ? sb.toString() : "Nema registrovanih korisnika.");
    }

    private void handleDeleteUser() {
        String email = view.deleteEmailField.getText().trim();

        if (email.isEmpty()) {
            view.prikaziPoruku("Unesite email korisnika za brisanje.");
            return;
        }

        boolean deleted = korisnikManager.izbrisiKorisnika(email);
        if (deleted) {
            view.prikaziPoruku("Korisnik obrisan: " + email);
            view.deleteEmailField.setText("");
            handleShowUsers();
        } else {
            view.prikaziPoruku("Korisnik nije pronađen: " + email);
        }
    }

    private void clearForm() {
        view.imeIPrezimeField.setText("");
        view.emailField.setText("");
        view.passwordField.setText("");
    }
}