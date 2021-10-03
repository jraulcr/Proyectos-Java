package com.ficheroImg.es;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class ReducirComprimirIMG {

	private final static Logger LOGGER = Logger.getLogger(ReducirComprimirIMG.class.getName());
	static int maxSize = 500;
	static File path = new File("C:\\Prueba\\");
	static long bytes = 100000;
	static float calidadCompresion = 0.80f;

	private static File calidadImg(File imagePath, String mimeType) {
		File file = imagePath;
		String contentType;
		try {

			long size = imagePath.length();

			if (size >= bytes) {
				BufferedImage image = ImageIO.read(imagePath);
				if (!mimeType.equals("image/jpeg")) {
					ImageIO.write(image, "jpg", imagePath);
					contentType = "image/jpeg";
				} else {
					contentType = mimeType;
				}

				Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByMIMEType(contentType);
				if (imageWriters.hasNext()) {
					FileOutputStream fos = new FileOutputStream(imagePath);
					ImageOutputStream ios = ImageIO.createImageOutputStream(fos);
					ImageWriter writer = imageWriters.next();
					writer.setOutput(ios);
					ImageWriteParam param = writer.getDefaultWriteParam();
					if (param.canWriteCompressed()) {
						param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
						param.setCompressionQuality(calidadCompresion);
					}
					writer.write(null, new IIOImage(image, null, null), param);
					ios.close();
					writer.dispose();
					fos.close();
					file = reducirImg(imagePath, contentType);
				}
			} else {
				return file;
			}
			LOGGER.info("¡Imagen comprimida! *********** " + file + "\r");

		} catch (Exception e) {
			LOGGER.severe("¡Fallo compresión imagen! " + e);
		}
		return file;
	}

	private static File reducirImg(File imagePath, String contentType) {
		File file = imagePath;
		BufferedImage img;
		try {
			img = ImageIO.read(file);
			int width = img.getWidth();
			int height = img.getHeight();
			int targetWidth;
			int targetHeight;

			if (width <= maxSize && height <= maxSize) {
				return file;
			} else if (width > height) {
				targetWidth = maxSize;
				targetHeight = targetWidth * height / width;
			} else {
				targetHeight = maxSize;
				targetWidth = targetHeight * width / height;
			}
			BufferedImage newImg = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
			newImg.getGraphics().drawImage(img.getScaledInstance(targetWidth, targetHeight, BufferedImage.SCALE_SMOOTH),
					0, 0, null);
			Iterator<ImageWriter> imageWriters = ImageIO.getImageWritersByMIMEType(contentType);
			if (imageWriters.hasNext()) {
				FileOutputStream fos = new FileOutputStream(file);
				ImageOutputStream ios = ImageIO.createImageOutputStream(fos);
				ImageWriter imageWriter = imageWriters.next();
				imageWriter.setOutput(ios);
				imageWriter.write(newImg);
				imageWriter.dispose();
				ios.close();
				fos.close();

				LOGGER.info("¡Imagen reducida! *********** " + file + "\r");
			}
		} catch (Exception e) {
			LOGGER.severe("¡Fallo reducción imagen! " + e);
		}
		return file;
	}

	private static File buscarImagen(File directorio) {
		String tipodeArchivo;
		try {
			File[] archivos = directorio.listFiles();
			for (File archivo : archivos) {
				if (archivo.getName() != null) {
					tipodeArchivo = Files.probeContentType(archivo.toPath());
					calidadImg(archivo, tipodeArchivo);
				}
			}
		} catch (Exception e) {
			LOGGER.severe("¡Imagen/es no encontrada/s! " + e);
		}
		return null;
	}

	public static void main(String[] args) {

		buscarImagen(path);

	}

}
