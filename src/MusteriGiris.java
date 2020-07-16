import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Label;

public class MusteriGiris {

	private JFrame frmMteriGirii;
	JLabel hata = new JLabel("");

	private JTextField adGiris;
	private JTextField sifreGiris;
	
	static String ad;
	private static String sifre;
	
	/**
	 * Create the application.
	 */
	public MusteriGiris() {
		initialize();
		frmMteriGirii.setVisible(true);
	}


	private void initialize() {
		frmMteriGirii = new JFrame();
		frmMteriGirii.setTitle("M\u00DC\u015ETER\u0130 G\u0130R\u0130\u015E\u0130");
		frmMteriGirii.setBounds(100, 100, 450, 300);
		frmMteriGirii.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMteriGirii.getContentPane().setLayout(null);
		
		JLabel lblHosgeldnz = new JLabel("HOSGELDINIZ");
		lblHosgeldnz.setFont(new Font("AR DESTINE", Font.PLAIN, 30));
		lblHosgeldnz.setBounds(121, 30, 208, 44);
		frmMteriGirii.getContentPane().add(lblHosgeldnz);
		
		JLabel sifre2 = new JLabel("\u015Eifre");
		sifre2.setFont(new Font("Dialog", Font.BOLD, 15));
		sifre2.setBounds(70, 160, 68, 28);
		frmMteriGirii.getContentPane().add(sifre2);
		
		JButton cikis2 = new JButton("\u00C7\u0131k\u0131\u015F");
		cikis2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proje pr = new proje();
				frmMteriGirii.dispose();

			}
		});
		cikis2.setBounds(190, 201, 111, 28);
		frmMteriGirii.getContentPane().add(cikis2);
		
		JButton MusteriGirisi = new JButton("Giri\u015F");
		MusteriGirisi.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
		
				ad = adGiris.getText();
				sifre = sifreGiris.getText();
				
				String sql_sorgu = " Select Count(kullaniciAdi) as giris From kitapci.kullanicilar Where kullaniciAdi = '" + ad + "'"
						+ " and kullaniciSifre = '" + sifre + "'";
				
				ResultSet myRs = KitapKayýt.baglan();
				myRs = KitapKayýt.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()){
						if(myRs.getInt("giris") == 1) {
							
							try {
								MusteriEkran2 me=new MusteriEkran2();
							} catch (Exception exception) {
								// TODO Auto-generated catch block
								exception.printStackTrace();
							} 
							frmMteriGirii.setVisible(false);
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
		});
		MusteriGirisi.setBounds(70, 201, 89, 28);
		frmMteriGirii.getContentPane().add(MusteriGirisi);
		
		
		hata.setBounds(152, 221, 123, 29);
		frmMteriGirii.getContentPane().add(hata);
		
		JLabel lblNewLabel_1 = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(29, 108, 117, 28);
		frmMteriGirii.getContentPane().add(lblNewLabel_1);
		
		adGiris = new JTextField();
		adGiris.setBounds(152, 109, 116, 28);
		frmMteriGirii.getContentPane().add(adGiris);
		adGiris.setColumns(10);
		
		sifreGiris = new JTextField();
		sifreGiris.setBounds(150, 161, 116, 28);
		frmMteriGirii.getContentPane().add(sifreGiris);
		sifreGiris.setColumns(10);
	}
}
