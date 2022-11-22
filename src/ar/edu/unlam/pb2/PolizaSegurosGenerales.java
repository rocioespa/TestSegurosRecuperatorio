package ar.edu.unlam.pb2;

import java.util.*;


public class PolizaSegurosGenerales extends Poliza implements SegurosGenerales {

	public Set<BienMaterial> bienes;
	public Set<Auto> autos;
	private Boolean fueRobado;

	

	public PolizaSegurosGenerales(Integer numeroDePoliza, Persona asegurado, Double sumaAsegurada, Double prima,
			Double premio) {
		super(numeroDePoliza, asegurado, sumaAsegurada, prima, premio);
		this.bienes = new HashSet<>();
		this.autos = new HashSet<>();
		this.fueRobado = false;
	}

	public Boolean isFueRobado() {
		return fueRobado;
	}

	public void setFueRobado(boolean fueRobado) {
		this.fueRobado = fueRobado;
	}
	
	
	
	public Set<BienMaterial> getBienes() {
		return bienes;
	}

	public void setBienes(Set<BienMaterial> bienes) {
		this.bienes = bienes;
	}

	public Set<Auto> getAutos() {
		return autos;
	}

	public void setAutos(Set<Auto> autos) {
		this.autos = autos;
	}

	public Boolean buscarBien(BienMaterial bien) {
		for (BienMaterial bien1 : bienes) {
			if(bien1.equals(bien)) {
				new Exception("El bien ya existe");
			}
		} return false;
	}

	@Override
	public void agregarBienAsegurado(BienMaterial bien) {
		if(buscarBien(bien) == false) {
			this.bienes.add(bien);
			this.autos.add((Auto) bien);
		}
		
	}

}
