package registracija;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RegistracijaView view = new RegistracijaView();
            KorisnikMenadzer menadzer = new KorisnikMenadzer();
            new RegistracijaController(view, menadzer);
            view.setVisible(true);
        });
    }
}
