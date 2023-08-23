package StokTipKartiNavigationCommands;

import Command.CommandIF;
import Entity.BaseEntity;
import Entity.StokTipKartEntity;
import Frame.StokTipKartiFrame;

public class StokTipKartiFirstCommand implements CommandIF{
	
	private StokTipKartiFrame stokTipKartiFrame;

	public StokTipKartiFirstCommand(StokTipKartiFrame stokTipKartiFrame) {
		super();
		this.stokTipKartiFrame = stokTipKartiFrame;
	}

	public void execute() {
		BaseEntity baseEntity = new StokTipKartEntity();
		
		baseEntity.ilkVeri();
		
		StokTipKartEntity stokTipKartEntity = (StokTipKartEntity) baseEntity;
		
		stokTipKartiFrame.model = stokTipKartEntity;
		
		stokTipKartiFrame.modelDoldur(stokTipKartEntity);
		
	}

}
