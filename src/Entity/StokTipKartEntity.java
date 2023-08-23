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

import Command.SingletonDbHelper;
import Hibernate.HibernateUtil;

@Entity
@Audited
@Table(name= "StokTipKart")
public class StokTipKartEntity extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stId;
	
	@Column(name = "stKodu", unique=true)
	private String stKodu;
	
	@Column(name = "stAdi")
	private String stAdi;
	
	@Column(name = "stAciklama")
	private String stAciklama;
	
	@Transient   // bu veritabanında sütun karşılığı olmayacağı anlamına gelir
	private boolean recorded;
	
	
	
	
	// save metodu 
	
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

		String query = "select * from stoktipkart order by stKodu limit 1";

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
	
	
	
	
	
	
	
	
	
	//son veriyi çekme 
	
	@Override
	public void sonVeri() {
		SingletonDbHelper helper = SingletonDbHelper.getInstance();

		String query = "select * from stoktipkart order by stKodu desc limit 1";
		
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

		if (getStKodu().equals("")) {
			ilkVeri();
		}
		else {
			try {
				String query = "select * from stoktipkart where stKodu > ? order by stKodu limit 1";
				PreparedStatement stmt = helper.con.prepareStatement(query);
				stmt.setString(1, getStKodu());
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
	
	
	
	
	
	
	
	
	
	// geri 
		
	@Override
	public void geri() {
		SingletonDbHelper helper = SingletonDbHelper.getInstance();
		
		if (getStKodu().equals("")) {
			ilkVeri();
		}
		else {
			try {
				String query = "select * from stoktipkart where stKodu < ? order by stKodu desc limit 1";
				PreparedStatement stmt = helper.con.prepareStatement(query);
				stmt.setString(1, String.valueOf(getStKodu()));
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
		
		
		
	/*	
		
	//recorded metodu
	
	public boolean isRecorded() {
		SingletonDbHelper helper = SingletonDbHelper.getInstance();

		ArrayList<String> recordedList = new ArrayList<>();
		
		try {
			Statement stmt = helper.con.createStatement();
			ResultSet rs = stmt.executeQuery("select stKodu from stoktipkart");
			while (rs.next()) {
				recordedList.add(rs.getString("stKodu"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (String i : recordedList) {
			if (i.equals(getStKodu())) {
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
			setStId(rs.getInt("stId"));
			setStKodu(rs.getString("stKodu"));
			setStAdi(rs.getString("stAdi"));
			setStAciklama(rs.getString("stAciklama"));
			setRecorded(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	

	
	//getters and setters
	
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
	
	public void setRecorded(boolean recorded) {
		this.recorded = recorded;
	}

}