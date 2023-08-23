package Frame;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Entity.StokTipKartEntity;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class StokTipKartiFrame extends JInternalFrame {
	public JTextField tfSTKodu;
	public JTextField tfSTAdi;
	public JTextField tfSTAciklama;
	public JButton btnSTKaydet;
	public JButton btnSTSil;
	public JButton btnSTIlk;
	public JButton btnSTSon;
	public JButton btnSTIleri;
	public JButton btnSTGeri;
	public StokTipKartEntity model;
	private JPanel panel;
	
	
	public StokTipKartiFrame() {
		setTitle("STOK TIP KARTI");
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 353, 200);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{73, 10, 74, 7, 78, 6, 0};
		gridBagLayout.rowHeights = new int[]{45, 22, 21, 21, 28, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridwidth = 6;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		
		btnSTIlk = new JButton("İLK");
		panel.add(btnSTIlk);
		
		btnSTGeri = new JButton("GERİ");
		panel.add(btnSTGeri);
		
		btnSTIleri = new JButton("İLERİ");
		panel.add(btnSTIleri);
		
		btnSTSon = new JButton("SON");
		panel.add(btnSTSon);
		
		JLabel lblSTKodu = new JLabel("Kodu:");
		lblSTKodu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSTKodu = new GridBagConstraints();
		gbc_lblSTKodu.anchor = GridBagConstraints.EAST;
		gbc_lblSTKodu.fill = GridBagConstraints.VERTICAL;
		gbc_lblSTKodu.insets = new Insets(0, 0, 5, 5);
		gbc_lblSTKodu.gridx = 0;
		gbc_lblSTKodu.gridy = 1;
		getContentPane().add(lblSTKodu, gbc_lblSTKodu);
		
		tfSTKodu = new JTextField();
		tfSTKodu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_tfSTKodu = new GridBagConstraints();
		gbc_tfSTKodu.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfSTKodu.insets = new Insets(0, 0, 5, 0);
		gbc_tfSTKodu.gridwidth = 5;
		gbc_tfSTKodu.gridx = 1;
		gbc_tfSTKodu.gridy = 1;
		getContentPane().add(tfSTKodu, gbc_tfSTKodu);
		tfSTKodu.setColumns(10);
		
		JLabel lblSTAdi = new JLabel("Adı:");
		lblSTAdi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSTAdi = new GridBagConstraints();
		gbc_lblSTAdi.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSTAdi.insets = new Insets(0, 0, 5, 5);
		gbc_lblSTAdi.gridx = 0;
		gbc_lblSTAdi.gridy = 2;
		getContentPane().add(lblSTAdi, gbc_lblSTAdi);
		
		tfSTAdi = new JTextField();
		tfSTAdi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_tfSTAdi = new GridBagConstraints();
		gbc_tfSTAdi.fill = GridBagConstraints.BOTH;
		gbc_tfSTAdi.insets = new Insets(0, 0, 5, 0);
		gbc_tfSTAdi.gridwidth = 5;
		gbc_tfSTAdi.gridx = 1;
		gbc_tfSTAdi.gridy = 2;
		getContentPane().add(tfSTAdi, gbc_tfSTAdi);
		tfSTAdi.setColumns(10);
		
		JLabel lblSTAciklama = new JLabel("Açıklama:");
		lblSTAciklama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblSTAciklama = new GridBagConstraints();
		gbc_lblSTAciklama.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSTAciklama.insets = new Insets(0, 0, 5, 5);
		gbc_lblSTAciklama.gridx = 0;
		gbc_lblSTAciklama.gridy = 3;
		getContentPane().add(lblSTAciklama, gbc_lblSTAciklama);
		
		tfSTAciklama = new JTextField();
		tfSTAciklama.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_tfSTAciklama = new GridBagConstraints();
		gbc_tfSTAciklama.fill = GridBagConstraints.BOTH;
		gbc_tfSTAciklama.insets = new Insets(0, 0, 5, 0);
		gbc_tfSTAciklama.gridwidth = 5;
		gbc_tfSTAciklama.gridx = 1;
		gbc_tfSTAciklama.gridy = 3;
		getContentPane().add(tfSTAciklama, gbc_tfSTAciklama);
		tfSTAciklama.setColumns(10);
		
		btnSTKaydet = new JButton("KAYDET");
		btnSTKaydet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSTKaydet = new GridBagConstraints();
		gbc_btnSTKaydet.fill = GridBagConstraints.BOTH;
		gbc_btnSTKaydet.insets = new Insets(0, 0, 0, 5);
		gbc_btnSTKaydet.gridx = 2;
		gbc_btnSTKaydet.gridy = 4;
		getContentPane().add(btnSTKaydet, gbc_btnSTKaydet);
		
		btnSTSil = new JButton("SİL");
		btnSTSil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSTSil = new GridBagConstraints();
		gbc_btnSTSil.fill = GridBagConstraints.BOTH;
		gbc_btnSTSil.gridx = 4;
		gbc_btnSTSil.gridy = 4;
		getContentPane().add(btnSTSil, gbc_btnSTSil);

	}
	
	public void modelDoldur(StokTipKartEntity stokTipKartEntity) {
		
		tfSTKodu.setText(stokTipKartEntity.getStKodu());
		tfSTAdi.setText(stokTipKartEntity.getStAdi());
		tfSTAciklama.setText(String.valueOf(stokTipKartEntity.getStAciklama()));
		
	}
}
