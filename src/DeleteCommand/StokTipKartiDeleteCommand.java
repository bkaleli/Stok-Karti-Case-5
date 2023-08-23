package DeleteCommand;

import Command.CommandIF;
import Frame.StokTipKartiFrame;

public class StokTipKartiDeleteCommand implements CommandIF {

	private StokTipKartiFrame stokTipKartiFrame;

	public StokTipKartiDeleteCommand(StokTipKartiFrame stokTipKartiFrame) {
		super();
		this.stokTipKartiFrame = stokTipKartiFrame;

	}

	@Override
	public void execute() {
		stokTipKartiFrame.model.delete();
	}
}
