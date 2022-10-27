import java.time.LocalDateTime;

public class Deposito {

	private Cooperado cooperado;
	private Usuario usuario;
	private LocalDateTime data;
	private Retornável retornavel;

	public Deposito(Cooperado cooperado, Usuario usuario, LocalDateTime data, Retornável retornavel) {
		setCooperado(cooperado);
		setUsuario(usuario);
		setData(data);
		setRetornavel(retornavel);
	}

	public Deposito() {

	}

	public Cooperado getCooperado() {
		return cooperado;
	}

	public void setCooperado(Cooperado cooperado) {
		this.cooperado = cooperado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Retornável getRetornavel() {
		return retornavel;
	}

	public void setRetornavel(Retornável retornavel) {
		this.retornavel = retornavel;
	}
}