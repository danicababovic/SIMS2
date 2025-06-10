package registracija;

public class Korisnik {
    private String imeIPrezime;
    private String email;
    private String password;

    public Korisnik(String imeIPrezime, String email, String password) {
        this.imeIPrezime = imeIPrezime;
        this.email = email;
        this.password = password;
    }

    //Geteri
    public String getImeIPrezime() {
		return imeIPrezime;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public boolean validno() {
        return imeIPrezime != null && !imeIPrezime.isEmpty() &&
               email != null && email.contains("@") &&
               password != null && password.length() >= 6;
    }
}