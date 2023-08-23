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
@Table(name= "KdvTipKart")
public class KdvTipKartEntity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ktId;
	
	@Column(name = "ktKodu")
	private String ktKodu;
	
	@Column(name = "ktAdi")
	private String ktAdi;
	
	@Column(name = "ktOrani")
	private double ktOrani;
	
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
	
	
	
	
	
	
	
	// ilk veri çekme 
	
	@Override
	public void ilkVeri() {
		SingletonDbHelper helper = SingletonDbHelper.getInstance();
		
		String query = "select * from kdvtipkart order by ktKodu limit 1";
		
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

		String query = "select * from kdvtipkart order by ktKodu desc limit 1";
		
		
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

		if (getKtKodu().equals("")) {
			ilkVeri();
		}
		else {
			try {			
				String query = "select * from kdvtipkart where ktKodu > ? order by ktKodu limit 1";
				PreparedStatement stmt = helper.con.prepareStatement(query);
				stmt.setString(1, String.valueOf(getKtKodu()));
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
		
		if (getKtKodu().equals("")) {
			sonVeri();
		}
		else {
			try {		
				String query = "select * from kdvtipkart where ktKodu < ? order by ktKodu desc limit 1";
				PreparedStatement stmt = helper.con.prepareStatement(query);
				stmt.setString(1, String.valueOf(getKtKodu()));
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
			ResultSet rs = stmt.executeQuery("select ktKodu from kdvtipkart");
			while (rs.next()) {
				recordedList.add(rs.getString("ktKodu"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (String i : recordedList) {
			if (i.equals(getKtKodu())) {
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
			setKtId(rs.getInt("ktId"));
			setKtKodu(rs.getString("ktKodu"));
			setKtAdi(rs.getString("ktAdi"));
			setKtOrani(rs.getDouble("ktOrani"));
			setRecorded(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	//getters and setters 
	
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

	public void setRecorded(boolean recorded) {
		this.recorded = recorded;
	}
	
	
	
	
	
	
	
}
