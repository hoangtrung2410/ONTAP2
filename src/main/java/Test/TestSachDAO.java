package Test;

import dao.KhachHangDAO;
import dao.SachDAO;
import model.KhachHang;
import model.Sach;

import java.util.ArrayList;

public
class TestSachDAO {
    public static
    void main ( String[] args ) {
        /*

        // Test Insert sach

        Sach sach1 = new Sach("LTJV","Lap trinh java",50000,2025);
        Sach sach2 = new Sach("LTC","Lap trinh C",70000,2030);

        SachDAO.getInstance().insert(sach1);
        SachDAO.getInstance().insert(sach2);
        for (int i=0;i<1000;i++){
            Sach sach= new Sach("LT" +i,"Lap trinh i :" +i , 20000 , 2025);
            SachDAO.getInstance().insert(sach);
        }



        //Test update
        Sach sach1 = new Sach("LTC","Lap trinh c",100000,2030);
        SachDAO.getInstance().update(sach1);
        Test delete
        for (int i=0;i<1000;i++) {
            Sach sach = new Sach("LT" + i, "Lap trinh i :" + i, 20000, 2025);
            SachDAO.getInstance().delete(sach);

// test array lish sachDAO
        ArrayList<Sach> list = SachDAO.getInstance().selectALL();

        for (Sach sach : list)
            System.out.println(sach.toString());
        }


          // sach  selectById
        Sach find = new Sach();
        find.setId("LTC");
        Sach sach2 = SachDAO.getInstance().selectById(find);
        System.out.println(sach2);

       */
        // test array lish sachDAO
        ArrayList<Sach> list1 = SachDAO.getInstance().selectByCondition("giaBan>30000");

        for (Sach sach : list1)
            System.out.println(sach.toString());


    }

}
