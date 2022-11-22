package ar.edu.unlam.pb2;

import java.util.*;

public class Compania {

	private String nombre;
	private Set<Poliza> polizasEmitidas;

	public Compania(String nombre) {
		this.nombre = nombre;
		this.polizasEmitidas = new HashSet<Poliza>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Poliza> getPolizas() {
		return polizasEmitidas;
	}

	public void setPolizas(Set<Poliza> polizas) {
		this.polizasEmitidas = polizas;
	}

	public void agregarPoliza(Poliza poliza) {
		this.polizasEmitidas.add(poliza);

	}

	public int obtenerLaCantidadDePolizasEmitidas() {
		// TODO Auto-generated method stub
		return this.polizasEmitidas.size();
	}

	public void denunciarSiniestro(Integer numero) throws PolizaInexistente {
		if (getPoliza(numero) instanceof PolizaSegurosGenerales) {
			((PolizaSegurosGenerales) getPoliza(numero)).setFueRobado(true);
		} else if (getPoliza(numero) instanceof PolizaDeVida) {
			((PolizaDeVida) getPoliza(numero)).setTuvoAlgunAccidente(true);
		}

	}

	public Poliza getPoliza(int numero) throws PolizaInexistente {
		for (Poliza poliza : polizasEmitidas) {
			if (poliza.getNumeroDePoliza().equals(numero)) {
				return poliza;
			}
		}
		throw new PolizaInexistente("Poliza Inexistente");
	}

}
