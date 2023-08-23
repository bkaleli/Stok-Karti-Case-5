package FrameCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DeleteCommand.KdvTipKartiDeleteCommand;
import Frame.KdvTipKartiFrame;
import Frame.MainFrame;
import KdvTipKartiNavigationCommand.KdvTipKartiFirstCommand;
import KdvTipKartiNavigationCommand.KdvTipKartiLastCommand;
import KdvTipKartiNavigationCommand.KdvTipKartiNextCommand;
import KdvTipKartiNavigationCommand.KdvTipKartiPreviousCommand;
import SaveCommand.KdvTipKartiSaveCommand;


public class KdvTipKartiFrameCommand {
	public KdvTipKartiFrame kdvTipKartiFrame;

	public void execute() {
		// TODO Auto-generated method stub
		
		kdvTipKartiFrame = new KdvTipKartiFrame();
		MainFrame.desktopPane.add(kdvTipKartiFrame).setVisible(true);
		
		setListeners();
	}

	private void setListeners() {
		kdvTipKartiFrame.btnKTKaydet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KdvTipKartiSaveCommand saveCommand = new KdvTipKartiSaveCommand(kdvTipKartiFrame);
				if(kdvTipKartiFrame.model.getKtKodu().equals(kdvTipKartiFrame.tfKTKodu.getText())) {     //bu if bloğu eğer stkodu kayıtlıysa update değilse recorded ı false yapıp save etmesi için 
					saveCommand.execute();
				}else {
					kdvTipKartiFrame.model.setRecorded(false);
					saveCommand.execute();
				}
			}
		});
		
		kdvTipKartiFrame.btnKTSil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KdvTipKartiDeleteCommand deleteCommand = new KdvTipKartiDeleteCommand(kdvTipKartiFrame);
				deleteCommand.execute();
				
			}	
		});
		
		kdvTipKartiFrame.btnKTIlk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KdvTipKartiFirstCommand firstCommand = new KdvTipKartiFirstCommand(kdvTipKartiFrame);
				firstCommand.execute();
				
			}	
		});
		
		kdvTipKartiFrame.btnKTSon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KdvTipKartiLastCommand lastCommand = new KdvTipKartiLastCommand(kdvTipKartiFrame);
				lastCommand.execute();
				
			}	
		});
		
		kdvTipKartiFrame.btnKTIleri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KdvTipKartiNextCommand nextCommand = new KdvTipKartiNextCommand(kdvTipKartiFrame);
				nextCommand.execute();
				
			}	
		});
		
		kdvTipKartiFrame.btnKTGeri.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KdvTipKartiPreviousCommand previousCommand = new KdvTipKartiPreviousCommand(kdvTipKartiFrame);
				previousCommand.execute();
				
			}	
		});
	}
}
