import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.io.FileOutputStream;

public class KitapKay�t 
{
	
	static Connection myConn;
	static Statement myStat;
	
	//veritaban�ndan veri cekme (listeleme)
	static ResultSet baglan(){
		ResultSet myRs = null; 
		try {
			
			myConn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/kitapci",
					"root","1234");
		    myStat = (Statement) myConn.createStatement();
			myRs = myStat.executeQuery("select * from kitaplar");
		

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return myRs;

	}
	
	//veritaban�na veri g�nderme (kay�t)
	static void ekle(String sql_sorgu) {
		
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//veritaban�n� g�ncelleme 
	static void guncelle(String guncelle_sorgu) {
		try {
			myStat.executeUpdate(guncelle_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void sil(String sil_sorgu) {
		try {
			myStat.executeUpdate(sil_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static ResultSet sorgula(String sql_sorgu) {
		ResultSet myRs = null;
		
		try {
			myRs = myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myRs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

}
	}





