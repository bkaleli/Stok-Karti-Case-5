package StokKartiFileCommand;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import Frame.StokKartiFrame;

public class SetActionCommandForAcButton extends JFrame implements ActionListener{

	public SetActionCommandForAcButton(StokKartiFrame stokKartiFrame) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String action = e.getActionCommand();
		String host = "192.168.2.44";
		int port = 21;
		String userName = "ftp-user";
		String password = "12345";

		String remoteFilePath = "C:/Users/Gökçe/Desktop/ftp/" + action;
		
		FTPClient ftpClient = new FTPClient();
		try{
			ftpClient.connect(host, port);
			ftpClient.login(userName, password);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE); 
			ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);

			File remoteFile = new File(remoteFilePath);
			Desktop.getDesktop().open(remoteFile);
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
