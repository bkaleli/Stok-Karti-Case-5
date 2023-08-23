package KdvTipKartiNavigationCommand;

import Command.CommandIF;
import Entity.BaseEntity;
import Entity.KdvTipKartEntity;
import Frame.KdvTipKartiFrame;

public class KdvTipKartiPreviousCommand implements CommandIF{
	
	private KdvTipKartiFrame kdvTipKartiFrame;

	public KdvTipKartiPreviousCommand(KdvTipKartiFrame kdvTipKartiFrame) {
		super();
		this.kdvTipKartiFrame = kdvTipKartiFrame;
	}

	public void execute() {
		BaseEntity baseEntity = new KdvTipKartEntity();
		
		KdvTipKartEntity kdvTipKartEntity = (KdvTipKartEntity) baseEntity;
		
		kdvTipKartEntity.setKtKodu(kdvTipKartiFrame.tfKTKodu.getText());
		
		kdvTipKartEntity.geri();
		
		kdvTipKartiFrame.model = kdvTipKartEntity;
		
		kdvTipKartiFrame.modelDoldur(kdvTipKartEntity);

	}
}
