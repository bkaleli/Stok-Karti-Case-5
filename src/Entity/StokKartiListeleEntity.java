package Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Command.SingletonDbHelper;
import Frame.StokKartiListesiFrame;



public class StokKartiListeleEntity {
	
	private String stokKodu;
	private String stokAdı;
	private int stokTipi;
	private String birimi;
	private String barkodu;
	private double kdvTipi;
	private String acıklama;
	private String olusturmaTarihi;
	
	private int stId;
	private String stKodu;
	private String stAdi;
	private String stAciklama;
	
	private int ktId;
	private String ktKodu;
	private String ktAdi;
	private double ktOrani;
	
	
	
	
	public StokKartiListeleEntity(String stokKodu, String stokAdı, int stokTipi, String birimi, String barkodu, double kdvTipi,
			String acıklama, String olusturmaTarihi, int stId, String stKodu, String stAdi, String stAciklama, int ktId,
			String ktKodu, String ktAdi, double ktOrani) {
		super();
		this.stokKodu = stokKodu;
		this.stokAdı = stokAdı;
		this.stokTipi = stokTipi;
		this.birimi = birimi;
		this.barkodu = barkodu;
		this.kdvTipi = kdvTipi;
		this.acıklama = acıklama;
		this.olusturmaTarihi = olusturmaTarihi;
		this.stId = stId;
		this.stKodu = stKodu;
		this.stAdi = stAdi;
		this.stAciklama = stAciklama;
		this.ktId = ktId;
		this.ktKodu = ktKodu;
		this.ktAdi = ktAdi;
		this.ktOrani = ktOrani;
		
		
	}
	

	
	
	public StokKartiListeleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




// listele butonu için bir liste döndürmeli 
	
	public ArrayList<StokKartiListeleEntity> listele(StokKartiListesiFrame stokKartiListesiFrame) {
		ArrayList<StokKartiListeleEntity> liste = new ArrayList<>();

		SingletonDbHelper helper = SingletonDbHelper.getInstance();

		try {
			Statement stmt = helper.con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from stokkart left join stoktipkart on stokkart.stokTipi = stoktipkart.stId left join kdvtipkart on stokkart.kdvTipi = kdvtipkart.ktOrani;");
			while (rs.next()) {
				liste.add(new StokKartiListeleEntity(rs.getString("stokKodu"),rs.getString("stokAdı"),rs.getInt("stokTipi"),rs.getString("birimi"),rs.getString("barkodu"),rs.getDouble("kdvTipi"),rs.getString("acıklama"),rs.getString("olusturmaTarihi"),rs.getInt("stId"), rs.getString("stKodu"), rs.getString("stAdi"), rs.getString("stAciklama"),rs.getInt("ktId"),rs.getString("ktKodu"),rs.getString("ktAdi"),rs.getDouble("ktOrani")));
			
			}
			
			
			stmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}	
		
		return liste;
	}
		
		


	

	public String getStokKodu() {
		return stokKodu;
	}




	public void setStokKodu(String stokKodu) {
		this.stokKodu = stokKodu;
	}




	public String getStokAdı() {
		return stokAdı;
	}




	public void setStokAdı(String stokAdı) {
		this.stokAdı = stokAdı;
	}




	public int getStokTipi() {
		return stokTipi;
	}




	public void setStokTipi(int stokTipi) {
		this.stokTipi = stokTipi;
	}




	public String getBirimi() {
		return birimi;
	}




	public void setBirimi(String birimi) {
		this.birimi = birimi;
	}




	public String getBarkodu() {
		return barkodu;
	}




	public void setBarkodu(String barkodu) {
		this.barkodu = barkodu;
	}




	public double getKdvTipi() {
		return kdvTipi;
	}




	public void setKdvTipi(double kdvTipi) {
		this.kdvTipi = kdvTipi;
	}




	public String getAcıklama() {
		return acıklama;
	}




	public void setAcıklama(String acıklama) {
		this.acıklama = acıklama;
	}




	public String getOlusturmaTarihi() {
		return olusturmaTarihi;
	}




	public void setOlusturmaTarihi(String olusturmaTarihi) {
		this.olusturmaTarihi = olusturmaTarihi;
	}




	public int getStId() {
		return stId;
	}




	public void setStId(int stId) {
		this.stId = stId;
	}




	public String getStKodu() {
		return stKodu;
	}




	public void setStKodu(String stKodu) {
		this.stKodu = stKodu;
	}




	public String getStAdi() {
		return stAdi;
	}




	public void setStAdi(String stAdi) {
		this.stAdi = stAdi;
	}




	public String getStAciklama() {
		return stAciklama;
	}




	public void setStAciklama(String stAciklama) {
		this.stAciklama = stAciklama;
	}




	public int getKtId() {
		return ktId;
	}




	public void setKtId(int ktId) {
		this.ktId = ktId;
	}




	public String getKtKodu() {
		return ktKodu;
	}




	public void setKtKodu(String ktKodu) {
		this.ktKodu = ktKodu;
	}




	public String getKtAdi() {
		return ktAdi;
	}




	public void setKtAdi(String ktAdi) {
		this.ktAdi = ktAdi;
	}




	public double getKtOrani() {
		return ktOrani;
	}




	public void setKtOrani(double ktOrani) {
		this.ktOrani = ktOrani;
	}
	
	
	
}
