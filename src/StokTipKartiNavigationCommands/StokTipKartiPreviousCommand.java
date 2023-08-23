package StokTipKartiNavigationCommands;

import Command.CommandIF;
import Entity.BaseEntity;
import Entity.StokTipKartEntity;
import Frame.StokTipKartiFrame;

public class StokTipKartiPreviousCommand implements CommandIF{
	private StokTipKartiFrame stokTipKartiFrame;

	public StokTipKartiPreviousCommand(StokTipKartiFrame stokTipKartiFrame) {
		super();
		this.stokTipKartiFrame = stokTipKartiFrame;
	}

	public void execute() {
		BaseEntity baseEntity = new StokTipKartEntity();
		
		StokTipKartEntity stokTipKartEntity = (StokTipKartEntity) baseEntity;
		
		stokTipKartEntity.setStKodu(stokTipKartiFrame.tfSTKodu.getText());

		baseEntity.geri();
		
		stokTipKartiFrame.model = stokTipKartEntity;

		stokTipKartiFrame.modelDoldur(stokTipKartEntity);
		
	}
}
