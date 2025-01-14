/**
 * 
 */
package com.endes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class ControladorDNITest {
	ControladorDNI controlador;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeAll");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("@BeforeEach");
		controlador = new ControladorDNI();
	}
	
	// Prueba para verificar que el calculo de la letra del DNI es correcto
	@Test
	@DisplayName ("Prueba dni valido")
	void testEsValidoDNI() {
		String dniCorrecto = "11111111H"; 
		
		assertTrue(controlador.esValido(dniCorrecto), "El dni correcto fue detectado como falso");
	}
	
	//Prueba para verificar las letras invalidas
	@Test
	@DisplayName ("Validación de la letra incorrecta")
	void testEsValido_DNILetraFalsa () {
		String dniFalso= "11111111R";
		
		assertFalse(controlador.esValido(dniFalso), "El dni con una letra mal fue reconocido como valido");
	}

	//Prueba para verificar las entradas nulas
	@Test 
	@DisplayName ("Validación para entradas nulas para dni")
	void testEsValido_DNIEntradasNulas () {
		assertFalse(controlador.esValido(null), "El DNI es nulo y fue reconocido como valido");
	}
	
	//Prueba para verificar las entradas cortas
	@Test 
	@DisplayName ("Validación para entradas demasiado cortas")
	void testEsValido_DNIEntradasCortas () {
		assertFalse(controlador.esValido("1111111H"), "El DNI es demasiado corto y fue reconocido como valido");
	}
	
	//Prueba para verificar las entradas cortas
	@Test 
	@DisplayName ("Validación para entradas con caracteres alfanumericos en los numero")
	void testEsValido_DNIConcaracteresNoNumericos () {
		assertFalse(controlador.esValido("1111F111H"), "El DNI tiene una letra en los numero y fue detectado como valido");
	}
}
