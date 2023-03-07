package br.com.projeto.restaurante.model;

public class EnderecoEntity {
	
	private Integer id;
	private Integer idCliente;
	private String cep;
	private String address;
	private String state;
	private String district;
	private String city;
	
	public EnderecoEntity(Integer id, Integer idCliente, String cep, String address, String state, String district,
			String city) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.cep = cep;
		this.address = address;
		this.state = state;
		this.district = district;
		this.city = city;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
