import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class IslemEkrani {


	private JFrame frame;
	private JTextField kitapAdi;
	private JTextField baskiSayisi;
	private JTextField basimYili;
	private JTextField satisAdedi;
	private JTextField stokMiktari;
	private JTextField fiyat;
	private JTextField kitapArama;
	private JTextField adet;
	private JButton silButonu;
	private JButton ekleButonu;
	private JButton araButonu;
	private JLabel label;
	
	String txtArama, txtAdet, sil_sorgu;
	
	DefaultTableModel modelim = new DefaultTableModel();
	private JButton btnGuncelle;
	

	/**
	 * Create the application.
	 */
	public IslemEkrani(int i) {
		initialize();

		frame.setVisible(true);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 478, 313);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		kitapAdi = new JTextField();
		kitapAdi.setBounds(101, 11, 96, 20);
		frame.getContentPane().add(kitapAdi);
		kitapAdi.setColumns(10);

		baskiSayisi = new JTextField();
		baskiSayisi.setBounds(101, 42, 96, 20);
		frame.getContentPane().add(baskiSayisi);
		baskiSayisi.setColumns(10);

		basimYili = new JTextField();
		basimYili.setBounds(101, 73, 96, 20);
		frame.getContentPane().add(basimYili);
		basimYili.setColumns(10);

		satisAdedi = new JTextField();
		satisAdedi.setBounds(101, 104, 96, 20);
		frame.getContentPane().add(satisAdedi);
		satisAdedi.setColumns(10);

		stokMiktari = new JTextField();
		stokMiktari.setBounds(101, 135, 96, 20);
		frame.getContentPane().add(stokMiktari);
		stokMiktari.setColumns(10);

		fiyat = new JTextField();
		fiyat.setBounds(101, 166, 96, 20);
		frame.getContentPane().add(fiyat);
		fiyat.setColumns(10);

		JLabel lblKitapAd = new JLabel("Kitap Ad\u0131:");
		lblKitapAd.setBounds(10, 14, 68, 14);
		frame.getContentPane().add(lblKitapAd);

		JLabel lblBaskSayss = new JLabel("Bask\u0131 Says\u0131s\u0131:");
		lblBaskSayss.setBounds(10, 45, 81, 14);
		frame.getContentPane().add(lblBaskSayss);

		JLabel lblBasmYl = new JLabel("Bas\u0131m Y\u0131l\u0131:");
		lblBasmYl.setBounds(10, 76, 81, 14);
		frame.getContentPane().add(lblBasmYl);

		JLabel lblSatAdedi = new JLabel("Sat\u0131\u015F Adedi:");
		lblSatAdedi.setBounds(10, 107, 79, 14);
		frame.getContentPane().add(lblSatAdedi);

		JLabel lblStokMiktar = new JLabel("Stok Miktar\u0131:");
		lblStokMiktar.setBounds(10, 138, 81, 14);
		frame.getContentPane().add(lblStokMiktar);

		JLabel lblFiyat = new JLabel("Fiyat:");
		lblFiyat.setBounds(10, 169, 68, 14);
		frame.getContentPane().add(lblFiyat);

		//Kitap kaydetme
		ekleButonu = new JButton("Ekle");
		ekleButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String kAdi,bSayisi, bYili,sAdedi,sMiktari,Fiyat,sql_sorgu;
				
				kAdi = kitapAdi.getText();
				bSayisi = baskiSayisi.getText();
				bYili = basimYili.getText();
				sAdedi = satisAdedi.getText();
				sMiktari = stokMiktari.getText();
				Fiyat = fiyat.getText();
				
				sql_sorgu = "INSERT INTO kitaplar (kitapAdi,baskiSayisi,basimYili,satisAdedi,stokMiktari,fiyat) VALUES ("+
				"'" + kAdi + "'" + "," + bSayisi + "," + bYili + "," + sAdedi + "," + sMiktari + "," + Fiyat +")" ;
			
				
				KitapKayýt.ekle(sql_sorgu);
			
				label.setText("Kitap Eklendi!");
			}
		});
		ekleButonu.setBounds(10, 210, 89, 41);
		frame.getContentPane().add(ekleButonu);

		JButton cikisButonu = new JButton("\u00C7\u0131k\u0131\u015F");
		cikisButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				try {
					YoneticiGiris ye = new YoneticiGiris();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		});
		cikisButonu.setBounds(108, 210, 89, 41);
		frame.getContentPane().add(cikisButonu);

		kitapArama = new JTextField();
		kitapArama.setBounds(351, 11, 101, 20);
		frame.getContentPane().add(kitapArama);
		kitapArama.setColumns(10);

		JLabel lblKitapAd_1 = new JLabel("Kitap Ad\u0131:");
		lblKitapAd_1.setBounds(275, 14, 66, 14);
		frame.getContentPane().add(lblKitapAd_1);

		JLabel lblAdet = new JLabel("Adet:");
		lblAdet.setBounds(275, 45, 66, 14);
		frame.getContentPane().add(lblAdet);

		adet = new JTextField();
		adet.setBounds(351, 42, 101, 20);
		frame.getContentPane().add(adet);
		adet.setColumns(10);

		//Kitap Silme
		silButonu = new JButton("Sil");
		silButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtArama = kitapArama.getText();
				sil_sorgu = "DELETE FROM kitaplar Where kitapAdi =" + "'" + txtArama + "'" ;
				
				KitapKayýt.sil(sil_sorgu);
				
				label.setText("Kitap Silindi!");
					
				}
			
		});
		silButonu.setBounds(363, 94, 89, 41);
		frame.getContentPane().add(silButonu);
		
		//Kitap Arama
		araButonu = new JButton("Ara");
		araButonu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtArama = kitapArama.getText();
				
				ResultSet myRs = null;
				
				String sql_sorgu = "select * from kitaplar where kitapAdi like '" + txtArama + "%'" ;
				myRs = KitapKayýt.sorgula(sql_sorgu);
					
				
				try {
					while(myRs.next()) {
						kitapAdi.setText(myRs.getString("kitapAdi")); 
						baskiSayisi.setText(myRs.getString("baskiSayisi")); 
						basimYili.setText(myRs.getString("basimYili")); 
						satisAdedi.setText(myRs.getString("satisAdedi")); 
						stokMiktari.setText(myRs.getString("stokMiktari")); 
						fiyat.setText(myRs.getString("fiyat")); 
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		araButonu.setBounds(252, 94, 89, 40);
		frame.getContentPane().add(araButonu);
		
		label = new JLabel("");
		label.setBounds(267, 231, 185, 20);
		frame.getContentPane().add(label);
		
		btnGuncelle = new JButton("G\u00FCncelle");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String Adi,Sayisi, Yili,Adedi,Miktari,Fiyat,guncelle_sorgu;
				
				Adi = kitapAdi.getText();
				Sayisi = baskiSayisi.getText();
				Yili = basimYili.getText();
				Adedi = satisAdedi.getText();
			    Miktari = stokMiktari.getText();
				Fiyat = fiyat.getText();
				
				guncelle_sorgu = "UPDATE kitaplar SET "+ "kitapAdi = " + "'" + Adi + "'" + "," +
				"baskiSayisi =" + Sayisi + "," + "basimYili =" +Yili + ","
						+ "satisAdedi =" + Adedi + "," +  "stokMiktari =" + Miktari + "," +
						"fiyat =" + Fiyat +  " WHERE kitapAdi = " + "'" + Adi + "'" ;
				
				KitapKayýt.guncelle(guncelle_sorgu);
				
				
				
			}
		});
		btnGuncelle.setBounds(308, 164, 97, 40);
		frame.getContentPane().add(btnGuncelle);
	}
}


