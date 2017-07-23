package br.com.jdjava.ModelCliente;

import java.io.Serializable;

public class ClienteDados implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int 	idCliente;
	private String 	cpfCliente;
	private String 	nomeCliente;
	private Boolean AtivoCliente;
	private Double 	vlTotalCliente;
	
	public ClienteDados() {
		
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Boolean getAtivoCliente() {
		return AtivoCliente;
	}

	public void setAtivoCliente(Boolean ativoCliente) {
		AtivoCliente = ativoCliente;
	}

	public Double getVlTotalCliente() {
		return vlTotalCliente;
	}

	public void setVlTotalCliente(Double vlTotalCliente) {
		this.vlTotalCliente = vlTotalCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AtivoCliente == null) ? 0 : AtivoCliente.hashCode());
		result = prime * result + ((cpfCliente == null) ? 0 : cpfCliente.hashCode());
		result = prime * result + idCliente;
		result = prime * result + ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
		result = prime * result + ((vlTotalCliente == null) ? 0 : vlTotalCliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDados other = (ClienteDados) obj;
		if (AtivoCliente == null) {
			if (other.AtivoCliente != null)
				return false;
		} else if (!AtivoCliente.equals(other.AtivoCliente))
			return false;
		if (cpfCliente == null) {
			if (other.cpfCliente != null)
				return false;
		} else if (!cpfCliente.equals(other.cpfCliente))
			return false;
		if (idCliente != other.idCliente)
			return false;
		if (nomeCliente == null) {
			if (other.nomeCliente != null)
				return false;
		} else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		if (vlTotalCliente == null) {
			if (other.vlTotalCliente != null)
				return false;
		} else if (!vlTotalCliente.equals(other.vlTotalCliente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClienteDados [idCliente=");
		builder.append(idCliente);
		builder.append(", cpfCliente=");
		builder.append(cpfCliente);
		builder.append(", nomeCliente=");
		builder.append(nomeCliente);
		builder.append(", AtivoCliente=");
		builder.append(AtivoCliente);
		builder.append(", vlTotalCliente=");
		builder.append(vlTotalCliente);
		builder.append("]");
		return builder.toString();
	}
	
	
}
