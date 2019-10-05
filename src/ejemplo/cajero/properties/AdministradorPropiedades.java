
package ejemplo.cajero.properties;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Funcionalidad para leer el archivo de propiedades y determinar el valor que tiene una entrada.
 * 
 * @author Matthias Quaas
 * @author Kai Wolf
 */
public class AdministradorPropiedades {

	private static Properties propiedad = new Properties();

	private AdministradorPropiedades() {}

	static {
		try {
			File archivo = new File(IPropiedades.ARCHIVO_PROPIEDADES);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(IPropiedades.ARCHIVO_PROPIEDADES))) {
				propiedad.load(bis);
				System.out.println(propiedad.stringPropertyNames());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Devuelve el valor de una propiedad. Lanza excepción si no existe la propiedad o si su valor no es true o false.
	 * 
	 * @param propertyName
	 * @return Value of property.
	 */
	public static boolean getEntrada(String nombre) {

		if (propiedad.getProperty(nombre) == null) {
			System.err.println("La entrada '"
				+ nombre + "' solicitada no existe");
		}

		return Boolean.valueOf(propiedad.getProperty(nombre));

	}

}
