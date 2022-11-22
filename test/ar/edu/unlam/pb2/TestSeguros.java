package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSeguros {

	@Test
	public void queSePuedaEmitirUnaPolizaDeAutos() {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;

		Persona asegurado = new Persona("Camila", 45987345, 24, TipoDeBeneficiario.MADRE);
		Auto auto = new Auto("Ford", "Fiesta", 2010, SUMA_ASEGURADA);
		Poliza poliza = new PolizaSegurosGenerales(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA, PREMIO);
		((PolizaSegurosGenerales)poliza).agregarBienAsegurado(auto);

		assertEquals(NUMERO_DE_POLIZA, ((Poliza) poliza).getNumeroDePoliza());
		assertEquals(asegurado, ((Poliza) poliza).getAsegurado());
		assertEquals(PREMIO, ((Poliza) poliza).getPremio());
		assertEquals(1,((PolizaSegurosGenerales) poliza).getAutos().size());
		assertEquals(1,((PolizaSegurosGenerales) poliza).getBienes().size());
	}
	
	@Test
	public void queSePuedaEmitirUnaPolizaDeVida() throws YaSeAplicoElBeneficio {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 2000000.0, PRIMA = 5000.0, PREMIO = 6000.0;
		
		Persona asegurado = new Persona("Camila", 45987345, 24, TipoDeBeneficiario.HIJA);
		Persona hijo = new Persona("Arturo", 65456231, 2, TipoDeBeneficiario.HIJO);
		Persona conyuge = new Persona("Arturo", 65456241, 3, TipoDeBeneficiario.CONYUGE);
		
		Poliza poliza = new PolizaDeVida(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA, PREMIO);
		((PolizaDeVida) poliza).agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		((PolizaDeVida) poliza).agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
	
		assertEquals(2, ((PolizaDeVida) poliza).obtenerCantidadDeBeneficiarios());
	}

	@Test
	public void queSePuedaEmitirUnaPolizaDeCombinadoFamiliar() throws YaSeAplicoElBeneficio {
		final Integer NUMERO_DE_POLIZA = 1;
		final Double SUMA_ASEGURADA = 20000000.0, PRIMA = 50000.0, PREMIO = 60000.0;
		
		BienMaterial casa = new Vivienda("Florencio Varela 1800", "San Justo", "La Matanza", "Buenos Aires");
		Persona asegurado = new Persona("Camila", 45987345, 24, TipoDeBeneficiario.HERMANA);
		Persona hijo = new Persona("Arturo", 65456231, 2, TipoDeBeneficiario.HIJO);
		Persona hija = new Persona("Maia", 65445231, 4, TipoDeBeneficiario.HIJA);
		Persona conyuge = new Persona("Arturo", 65456232, 4, TipoDeBeneficiario.CONYUGE);
		
		Poliza poliza = new PolizaCombinadoFamiliar(NUMERO_DE_POLIZA, asegurado, SUMA_ASEGURADA, PRIMA, PREMIO);
		((SeguroDeVida) poliza).agregarBeneficiario(hijo, TipoDeBeneficiario.HIJO);
		((SeguroDeVida) poliza).agregarBeneficiario(hija, TipoDeBeneficiario.HIJA);
		((SeguroDeVida) poliza).agregarBeneficiario(conyuge, TipoDeBeneficiario.CONYUGE);
		((SegurosGenerales) poliza).agregarBienAsegurado(casa);
		
		assertEquals(3,((PolizaCombinadoFamiliar) poliza).obtenerCantidadDeBeneficiarios());
		assertEquals(1,((PolizaCombinadoFamiliar) poliza).obtenerBienAsegurado());
		
	}
	
	@Test
	public void queSePuedanAdministrarDistintosTiposDePolizas() {
		
		Compania libra = new Compania("Libra");
		libra.agregarPoliza(new PolizaSegurosGenerales(1, new Persona("Camila", 45987345, 24, TipoDeBeneficiario.HIJA), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaSegurosGenerales(2, new Persona("Juan", 2745123, 24, TipoDeBeneficiario.HIJO), 1500000.0, 4000.0, 60000.0));
		libra.agregarPoliza(new PolizaDeVida(3, new Persona("Pedro", 455647345, 24, TipoDeBeneficiario.CONYUGE), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Natalia", 45987345, 24, TipoDeBeneficiario.HERMANA), 2000000.0, 5000.0, 60000.0));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(4, new Persona("Victor", 652354, 24, TipoDeBeneficiario.HIJO), 2000000.0, 5000.0, 60000.0));
		
		assertEquals(5, libra.obtenerLaCantidadDePolizasEmitidas());
	}
	
	@Test
	public void queSePuedaDenunciarElRoboDeUnAuto() throws PolizaInexistente {
		Integer numeroDePoliza = 1;
		Compania libra = new Compania("Libra");
	    PolizaSegurosGenerales p = new PolizaSegurosGenerales(numeroDePoliza, new Persona("Camila", 45987345, 24, TipoDeBeneficiario.HIJA), 2000000.0, 5000.0, 60000.0);
		libra.agregarPoliza(p);
		
		libra.denunciarSiniestro(numeroDePoliza);
		assertEquals(true,p.isFueRobado());

	}
	
	@Test
	public void queSePuedaDenunciarUnSiniestroParaUnaPolizaDeVida() throws PolizaInexistente {
		Integer numeroDePoliza = 1;
		Compania libra = new Compania("Libra");
	    
		PolizaDeVida pv = new PolizaDeVida(numeroDePoliza, new Persona("Pedro", 455647345, 24,TipoDeBeneficiario.CONYUGE), 2000000.0, 5000.0, null);
		libra.agregarPoliza(pv);
		
		libra.denunciarSiniestro(1);
		
		assertEquals(true,pv.getTuvoAlgunAccidente());
	}
	
	@Test (expected = PolizaInexistente.class)
	public void verificarQueNoSePuedaDenunciarUnSiniestroParaUnaPolizaQueNoExista() throws PolizaInexistente {
		Integer numeroDePoliza = 1;
		Compania libra = new Compania("Libra");
	
		libra.agregarPoliza(new PolizaSegurosGenerales(numeroDePoliza++, new Persona("Camila", 45987345, 24,TipoDeBeneficiario.CONYUGE), 2000000.0, 5000.0, null));
		libra.agregarPoliza(new PolizaSegurosGenerales(numeroDePoliza++, new Persona("Juan", 2745123, 24,TipoDeBeneficiario.HERMANA), 1500000.0, 4000.0, null));
		libra.agregarPoliza(new PolizaDeVida(numeroDePoliza++, new Persona("Pedro", 455647345, 24,TipoDeBeneficiario.HERMANO), 2000000.0, 5000.0, null));
		libra.agregarPoliza(new PolizaCombinadoFamiliar(numeroDePoliza++, new Persona("Natalia", 45987345, 24,TipoDeBeneficiario.HIJO), 2000000.0, 5000.0, null));

		libra.denunciarSiniestro(5);

	}
}
