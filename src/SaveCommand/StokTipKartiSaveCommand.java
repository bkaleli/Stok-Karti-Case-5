package SaveCommand;

import Command.CommandIF;
import Frame.StokTipKartiFrame;

public class StokTipKartiSaveCommand implements CommandIF{
	private StokTipKartiFrame stokTipKartiFrame;


	public StokTipKartiSaveCommand(StokTipKartiFrame stokTipKartiFrame) {
		super();
		this.stokTipKartiFrame = stokTipKartiFrame;
	
	}
	
	public void execute() {
		stokTipKartiFrame.model.setStKodu(stokTipKartiFrame.tfSTKodu.getText());    
		stokTipKartiFrame.model.setStAdi(stokTipKartiFrame.tfSTAdi.getText());
		stokTipKartiFrame.model.setStAciklama(stokTipKartiFrame.tfSTAciklama.getText());  // modelde navigasyonlardan gelen bir veri var delete için ama burda onu kullanamayız, modeli componentteki verilerle set ettim
		
		if(stokTipKartiFrame.model.isRecorded()) {
			System.out.println("update");
			stokTipKartiFrame.model.update();	
		}
		else {
			System.out.println("save");
			stokTipKartiFrame.model.save();
		}		
	}
}
