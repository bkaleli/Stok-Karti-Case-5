package StokKartiFileCommand;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import Command.SingletonDbHelper;
import Frame.StokKartiFrame;
import StokKartiFileCommand.StokKartiFileSaveCommand;

public class CreateDynamicallyFileComponent {

	public void CreateDynamicallyFileComponent(StokKartiFrame stokKartiFrame, int stokId) {

		SingletonDbHelper helper = SingletonDbHelper.getInstance();

		String query = "select count(id) from stok_dosya where stok_id = ?"; // 
		String query2 = "select dosya_adi, olusturma_zamani from stok_dosya where stok_id = ?";

		int count = 0;

		try {
			PreparedStatement stmt = helper.con.prepareStatement(query);
			stmt.setInt(1, stokId);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				count = rs.getInt("count(id)"); // stok dosya row sayısı
			}
			System.out.println(count);


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		stokKartiFrame.pnlDosyaFields.removeAll();

		if(count != 0) {
			GridBagConstraints gbc_tfDosyaAdi = new GridBagConstraints();
			gbc_tfDosyaAdi.insets = new Insets(0, 0, 5, 5);
			gbc_tfDosyaAdi.fill = GridBagConstraints.BOTH;
			gbc_tfDosyaAdi.gridx = 0;
			gbc_tfDosyaAdi.gridy = 0;

			GridBagConstraints gbc_tfDosyaTarihi = new GridBagConstraints();
			gbc_tfDosyaTarihi.insets = new Insets(0, 0, 5, 5);
			gbc_tfDosyaTarihi.fill = GridBagConstraints.BOTH;
			gbc_tfDosyaTarihi.gridx = 1;
			gbc_tfDosyaTarihi.gridy = 0;

			GridBagConstraints gbc_btnDosyaIndir = new GridBagConstraints();
			gbc_btnDosyaIndir.insets = new Insets(0, 0, 5, 5);
			gbc_btnDosyaIndir.gridx = 2;
			gbc_btnDosyaIndir.gridy = 0;

			GridBagConstraints gbc_btnDosyaAc = new GridBagConstraints();
			gbc_btnDosyaAc.insets = new Insets(0, 0, 5, 5);
			gbc_btnDosyaAc.gridx = 3;
			gbc_btnDosyaAc.gridy = 0;

			GridBagConstraints gbc_btnDosyaSil = new GridBagConstraints();
			gbc_btnDosyaSil.insets = new Insets(0, 0, 5, 5);
			gbc_btnDosyaSil.gridx = 4;
			gbc_btnDosyaSil.gridy = 0;

			for(int i= 0 ; i<count ; i++) {
				try {
					PreparedStatement stmt = helper.con.prepareStatement(query2);
					stmt.setInt(1, stokId);
					ResultSet rs = stmt.executeQuery();

					gbc_tfDosyaAdi.gridy = 0;     // burası y ekseninin sıfırlanması için
					gbc_tfDosyaTarihi.gridy = 0;
					gbc_btnDosyaIndir.gridy = 0;
					gbc_btnDosyaAc.gridy = 0;
					gbc_btnDosyaSil.gridy = 0;


					while(rs.next()) {                                                                            // button da set action command diye bişey var araştır

						stokKartiFrame.tfDosyaAdi = new JTextField();
						stokKartiFrame.tfDosyaAdi.setEditable(false);
						stokKartiFrame.pnlDosyaFields.add(stokKartiFrame.tfDosyaAdi, gbc_tfDosyaAdi);
						stokKartiFrame.tfDosyaAdi.setColumns(10);

						stokKartiFrame.tfDosyaTarihi = new JTextField();
						stokKartiFrame.tfDosyaTarihi.setEditable(false);
						stokKartiFrame.pnlDosyaFields.add(stokKartiFrame.tfDosyaTarihi, gbc_tfDosyaTarihi);
						stokKartiFrame.tfDosyaTarihi.setColumns(10);

						stokKartiFrame.tfDosyaAdi.setText(rs.getString("dosya_adi"));
						stokKartiFrame.tfDosyaTarihi.setText(rs.getString("olusturma_zamani"));
						
						JButton btnDosyaIndir = new JButton("İndir");
						stokKartiFrame.pnlDosyaFields.add(btnDosyaIndir, gbc_btnDosyaIndir);
						btnDosyaIndir.setActionCommand(rs.getString("dosya_adi"));
						btnDosyaIndir.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { 
								SetActionCommandForIndirButton setActionCommandForIndirButton = new SetActionCommandForIndirButton(stokKartiFrame);
								setActionCommandForIndirButton.actionPerformed(e);
							}
						});

						
						JButton btnDosyaAc = new JButton("Aç");
						stokKartiFrame.pnlDosyaFields.add(btnDosyaAc, gbc_btnDosyaAc);
						btnDosyaAc.setActionCommand(rs.getString("dosya_adi"));
						btnDosyaAc.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								SetActionCommandForAcButton setActionCommandForAcButton = new SetActionCommandForAcButton(stokKartiFrame);
								setActionCommandForAcButton.actionPerformed(e);
							}
							
						});
						
						
						
