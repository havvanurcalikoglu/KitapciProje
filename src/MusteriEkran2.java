import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

public class MusteriEkran2 extends JFrame {

	private JFrame frame;
	private JTextField ara;
	
	private JPanel contentPane;
	private JButton btnAra;

	DefaultTableModel modelim = new DefaultTableModel();
	Object[] satirlar = new Object[6];
	Object[] kolonlar = {"KitapAdi","BaskiSayisi","BasimYili","Satisadedi","StokMiktari","Fiyat"};
	private JLabel label;
	private JScrollPane scrollPane;
	String s;
	int secim1;
	private JTable table;


	
	public MusteriEkran2() {
		initialize();
		frame.setVisible(true);
	}


	
	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 449, 317);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		table = new JTable();
		modelim.setColumnIdentifiers(kolonlar);

		
		String[] secim = {"Fiyata Göre","Satýþa Göre"};
		JComboBox comboBox = new JComboBox(secim);

		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				int secim = 0;
				String s = (String) comboBox.getSelectedItem();

				if(s.equals("Fiyata Göre")) 
				{
					modelim.setRowCount(0);
					ResultSet myRs = null;
					secim = 1;
					String sql_sorgu1 = "Select * From kitaplar Order By fiyat";
					myRs = KitapKayýt.sorgula(sql_sorgu1);
					modelim.addRow(kolonlar);
					try {
						while(myRs.next()) {
							satirlar[0] = myRs.getString("kitapAdi");
							satirlar[1] = myRs.getString("baskiSayisi");
							satirlar[2] = myRs.getString("basimYili");
							satirlar[3] = myRs.getString("satisAdedi");
							satirlar[4] = myRs.getString("stokMiktari");
							satirlar[5] = myRs.getString("fiyat");
							modelim.addRow(satirlar);
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table.setModel(modelim);
					
				}
				else if (s.equals("Satýþa Göre")) 
				{
					modelim.setRowCount(0);
					ResultSet myRs = null;
					secim = 2;
					String sql_sorgu2 = "Select * From kitaplar Order By satisAdedi DESC";
					myRs = KitapKayýt.sorgula(sql_sorgu2);
					modelim.addRow(kolonlar);
					try {
						while(myRs.next()) {
							satirlar[0] = myRs.getString("kitapAdi");
							satirlar[1] = myRs.getString("baskiSayisi");
							satirlar[2] = myRs.getString("basimYili");
							satirlar[3] = myRs.getString("satisAdedi");
							satirlar[4] = myRs.getString("stokMiktari");
							satirlar[5] = myRs.getString("fiyat");
							modelim.addRow(satirlar);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					table.setModel(modelim);
				}
				
			}

		});

	
		comboBox.setToolTipText("");
		comboBox.setBounds(26, 11, 131, 20);
		frame.getContentPane().add(comboBox);

		JLabel lblAra = new JLabel("Ara:");
		lblAra.setFont(new Font("AR DESTINE", Font.PLAIN, 15));
		lblAra.setBounds(233, 13, 46, 14);
		frame.getContentPane().add(lblAra);

		ara = new JTextField();
		ara.setBounds(274, 11, 86, 20);
		frame.getContentPane().add(ara);
		ara.setColumns(10);

		btnAra = new JButton("ARA");
		btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				modelim.setRowCount(0);
				String ad = ara.getText();
				
				ResultSet myRs = null;
				
				String sql_sorgu = "select * from kitaplar where kitapAdi like '" + ad + "%'" ;
				myRs = KitapKayýt.sorgula(sql_sorgu);
				modelim.addRow(kolonlar);
				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("kitapAdi");
						satirlar[1] = myRs.getString("baskiSayisi");
						satirlar[2] = myRs.getString("basimYili");
						satirlar[3] = myRs.getString("satisAdedi");
						satirlar[4] = myRs.getString("stokMiktari");
						satirlar[5] = myRs.getString("fiyat");
						modelim.addRow(satirlar);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(modelim);
			}
		});

		
		btnAra.setBounds(92, 246, 89, 32);
		frame.getContentPane().add(btnAra);

		JButton btnk = new JButton("Çýkýþ");
		btnk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.dispose();
				proje p = new proje();
			}
		});
		btnk.setBounds(220, 246, 89, 32);
		frame.getContentPane().add(btnk);

		label = new JLabel("");
		label.setBounds(138, 221, 171, 14);
		frame.getContentPane().add(label);
		
		
		scrollPane.setBounds(12, 203, 189, -92);
		frame.getContentPane().add(scrollPane);
		
		table.setBounds(22, 38, 397, 197);
		frame.getContentPane().add(table);
		

	
	}
}






