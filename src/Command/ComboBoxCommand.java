package Command;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Frame.StokKartiFrame;

public class ComboBoxCommand {
	
	
	
	// stok tipi combobox 
	public void comboBoxStokTipi(StokKartiFrame stokKartiFrame) {
		ArrayList<Integer> liste = new ArrayList<>();
		
		SingletonDbHelper helper = SingletonDbHelper.getInstance();
		
		try {
			Statement stmt = helper.con.createStatement();
			ResultSet rs = stmt.executeQuery("select stId from stoktipkart");
			
			while (rs.next()) {
				liste.add(rs.getInt("stId"));
				
			}
			
			for (int i: liste) {
				stokKartiFrame.cbStokTipi.addItem(i);

			}
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	// kdv tipi combobox
	public void comboBoxKdvTipi(StokKartiFrame stokKartiFrame) {
		ArrayList<Double> liste = new ArrayList<>();
		
		SingletonDbHelper helper = SingletonDbHelper.getInstance();
		
		try {
			Statement stmt = helper.con.createStatement();
			ResultSet rs = stmt.executeQuery("select ktOrani from kdvtipkart");
			
			while (rs.next()) {
				liste.add(rs.getDouble("ktOrani"));
				
			}
			
			for (double i: liste) {
				stokKartiFrame.cbKdvTipi.addItem(i);

			}
			stmt.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
