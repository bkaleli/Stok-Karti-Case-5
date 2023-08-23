package KdvTipKartiNavigationCommand;

import Command.CommandIF;
import Entity.BaseEntity;
import Entity.KdvTipKartEntity;
import Frame.KdvTipKartiFrame;

public class KdvTipKartiNextCommand implements CommandIF{
	private KdvTipKartiFrame kdvTipKartiFrame;

	public KdvTipKartiNextCommand(KdvTipKartiFrame kdvTipKartiFrame) {
		super();
		this.kdvTipKartiFrame = kdvTipKartiFrame;
	}

	public void execute() {
		BaseEntity baseEntity = new KdvTipKartEntity();
		
		KdvTipKartEntity kdvTipKartEntity = (KdvTipKartEntity) baseEntity;
		
		kdvTipKartEntity.setKtKodu(kdvTipKartiFrame.tfKTKodu.getText());
		
		kdvTipKartEntity.ileri();
		
		kdvTipKartiFrame.model = kdvTipKartEntity;
		
		kdvTipKartiFrame.modelDoldur(kdvTipKartEntity);

	}
}
