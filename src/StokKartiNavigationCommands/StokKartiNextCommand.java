package StokKartiNavigationCommands;

import Command.CommandIF;
import Entity.BaseEntity;
import Entity.StokKartEntity;
import Frame.StokKartiFrame;

public class StokKartiNextCommand implements CommandIF{

	private StokKartiFrame stokKartiFrame;

	public StokKartiNextCommand(StokKartiFrame stokKartiFrame) {
		super();
		this.stokKartiFrame = stokKartiFrame;
	}

	public void execute() {

		BaseEntity baseEntity = new StokKartEntity();

		StokKartEntity stokKartEntity = (StokKartEntity) baseEntity;
		
		stokKartEntity.setStokKodu(stokKartiFrame.tfStokKodu.getText());

		stokKartEntity.ileri();

		stokKartiFrame.model = stokKartEntity; //CreateDynamicallyFileComponent için stokKartiFrame.model i set ettik
		
		stokKartiFrame.modelDoldur(stokKartEntity);

	}
}
