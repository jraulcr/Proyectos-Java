package com.ficheroImg.es;

import java.io.File;
import java.nio.file.Files;
import java.util.logging.Logger;

public class BuscarPath {
	
	private final static Logger LOGGER = Logger.getLogger(Reducir.class.getName());

	
	public File buscarImagen(File directorio) {
		String tipodeArchivo;
		try {
			File[] archivos = directorio.listFiles();
			for (File archivo : archivos) {
				if (archivo!=null && archivo.getName() != null) {
					tipodeArchivo = Files.probeContentType(archivo.toPath());
					Comprimir com = new Comprimir();
					if(tipodeArchivo!=null) {
						com.comprimirImg(archivo, tipodeArchivo);
					}
				}
			}
		} catch (Exception e) {
			LOGGER.severe("¡Imagen/es no encontrada/s! " + e);
			e.printStackTrace();
		}
		return null;
	}
}
