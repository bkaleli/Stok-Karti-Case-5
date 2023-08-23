package Entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import Command.SingletonDbHelper;
import Hibernate.HibernateUtil;

@Entity
@Audited
@Table(name= "StokKart")
public class StokKartEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stokId;
	
	@Column(name = "stokKodu", unique=true)
	private String stokKodu;
	
	@Column(name = "stokAdı")
	private String stokAdı;
	
	@Column(name = "stokTipi")
	private int stokTipi;
	
	@Column(name = "birimi")
	private String birimi;
	
	@Column(name = "barkodu")
	private String barkodu;    
	
	@Column(name = "kdvTipi")
	private double kdvTipi;
	
	@Column(name = "acıklama")
	private String acıklama;
	
	@Column(name = "olusturmaTarihi")
	private String olusturmaTarihi;
	
	@NotAudited
	@Transient   // bu veritabanında sütun karşılığı olmayacağı anlamına gelir
	private boolean recorded;
	
	
	//constructor
	
	public StokKartEntity() {
		super();
	}

	


	public StokKartEntity(String stokKodu, String stokAdı, int stokTipi, String birimi, String barkodu, double kdvTipi,
			String acıklama, String olusturmaTarihi) {
		super();
		this.stokKodu = stokKodu;
		this.stokAdı = stokAdı;
		this.stokTipi = stokTipi;
		this.birimi = birimi;
		this.barkodu = barkodu;
		this.kdvTipi = kdvTipi;
		this.acıklama = acıklama;
		this.olusturmaTarihi = olusturmaTarihi;
	}





	//save metodu

	public void save() {
				
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.save(this);
		
		transaction.commit();
	}
	
	
	
	
	
	
	
	//update metodu

		public void update() {
					
			Session session = HibernateUtil.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.update(this);
			
			transaction.commit();
		}
	
	
	
		
		
	
	//delete metodu
	
	public void delete() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.delete(this);
		
		transaction.commit();
		
	}



	
	
	
	
	
	//ilk veriyi çekme
	
	@Override
	public void ilkVeri() {
		SingletonDbHelper helper = SingletonDbHelper.getInstance();

		String query = "select * from stokkart order by stokKodu limit 1";
		
		try {
			Statement stmt = helper.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				resultSetDoldur(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	// son veriyi çekme 
	
	@Override
	public void sonVeri() {
		SingletonDbHelper helper = SingletonDbHelper.getInstance();

		String query = "select * from stokkart order by stokKodu desc limit 1";
		
		try {
			Statement stmt = helper.con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				resultSetDoldur(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	//ileri 
	
	@Override
	public void ileri() {
		SingletonDbHelper helper = SingletonDbHelper.getInstance();
		
		if (getStokKodu().equals("")) {
			ilkVeri();
		}
		else {
			try {
				String query = "select * from stokkart where stokKodu > ? order by stokKodu limit 1";
				PreparedStatement stmt = helper.con.prepareStatement(query);
				stmt.setString(1, getStokKodu());
				ResultSet rs = stmt.executeQuery();

				if(rs.next()) {
					resultSetDoldur(rs);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	//geri
	
	@Override
	public void geri() {
		SingletonDbHelper helper = SingletonDbHelper.getInstance();
		
		if (getStokKodu().equals("")) {
			sonVeri();
		}
		else {
			try {

				String query = "select * from stokkart where stokkodu < ? order by stokKodu desc limit 1";
				PreparedStatement stmt = helper.con.prepareStatement(query);
				stmt.setString(1, getStokKodu());
				ResultSet rs = stmt.executeQuery();

				if(rs.next()) {
					resultSetDoldur(rs);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	

	
	
	// enter ile component doldurma
	
	public StokKartEntity setEntity(String kod) {
		SingletonDbHelper helper = SingletonDbHelper.getInstance();
	
		String query = "select * from stokkart where stokKodu = ?";
	
		StokKartEntity stokKartEntity = new StokKartEntity();
		try {
			
			PreparedStatement stmt = helper.con.prepareStatement(query);
			stmt.setString(1, kod);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				stokKartEntity.setStokId(rs.getInt("stokId"));
				stokKartEntity.setStokKodu(rs.getString("stokKodu"));
				stokKartEntity.setStokAdı(rs.getString("stokAdı"));
				stokKartEntity.setStokTipi(rs.getInt("stokTipi"));
				stokKartEntity.setBirimi(rs.getString("birimi"));
				stokKartEntity.setBarkodu(rs.getString("barkodu"));
				stokKartEntity.setKdvTipi(rs.getDouble("kdvTipi"));
				stokKartEntity.setAcıklama(rs.getString("acıklama"));
				stokKartEntity.setOlusturmaTarihi(rs.getString("olusturmaTarihi"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stokKartEntity;
	}
	
	
	
	/*
	
	
	//recorded metodu

	public boolean isRecorded() {
		SingletonDbHelper helper = SingletonDbHelper.getInstance();

		ArrayList<String> recordedList = new ArrayList<>();
		
		try {
			Statement stmt = helper.con.createStatement();
			ResultSet rs = stmt.executeQuery("select stokkodu from stokkart");
			while (rs.next()) {
				recordedList.add(rs.getString("stokkodu"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (String i : recordedList) {
			if (i.equals(getStokKodu())) {
				return true;
			}   
		}
		return false;
	}

	*/
	
	
	
	
	//recorded metodu
	
	public boolean isRecorded() {
		return recorded;
	}
	
	
	
	
	
	

	
	public void resultSetDoldur(ResultSet rs) {
		
		try {
			setStokId(rs.getInt("stokId"));
			setStokKodu(rs.getString("stokKodu"));
			setStokAdı(rs.getString("stokAdı"));
			setStokTipi(rs.getInt("stokTipi"));
			setBirimi(rs.getString("birimi"));
			setBarkodu(rs.getString("barkodu"));
			setKdvTipi(rs.getDouble("kdvTipi"));
			setAcıklama(rs.getString("acıklama"));
			setOlusturmaTarihi(rs.getString("olusturmaTarihi"));
			setRecorded(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public StokKartEntity getStokKartEntity() {
		return this;
	}
	
	
	
	
	
	//getters and setters
	
	public int getStokId() {
		return stokId;
	}
	public void setStokId(int stokId) {
		this.stokId = stokId;
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
	
	public void setRecorded(boolean recorded) {
		this.recorded = recorded;
	}
	

}

	