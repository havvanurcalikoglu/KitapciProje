import javax.swing.JFrame;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class proje {

	private JFrame frmKitap;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proje window = new proje();
					window.frmKitap.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public proje() {
		initialize();
		frmKitap.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmKitap = new JFrame();
		frmKitap.setTitle("K\u0130TAP\u00C7I");
		frmKitap.setBounds(100, 100, 450, 300);
		frmKitap.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmKitap.getContentPane().setLayout(null);
		
		JButton btnYneticiGirii = new JButton("Y\u00F6netici Giri\u015Fi");
		btnYneticiGirii.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				YoneticiGiris yg = new YoneticiGiris();
				frmKitap.dispose();
				
			}
		});
		btnYneticiGirii.setBounds(104, 36, 176, 45);
		frmKitap.getContentPane().add(btnYneticiGirii);
		
		JButton btnMteriGirii = new JButton("M\u00FC\u015Fteri Giri\u015Fi");
		btnMteriGirii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriGiris mg = new MusteriGiris();
				frmKitap.dispose();
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
			}
		});
		btnMteriGirii.setBounds(104, 105, 176, 45);
		frmKitap.getContentPane().add(btnMteriGirii);
		
		JButton btnk = new JButton("\u00C7\u0131k\u0131\u015F");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmKitap.dispose();
			}
		});
		btnk.setBounds(141, 176, 118, 35);
		frmKitap.getContentPane().add(btnk);
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon(proje.class.getResource("/images/sa.jpg")));
		label.setBounds(0, 0, 434, 261);
		frmKitap.getContentPane().add(label);
	}
}
