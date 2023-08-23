package StokKartiFileCommand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Date;

import javax.swing.JFileChooser;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import Entity.FileEntity;
import Frame.StokKartiFrame;

public class StokKartiFileSaveCommand{

	public void execute(StokKartiFrame stokKartiFrame) {
		JFileChooser fileChooser = new JFileChooser();
		int fileChooserResult = fileChooser.showSaveDialog(stokKartiFrame);
		
		if(fileChooserResult == JFileChooser.CANCEL_OPTION) {   // cancel a basınca hata vermeden kapanması için
			return;
		}else if (fileChooserResult == JFileChooser.APPROVE_OPTION) { 
			File file = new File(fileChooser.getSelectedFile().getAbsolutePath()); //seçilen dosya
			String dosyaYolu = fileChooser.getSelectedFile().getAbsolutePath();
			System.out.println(dosyaYolu);
			
			String dosyaAdi = file.getName();
			Date olusturmaZamani = new Date();
	
			System.out.println(olusturmaZamani);
			System.out.println(dosyaAdi);
			System.out.println(file);
	
			FileEntity fileEntity = new FileEntity();
	
			fileEntity.setStok_id(stokKartiFrame.getModel().getStokId());
			fileEntity.setDosya_adi(dosyaAdi);
			fileEntity.setOlusturma_zamani(olusturmaZamani);
	
			fileEntity.save(); // veri tabanına kaydetme
	
			// dosyayı ftp ile ftp klasörüne göndermeliyim 
	
		
			String host = "192.168.2.44";
			int port = 21;
			String userName = "ftp-user";
			String password = "12345";
			
			String remoteFilePath = "C:/Users/Gökçe/Desktop/ftp"; // ftp file
	        String localFilePath = fileChooser.getSelectedFile().getAbsolutePath(); //selected file
	        String selectedFileName = fileChooser.getSelectedFile().getName(); //selected file
	
			FTPClient ftpClient = new FTPClient();
			ftpClient.setControlEncoding("UTF-8"); //connect'ten once olmali
	
			try {
				
				ftpClient.connect(host, port);
				ftpClient.login(userName, password);
				ftpClient.enterLocalPassiveMode();
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				ftpClient.setBufferSize(2048000);
			
				System.out.println(ftpClient.isConnected());
				
				boolean s = ftpClient.changeWorkingDirectory(remoteFilePath);
				System.out.println("s " + s);
	
				File localFile = new File(localFilePath);
	            FileInputStream inputStream = new FileInputStream(localFile);
				
	            boolean s2 = ftpClient.storeFile(selectedFileName, inputStream);
				System.out.println("s2 " + s2);
	
	            
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
