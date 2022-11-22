package ar.edu.unlam.pb2;

import java.util.*;


public class PolizaCombinadoFamiliar extends Poliza implements SeguroDeVida, SegurosGenerales{
	
	private Set<BienMaterial> bienes = new HashSet<>();
	private Set<Persona> beneficiarios = new HashSet<>();

	public PolizaCombinadoFamiliar(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima,
			Double premio) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima, premio);
		// TODO Auto-generated constructor stub
	}

	public Boolean buscarBien(BienMaterial bien) {
		for (BienMaterial bien1 : bienes) {
			if(bien1.equals(bien)) {
				new Exception("El bien ya existe");
			}
		} return false;
	}
	
	public int obtenerBienAsegurado() {
		return this.bienes.size();
	}

	@Override
	public void agregarBienAsegurado(BienMaterial bien) {
		if(buscarBien(bien) == false) {
			this.bienes.add(bien);
			
		}
		
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

	


