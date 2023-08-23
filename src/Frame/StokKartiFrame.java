package Frame;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

import Entity.StokKartEntity;

import javax.swing.JFileChooser;
import javax.swing.JDialog;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class StokKartiFrame extends JInternalFrame {

	public JTextField tfStokKodu;
	public JTextField tfStokAdı;
	public JTextField tfBarkodu;
	public JTextArea taAciklama;
	public JComboBox<Integer> cbStokTipi;
	public JComboBox<String> cbBirimi;
	public JComboBox<Double> cbKdvTipi;
	public JButton btnSil;
	public JTextField tfOlusturmaTarihi;
	public JTable tbTable;
	public JButton btnKaydet;
	public JButton btnIlk;
	public JButton btnSon;
	public JButton btnGeri;
	public JButton btnIleri;
	public StokKartEntity model;
	
	public JTabbedPane tabbedPane;
	public JPanel pnlDosya;
	public JPanel pnlResim;
	public JButton btnDosyaIndir;
	public JButton btnDosyaAc;
	public JButton btnDosyaSil;
	public JTextField tfDosyaTarihi;
	public JButton btnDDosyaEkle;
	public JButton btnRDosyaEkle;
	public JTextField tfDosyaAdi;
	public JLabel lblDosyaAdi;
	private JLabel lblOlusturmaZamani;
	public JPanel pnlDosyaFields;

	public JComboBox<Double> getCbKdvTipi() {
		return cbKdvTipi;
	}

	public void setCbKdvTipi(JComboBox<Double> cbKdvTipi) {
		this.cbKdvTipi = cbKdvTipi;
	}


	public StokKartiFrame() {
		setTitle("STOK KARTI");
		setResizable(true);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(100, 100, 713, 523);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{180, 127, 109, 93, 118, 70, 0};
		gridBagLayout.rowHeights = new int[]{43, 30, 26, 22, 26, 25, 26, 30, 30, 36, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 6;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);

		btnIlk = new JButton("İLK");
		panel.add(btnIlk);

		btnGeri = new JButton("GERİ");
		panel.add(btnGeri);

		btnIleri = new JButton("İLERİ");
		panel.add(btnIleri);

		btnSon = new JButton("SON");
		panel.add(btnSon);

		JLabel lblStokKodu = new JLabel("Kodu:");
		lblStokKodu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStokKodu = new GridBagConstraints();
		gbc_lblStokKodu.anchor = GridBagConstraints.EAST;
		gbc_lblStokKodu.fill = GridBagConstraints.VERTICAL;
		gbc_lblStokKodu.insets = new Insets(0, 0, 5, 5);
		gbc_lblStokKodu.gridx = 0;
		gbc_lblStokKodu.gridy = 1;
		getContentPane().add(lblStokKodu, gbc_lblStokKodu);

		tfStokKodu = new JTextField();
		tfStokKodu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_tfStokKodu = new GridBagConstraints();
		gbc_tfStokKodu.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfStokKodu.insets = new Insets(0, 0, 5, 5);
		gbc_tfStokKodu.gridwidth = 4;
		gbc_tfStokKodu.gridx = 1;
		gbc_tfStokKodu.gridy = 1;
		getContentPane().add(tfStokKodu, gbc_tfStokKodu);
		tfStokKodu.setColumns(10);

		JLabel lblStokAdı = new JLabel("Adı:");
		lblStokAdı.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStokAdı = new GridBagConstraints();
		gbc_lblStokAdı.anchor = GridBagConstraints.EAST;
		gbc_lblStokAdı.fill = GridBagConstraints.VERTICAL;
		gbc_lblStokAdı.insets = new Insets(0, 0, 5, 5);
		gbc_lblStokAdı.gridx = 0;
		gbc_lblStokAdı.gridy = 2;
		getContentPane().add(lblStokAdı, gbc_lblStokAdı);

		tfStokAdı = new JTextField();
		tfStokAdı.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_tfStokAdı = new GridBagConstraints();
		gbc_tfStokAdı.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfStokAdı.insets = new Insets(0, 0, 5, 5);
		gbc_tfStokAdı.gridwidth = 4;
		gbc_tfStokAdı.gridx = 1;
		gbc_tfStokAdı.gridy = 2;
		getContentPane().add(tfStokAdı, gbc_tfStokAdı);
		tfStokAdı.setColumns(10);

		JLabel lblStokTipi = new JLabel("Stok Tipi:");
		lblStokTipi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStokTipi = new GridBagConstraints();
		gbc_lblStokTipi.anchor = GridBagConstraints.EAST;
		gbc_lblStokTipi.fill = GridBagConstraints.VERTICAL;
		gbc_lblStokTipi.insets = new Insets(0, 0, 5, 5);
		gbc_lblStokTipi.gridx = 0;
		gbc_lblStokTipi.gridy = 3;
		getContentPane().add(lblStokTipi, gbc_lblStokTipi);

		cbStokTipi = new JComboBox<Integer>();
		cbStokTipi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_cbStokTipi = new GridBagConstraints();
		gbc_cbStokTipi.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbStokTipi.insets = new Insets(0, 0, 5, 5);
		gbc_cbStokTipi.gridwidth = 4;
		gbc_cbStokTipi.gridx = 1;
		gbc_cbStokTipi.gridy = 3;
		getContentPane().add(cbStokTipi, gbc_cbStokTipi);

		JLabel lblBirimi = new JLabel("Birimi:");
		lblBirimi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblBirimi = new GridBagConstraints();
		gbc_lblBirimi.anchor = GridBagConstraints.EAST;
		gbc_lblBirimi.fill = GridBagConstraints.VERTICAL;
		gbc_lblBirimi.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirimi.gridx = 0;
		gbc_lblBirimi.gridy = 4;
		getContentPane().add(lblBirimi, gbc_lblBirimi);


		cbBirimi = new JComboBox<String>();
		cbBirimi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbBirimi.addItem("A");
		cbBirimi.addItem("B");
		cbBirimi.addItem("C");
		cbBirimi.addItem("D");
		GridBagConstraints gbc_cbBirimi = new GridBagConstraints();
		gbc_cbBirimi.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbBirimi.insets = new Insets(0, 0, 5, 5);
		gbc_cbBirimi.gridwidth = 4;
		gbc_cbBirimi.gridx = 1;
		gbc_cbBirimi.gridy = 4;
		getContentPane().add(cbBirimi, gbc_cbBirimi);

		JLabel lblBarkodu = new JLabel("Barkoodu:");
		lblBarkodu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblBarkodu = new GridBagConstraints();
		gbc_lblBarkodu.anchor = GridBagConstraints.EAST;
		gbc_lblBarkodu.fill = GridBagConstraints.VERTICAL;
		gbc_lblBarkodu.insets = new Insets(0, 0, 5, 5);
		gbc_lblBarkodu.gridx = 0;
		gbc_lblBarkodu.gridy = 5;
		getContentPane().add(lblBarkodu, gbc_lblBarkodu);

		tfBarkodu = new JTextField();
		tfBarkodu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_tfBarkodu = new GridBagConstraints();
		gbc_tfBarkodu.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBarkodu.insets = new Insets(0, 0, 5, 5);
		gbc_tfBarkodu.gridwidth = 4;
		gbc_tfBarkodu.gridx = 1;
		gbc_tfBarkodu.gridy = 5;
		getContentPane().add(tfBarkodu, gbc_tfBarkodu);
		tfBarkodu.setColumns(10);

		JLabel lblKdvTipi = new JLabel("Kdv Tipi:");
		lblKdvTipi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblKdvTipi = new GridBagConstraints();
		gbc_lblKdvTipi.anchor = GridBagConstraints.EAST;
		gbc_lblKdvTipi.fill = GridBagConstraints.VERTICAL;
		gbc_lblKdvTipi.insets = new Insets(0, 0, 5, 5);
		gbc_lblKdvTipi.gridx = 0;
		gbc_lblKdvTipi.gridy = 6;
		getContentPane().add(lblKdvTipi, gbc_lblKdvTipi);

		cbKdvTipi = new JComboBox<Double>();
		cbKdvTipi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_cbKdvTipi = new GridBagConstraints();
		gbc_cbKdvTipi.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbKdvTipi.insets = new Insets(0, 0, 5, 5);
		gbc_cbKdvTipi.gridwidth = 4;
		gbc_cbKdvTipi.gridx = 1;
		gbc_cbKdvTipi.gridy = 6;
		getContentPane().add(cbKdvTipi, gbc_cbKdvTipi);

		JLabel lblAciklama = new JLabel("Açıklama:");
		lblAciklama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAciklama = new GridBagConstraints();
		gbc_lblAciklama.anchor = GridBagConstraints.EAST;
		gbc_lblAciklama.fill = GridBagConstraints.VERTICAL;
		gbc_lblAciklama.insets = new Insets(0, 0, 5, 5);
		gbc_lblAciklama.gridx = 0;
		gbc_lblAciklama.gridy = 7;
		getContentPane().add(lblAciklama, gbc_lblAciklama);


		taAciklama = new JTextArea();
		taAciklama.setFont(new Font("Monospaced", Font.PLAIN, 14));
		GridBagConstraints gbc_taAciklama = new GridBagConstraints();
		gbc_taAciklama.anchor = GridBagConstraints.NORTH;
		gbc_taAciklama.fill = GridBagConstraints.HORIZONTAL;
		gbc_taAciklama.insets = new Insets(0, 0, 5, 5);
		gbc_taAciklama.gridwidth = 4;
		gbc_taAciklama.gridx = 1;
		gbc_taAciklama.gridy = 7;
		getContentPane().add(taAciklama, gbc_taAciklama);

		JLabel lblOlusturmaTarihi = new JLabel("Oluşturma Tarihi:");
		lblOlusturmaTarihi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblOlusturmaTarihi = new GridBagConstraints();
		gbc_lblOlusturmaTarihi.anchor = GridBagConstraints.EAST;
		gbc_lblOlusturmaTarihi.fill = GridBagConstraints.VERTICAL;
		gbc_lblOlusturmaTarihi.insets = new Insets(0, 0, 5, 5);
		gbc_lblOlusturmaTarihi.gridx = 0;
		gbc_lblOlusturmaTarihi.gridy = 8;
		getContentPane().add(lblOlusturmaTarihi, gbc_lblOlusturmaTarihi);

		tfOlusturmaTarihi = new JTextField();
		tfOlusturmaTarihi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_tfOlusturmaTarihi = new GridBagConstraints();
		gbc_tfOlusturmaTarihi.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfOlusturmaTarihi.insets = new Insets(0, 0, 5, 5);
		gbc_tfOlusturmaTarihi.gridwidth = 4;
		gbc_tfOlusturmaTarihi.gridx = 1;
		gbc_tfOlusturmaTarihi.gridy = 8;
		getContentPane().add(tfOlusturmaTarihi, gbc_tfOlusturmaTarihi);
		tfOlusturmaTarihi.setColumns(10);

		btnKaydet = new JButton("KAYDET");
		btnKaydet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnKaydet = new GridBagConstraints();
		gbc_btnKaydet.fill = GridBagConstraints.BOTH;
		gbc_btnKaydet.insets = new Insets(0, 0, 5, 5);
		gbc_btnKaydet.gridx = 2;
		gbc_btnKaydet.gridy = 9;
		getContentPane().add(btnKaydet, gbc_btnKaydet);

		btnSil = new JButton("SİL");
		btnSil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSil = new GridBagConstraints();
		gbc_btnSil.insets = new Insets(0, 0, 5, 5);
		gbc_btnSil.fill = GridBagConstraints.BOTH;
		gbc_btnSil.gridx = 3;
		gbc_btnSil.gridy = 9;
		getContentPane().add(btnSil, gbc_btnSil);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridheight = 5;
		gbc_tabbedPane.gridwidth = 6;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 10;
		getContentPane().add(tabbedPane, gbc_tabbedPane);

		pnlDosya = new JPanel();
		tabbedPane.addTab("Dosya", null, pnlDosya, null);
		GridBagLayout gbl_pnlDosya = new GridBagLayout();
		gbl_pnlDosya.columnWidths = new int[]{345, 98, 50, 42, 37, 79, 0};
		gbl_pnlDosya.rowHeights = new int[]{26, 0, 0};
		gbl_pnlDosya.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDosya.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		pnlDosya.setLayout(gbl_pnlDosya);
		
		lblDosyaAdi = new JLabel("Dosya Adı");
		GridBagConstraints gbc_lblDosyaAdi = new GridBagConstraints();
		gbc_lblDosyaAdi.fill = GridBagConstraints.VERTICAL;
		gbc_lblDosyaAdi.insets = new Insets(0, 0, 5, 5);
		gbc_lblDosyaAdi.gridx = 0;
		gbc_lblDosyaAdi.gridy = 0;
		pnlDosya.add(lblDosyaAdi, gbc_lblDosyaAdi);
		
		lblOlusturmaZamani = new JLabel("Oluşturma Zamanı");
		GridBagConstraints gbc_lblOlusturmaZamani = new GridBagConstraints();
		gbc_lblOlusturmaZamani.fill = GridBagConstraints.VERTICAL;
		gbc_lblOlusturmaZamani.insets = new Insets(0, 0, 5, 5);
		gbc_lblOlusturmaZamani.gridx = 1;
		gbc_lblOlusturmaZamani.gridy = 0;
		pnlDosya.add(lblOlusturmaZamani, gbc_lblOlusturmaZamani);

		btnDDosyaEkle = new JButton("Dosya ekle");
		GridBagConstraints gbc_btnDDosyaEkle = new GridBagConstraints();
		gbc_btnDDosyaEkle.insets = new Insets(0, 0, 5, 0);
		gbc_btnDDosyaEkle.fill = GridBagConstraints.BOTH;
		gbc_btnDDosyaEkle.gridx = 5;
		gbc_btnDDosyaEkle.gridy = 0;
		pnlDosya.add(btnDDosyaEkle, gbc_btnDDosyaEkle);
		
		pnlDosyaFields = new JPanel();
		GridBagConstraints gbc_pnlDosyaFields = new GridBagConstraints();
		gbc_pnlDosyaFields.gridwidth = 6;
		gbc_pnlDosyaFields.insets = new Insets(0, 0, 0, 5);
		gbc_pnlDosyaFields.fill = GridBagConstraints.BOTH;
		gbc_pnlDosyaFields.gridx = 0;
		gbc_pnlDosyaFields.gridy = 1;
		pnlDosya.add(pnlDosyaFields, gbc_pnlDosyaFields);
		GridBagLayout gbl_pnlDosyaFields = new GridBagLayout();
		gbl_pnlDosyaFields.columnWidths = new int[]{376, 104, 44, 46, 44, 0, 0, 0, 0};
		gbl_pnlDosyaFields.rowHeights = new int[]{0, 0};
		gbl_pnlDosyaFields.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlDosyaFields.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlDosyaFields.setLayout(gbl_pnlDosyaFields);
		
		
		
	
		
		
		
		
		/*
		 
		tfDosyaAdi = new JTextField();
		tfDosyaAdi.setEditable(false);
		GridBagConstraints gbc_tfDosyaAdi = new GridBagConstraints();
		gbc_tfDosyaAdi.insets = new Insets(0, 0, 5, 5);
		gbc_tfDosyaAdi.fill = GridBagConstraints.BOTH;
		gbc_tfDosyaAdi.gridx = 0;
		gbc_tfDosyaAdi.gridy = 1;
		pnlDosya.add(tfDosyaAdi, gbc_tfDosyaAdi);
		tfDosyaAdi.setColumns(10);

		tfDosyaTarihi = new JTextField();
		tfDosyaTarihi.setEditable(false);
		GridBagConstraints gbc_tfDosyaTarihi = new GridBagConstraints();
		gbc_tfDosyaTarihi.insets = new Insets(0, 0, 5, 5);
		gbc_tfDosyaTarihi.fill = GridBagConstraints.BOTH;
		gbc_tfDosyaTarihi.gridx = 1;
		gbc_tfDosyaTarihi.gridy = 1;
		pnlDosya.add(tfDosyaTarihi, gbc_tfDosyaTarihi);
		tfDosyaTarihi.setColumns(10);

		btnDosyaIndir = new JButton("İndir");
		GridBagConstraints gbc_btnDosyaIndir = new GridBagConstraints();
		gbc_btnDosyaIndir.insets = new Insets(0, 0, 5, 5);
		gbc_btnDosyaIndir.gridx = 2;
		gbc_btnDosyaIndir.gridy = 1;
		pnlDosya.add(btnDosyaIndir, gbc_btnDosyaIndir);

		btnDosyaAc = new JButton("Aç");
		GridBagConstraints gbc_btnDosyaAc = new GridBagConstraints();
		gbc_btnDosyaAc.insets = new Insets(0, 0, 5, 5);
		gbc_btnDosyaAc.gridx = 3;
		gbc_btnDosyaAc.gridy = 1;
		pnlDosya.add(btnDosyaAc, gbc_btnDosyaAc);

		btnDosyaSil = new JButton("Sil");
		GridBagConstraints gbc_btnDosyaSil = new GridBagConstraints();
		gbc_btnDosyaSil.insets = new Insets(0, 0, 5, 5);
		gbc_btnDosyaSil.gridx = 4;
		gbc_btnDosyaSil.gridy = 1;
		pnlDosya.add(btnDosyaSil, gbc_btnDosyaSil);
		
		*/

		pnlResim = new JPanel();
		tabbedPane.addTab("Resim", null, pnlResim, null);
		GridBagLayout gbl_pnlResim = new GridBagLayout();
		gbl_pnlResim.columnWidths = new int[]{580, 106, 0};
		gbl_pnlResim.rowHeights = new int[]{14, 0, 0};
		gbl_pnlResim.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlResim.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pnlResim.setLayout(gbl_pnlResim);
		
		btnRDosyaEkle = new JButton("Dosya Ekle");
		GridBagConstraints gbc_btnRDosyaEkle = new GridBagConstraints();
		gbc_btnRDosyaEkle.anchor = GridBagConstraints.NORTH;
		gbc_btnRDosyaEkle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRDosyaEkle.gridx = 1;
		gbc_btnRDosyaEkle.gridy = 1;
		pnlResim.add(btnRDosyaEkle, gbc_btnRDosyaEkle);


	}
	
	
	
	

	public void modelDoldur(StokKartEntity stokKartEntity) {
		tfStokKodu.setText(stokKartEntity.getStokKodu());
		tfStokAdı.setText(stokKartEntity.getStokAdı());
		cbStokTipi.setSelectedItem(stokKartEntity.getStokTipi());
		cbBirimi.setSelectedItem(stokKartEntity.getBirimi());
		tfBarkodu.setText(stokKartEntity.getBarkodu());
		cbKdvTipi.setSelectedItem(stokKartEntity.getKdvTipi());
		taAciklama.setText(stokKartEntity.getAcıklama());
		tfOlusturmaTarihi.setText(stokKartEntity.getOlusturmaTarihi());
	}

	public StokKartEntity getModel() {
		return model;
	}

	public void setModel(StokKartEntity model) {
		this.model = model;
	}
}
