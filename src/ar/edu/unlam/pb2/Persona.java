package ar.edu.unlam.pb2;

public class Persona {
	
	private String nombre;
	private Integer dni;
	private Integer edad;
	private TipoDeBeneficiario tipoDePersona;

	public Persona(String nombre, Integer dni, Integer edad,TipoDeBeneficiario tipoDePersona) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.tipoDePersona = tipoDePersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public TipoDeBeneficiario getTipoDePersona() {
		return tipoDePersona;
	}

	public void setTipoDePersona(TipoDeBeneficiario tipoDePersona) {
		this.tipoDePersona = tipoDePersona;
	}

	

}
