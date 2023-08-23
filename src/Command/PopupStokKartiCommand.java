package Command;

import javax.swing.table.DefaultTableModel;

import Entity.StokKartEntity;
import Frame.StokKartiListesiFrame;
import FrameCommand.StokKartiFrameCommand;


public class PopupStokKartiCommand {

	public void stokKartiDoldur(StokKartiListesiFrame stokKartiListesiFrame) {
		StokKartEntity stokKartEntity = new StokKartEntity();
				
		DefaultTableModel model = (DefaultTableModel) stokKartiListesiFrame.tbTable.getModel();
		int selectedRowIndex = stokKartiListesiFrame.tbTable.getSelectedRow();
		
		stokKartEntity.setStokKodu((String) model.getValueAt(selectedRowIndex, 0));
		stokKartEntity.setStokAdı((String) model.getValueAt(selectedRowIndex, 1));
		stokKartEntity.setStokTipi((Integer) model.getValueAt(selectedRowIndex, 2));
		stokKartEntity.setBirimi((String) model.getValueAt(selectedRowIndex, 3));
		stokKartEntity.setBarkodu((String) model.getValueAt(selectedRowIndex, 4));
		stokKartEntity.setKdvTipi((Double)model.getValueAt(selectedRowIndex, 5));
		stokKartEntity.setAcıklama((String) model.getValueAt(selectedRowIndex, 6));
		stokKartEntity.setOlusturmaTarihi((String) model.getValueAt(selectedRowIndex, 7));

		StokKartiFrameCommand stokKartiFrameCommand = new StokKartiFrameCommand(); 
		stokKartiFrameCommand.execute();
		
		stokKartiFrameCommand.stokKartiFrame.tfStokKodu.setText(stokKartEntity.getStokKodu());
		stokKartiFrameCommand.stokKartiFrame.tfStokAdı.setText(stokKartEntity.getStokAdı());
		stokKartiFrameCommand.stokKartiFrame.cbStokTipi.setSelectedItem(stokKartEntity.getStokTipi());
		stokKartiFrameCommand.stokKartiFrame.cbBirimi.setSelectedItem(stokKartEntity.getBirimi());
		stokKartiFrameCommand.stokKartiFrame.tfBarkodu.setText(stokKartEntity.getBarkodu());
		stokKartiFrameCommand.stokKartiFrame.cbKdvTipi.setSelectedItem(stokKartEntity.getKdvTipi());
		stokKartiFrameCommand.stokKartiFrame.taAciklama.setText(stokKartEntity.getAcıklama());
		stokKartiFrameCommand.stokKartiFrame.tfOlusturmaTarihi.setText(stokKartEntity.getOlusturmaTarihi());
	}
}
