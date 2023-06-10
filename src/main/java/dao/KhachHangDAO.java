package dao;

import Database.Connect;
import model.KhachHang;


import java.sql.*;
import java.util.ArrayList;

public
class KhachHangDAO implements DaoInterface<KhachHang>{
    public static KhachHangDAO getInstance(){
        return new KhachHangDAO();
    }


    @Override
    public
    int insert ( KhachHang khachHang ) {

        int ketqua =0;
        try{
            // tao ket noi
            Connection conn = Connect.getConnection();
            // tao statement
            Statement stmt = conn.createStatement();
            // thuc thi
            String sql ="INSERT INTO khachHang( hoVaTen, ngaySinh, diaChi)"
                    + " VALUES ('"+khachHang.getHoVaTen()+"' , '"+khachHang.getNgaySinh()+"' , '"+khachHang.getDiaChi()+"')";


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
    int update ( KhachHang khachHang ) {

        int ketqua =0;
        try{
            // tao ket noi
            Connection conn = Connect.getConnection();
            // tao statement
            Statement stmt = conn.createStatement();
            // thuc thi
            String sql ="UPDATE  khachHang"+
                    " SET " +

                    "hoVaTen= '"+khachHang.getHoVaTen()+"'"+
                    "ngaySinh='"+khachHang.getNgaySinh()+"'"+
                    "diaChi='"+khachHang.getDiaChi()+"'"+
                    "where id= +khachHang.setId()+";


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
    int delete ( KhachHang khachHang ) {
        int ketqua=0;
        try{
            // tao ket noi
            Connection conn = Connect.getConnection();
            // tao statement
            Statement stmt = conn.createStatement();
            // thuc thi
            String sql ="DELETE FROM khachHang "+
                    " WHERE id = '"+khachHang.getId()+"\'";


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
    ArrayList<KhachHang> selectALL () {
        ArrayList<KhachHang> ketqua = new ArrayList<KhachHang>();
        try{
            Connection conn = Connect.getConnection();

            Statement stmt = conn.createStatement();

            String sql ="Select *From khachHang";

            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String hoVaTen = rs.getString("hoVaTen");
                Date ngaySinh = rs.getDate("ngaySinh");
                String diaChi = rs.getString("diaChi");

                KhachHang k_hang = new KhachHang(id,hoVaTen,
                        ngaySinh,diaChi);
                ketqua.add(k_hang);
            }


        Connect.closeConnection(conn);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    return ketqua;
    }

    @Override
    public
    KhachHang selectById ( KhachHang khachHang ) {
        KhachHang ketqua = null;
        try{
            Connection conn = Connect.getConnection();

            Statement stmt = conn.createStatement();

            String sql= "SELECT *FROM khachHang WHere id ='+khachHang.getId()+'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String hoVaTen = rs.getString("hoVaTen ");
                Date ngaySinh = rs.getDate("ngaySinh");
                String diaChi = rs.getString("diaChi");
                ketqua = new KhachHang(id,hoVaTen,ngaySinh,diaChi);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }





        return ketqua;
    }

    @Override
    public
    ArrayList<KhachHang> selectByCondition ( String condition ) {
        return null;
    }
}
