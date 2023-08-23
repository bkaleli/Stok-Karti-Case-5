package Frame;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;

public class StokKartiListesiFrame extends JInternalFrame {

	public JTable tbTable = new JTable();
	public JButton btnListele;
	public DefaultTableModel model = new DefaultTableModel();
	public final JPopupMenu popupMenu = new JPopupMenu();
	public final JMenuItem pumnitmPdf = new JMenuItem("Listeyi jasper'da görüntüle");
	public final JMenuItem pumnitmExcel = new JMenuItem("Listeyi excele aktar");
	public final JMenuItem pumnitmStokKarti = new JMenuItem("Satır bilgilerini stok kartında göster");
	public final JMenuItem pumnitmMail = new JMenuItem("Listeyi maile pdf gönder");

	
	public StokKartiListesiFrame() {
		setTitle("STOK KARTI LİSTESİ");
		setMaximizable(true);
		setIconifiable(true);
		setResizable(true);
		setClosable(true);
		getContentPane().setLayout(null);
		setBounds(100, 100, 1374, 351);
		addPopup(tbTable, popupMenu);
		
		
		popupMenu.add(pumnitmExcel);
		
		popupMenu.add(pumnitmPdf);
		
		popupMenu.add(pumnitmStokKarti);
		
		popupMenu.add(pumnitmMail);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 1358, 291);
		getContentPane().add(scrollPane);
	
		
		tbTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stok Kodu", "Stok Ad\u0131", "Stok Tipi (Id)", "Birimi", "Barkodu", "KDV Tipi (Oranı)", "A\u00E7\u0131klama", "Olu\u015Fturma Tarihi", "Stok Tipi Kodu", "Stok Tipi Ad\u0131", "Stok Tipi A\u00E7\u0131klama", "KDV Tipi Id", "KDV Tipi Kodu", "KDV Tipi Ad\u0131"
			}
		));
		tbTable.setBounds(449, 227, 481, 176);
		scrollPane.setViewportView(tbTable);
		
		btnListele = new JButton("LİSTELE");
		btnListele.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListele.setBounds(1226, 0, 132, 30);
		getContentPane().add(btnListele);
	
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
