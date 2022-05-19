import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query06 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch60_61?serverTimezone=UTC", "root", "Muzaffer.1990");
        Statement st = con.createStatement();

     //   st.execute("CREATE TABLE urunler (id   int ,isim VARCHAR(10), fiyat  int)");
     //   System.out.println("tablo olusturuldu");

        // SORU: urunler tablosuna aşağıdaki verileri toplu bir şekilde etkileyin
// Çok miktarda kayıt eklemek için PreparedStatement metodu kullanılır.
// 1) Veri girişine uygun bir POJO (Plain Old Java Object) class oluşturulur
// 2) POJO class ta nesneleri saklayacak bir collection oluşturulur
// 3) Bir döngğü ile kayıtlar eklenir.
/*
        List<UrunPojo> kayitlar=new ArrayList<>();
      //  List.of(
      //  );
        kayitlar.add(new UrunPojo(101, "Laptop", 6500));
        kayitlar.add(new UrunPojo(102, "PC", 4500));
        kayitlar.add(new UrunPojo(103, "Telefon", 4500));
        kayitlar.add(new UrunPojo(104, "Anakart", 1500));
        kayitlar.add(new UrunPojo(105, "Klavye", 200));
        kayitlar.add(new UrunPojo(106, "Fare", 100));

        PreparedStatement tablo = con.prepareStatement("insert into urunler values(?,?,?)");

        for (UrunPojo w:kayitlar){
            tablo.setInt(1,w.getId());
            tablo.setString(2,w.getIsim());
            tablo.setDouble(3,w.getFiyat());
            tablo.addBatch();
        }
        tablo.executeBatch();
        System.out.println("eklendi hersey");
       // for (int i = 1; i <kayitlar.size() ; i++) {
       //     tablo.setInt(i,kayitlar.get(i).getId());
       // }
       */
        //srou urunlerdeki pc nin fiyatina %10 zam yap
      //  int s1=st.executeUpdate("update urunler set fiyat = fiyat*1.1 where isim='pc'");
      //  System.out.println(s1+ "oldu");

       // SORU4: urunler tablosunda Marka adında, Default değeri ASUS olan, bir sütun ekleyin.
     // st.executeUpdate("alter table urunler add marka varchar(10) default 'asus'");
     //   System.out.println("oldu");

        //soru urunler tablosunu silinir
        st.executeUpdate("drop table urunler");
        System.out.println(" tablo silindi oldu");


    }
}
