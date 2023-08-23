package FrameCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DeleteCommand.StokTipKartiDeleteCommand;
import Frame.MainFrame;
import Frame.StokTipKartiFrame;
import SaveCommand.StokTipKartiSaveCommand;
import StokTipKartiNavigationCommands.StokTipKartiFirstCommand;
import StokTipKartiNavigationCommands.StokTipKartiLastCommand;
import StokTipKartiNavigationCommands.StokTipKartiNextCommand;
import StokTipKartiNavigationCommands.StokTipKartiPreviousCommand;


public class StokTipKartiFrameCommand {
	private StokTipKartiFrame stokTipKartiFrame;
	
	public void execute() {
		// TODO Auto-generated method stub

		stokTipKartiFrame = new StokTipKartiFrame();
		MainFrame.desktopPane.add(stokTipKartiFrame).setVisible(true);
		
		setListeners();
	}

	private void setListeners() {
		stokTipKartiFrame.btnSTKaydet.addActionListener(new ActionListener() {
			// buraya focus listener ekle eğer kayıt varsa yeni model çağırıp execute çağır yoksa saddece execute çağır
			@Override
			public void actionPerformed(ActionEvent e) {
				StokTipKartiSaveCommand saveCommand = new StokTipKartiSaveCommand(stokTipKartiFrame);
				if(stokTipKartiFrame.model.getStKodu().equals(stokTipKartiFrame.tfSTKodu.getText())) {     //bu if bloğu eğer stkodu kayıtlıysa update değilse recorded ı false yapıp save etmesi için 
					saveCommand.execute();
				}else {
					stokTipKartiFrame.model.setRecorded(false);
					saveCommand.execute();
				}
				
			}
			
		});
		
		stokTipKartiFrame.btnSTSil.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StokTipKartiDeleteCommand deleteCommand = new StokTipKartiDeleteCommand(stokTipKartiFrame);
				deleteCommand.execute();
			}
			
		});
		
		stokTipKartiFrame.btnSTIlk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StokTipKartiFirstCommand firstCommand = new StokTipKartiFirstCommand(stokTipKartiFrame);
				firstCommand.execute();
			}
			
		});
		
		stokTipKartiFrame.btnSTSon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StokTipKartiLastCommand lastCommand = new StokTipKartiLastCommand(stokTipKartiFrame);
				lastCommand.execute();
			}
			
		});
		
		stokTipKartiFrame.btnSTIleri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StokTipKartiNextCommand nextCommand = new StokTipKartiNextCommand(stokTipKartiFrame);
				nextCommand.execute();
			}
			
		});
		
		stokTipKartiFrame.btnSTGeri.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StokTipKartiPreviousCommand previousCommand = new StokTipKartiPreviousCommand(stokTipKartiFrame);
				previousCommand.execute();
			}
			
		});
	
		
	}
}
