/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author khoi
 */
public class NganHangCH {
    private String mon;
    private String cauhoi;
    private String daA;
    private String daB;
    private String daC;
    private String daD;
    private String daDung;
    private Connection conn;
    public NganHangCH() {
        Connect();
    }

    public NganHangCH(String mon, String cauhoi, String daA, String daB, String daC, String daD, String daDung) {
        this.mon = mon;
        this.cauhoi = cauhoi;
        this.daA = daA;
        this.daB = daB;
        this.daC = daC;
        this.daD = daD;
        this.daDung = daDung;
        Connect();
    }

    public NganHangCH(String cauhoi, String daA, String daB, String daC, String daD, String daDung) {
        this.cauhoi = cauhoi;
        this.daA = daA;
        this.daB = daB;
        this.daC = daC;
        this.daD = daD;
        this.daDung = daDung;
    }

    public NganHangCH(String mon) {
        this.mon = mon;
        Connect();
    }

    public String getMon() {
        return mon;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public String getDaA() {
        return daA;
    }

    public String getDaB() {
        return daB;
    }

    public String getDaC() {
        return daC;
    }

    public String getDaD() {
        return daD;
    }

    public String getDaDung() {
        return daDung;
    }
    
    public void themNH(ArrayList<NganHangCH> nh){
        try {
            for(NganHangCH as:nh){
                String sql="insert into NHCH(mon, cauhoi, daA, daB, daC, daD, daDung) values(?,?,?,?,?,?,?)";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1, this.mon);
                ps.setString(2, as.getCauhoi());
                ps.setString(3, as.getDaA());
                ps.setString(4, as.getDaB());
                ps.setString(5, as.getDaC());
                ps.setString(6, as.getDaD());
                ps.setString(7, as.getDaDung());
                ps.executeUpdate();
            }
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void xoaNH(){
        try {
            String sql="delete from NHCH where mon=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, this.mon);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateNH(ArrayList<NganHangCH> nh, String mon){
        try {
            String sql="delete from NHCH where mon=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, mon);
            ps.executeUpdate();
            ps.close();
            
            for(NganHangCH as:nh){
                String sql1="insert into NHCH(mon, cauhoi, daA, daB, daC, daD, daDung) values(?,?,?,?,?,?,?)";
                PreparedStatement ps1=conn.prepareStatement(sql1);
                ps1.setString(1, mon);
                ps1.setString(2, as.getCauhoi());
                ps1.setString(3, as.getDaA());
                ps1.setString(4, as.getDaB());
                ps1.setString(5, as.getDaC());
                ps1.setString(6, as.getDaD());
                ps1.setString(7, as.getDaDung());
                ps1.executeUpdate();
                ps1.close();
            }
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<NganHangCH> loadNH(){
        ArrayList<NganHangCH> nh=new ArrayList<>();
        try {
            String sql="select * from NHCH";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {                
                NganHangCH a=new NganHangCH(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                nh.add(a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return nh;
   }
    
    private void Connect(){
        try {
            String sql="jdbc:mysql://localhost/qlthi1";
            String user="root";
            String pass="";
            conn=DriverManager.getConnection(sql, user, pass);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public String toString() {
        return this.cauhoi+"\r\n"+this.daA+"\r\n"+this.daB+"\r\n"+this.daC+"\r\n"
                +this.daD+"\r\n"+this.daDung;
    }
    
}
