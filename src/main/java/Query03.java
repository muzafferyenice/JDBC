import java.sql.*;

public class Query03 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch60_61?serverTimezone=UTC", "root", "Muzaffer.1990");

        Statement st = con.createStatement();

        //bolumler tablosundan tum kayitlari listeleyiniz
        ResultSet tablo1 = st.executeQuery("select * from personel");

        System.out.printf("%-6s %-15.15s %-8s \n", "bolum_id", "bolum_isim", "konum");
        System.out.println("====== ============== ======== ");

        while (tablo1.next()) {
            System.out.printf("%-6d %-15.15s %-8s \n", tablo1.getInt(1), tablo1.getString(2), tablo1.getString(3));
        }
        // SATIS ve MUHASEBE bolumlerinde calişan personelin isimlerini ve maaşlarını,
        // maaş ters sıralı listeleyiniz.
        ResultSet tablo2 = st.executeQuery("select personel_isim,maas from personel where bolum_id in(10,30) order by maas desc");

        while (tablo2.next()) {
            System.out.println(tablo2.getString(1) + "\t" + tablo2.getInt(2));
        }

        System.out.println("soru 3 ");
        // Soru3: Tüm bölümlerde çalışan personel isimlerini, bölüm isimlerini ve maaşlarını,
        // bölüm ve maas sıralı listeleyiniz.
        // NOT: Çalışanı olamasa bile bölüm ismi gösterilmelidir.
        ResultSet tablo3 = st.executeQuery("    select p.personel_isim, b.bolum_isim, p.maas from bolumler b left join personel \n" +
                "                p on p.bolum_id=b.bolum_id order by b.bolum_isim, p.maas");

        System.out.printf("%-6s %-15.15s %-8s \n", "isim", "bolum_isim", "maas");
        System.out.println("====== ============== ======== ");
        while (tablo3.next()) {
            System.out.printf("%-10s %-15.15s %-8s \n", tablo3.getString(1), tablo3.getString(2), tablo3.getString(3));
            //System.out.println(tablo3.getString(1)+tablo3.getString(2)+tablo3.getInt(3));
        }
        System.out.println("Maaşı en yüksek 10 kişinin bolümünü, adını ve maaşını listeleyiniz");
        ResultSet tablo4 = st.executeQuery("select p.personel_isim, b.bolum_isim, p.maas from bolumler b left join personel \n" +
                "p on p.bolum_id=b.bolum_id  order by p.maas desc limit 10");

        System.out.printf("%-6s %-15.15s %-8s \n", "isim", "bolum_isim", "maas");
        System.out.println("====== ============== ======== ");
        while (tablo4.next()) {
            System.out.printf("%-10s %-15.15s %-8s \n", tablo4.getString(1), tablo4.getString(2), tablo4.getString(3));
            //System.out.println(tablo3.getString(1)+tablo3.getString(2)+tablo3.getInt(3));
        }


    }
}
