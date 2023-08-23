package StokKartiNavigationCommands;

import Command.CommandIF;
import Entity.BaseEntity;
import Entity.StokKartEntity;
import Frame.StokKartiFrame;


public class StokKartiFirstCommand implements CommandIF{
	private StokKartiFrame stokKartiFrame;

	public StokKartiFirstCommand(StokKartiFrame stokKartiFrame) {
		super();
		this.stokKartiFrame = stokKartiFrame;
	}

	public void execute() {
		
		BaseEntity baseEntity = new StokKartEntity();
					
		baseEntity.ilkVeri();
					
		StokKartEntity stokKartEntity = (StokKartEntity) baseEntity;
		
		stokKartiFrame.model = stokKartEntity; //CreateDynamicallyFileComponent için stokKartiFrame.model i set ettik

		stokKartiFrame.modelDoldur(stokKartEntity);
	}
	
	
}
