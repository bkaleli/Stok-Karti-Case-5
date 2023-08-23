package StokKartiFileCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import Command.SingletonDbHelper;
import Frame.StokKartiFrame;

public class SetActionCommandForSilButton extends JFrame implements ActionListener{

	StokKartiFrame stokKartiFrame = null;
	
	public SetActionCommandForSilButton(StokKartiFrame stokKartiFrame) {
		setStokKartiFrame(stokKartiFrame);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		SingletonDbHelper helper = SingletonDbHelper.getInstance();
		
		String action = e.getActionCommand();
		
		String query3 = "select id from stok_dosya where (`stok_id` = ? and dosya_adi = ?)";
		String query4 = "delete from stok_dosya where id = ?";

		// veritabanından silme işlemi 
		
		try {
			PreparedStatement stmt = helper.con.prepareStatement(query3);    // burası verilere ait id yi almak için
			stmt.setInt(1, stokKartiFrame.getModel().getStokId());
			System.out.println(stokKartiFrame.getModel().getStokId());
			stmt.setString(2, action);		
			System.out.println(action);
			
			ResultSet rs = stmt.executeQuery();

			int id = 0;
			if (rs.next()) {
				id =  rs.getInt("id");
			}

			System.out.println(id);
			
			
			PreparedStatement stmt2 = helper.con.prepareStatement(query4);    // burası verilere ait id yi almak için
			stmt2.setInt(1, id);
			System.out.println(id);
			
			stmt2.executeUpdate();
			
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		// ftp dosyasından silme işlemi                     
		
		String host = "192.168.2.44";
		int port = 21;
		String userName = "ftp-user";
		String password = "12345";

		FTPClient ftpClient = new FTPClient();
		ftpClient.setControlEncoding("UTF-8"); //connect'ten once olmali

		try {
			ftpClient.connect(host, port);
			ftpClient.login(userName, password);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.setBufferSize(2048000);
			
			boolean s2 = ftpClient.isConnected();
			System.out.println("s2" + s2);
		
			String fileName = action;
			
			boolean s = ftpClient.deleteFile(fileName);
			System.out.println("s" + s);
			
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public StokKartiFrame getStokKartiFrame() {
		return stokKartiFrame;
	}
	public void setStokKartiFrame(StokKartiFrame stokKartiFrame) {
		this.stokKartiFrame = stokKartiFrame;
	}
	
}

