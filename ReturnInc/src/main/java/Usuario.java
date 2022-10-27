public class Usuario {

	private long id;
	private String nome;
	private String cpf;
	private String genero;
	private Endereço endereco;

	public Usuario(long id, String nome, String cpf, String genero, Endereço endereco) {
		super();
		setId(id);
		setNome(nome);
		setCpf(cpf);
		setGenero(genero);
		setEndereco(endereco);
	}

	private Usuario() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Endereço getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereço endereco) {
		this.endereco = endereco;
	}
}