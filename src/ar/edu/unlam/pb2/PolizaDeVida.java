package ar.edu.unlam.pb2;

import java.util.List;
import java.util.*;

public class PolizaDeVida extends Poliza implements SeguroDeVida{
	
	public Set<Persona> beneficiarios;
	private Boolean tuvoAlgunAccidente;

	public PolizaDeVida(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima, Double premio) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima, premio);
		this.beneficiarios = new HashSet<>();
		this.tuvoAlgunAccidente = false;
	}

	public Boolean getTuvoAlgunAccidente() {
		return tuvoAlgunAccidente;
	}

	public void setTuvoAlgunAccidente(Boolean tuvoAlgunAccidente) {
		this.tuvoAlgunAccidente = tuvoAlgunAccidente;
	}

	public void setBeneficiarios(Set<Persona> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	@Override
	public void agregarBeneficiario(Persona p, TipoDeBeneficiario tipoDeBeneficiario) throws YaSeAplicoElBeneficio {
		for (Persona persona : beneficiarios) {
			if(persona.getDni().equals(p.getDni())) {
				throw new YaSeAplicoElBeneficio("ya se aplico el beneficio a esta persona");
			}
		}this.beneficiarios.add(p);
		
	}

	@Override
	public int obtenerCantidadDeBeneficiarios() {
		return this.beneficiarios.size();
	}

	

}
