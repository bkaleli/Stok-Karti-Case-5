package FrameCommand;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Frame.MainFrame;


public class MainFrameCommandProject5{
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame mainFrame = new MainFrame();
					mainFrame.mnitmStokKarti.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							StokKartiFrameCommand stokKartiFrameCommand = new StokKartiFrameCommand();
							stokKartiFrameCommand.execute();
							
						}
					});	
					
					mainFrame.mnitmStokTipKarti.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							StokTipKartiFrameCommand stokTipKartiFrameCommand = new StokTipKartiFrameCommand();
							stokTipKartiFrameCommand.execute();
							
						}
					});	
					
					mainFrame.mnitmKdvTipKarti.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							KdvTipKartiFrameCommand kdvTipKartiFrameCommand = new KdvTipKartiFrameCommand();
							kdvTipKartiFrameCommand.execute();
							
						}
					});	
					
					mainFrame.mnitmStokKartiListesi.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							StokKartiListesiFrameCommand stokKartiListesiFrameCommand = new StokKartiListesiFrameCommand();
							stokKartiListesiFrameCommand.execute();

						}
					});	
			
					mainFrame.setVisible(true);

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
}
