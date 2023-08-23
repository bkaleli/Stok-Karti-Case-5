package SaveCommand;

import Command.CommandIF;
import Frame.StokKartiFrame;

public class StokKartiSaveCommand implements CommandIF {
	private StokKartiFrame stokKartiFrame;
	
	public StokKartiSaveCommand(StokKartiFrame stokKartiFrame) {
		super();
		this.stokKartiFrame = stokKartiFrame;
	}
	
	public void execute() {
		
		stokKartiFrame.model.setStokKodu(stokKartiFrame.tfStokKodu.getText());
		stokKartiFrame.model.setStokAdı(stokKartiFrame.tfStokAdı.getText());
		stokKartiFrame.model.setStokTipi((int) stokKartiFrame.cbStokTipi.getSelectedItem());
		stokKartiFrame.model.setBirimi((String) stokKartiFrame.cbBirimi.getSelectedItem());
		stokKartiFrame.model.setBarkodu(stokKartiFrame.tfBarkodu.getText());
		stokKartiFrame.model.setKdvTipi(Double.valueOf((stokKartiFrame.cbKdvTipi.getSelectedItem()).toString()));
		stokKartiFrame.model.setAcıklama(stokKartiFrame.taAciklama.getText());
		stokKartiFrame.model.setOlusturmaTarihi(stokKartiFrame.tfOlusturmaTarihi.getText());
				
		if(stokKartiFrame.model.isRecorded()) {
			stokKartiFrame.model.update();
		}
		else {
			stokKartiFrame.model.save();
		}	
		
	}
}
