package DeleteCommand;

import Command.CommandIF;
import Frame.StokKartiFrame;

public class StokKartiDeleteCommand implements CommandIF{

	private StokKartiFrame stokKartiFrame;
	
	public StokKartiDeleteCommand(StokKartiFrame stokKartiFrame) {
		super();
		this.stokKartiFrame = stokKartiFrame;
	}


	@Override
	public void execute() {
		stokKartiFrame.model.delete();
		
	}
}
