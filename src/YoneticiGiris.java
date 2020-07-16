import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Label;

public class YoneticiGiris {

	private JFrame frmYneticiGirii;

	protected JTextComponent hataLabel;
	private Label hata;
	private JTextField adGiris;
	
	static String ad;
	private static String sifre;
	private JTextField sifreGiris;


	/**
	 * Create the application.
	 */
	public YoneticiGiris() {
		initialize();
		frmYneticiGirii.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmYneticiGirii = new JFrame();
		frmYneticiGirii.setTitle("Y\u00D6NET\u0130C\u0130 G\u0130R\u0130\u015E\u0130");
		frmYneticiGirii.setBounds(100, 100, 450, 300);
		frmYneticiGirii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmYneticiGirii.getContentPane().setLayout(null);
		
		JLabel label2 = new JLabel("\u015Eifre");
		label2.setFont(new Font("Dialog", Font.BOLD, 15));
		label2.setBounds(122, 145, 57, 29);
		frmYneticiGirii.getContentPane().add(label2);
		
		JButton cikis = new JButton("\u00C7\u0131k\u0131\u015F");
		cikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proje pr = new proje();
				frmYneticiGirii.dispose();
			
				
			}
		});
		cikis.setBounds(191, 189, 97, 29);
		frmYneticiGirii.getContentPane().add(cikis);
		
		JLabel lblHogeldiniz = new JLabel("HOSGELDINIZ");
		lblHogeldiniz.setFont(new Font("AR DESTINE", Font.PLAIN, 30));
		lblHogeldiniz.setBounds(133, 49, 216, 34);
		frmYneticiGirii.getContentPane().add(lblHogeldiniz);
		
		JButton YoneticiGirisi = new JButton("Giri\u015F");
		YoneticiGirisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ad = adGiris.getText();
				sifre = sifreGiris.getText();
				
				
				if(ad.equals("YÖNETÝCÝ") && sifre.equals("4115")) {
					String sql_sorgu = " Select Count(kullaniciAdi) as giris From kitapci.kullanicilar Where kullaniciAdi = '" + ad + "'"
							+ " and kullaniciSifre = '" + sifre + "'";
					ResultSet myRs = KitapKayýt.baglan();
					myRs = KitapKayýt.sorgula(sql_sorgu);
					
					try {
						while(myRs.next()){
							if(myRs.getInt("giris") == 1) {
								
								try {
									IslemEkrani ekran = new IslemEkrani(1);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} 
								frmYneticiGirii.setVisible(false);
								 //Giris ekranýný kapatma
							}
							else {
								hata.setText("HATALI GÝRÝÞ");
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					hata.setText("Hatalý giris");
				}
				}
				
				
				
				
		});
		YoneticiGirisi.setBounds(73, 189, 89, 29);
		frmYneticiGirii.getContentPane().add(YoneticiGirisi);
		
		hata = new Label("");
		hata.setFont(new Font("AR DESTINE", Font.PLAIN, 15));
		hata.setBounds(148, 222, 158, 14);
		frmYneticiGirii.getContentPane().add(hata);
		
		adGiris = new JTextField();
		adGiris.setBounds(191, 107, 97, 25);
		frmYneticiGirii.getContentPane().add(adGiris);
		adGiris.setColumns(10);
		
		JLabel label1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		label1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label1.setBounds(73, 111, 106, 21);
		frmYneticiGirii.getContentPane().add(label1);
		
		sifreGiris = new JTextField();
		sifreGiris.setBounds(191, 148, 97, 25);
		frmYneticiGirii.getContentPane().add(sifreGiris);
		sifreGiris.setColumns(10);
	}
}
