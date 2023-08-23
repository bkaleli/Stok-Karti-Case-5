package Command;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JTable;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelCommand {
	public ExcelCommand() {
		super();
		
	}
	
	
	public void excel(JTable table) throws IOException, RowsExceededException, WriteException {
		File file = new File("/C:/Users/Gökçe/Desktop/StokKartListesi.xls");
		WritableWorkbook workbook = Workbook.createWorkbook(file);
		WritableSheet sheet = workbook.createSheet("Liste", 0);

		for(int i = 0; i < table.getColumnCount(); i++) {
			Label column = new Label(i, 0 , table.getColumnName(i));
			sheet.addCell(column);
		}
		
		for(int j = 0; j < table.getRowCount(); j++) {
			for(int k = 0; k < table.getColumnCount(); k++) {				
				try {
					Label row = new Label(k, j+1, table.getValueAt(j, k).toString());
					sheet.addCell(row);
				} catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (NullPointerException e) {  // burası eğer kayıtlı stok kartının kdv oranı, kdv tip kartlarında yoksa null döndürmesi için
					Label row = new Label(k, j+1, "null");
					sheet.addCell(row);
				}
			}
		}
		workbook.write();
		workbook.close();
		
		Desktop desktop = Desktop.getDesktop();
		desktop.open(file);
		
	}
}	

	