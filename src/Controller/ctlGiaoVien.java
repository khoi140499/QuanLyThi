/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GiaoVien;
import Model.Users;
import View.PhanHoiHS;
import View.QLGiaoVien;
import View.TTGiaoVien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author khoi
 */
public class ctlGiaoVien {
    private QLGiaoVien view;
    private TTGiaoVien view1;
    private View.GiaoVien view2;
    private PhanHoiHS view3;
    DefaultListModel dl=new DefaultListModel();
    private ArrayList<Model.GiaoVien> gv=new Model.GiaoVien().loadGV();
    private ArrayList<Users> us=new Users().loadUser();
    private String s1="";
    private String s2="";
    private String s3="";
    public ctlGiaoVien() {
    }

    public ctlGiaoVien(QLGiaoVien view) {
        this.view = view;
    }

    public ctlGiaoVien(TTGiaoVien view1) {
        this.view1 = view1;
    }
    
    public ctlGiaoVien(View.GiaoVien view2) {
        this.view2 = view2;
    }

    public ctlGiaoVien(PhanHoiHS view3) {
        this.view3 = view3;
    }
    
    private void tb(String s){
        try {
            throw new StringIndexOutOfBoundsException(s+" không được để trống");
        } catch (StringIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private String ktraNS(String s){
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        sf.setLenient(false);
        try {
            sf.parse(s);
        } catch (ParseException e) {
            s="1";
        }
        return s;
    }
    
    private boolean ktraEmail(String s){
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(s.matches(EMAIL_REGEX)==true){
            return true;
        }
        return false;
    }
    
    private boolean ktrMon(String s){
        if(s.equalsIgnoreCase("Vật lý")==false && s.equals("Hóa học")==false && s.equalsIgnoreCase("Toán")==false
           && s.equalsIgnoreCase("Sử")==false && s.equalsIgnoreCase("Sinh")==false && s.equalsIgnoreCase("Địa lý")==false
           && s.equalsIgnoreCase("Tiếng anh")==false && s.equalsIgnoreCase("GDCD")==false){
            return false;
        }
        return true;
    }
    
    private boolean ktrGT(String s){
        if(s.equalsIgnoreCase("nam")==false && s.equalsIgnoreCase("nữ")==false){
            return false;
        }
        return true;
    }

    public void themGV(){
        view.getBtnThemGV().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(view.getTxtMaTK().getText().isEmpty()){
                    tb("Mã tài khoản");
                }
                else if(view.getTxtMK().getText().isEmpty()){
                    tb("Mật khẩu");
                }
                else if(view.getTxtGV().getText().isEmpty()){
                    tb("Tên giáo viên");
                }
                else if(ktraNS(view.getTxtNS().getText()).equals("1")==true){
                    JOptionPane.showMessageDialog(null, "Sai định dạng ngày sinh. Định dạng ngày sinh là yyyy-MM-dd");
                }
                else if(ktrGT(view.getTxtGioiTinh().getText())==false){
                    JOptionPane.showMessageDialog(null, "Giới tính chỉ có thể là nam hoặc nữ");
                }
                else if(ktraEmail(view.getTxtEmail().getText())==false){
                    JOptionPane.showMessageDialog(null, "Sai định dạng email");
                }
                else if(view.getTxtSDT().getText().isEmpty()){
                    tb("Số điện thoại");
                }
                else if(ktrMon(view.getTxtMonDay().getText())==false){
                    JOptionPane.showMessageDialog(null, "Môn dạy không hợp lệ");
                }
                else if(view.getTxtDiaChi().getText().isEmpty()){
                    tb("Địa chỉ");
                }
                else{
                    Model.GiaoVien a=new Model.GiaoVien(view.getTxtMaTK().getText(), view.getTxtGV().getText(),
                        view.getTxtNS().getText(), view.getTxtGioiTinh().getText(), view.getTxtEmail().getText(),
                        view.getTxtSDT().getText(), view.getTxtMonDay().getText(), view.getTxtDiaChi().getText());
                    if(a.themGiaoVien().equals("1")==true){
                        Users s=new Users(view.getTxtMaTK().getText(), view.getTxtMK().getText(), 2);
                        s.themUser();
                    }
                }
                
            }
        });
    }
    
    public void updateGV(){
        view.getBtnSuaGV().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(view.getTxtMaTK().getText().isEmpty()){
                    tb("Mã tài khoản");
                }
                else if(view.getTxtMK().getText().isEmpty()){
                    tb("Mật khẩu");
                }
                else if(view.getTxtGV().getText().isEmpty()){
                    tb("Tên giáo viên");
                }
                else if(ktraNS(view.getTxtNS().getText()).equals("1")==true){
                    JOptionPane.showMessageDialog(null, "Sai định dạng ngày sinh. Định dạng ngày sinh là yyyy-MM-dd");
                }
                else if(ktrGT(view.getTxtGioiTinh().getText())==false){
                    JOptionPane.showMessageDialog(null, "Giới tính chỉ có thể là nam hoặc nữ");
                }
                else if(ktraEmail(view.getTxtEmail().getText())==false){
                    JOptionPane.showMessageDialog(null, "Sai định dạng email");
                }
                else if(view.getTxtSDT().getText().isEmpty()){
                    tb("Số điện thoại");
                }
                else if(ktrMon(view.getTxtMonDay().getText())==false){
                    JOptionPane.showMessageDialog(null, "Môn dạy không hợp lệ");
                }
                else if(view.getTxtDiaChi().getText().isEmpty()){
                    tb("Địa chỉ");
                }
                else{
                    Model.GiaoVien a=new Model.GiaoVien(view.getTxtMaTK().getText(), view.getTxtGV().getText(),
                        view.getTxtNS().getText(), view.getTxtGioiTinh().getText(), view.getTxtEmail().getText(),
                        view.getTxtSDT().getText(), view.getTxtMonDay().getText(), view.getTxtDiaChi().getText());
                    if(a.updateGV().equals("1")==true){
                        Users b=new Users(view.getTxtMaTK().getText(), view.getTxtMK().getText());
                        b.updateUser();
                        }
                    }
                }
        }); 
    }
    
    public void deleteGV(){
        view.getBtnXoaGV().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Model.GiaoVien a=new Model.GiaoVien(view.getTxtMaTK().getText(), view.getTxtGV().getText(),
                        view.getTxtNS().getText(), view.getTxtGioiTinh().getText(), view.getTxtEmail().getText(),
                        view.getTxtSDT().getText(), view.getTxtMonDay().getText(), view.getTxtDiaChi().getText());
                if(a.deleteGV().equals("1")==true){
                    Users b=new Users(view.getTxtMaTK().getText(), view.getTxtMK().getText());
                    b.deleteUser();
                    }
                }
        });
    }
    
    public void loadGV(){
        Thread t=new Thread(){
            @Override
            public void run(){
                while(true){
                    dl.removeAllElements();
                    for(Model.GiaoVien as:gv){
                            dl.addElement(as.getTen());
                        }
                        view.getListGV().setModel(dl);
                    try {
                        sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(QLGiaoVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t.start();
    }
    
    public void clickList(){
        view.getListGV().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                for(Model.GiaoVien as:gv){
                    if(as.getTen().equals(view.getListGV().getSelectedValue().toString())==true){
                        view.getTxtMaTK().setText(as.getMatk());
                        view.getTxtNS().setText(as.getNgaysinh());
                        view.getTxtGioiTinh().setText(as.getGioitinh());
                        view.getTxtGV().setText(as.getTen());
                        view.getTxtEmail().setText(as.getEmail());
                        view.getTxtSDT().setText(as.getSdt());
                        view.getTxtMonDay().setText(as.getMonday());
                        view.getTxtDiaChi().setText(as.getDiachi());
                    }
                }
                for(Users as:us){
                    if(as.getMatk().endsWith(view.getTxtMaTK().getText())==true){
                        view.getTxtMK().setText(as.getMatkhau());
                        }
                    }
                }

            @Override
            public void mousePressed(MouseEvent me) {}

            @Override
            public void mouseReleased(MouseEvent me) {}

            @Override
            public void mouseEntered(MouseEvent me) {}

            @Override
            public void mouseExited(MouseEvent me) {}
        });
    }
    
    public void ttGV(){
        try {
            File f=new File("user.txt");
            Scanner sc=new Scanner(f);
            while(sc.hasNext()){
                s1=sc.nextLine();
                s2=sc.nextLine();
                s3=sc.nextLine();
            }
            for(GiaoVien as:gv){
                if(as.getMatk().equalsIgnoreCase(s1)==true){
                    view1.getTxtMaGV().setText(s1);
                    view1.getTxtTenGV().setText(as.getTen());
                    view1.getTxtNgaySInh().setText(as.getNgaysinh());
                    view1.getTxtGioiTinh().setText(as.getGioitinh());
                    view1.getTxtEmail().setText(as.getEmail());
                    view1.getTxtSDTT().setText(as.getSdt());
                    view1.getTxtMonDay().setText(as.getMonday());
                    view1.getTxtDiaChi().setText(as.getDiachi());
                }
            }
            
            for(Users as:us){
                if(as.getMatk().equalsIgnoreCase(s1)==true){
                    view1.getTxtPass().setText(as.getMatkhau());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void hienTen(){
        try {
            File f=new File("user.txt");
            Scanner sc=new Scanner(f);
            while(sc.hasNext()){
                s1=sc.nextLine();
                s2=sc.nextLine();
                s3=sc.nextLine();
            }
            for(GiaoVien as:gv){
                if(as.getMatk().equalsIgnoreCase(s1)==true){
                    view2.getLabelTen().setText(as.getTen());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void dsGV(){
        dl.removeAllElements();
        for(GiaoVien as:gv){
            dl.addElement(as.getTen());
        }
        view3.getListPH().setModel(dl);
    }
    
    public void dsGVEvent(){
        view3.getListPH().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                view3.getTxtGV().setText(view3.getListPH().getSelectedValue().toString());
            }
            @Override
            public void mousePressed(MouseEvent me) {}
            @Override
            public void mouseReleased(MouseEvent me) {}
            @Override
            public void mouseEntered(MouseEvent me) {}
            @Override
            public void mouseExited(MouseEvent me) {}
        });
    }
    
}
