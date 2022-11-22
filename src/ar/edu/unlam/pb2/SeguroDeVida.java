package ar.edu.unlam.pb2;

import java.util.List;

public interface SeguroDeVida {
	
	public void agregarBeneficiario(Persona hijo, TipoDeBeneficiario tipoDeBeneficiario) throws YaSeAplicoElBeneficio;
	public int obtenerCantidadDeBeneficiarios();
	

}
