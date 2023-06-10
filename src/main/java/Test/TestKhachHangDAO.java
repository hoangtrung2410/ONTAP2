package Test;

import dao.KhachHangDAO;
import model.KhachHang;

import java.util.ArrayList;

public
class TestKhachHangDAO {
    public static
    void main ( String[] args ) {
        /*
        ArrayList<KhachHang> list  = KhachHangDAO.getInstance().selectALL();
        for (KhachHang k_hang : list){
            System.out.println(k_hang.toString());
        }

        */
        KhachHang find =new KhachHang();
        int i=2;

        find.setId(i);
        KhachHang k_hang1;
        k_hang1 = KhachHangDAO.getInstance().selectById(find);
        System.out.println(k_hang1);
    }
}