						/*
						stokKartiFrame.btnDosyaAc.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { 
								String host = "192.168.2.44";
								int port = 21;
								String userName = "ftp-user";
								String password = "12345";

								
								FTPClient ftpClient = new FTPClient();
								try{
									ftpClient.connect(host, port);
									ftpClient.login(userName, password);
									ftpClient.enterLocalPassiveMode();
									ftpClient.setFileType(FTP.BINARY_FILE_TYPE); 
									ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);

									String remoteFilePath = "C:/Users/Gökçe/Desktop/ftp/" + stokKartiFrame.tfDosyaAdi.getText();
									File remoteFile = new File(remoteFilePath);
									
									
									Desktop.getDesktop().open(remoteFile);
									
									
								}
								catch (Exception e1) {
									e1.printStackTrace();
								}

							}
						});
						*/
						

						JButton btnDosyaSil = new JButton("Sil");
						stokKartiFrame.pnlDosyaFields.add(btnDosyaSil, gbc_btnDosyaSil);
						btnDosyaSil.setActionCommand(rs.getString("dosya_adi"));
						btnDosyaSil.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								SetActionCommandForSilButton setActionCommandForSilButton = new SetActionCommandForSilButton(stokKartiFrame);
								setActionCommandForSilButton.actionPerformed(e);
							}
							
						});
						
						
						
						/*
						stokKartiFrame.btnDosyaSil.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) { 
								
								String query3 = "select id from stok_dosya where (`stok_id` = ? and dosya_adi = ?)";
								String query4 = "delete from stok_dosya where id = ?";

								// veritabanından silme işlemi 
								
								try {
									PreparedStatement stmt = helper.con.prepareStatement(query3);    // burası verilere ait id yi almak için
									stmt.setInt(1, stokId);
									System.out.println(stokId);
									stmt.setString(2, stokKartiFrame.tfDosyaAdi.getText());		
									System.out.println(stokKartiFrame.tfDosyaAdi.getText());
									
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
								
									String fileName = stokKartiFrame.tfDosyaAdi.getText();
									
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
						});
						*/
					
						gbc_tfDosyaAdi.gridy++;
						gbc_tfDosyaTarihi.gridy++;
						gbc_btnDosyaIndir.gridy++;
						gbc_btnDosyaAc.gridy++;
						gbc_btnDosyaSil.gridy++;
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			//			
			//			JScrollBar scrollBar = new JScrollBar();
			//			GridBagConstraints gbc_scrollBar = new GridBagConstraints();
			//			gbc_scrollBar.gridheight = gbc_tfDosyaAdi.gridy ; 
			//			gbc_scrollBar.gridx = 5;
			//			//gbc_scrollBar.gridy = 0;
			//			stokKartiFrame.pnlDosyaFields.add(scrollBar, gbc_scrollBar);
		}
	}
}