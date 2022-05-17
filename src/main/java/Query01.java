import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1- driver yukle
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2- baglanti olustur
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "Muzaffer.1990");
        //"jdbc:mysql://localhost:3306/okul2?serverTimezone=UTC"
        // okul localdeki database in adi

        //3- Statement
        Statement st = con.createStatement();

        //4- ResultSet
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        System.out.printf("%-6s %-15.15s %-8s %-8s\n", "Okul No", "Ogrenci Isim", "Sinif", "Cinsiyet");
        System.out.println("====== ============== ========  =======");
        //5- sonuclari yazdir
        while (veri.next()) {
            //  System.out.println("veri = " + veri.getInt(1) + " " + veri.getString(2) + " " + veri.getString(3) + " " + veri.getString(4));

            System.err.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4));

        }
        //6- kapatma
        con.close();
        st.close();
        veri.close();

    }
}
