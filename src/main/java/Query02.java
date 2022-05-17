import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");


        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/okul?serverTimezone=UTC", "root", "Muzaffer.1990");

        Statement st = con.createStatement();

        /*
        ogrenciler tablosundaki erkek ogrenci bilgileri getirin

         */
        ResultSet veri = st.executeQuery("select * from ogrenciler where cinsiyet = 'E'");
        System.out.printf("%-6s %-15.15s %-8s %-8s\n", "Okul No", "Ogrenci Isim", "Sinif", "Cinsiyet");
        System.out.println("====== ============== ========  =======");

        while (veri.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1), veri.getString(2), veri.getString(3), veri.getString(4));
        }

        // kiz ogrenci 9. siniflari geitr
        System.out.println(" kiz ogrenci 9. siniflari geitr");
        ResultSet veri1 = st.executeQuery("select * from ogrenciler where cinsiyet = 'k' and sinif=9 ");
        while (veri1.next()) {
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri1.getInt(1), veri1.getString(2), veri1.getString(3), veri1.getString(4));

        }

    }
}
