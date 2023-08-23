package Command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JTable;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;


public class MailCommand {

	public void mailGonder(JTable table) {
		
		
		//jasper dosyası oluşturup pdf e dönüştürme kısmı 
		
		String inputFile = "C:/Users/Gökçe/Desktop/stokKartListesi.jrxml";
		
		Collection<Map<String, Object>> liste = new ArrayList<>();

		for(int j = 0; j < table.getRowCount(); j++) {
			Map<String, Object> row = new HashMap<>();
			
			row.put("stokKodu", table.getValueAt(j, 0).toString());
			row.put("stokAdi", table.getValueAt(j, 1).toString());
			row.put("stokTipi", Integer.valueOf(table.getValueAt(j, 2).toString()));
			row.put("birimi", table.getValueAt(j, 3).toString());
			row.put("barkodu", table.getValueAt(j, 4).toString());
			row.put("kdvTipi", Double.valueOf(table.getValueAt(j, 5).toString()));
			row.put("aciklama", table.getValueAt(j, 6).toString());
			row.put("olusturmaTarihi", table.getValueAt(j, 7).toString());

			
			row.put("stKodu", table.getValueAt(j, 8).toString());
			row.put("stAdi", table.getValueAt(j, 9).toString());
			row.put("stAciklama", table.getValueAt(j, 10).toString());
			
			row.put("ktId", Integer.valueOf(table.getValueAt(j, 11).toString()));
			row.put("ktKodu", table.getValueAt(j, 12).toString());
			row.put("ktAdi", table.getValueAt(j, 13).toString());
			
			liste.add(row);
		}
		
		JRMapCollectionDataSource JRMap = new JRMapCollectionDataSource(liste);
		
		try {
			JasperReport report = JasperCompileManager.compileReport(inputFile);
			
			JasperPrint print = JasperFillManager.fillReport(report, null, JRMap);
			
			//JasperViewer.viewReport(print);
			
			JasperExportManager.exportReportToPdfFile(print, "C://Users/Gökçe/Desktop/StokKartListesi.pdf");      //iText.jar kullandım
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		
		//pdf i mail gönderme kısmı 
		
		
		
		final String userName = "bkaleli3460@gmail.com";
		final String password = "rekpsllokwdwldab";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		
		
		Session session = Session.getInstance(prop, 
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(userName, password);
					}
			
				});
				
		
		try {
			Message mess = new MimeMessage(session);
			mess.setFrom(new InternetAddress("bekaleli@hotmail.com"));
			mess.setRecipients(Message.RecipientType.TO ,  InternetAddress.parse("bekaleli@hotmail.com"));
			mess.setSubject("Stok Kart Listesi Pdf");
			
			Multipart multipart = new MimeMultipart();
			
			MimeBodyPart bodyPart = new MimeBodyPart();
			FileDataSource fileDataSource = new FileDataSource("C:/Users/Gökçe/Desktop/StokKartListesi.pdf");
			bodyPart.setDataHandler(new DataHandler(fileDataSource));
			bodyPart.setFileName(fileDataSource.getName());
			multipart.addBodyPart(bodyPart);
			
			mess.setContent(multipart);
			
			Transport.send(mess);
		
		
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}


