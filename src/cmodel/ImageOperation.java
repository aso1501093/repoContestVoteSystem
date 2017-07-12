package cmodel;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.codec.binary.Base64;

public class ImageOperation {

	public String convertBlobToBase64(InputStream is){
		
		BufferedInputStream bis = new BufferedInputStream(is);
		try {
			BufferedImage img=ImageIO.read(bis);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        BufferedOutputStream bos = new BufferedOutputStream(baos);
	        img.flush();

	        // 読み終わった画像をバイト出力へ。
	        ImageIO.write(img, "jpg", bos);
	        bos.flush();
	        bos.close();
	        byte[] bImage = baos.toByteArray();

	        // バイト配列→BASE64へ変換する
	        Base64 base64 = new Base64();
	        byte[] encoded = base64.encode(bImage);
	        String  base64Image = new String(encoded);
	        System.out.println("base64Image  "+base64Image);
	        System.out.println("base64Image 長さ"+base64Image.length());
	        return base64Image;
	    

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		
		
		return null;
	}
	
	
}
