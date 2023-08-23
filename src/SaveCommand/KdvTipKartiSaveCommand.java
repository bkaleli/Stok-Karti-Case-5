package SaveCommand;

import Command.CommandIF;
import Frame.KdvTipKartiFrame;

public class KdvTipKartiSaveCommand implements CommandIF{
	private KdvTipKartiFrame kdvTipKartiFrame;


	public KdvTipKartiSaveCommand(KdvTipKartiFrame kdvTipKartiFrame) {
		super();
		this.kdvTipKartiFrame = kdvTipKartiFrame;
	
	}
	
	public void execute() {
		kdvTipKartiFrame.model.setKtKodu(kdvTipKartiFrame.tfKTKodu.getText());
		kdvTipKartiFrame.model.setKtAdi(kdvTipKartiFrame.tfKTAdi.getText());
		kdvTipKartiFrame.model.setKtOrani(Double.parseDouble(kdvTipKartiFrame.tfKTOrani.getText()));
		
		if(kdvTipKartiFrame.model.isRecorded()) {
			
			kdvTipKartiFrame.model.update();
		}
		else {
			
			kdvTipKartiFrame.model.save();
		}	
	}

}
