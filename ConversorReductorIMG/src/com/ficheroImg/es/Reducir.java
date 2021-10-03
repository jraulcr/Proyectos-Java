package com.ficheroImg.es;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

public class Reducir {
	
	private final static Logger LOGGER = Logger.getLogger(Reducir.class.getName());

	
	   public File reducir(File imagePath, String contentType) {
			FicheroImg maximoSize =  new FicheroImg();
			int maxSize = maximoSize.getMaxSize();			
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
	            newImg.getGraphics().drawImage(img.getScaledInstance(targetWidth, targetHeight, BufferedImage.SCALE_SMOOTH), 0, 0, null);
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
	        	LOGGER.severe("¡Fallo reducción. Imagen no encontrada! " + e);
	        	e.printStackTrace();
	        }
	        return file;
	    }
	   
	   
	   

}
