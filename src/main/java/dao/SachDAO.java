package dao;

import Database.Connect;
import model.Sach;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public
class SachDAO  implements DaoInterface<Sach> {
    public static SachDAO getInstance(){
        return new SachDAO();
    }


    @Override
    public
    int insert ( Sach sach ) {
        int ketqua =0;
        try{
            // tao ket noi
            Connection conn = Connect.getConnection();
            // tao statement
            Statement stmt = conn.createStatement();
            // thuc thi
            String sql ="INSERT INTO sach(id, tenSach, giaBan, namXuatBan)"
                    + " VALUES ('"+sach.getId()+"' , '"+sach.getTenSach()+"' , '"+sach.getGiaBan()+"' , '"+sach.getNamXuatBan()+"')";


        ketqua = stmt.executeUpdate(sql);
        //
            System.out.println("Ban Da thuc thi : " + sql);
            System.out.println("Co " + ketqua + "Ket qua bi thay doi");
        //
        Connect.closeConnection(conn);

        }

        catch (SQLException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public
    int update ( Sach sach ) {
        int ketqua=0;
        try{
            // tao ket noi
            Connection conn = Connect.getConnection();
            // tao statement
            Statement stmt = conn.createStatement();
            // thuc thi
            String sql ="UPDATE sach "+
                       " SET " +
                       " tenSach='"+ sach.getTenSach() +"'"+
                       ", giaBan ='"+ sach.getGiaBan()+"'"+
                       ", namXuatBan ="+ sach.getNamXuatBan() +
                       " WHERE id = '"+sach.getId()+"\'";


            System.out.println(sql);


            ketqua = stmt.executeUpdate(sql);
            //
            System.out.println("Ban Da thuc thi : " +sql);
            System.out.println("Co " + ketqua + " Ket qua bi thay doi");
            //
            Connect.closeConnection(conn);

        }

        catch (SQLException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public
    int delete ( Sach sach ) {
        int ketqua=0;
        try{
            // tao ket noi
            Connection conn = Connect.getConnection();
            // tao statement
            Statement stmt = conn.createStatement();
            // thuc thi
            String sql ="DELETE FROM sach "+
                    " WHERE id = '"+sach.getId()+"\'";


            System.out.println(sql);


            ketqua = stmt.executeUpdate(sql);
            //
            System.out.println("Ban Da thuc thi : " +sql);
            System.out.println("Co " + ketqua + " Ket qua bi thay doi");
            //
            Connect.closeConnection(conn);

        }

        catch (SQLException e){
            e.printStackTrace();
        }
        return ketqua;

    }

    @Override
    public
    ArrayList<Sach> selectALL () {
        ArrayList<Sach> ketqua =new ArrayList<Sach>();
        try{
            // tao ket noi
            Connection conn = Connect.getConnection();
            // tao statement
            Statement stmt = conn.createStatement();
            // thuc thi
            String sql ="SELECT * FROM sach";


            System.out.println(sql);
            ResultSet rs = stmt.executeQuery("SELECT * FROM sach");
            //
            while (rs.next()){
                // danh ten cot hoac thu tu cot
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                Sach sach = new Sach(id,tenSach,giaBan,namXuatBan);
                ketqua.add(sach);



            }
            //
            Connect.closeConnection(conn);

        }

        catch (SQLException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public
    Sach selectById ( Sach sach ) {
       Sach ketqua =null;
        try{
            // tao ket noi
            Connection conn = Connect.getConnection();
            // tao statement
            Statement stmt = conn.createStatement();
            // thuc thi
            String sql ="SELECT * FROM sach WHere id = '"+sach.getId()+"' ";


            System.out.println(sql);
            ResultSet rs = stmt.executeQuery("SELECT * FROM sach WHere id = '"+sach.getId()+"' ");
            //
            while (rs.next()){
                // danh ten cot hoac thu tu cot
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                ketqua = new Sach(id,tenSach,giaBan,namXuatBan);



            }
            //
            Connect.closeConnection(conn);

        }

        catch (SQLException e){
            e.printStackTrace();
        }
        return ketqua;
    }

    @Override
    public
    ArrayList<Sach> selectByCondition ( String condition ) {
        ArrayList<Sach> ketqua =new ArrayList<Sach>();
        try{
            // tao ket noi
            Connection conn = Connect.getConnection();
            // tao statement
            Statement stmt = conn.createStatement();
            // thuc thi
            String sql ="SELECT * FROM sach";


            System.out.println(sql);
            ResultSet rs = stmt.executeQuery("SELECT * FROM sach where "+condition);
            //
            while (rs.next()){
                // danh ten cot hoac thu tu cot
                String id = rs.getString("id");
                String tenSach = rs.getString("tenSach");
                float giaBan = rs.getFloat("giaBan");
                int namXuatBan = rs.getInt("namXuatBan");
                Sach sach = new Sach(id,tenSach,giaBan,namXuatBan);
                ketqua.add(sach);



            }
            //
            Connect.closeConnection(conn);

        }

        catch (SQLException e){
            e.printStackTrace();
        }
        return ketqua;
    }
}
