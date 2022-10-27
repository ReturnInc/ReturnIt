import java.time.LocalDateTime;

public class Agendamento {

	private LocalDateTime data;
	private Endereço local;
	private Cooperado cooperado;
	private Empresa empresa;

	private Agendamento(LocalDateTime data, Endereço local, Cooperado cooperado, Empresa empresa) {
		setData(data);
		setLocal(local);
		setCooperado(cooperado);
		setEmpresa(empresa);
	}

	private Agendamento() {
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Endereço getLocal() {
		return local;
	}

	public void setLocal(Endereço local) {
		this.local = local;
	}

	public Cooperado getColaborador() {
		return cooperado;
	}

	public void setCooperado(Cooperado cooperado) {
		this.cooperado = cooperado;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
