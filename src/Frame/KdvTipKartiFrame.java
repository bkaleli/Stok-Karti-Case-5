package Frame;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import Entity.KdvTipKartEntity;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class KdvTipKartiFrame extends JInternalFrame {
	public JTextField tfKTKodu;
	public JTextField tfKTAdi;
	public JTextField tfKTOrani;
	public JButton btnKTKaydet;
	public JButton btnKTSil;
	public JButton btnKTIlk;
	public JButton btnKTGeri;
	public JButton btnKTSon;
	public JButton btnKTIleri;
	public KdvTipKartEntity model;
	private JPanel panel;
	
	public KdvTipKartiFrame() {
		setTitle("KDV TIP KARTI");
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 350, 196);
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{66, 23, 76, 11, 82, -11, 0};
		gridBagLayout.rowHeights = new int[]{47, 22, 22, 22, 29, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridwidth = 6;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		
		btnKTIlk = new JButton("İLK");
		panel.add(btnKTIlk);
		
		btnKTGeri = new JButton("GERİ");
		panel.add(btnKTGeri);
		
		btnKTIleri = new JButton("İLERİ");
		panel.add(btnKTIleri);
		
		btnKTSon = new JButton("SON");
		panel.add(btnKTSon);
		
		JLabel lblKTKodu = new JLabel("Kodu:");
		lblKTKodu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblKTKodu = new GridBagConstraints();
		gbc_lblKTKodu.anchor = GridBagConstraints.EAST;
		gbc_lblKTKodu.fill = GridBagConstraints.VERTICAL;
		gbc_lblKTKodu.insets = new Insets(0, 0, 5, 5);
		gbc_lblKTKodu.gridx = 0;
		gbc_lblKTKodu.gridy = 1;
		getContentPane().add(lblKTKodu, gbc_lblKTKodu);
		tfKTKodu = new JTextField();
		GridBagConstraints gbc_tfKTKodu = new GridBagConstraints();
		gbc_tfKTKodu.anchor = GridBagConstraints.SOUTH;
		gbc_tfKTKodu.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfKTKodu.insets = new Insets(0, 0, 5, 5);
		gbc_tfKTKodu.gridwidth = 5;
		gbc_tfKTKodu.gridx = 1;
		gbc_tfKTKodu.gridy = 1;
		getContentPane().add(tfKTKodu, gbc_tfKTKodu);
		tfKTKodu.setColumns(10);
		
		JLabel lblKTAdi = new JLabel("Adı:");
		lblKTAdi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblKTAdi = new GridBagConstraints();
		gbc_lblKTAdi.anchor = GridBagConstraints.EAST;
		gbc_lblKTAdi.fill = GridBagConstraints.VERTICAL;
		gbc_lblKTAdi.insets = new Insets(0, 0, 5, 5);
		gbc_lblKTAdi.gridx = 0;
		gbc_lblKTAdi.gridy = 2;
		getContentPane().add(lblKTAdi, gbc_lblKTAdi);
		
		tfKTAdi = new JTextField();
		GridBagConstraints gbc_tfKTAdi = new GridBagConstraints();
		gbc_tfKTAdi.anchor = GridBagConstraints.SOUTH;
		gbc_tfKTAdi.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfKTAdi.insets = new Insets(0, 0, 5, 5);
		gbc_tfKTAdi.gridwidth = 5;
		gbc_tfKTAdi.gridx = 1;
		gbc_tfKTAdi.gridy = 2;
		getContentPane().add(tfKTAdi, gbc_tfKTAdi);
		tfKTAdi.setColumns(10);
		
		JLabel lblKTOrani = new JLabel("Orani:");
		lblKTOrani.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblKTOrani = new GridBagConstraints();
		gbc_lblKTOrani.anchor = GridBagConstraints.EAST;
		gbc_lblKTOrani.fill = GridBagConstraints.VERTICAL;
		gbc_lblKTOrani.insets = new Insets(0, 0, 5, 5);
		gbc_lblKTOrani.gridx = 0;
		gbc_lblKTOrani.gridy = 3;
		getContentPane().add(lblKTOrani, gbc_lblKTOrani);
		
		tfKTOrani = new JTextField();
		GridBagConstraints gbc_tfKTOrani = new GridBagConstraints();
		gbc_tfKTOrani.anchor = GridBagConstraints.SOUTH;
		gbc_tfKTOrani.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfKTOrani.insets = new Insets(0, 0, 5, 5);
		gbc_tfKTOrani.gridwidth = 5;
		gbc_tfKTOrani.gridx = 1;
		gbc_tfKTOrani.gridy = 3;
		getContentPane().add(tfKTOrani, gbc_tfKTOrani);
		tfKTOrani.setColumns(10);
		
		btnKTKaydet = new JButton("KAYDET");
		btnKTKaydet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnKTKaydet = new GridBagConstraints();
		gbc_btnKTKaydet.anchor = GridBagConstraints.EAST;
		gbc_btnKTKaydet.fill = GridBagConstraints.VERTICAL;
		gbc_btnKTKaydet.insets = new Insets(0, 0, 0, 5);
		gbc_btnKTKaydet.gridx = 2;
		gbc_btnKTKaydet.gridy = 4;
		getContentPane().add(btnKTKaydet, gbc_btnKTKaydet);
		
		btnKTSil = new JButton("SİL");
		btnKTSil.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnKTSil = new GridBagConstraints();
		gbc_btnKTSil.insets = new Insets(0, 0, 0, 5);
		gbc_btnKTSil.fill = GridBagConstraints.BOTH;
		gbc_btnKTSil.gridx = 4;
		gbc_btnKTSil.gridy = 4;
		getContentPane().add(btnKTSil, gbc_btnKTSil);
		
	}
	
	public void modelDoldur(KdvTipKartEntity kdvTipKartEntity) {
		
		tfKTKodu.setText(kdvTipKartEntity.getKtKodu());
		tfKTAdi.setText(kdvTipKartEntity.getKtAdi());
		tfKTOrani.setText(String.valueOf(kdvTipKartEntity.getKtOrani()));
	}
}
