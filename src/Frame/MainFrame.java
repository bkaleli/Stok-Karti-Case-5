package Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

public class MainFrame extends JFrame {

	public JPanel contentPane;
	public JMenuBar menuBar;
	public JMenu mnStokMenu;
	public JMenuItem mnitmStokKarti;
	public JMenuItem mnitmStokKartiListesi;
	public JMenuItem mnitmStokTipKarti;
	public JMenuItem mnitmKdvTipKarti;
	public static JDesktopPane desktopPane;
	
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1984, 1100);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnStokMenu = new JMenu("Stok Menü");
		menuBar.add(mnStokMenu);
		
		mnitmStokKarti = new JMenuItem("Stok Kartı");
		mnStokMenu.add(mnitmStokKarti);
		
		mnitmStokKartiListesi = new JMenuItem("Stok Kartı Listesi");
		mnStokMenu.add(mnitmStokKartiListesi);
		
		mnitmStokTipKarti = new JMenuItem("Stok Tip Kartı");
		mnStokMenu.add(mnitmStokTipKarti);
		
		mnitmKdvTipKarti = new JMenuItem("KDV Tip Kartı");
		mnStokMenu.add(mnitmKdvTipKarti);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1924, 1039);
		contentPane.add(desktopPane);
		
	}
}
