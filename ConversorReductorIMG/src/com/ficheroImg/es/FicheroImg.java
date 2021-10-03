
package com.ficheroImg.es;

import java.io.File;


public class FicheroImg {
	
	private int maxSize = 500;
	private File pathFile = new File("C:\\Prueba\\");
	private float compressionQuality = 0.85f;	
	private long bytes = 100000;
	
	public FicheroImg() {}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public File getPathFile() {
		return pathFile;
	}

	public void setPathFile(File pathFile) {
		this.pathFile = pathFile;
	}

	public float getCompressionQuality() {
		return compressionQuality;
	}

	public void setCompressionQuality(float compressionQuality) {
		this.compressionQuality = compressionQuality;
	}

	public long getBytes() {
		return bytes;
	}

	public void setBytes(long bytes) {
		this.bytes = bytes;
	}
}
