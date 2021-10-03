
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;


public class Main {
	
	//Para pruebas de resultados https://www.base64decode.net/base64-image-decoder

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String imagePath = "C:\\Prueba\\imagen.jpg";
		System.out.println("=================Encoder Image to Base 64!=================");
		encoder(imagePath);
		
		String base64ImageString = encoder(imagePath);
	//	System.out.println("Base64ImageString = " + base64ImageString);

		System.out.println("=================Decoder Base64ImageString to Image!=================");
		decoder(base64ImageString, "C:\\Prueba\\decoderimageBase64.jpg");

		System.out.println("DONE!");
		
	
		
		// Escribir el codigo en archivo txt
		
	//	Path originalPath = Paths.get("C:\\Prueba\\", "mail.txt");
		Path originalPath = Paths.get("C:\\Prueba\\", "imagen.jpg");
		Path targetPath = Paths.get("C:\\Prueba\\", "encodedIMG.txt");
		Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
		try(OutputStream output = Files.newOutputStream(targetPath)){
		    //Copy the encoded file content to target file
		    Files.copy(originalPath, mimeEncoder.wrap(output));
		    //Or simply use the encoded output stream
		    OutputStream encodedStrem = mimeEncoder.wrap(output);
		}
	}
	
	
//codifica
	public static String encoder(String imagePath) {
		String base64Image = "";
		File file = new File(imagePath);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
			System.out.println(base64Image);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
		return base64Image;
	}
	
//decodifica
	public static void decoder(String base64Image, String pathFile) {
		try (FileOutputStream imageOutFile = new FileOutputStream(pathFile)) {
			// Converting a Base64 String into Image byte array
			byte[] imageByteArray = Base64.getDecoder().decode(base64Image);
			imageOutFile.write(imageByteArray);
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException ioe) {
			System.out.println("Exception while reading the Image " + ioe);
		}
	}



	

	
	


}
