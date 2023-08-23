package FrameCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import Command.ExcelCommand;
import Command.MailCommand;
import Command.PdfCommand;
import Command.PopupStokKartiCommand;
import Entity.StokKartiListeleEntity;
import Frame.MainFrame;
import Frame.StokKartiListesiFrame;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class StokKartiListesiFrameCommand {	
	private StokKartiListesiFrame stokKartiListesiFrame;

	public void execute() {
		// TODO Auto-generated method stub
		stokKartiListesiFrame = new StokKartiListesiFrame();
		MainFrame.desktopPane.add(stokKartiListesiFrame).setVisible(true);
		setListeners();
				
	}
	
	
	private void setListeners() {
		stokKartiListesiFrame.btnListele.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StokKartiListeleEntity stokKartiListeleEntity = new StokKartiListeleEntity();
				ArrayList<StokKartiListeleEntity> liste = new ArrayList<>();
				liste = stokKartiListeleEntity.listele(stokKartiListesiFrame);
				
				DefaultTableModel model = (DefaultTableModel) stokKartiListesiFrame.tbTable.getModel();
				for (StokKartiListeleEntity i : liste) {
					Object[] row = { i.getStokKodu(), i.getStokAdı(), i.getStokTipi(), i.getBirimi(), i.getBarkodu(),
							i.getKdvTipi(), i.getAcıklama(), i.getOlusturmaTarihi(), 
							i.getStKodu(), i.getStAdi(), i.getStAciklama(),
							i.getKtId(), i.getKtKodu(), i.getKtAdi()};
					model.addRow(row);

				}	
			}
		});
		
		stokKartiListesiFrame.pumnitmExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ExcelCommand excelCommand = new ExcelCommand();
					excelCommand.excel(stokKartiListesiFrame.tbTable);
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		stokKartiListesiFrame.pumnitmStokKarti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PopupStokKartiCommand popupStokKartiCommand = new PopupStokKartiCommand(); 
				popupStokKartiCommand.stokKartiDoldur(stokKartiListesiFrame);
			}
		});
		
		stokKartiListesiFrame.pumnitmPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PdfCommand pdfCommand = new PdfCommand();
				pdfCommand.pdfOnizleme(stokKartiListesiFrame.tbTable);
				
			}
		});
		
		stokKartiListesiFrame.pumnitmMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MailCommand mailCommand = new MailCommand();
				mailCommand.mailGonder(stokKartiListesiFrame.tbTable);
				
			}
		});
	}
	
}







