package StokTipKartiNavigationCommands;

import Command.CommandIF;
import Entity.BaseEntity;
import Entity.StokTipKartEntity;
import Frame.StokTipKartiFrame;

public class StokTipKartiNextCommand implements CommandIF{
	
	private StokTipKartiFrame stokTipKartiFrame;

	public StokTipKartiNextCommand(StokTipKartiFrame stokTipKartiFrame) {
		super();
		this.stokTipKartiFrame = stokTipKartiFrame;
	}

	public void execute() {
		BaseEntity baseEntity = new StokTipKartEntity();
		
		StokTipKartEntity stokTipKartEntity = (StokTipKartEntity) baseEntity;
		
		stokTipKartEntity.setStKodu(stokTipKartiFrame.tfSTKodu.getText());
		
		baseEntity.ileri();
		
		stokTipKartiFrame.model = stokTipKartEntity;
		
		stokTipKartiFrame.modelDoldur(stokTipKartEntity);
		
	}
}
