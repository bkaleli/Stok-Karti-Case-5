package FrameCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Command.ComboBoxCommand;
import DeleteCommand.StokKartiDeleteCommand;
import Entity.StokKartEntity;
import Frame.MainFrame;
import Frame.StokKartiFrame;
import SaveCommand.StokKartiSaveCommand;
import StokKartiFileCommand.CreateDynamicallyFileComponent;
import StokKartiFileCommand.StokKartiFileSaveCommand;
import StokKartiFileCommand.StokKartiImageSaveCommand;
import StokKartiNavigationCommands.StokKartiFirstCommand;
import StokKartiNavigationCommands.StokKartiLastCommand;
import StokKartiNavigationCommands.StokKartiNextCommand;
import StokKartiNavigationCommands.StokKartiPreviousCommand;


public class StokKartiFrameCommand {
	public StokKartiFrame stokKartiFrame;
	
	public void execute() {
		// TODO Auto-generated method stub
		
		
		stokKartiFrame = new StokKartiFrame();
		MainFrame.desktopPane.add(stokKartiFrame).setVisible(true);
		
		ComboBoxCommand comboBoxCommandler = new ComboBoxCommand();
		comboBoxCommandler.comboBoxStokTipi(stokKartiFrame);
		comboBoxCommandler.comboBoxKdvTipi(stokKartiFrame);
		
		setListeners();
			
	}
	
	private void setListeners() {
		stokKartiFrame.btnKaydet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StokKartiSaveCommand saveCommand = new StokKartiSaveCommand(stokKartiFrame);
				
				if(stokKartiFrame.model.getStokKodu().equals(stokKartiFrame.tfStokKodu.getText())) {     //bu if bloğu eğer stokkodu kayıtlıysa update değilse recorded ı false yapıp save etmesi için 
					saveCommand.execute();
				}else {
					stokKartiFrame.model.setRecorded(false);
					saveCommand.execute();
				}
			}
		});
		
		stokKartiFrame.btnSil.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StokKartiDeleteCommand deleteCommand = new StokKartiDeleteCommand(stokKartiFrame);
				deleteCommand.execute();
			}
		});
		
		stokKartiFrame.btnIlk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StokKartiFirstCommand firstCommand = new StokKartiFirstCommand(stokKartiFrame);
				firstCommand.execute();
				
				CreateDynamicallyFileComponent createDynamicallyFileComponent = new CreateDynamicallyFileComponent();
				createDynamicallyFileComponent.CreateDynamicallyFileComponent(stokKartiFrame, stokKartiFrame.getModel().getStokId());
			}
			
		});
		
		stokKartiFrame.btnSon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StokKartiLastCommand lastCommand = new StokKartiLastCommand(stokKartiFrame);
				lastCommand.execute();
				CreateDynamicallyFileComponent createDynamicallyFileComponent = new CreateDynamicallyFileComponent();
				createDynamicallyFileComponent.CreateDynamicallyFileComponent(stokKartiFrame, stokKartiFrame.getModel().getStokId());
			}
			
		});
		
		stokKartiFrame.btnIleri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StokKartiNextCommand nextCommand = new StokKartiNextCommand(stokKartiFrame);
				nextCommand.execute();
				CreateDynamicallyFileComponent createDynamicallyFileComponent = new CreateDynamicallyFileComponent();
				createDynamicallyFileComponent.CreateDynamicallyFileComponent(stokKartiFrame, stokKartiFrame.getModel().getStokId());
			}
			
		});
		
		stokKartiFrame.btnGeri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StokKartiPreviousCommand previousCommand = new StokKartiPreviousCommand(stokKartiFrame);
				previousCommand.execute();
				CreateDynamicallyFileComponent createDynamicallyFileComponent = new CreateDynamicallyFileComponent();
				createDynamicallyFileComponent.CreateDynamicallyFileComponent(stokKartiFrame, stokKartiFrame.getModel().getStokId());
			}
			
		});
		
		stokKartiFrame.tfStokKodu.addActionListener(new ActionListener() {    //stok kodu textfield da enter a bastığında bilgiler componentlerde gözükecek
			@Override
			public void actionPerformed(ActionEvent e) {
				String kod = stokKartiFrame.tfStokKodu.getText();
				StokKartEntity stokKartEntity = new StokKartEntity();
				stokKartEntity = stokKartEntity.setEntity(kod);
//				StokKartEntity.setEntity(kod);         // setEntity static yapılmalı 
				stokKartiFrame.modelDoldur(stokKartEntity);  //modelDoldur(StokKartEntity.setEntity(kod))
				
				stokKartiFrame.model = stokKartEntity;  // createDinamicallyFileComponent i kullanmak için StokKartFrame.model i set edilen StokKartEntity ye eşitledim 
				CreateDynamicallyFileComponent createDynamicallyFileComponent = new CreateDynamicallyFileComponent();
				createDynamicallyFileComponent.CreateDynamicallyFileComponent(stokKartiFrame, stokKartiFrame.getModel().getStokId());
			}
		});
		
		stokKartiFrame.btnDDosyaEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				StokKartiFileSaveCommand stokKartiFileSaveCommand = new StokKartiFileSaveCommand();
				stokKartiFileSaveCommand.execute(stokKartiFrame);
			}
		});
		
		stokKartiFrame.btnRDosyaEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				StokKartiImageSaveCommand stokKartiImageSaveCommand = new StokKartiImageSaveCommand();
				stokKartiImageSaveCommand.execute();
				
			}
		});
		
		/*stokKartiFrame.tfStokKodu.addFocusListener(new FocusAdapter() {    //stok kodu textfield da enter a bastığında bilgiler componentlerde gözükecek
			@Override
			public void focusLost(FocusEvent arg0) {
				StokKartEntity stokKartEntity = new StokKartEntity();
				stokKartEntity.doldur(stokKartiFrame);
			}
		});*/
	}
}
