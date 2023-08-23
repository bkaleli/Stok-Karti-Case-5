package KdvTipKartiNavigationCommand;

import Command.CommandIF;
import Entity.BaseEntity;
import Entity.KdvTipKartEntity;
import Frame.KdvTipKartiFrame;

public class KdvTipKartiLastCommand implements CommandIF{

	private KdvTipKartiFrame kdvTipKartiFrame;

	public KdvTipKartiLastCommand(KdvTipKartiFrame kdvTipKartiFrame) {
		super();
		this.kdvTipKartiFrame = kdvTipKartiFrame;
	}

	public void execute() {
		BaseEntity baseEntity = new KdvTipKartEntity();
				
		baseEntity.sonVeri();
		
		KdvTipKartEntity kdvTipKartEntity = (KdvTipKartEntity) baseEntity;
		
		kdvTipKartiFrame.model = kdvTipKartEntity;
		
		kdvTipKartiFrame.modelDoldur(kdvTipKartEntity);

	}
}
