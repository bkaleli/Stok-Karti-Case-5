package KdvTipKartiNavigationCommand;

import Command.CommandIF;
import Entity.BaseEntity;
import Entity.KdvTipKartEntity;
import Frame.KdvTipKartiFrame;

public class KdvTipKartiFirstCommand implements CommandIF{
	
	private KdvTipKartiFrame kdvTipKartiFrame;
	
	public KdvTipKartiFirstCommand(KdvTipKartiFrame kdvTipKartiFrame) {
		super();
		this.kdvTipKartiFrame = kdvTipKartiFrame;
	}

	public void execute() {
		BaseEntity baseEntity = new KdvTipKartEntity();
		
		baseEntity.ilkVeri();
		
		KdvTipKartEntity kdvTipKartEntity = (KdvTipKartEntity) baseEntity;
		
		kdvTipKartiFrame.model = kdvTipKartEntity;
		
		kdvTipKartiFrame.modelDoldur(kdvTipKartEntity);
		
	}
}
