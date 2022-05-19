import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch60_61?serverTimezone=UTC", "root", "Muzaffer.1990");

        Statement st = con.createStatement();

// soru isciler adinda bir tablo olustrurun id int, birim varchar(30),maas int


        //String sorgu = "CREATE TABLE isciler (id int, birim VARCHAR(10), maas int)";
      //  String sorgu = "create table isciler (id int, birim varchar(10), maas int)";
      //  st.execute(sorgu);
      //  System.out.println("tablo olusturuldu");

    // isciler tablosunu sil
     //   st.execute("drop table isciler");
     //   System.out.println("isciler silndi");//ayni harddisc de oldugu icin silme biraz zzaman aliyor

    // soru isciler tablosuna sutun ekle isim varchar(20)
     //   st.execute("alter table isciler add isim varchar(20)");
      //  System.out.println("sutun eklendi");

        // soru isciler tablosuna iki tane sutun ekle soyisim varchar(20) sehir varchar(10)
      //  st.execute("alter table isciler add (soyisim varchar(20), sehir varchar(10))");

        System.out.println("2 sutun eklendi");

       // soru isciler tablosundaki sehir sutunun ismini ulke olarak degistirin

        //st.execute("alter table isciler rename column sehir to ulke");
        System.out.println("soru isciler tablosundaki sehir sutunun ismini ulke olarak degistirildi");

        // tablo ismi employeee olarak degistir
      //  st.execute("alter table isciler rename to employee");
        System.out.println("soru isciler tablosundaki sehir sutunun ismini ulke olarak degistirildi");

        //ulke data turunu char(30) yap
        st.execute("alter table employee modify ulke char(30)");
        System.out.println("ulke char(30) oldu");

    }
}
