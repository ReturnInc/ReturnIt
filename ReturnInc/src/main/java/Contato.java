public class Contato {

	private int Whatsapp;
	private String Email;

	private Contato(int Whatsapp, String Email) {

		setWhatsapp(Whatsapp);
		setEmail(Email);
	}

	private Contato() {
	}

	public int getWhatsapp() {
		return Whatsapp;
	}

	public void setWhatsapp(int whatsapp) {
		Whatsapp = whatsapp;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
