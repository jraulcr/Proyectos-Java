package com.ficheroImg.es;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream; 

public class Comprimir {

	private final static Logger LOGGER = Logger.getLogger(Reducir.class.getName());
	
	public File comprimirImg(File imagePath, String mimeType) {
		File file = imagePath;
		String contentType;
		try {
			long size = imagePath.length();
			FicheroImg bytes = new FicheroImg();

			if (size >= bytes.getBytes()) {
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
						FicheroImg calidadCompresion = new FicheroImg();
						param.setCompressionQuality(calidadCompresion.getCompressionQuality());
					}
					writer.write(null, new IIOImage(image, null, null), param);
					ios.close();
					writer.dispose();
					fos.close();
					Reducir reducirImg = new Reducir();
					file = reducirImg.reducir(imagePath, contentType);
				}
			} else {
				return file;
			}
			LOGGER.info("¡Imagen comprimida! *********** " + file + "\r");

		} catch (Exception e) {
			LOGGER.severe("¡Fallo compresión imagen! " + e);
			e.printStackTrace();
		}
		return file;
	}
	
}
