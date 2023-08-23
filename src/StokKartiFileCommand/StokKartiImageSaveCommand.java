package StokKartiFileCommand;

import java.io.File;

import javax.swing.JFileChooser;

import Command.CommandIF;
import Entity.FileEntity;

public class StokKartiImageSaveCommand implements CommandIF{

	@Override
	public void execute() {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showSaveDialog(null);
		
		
	}
}
