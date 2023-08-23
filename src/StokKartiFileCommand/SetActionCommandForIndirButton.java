package StokKartiFileCommand;

import java.awt.Desktop;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import Frame.StokKartiFrame;

public class SetActionCommandForIndirButton extends JFrame implements ActionListener{

	String dosya_adi = null;
	StokKartiFrame stokKartiFrame = null;

	public SetActionCommandForIndirButton(StokKartiFrame stokKartiFrame) {		
		setStokKartiFrame(stokKartiFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String action = e.getActionCommand();
		String host = "192.168.2.44";
		int port = 21;
		String userName = "ftp-user";
		String password = "12345";

		String remoteFilePath = "C:/Users/Gökçe/Desktop/ftp/" + action; //    c:/ koyulunca da oluyor, neden? 
		System.out.println("Dosya Adi: ");
		System.out.println(action);
		FTPClient ftpClient = new FTPClient();
		try{
			ftpClient.connect(host, port);
			ftpClient.login(userName, password);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE); 
			ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);

			JFileChooser fileChooser = new JFileChooser();
			//fileChooser.setSelectedFile(new File(stokKartiFrame.tfDosyaAdi.getText()));

			int fileChooserResult = fileChooser.showSaveDialog(stokKartiFrame);

			if (fileChooserResult == JFileChooser.CANCEL_OPTION) {  //dosya ekleye de ekle 
				return;
			} else if (fileChooserResult == JFileChooser.APPROVE_OPTION) {
				System.out.println(fileChooser.getSelectedFile().getPath());

				File downloadFile = fileChooser.getSelectedFile();

				OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(downloadFile));
				boolean successDownload = ftpClient.retrieveFile(action, outputStream);

				System.out.println("remoteFilePath = " + remoteFilePath);
				outputStream.close();

				if (successDownload) {
					System.out.println("File #1 has been downloaded successfully.");
				}
				Desktop.getDesktop().open(downloadFile);
			}
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}



	public void setDosya_adi(String dosya_adi) {
		this.dosya_adi = dosya_adi;
	}

	public StokKartiFrame getStokKartiFrame() {
		return stokKartiFrame;
	}

	public void setStokKartiFrame(StokKartiFrame stokKartiFrame) {
		this.stokKartiFrame = stokKartiFrame;
	}


}
