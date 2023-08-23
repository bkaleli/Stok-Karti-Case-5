package StokTipKartiNavigationCommands;

import Command.CommandIF;
import Entity.BaseEntity;
import Entity.StokTipKartEntity;
import Frame.StokTipKartiFrame;

public class StokTipKartiLastCommand implements CommandIF {

	private StokTipKartiFrame stokTipKartiFrame;

	public StokTipKartiLastCommand(StokTipKartiFrame stokTipKartiFrame) {
		super();
		this.stokTipKartiFrame = stokTipKartiFrame;
	}

	public void execute() {
		BaseEntity baseEntity = new StokTipKartEntity();
		
		baseEntity.sonVeri();
		
		StokTipKartEntity stokTipKartEntity = (StokTipKartEntity) baseEntity;
		
		stokTipKartiFrame.model = stokTipKartEntity;

		stokTipKartiFrame.modelDoldur(stokTipKartEntity);
		
	}
}
