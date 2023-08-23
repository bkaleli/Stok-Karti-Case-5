package Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Hibernate.HibernateUtil;

@Entity
@Table(name= "stok_resim")
public class ImageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "stok_id")
	private int stok_id;
	
	@Column(name = "resim_adi")
	private String dosya_adi;
	
	@Column(name = "olusturma_zamani")
	private Date olusturma_zamani;

	
	
	
	
	
	
	// save metodu 
	
		public void save() {
			
			Session session = HibernateUtil.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.save(this);
			
			transaction.commit();
			
		}
	
	
	
	
	
	
	// getters and setters 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStok_id() {
		return stok_id;
	}

	public void setStok_id(int stok_id) {
		this.stok_id = stok_id;
	}

	public String getDosya_adi() {
		return dosya_adi;
	}

	public void setDosya_adi(String dosya_adi) {
		this.dosya_adi = dosya_adi;
	}

	public Date getOlusturma_zamani() {
		return olusturma_zamani;
	}

	public void setOlusturma_zamani(Date olusturma_zamani) {
		this.olusturma_zamani = olusturma_zamani;
	}
	
	
	
	
	
}
