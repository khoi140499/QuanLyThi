/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GiaoVien;
import Model.HocSinh;
import Model.Users;
import View.DiemThi;
import View.PhanHoiGV;
import View.QLHocSinh;
import View.TTHocSinh;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
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
public class ctlHocSinh {
    private QLHocSinh view;
    private DiemThi view1;
    private View.HocSinh view2;
    private TTHocSinh view3;
    private PhanHoiGV view4;
    DefaultListModel dl=new DefaultListModel();
    private ArrayList<Model.HocSinh> hs=new Model.HocSinh().loadHS();
    private ArrayList<Users> us=new Users().loadUser();
    private String s1="",s2="",s3="";
    public ctlHocSinh() {
    }

    public ctlHocSinh(QLHocSinh view) {
        this.view = view;
    }

    public ctlHocSinh(View.HocSinh view2) {
        this.view2 = view2;
    }

    public ctlHocSinh(TTHocSinh view3) {
        this.view3 = view3;
    }

    public ctlHocSinh(PhanHoiGV view4) {
        this.view4 = view4;
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

    private boolean ktrGT(String s){
        if(s.equalsIgnoreCase("nam")==false && s.equalsIgnoreCase("nữ")==false){
            return false;
        }
        return true;
    }
    
    public void themHS(){
        view.getBtnThemHS().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if(view.getTxtMaTK().getText().isEmpty()){
                        tb("Mã tài khoản");
                    }
                    else if(view.getTxtMK().getText().isEmpty()){
                        tb("Mật khẩu");
                    }
                    else if(view.getTxtHS().getText().isEmpty()){
                        tb("Tên học sinh");
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
                    else if(view.getTxtLop().getText().isEmpty()){
                        tb("Lớp");
                    }
                    else if(view.getTxtDiaChi().getText().isEmpty()){
                        tb("Địa chỉ");
                    }
                    else if(Integer.parseInt(view.getTxtKhoaHoc().getText())<=0){
                        try {
                            throw new Exception("Khóa học phải lơns hơn 0");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        Model.HocSinh a=new Model.HocSinh(view.getTxtMaTK().getText(), view.getTxtHS().getText(), view.getTxtNS().getText(),
                        view.getTxtGioiTinh().getText(), view.getTxtEmail().getText(), view.getTxtSDT().getText(), view.getTxtLop().getText(),
                        view.getTxtDiaChi().getText(), Integer.parseInt(view.getTxtKhoaHoc().getText()));
                        if(a.themHS().equals("1")==true){
                            Users s=new Users(view.getTxtMaTK().getText(), view.getTxtMK().getText(), 3);
                            s.themUser();
                            }
                        }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Không được nhập text trong textfield khóa học");
                    }
                }
        });
    }
    
    public void updateHS(){
        view.getBtnSuaHS().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if(view.getTxtMaTK().getText().isEmpty()){
                        tb("Mã tài khoản");
                    }
                    else if(view.getTxtMK().getText().isEmpty()){
                        tb("Mật khẩu");
                    }
                    else if(view.getTxtHS().getText().isEmpty()){
                        tb("Tên học sinh");
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
                    else if(view.getTxtLop().getText().isEmpty()){
                        tb("Lớp");
                    }
                    else if(view.getTxtDiaChi().getText().isEmpty()){
                        tb("Địa chỉ");
                    }
                    else if(Integer.parseInt(view.getTxtKhoaHoc().getText())<=0){
                        try {
                            throw new Exception("Khóa học phải lơns hơn 0");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        Model.HocSinh a=new Model.HocSinh(view.getTxtMaTK().getText(), view.getTxtHS().getText(), view.getTxtNS().getText(),
                        view.getTxtGioiTinh().getText(), view.getTxtEmail().getText(), view.getTxtSDT().getText(), view.getTxtLop().getText(),
                        view.getTxtDiaChi().getText(), Integer.parseInt(view.getTxtKhoaHoc().getText()));
                        if(a.updateHS().equals("1")==true){
                            Users b=new Users(view.getTxtMaTK().getText(), view.getTxtMK().getText());
                            b.updateUser();
                            }       
                    }
            } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Không được nhập text trong textfield khóa học");
                    }
                }
        });
    }
    
    public void deleteHS(){
        view.getBtnXoaHS().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Model.HocSinh a=new Model.HocSinh(view.getTxtMaTK().getText(), view.getTxtHS().getText(), view.getTxtNS().getText(),
                view.getTxtGioiTinh().getText(), view.getTxtEmail().getText(), view.getTxtSDT().getText(), view.getTxtLop().getText(),
                view.getTxtDiaChi().getText(), Integer.parseInt(view.getTxtKhoaHoc().getText()));
                if(a.deleteHS().equals("1")==true){
                    Users b=new Users(view.getTxtMaTK().getText(), view.getTxtMK().getText());
                    b.deleteUser();
                }
            }
        });
    }
    
    public void loadHS(){
        Thread a=new Thread(){
            @Override
            public void run(){
                while(true){
                    dl.removeAllElements();
                    for(Model.HocSinh as:hs){
                        dl.addElement(as.getTen());
                    }
                    view.getListHS().setModel(dl);
                    try {
                        sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(QLHocSinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        a.start();
    }
    
    public void clickHS(){
        view.getListHS().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                for(Model.HocSinh as:hs){
                    if(as.getTen().equals(view.getListHS().getSelectedValue().toString())==true){
                        view.getTxtMaTK().setText(as.getMatk());
                        view.getTxtNS().setText(as.getNgaysinh());
                        view.getTxtGioiTinh().setText(as.getGioitinh());
                        view.getTxtHS().setText(as.getTen());
                        view.getTxtEmail().setText(as.getEmail());
                        view.getTxtSDT().setText(as.getSdt());
                        view.getTxtLop().setText(as.getLop());
                        view.getTxtDiaChi().setText(as.getDiachi());
                        view.getTxtKhoaHoc().setText(as.getKhoahoc()+"");
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
    
    public void labelHS(){
        try {
            File f=new File("user.txt");
            Scanner sc=new Scanner(f);
            while(sc.hasNext()){
                s1=sc.nextLine();
                s2=sc.nextLine();
                s3=sc.nextLine();
            }
            for(HocSinh as:hs){
                if(as.getMatk().equalsIgnoreCase(s1)==true){
                    view2.getLb().setText(as.getTen());
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void ttHS(){
        for(HocSinh as:hs){
            if(as.getMatk().equalsIgnoreCase(maTK())==true){
                view3.getTxtMaGV().setText(as.getMatk());
                view3.getTxtTenGV().setText(as.getTen());
                view3.getTxtGioiTinh().setText(as.getGioitinh());
                view3.getTxtEmail().setText(as.getEmail());
                view3.getTxtSDTT().setText(as.getSdt());
                view3.getTxtDiaChi().setText(as.getDiachi());
                view3.getTxtKhoaHoc().setText(as.getKhoahoc()+"");
                view3.getTxtMonDay().setText(as.getLop());
                view3.getTxtNgaySInh().setText(as.getNgaysinh());
            }
        }
        for(Users as:us){
            if(as.getMatk().equalsIgnoreCase(maTK())==true){
                view3.getTxtPass().setText(as.getMatkhau());
            }
        }
    }
    
    public void updateTTHS(){
        view3.getBtnSuaTT().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if(view.getTxtMaTK().getText().isEmpty()){
                        tb("Mã tài khoản");
                    }
                    else if(view.getTxtMK().getText().isEmpty()){
                        tb("Mật khẩu");
                    }
                    else if(view.getTxtHS().getText().isEmpty()){
                        tb("Tên học sinh");
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
                    else if(view.getTxtLop().getText().isEmpty()){
                        tb("Lớp");
                    }
                    else if(view.getTxtDiaChi().getText().isEmpty()){
                        tb("Địa chỉ");
                    }
                    else if(Integer.parseInt(view.getTxtKhoaHoc().getText())<=0){
                        try {
                            throw new Exception("Khóa học phải lơns hơn 0");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    else{
                        Model.HocSinh a=new Model.HocSinh(view.getTxtMaTK().getText(), view.getTxtHS().getText(), view.getTxtNS().getText(),
                        view.getTxtGioiTinh().getText(), view.getTxtEmail().getText(), view.getTxtSDT().getText(), view.getTxtLop().getText(),
                        view.getTxtDiaChi().getText(), Integer.parseInt(view.getTxtKhoaHoc().getText()));
                        if(a.updateHS().equals("1")==true){
                            Users b=new Users(view.getTxtMaTK().getText(), view.getTxtMK().getText());
                            b.updateUser();
                            }       
                    }
            } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Không được nhập text trong textfield khóa học");
                    }
            }
        });
    }
    
    public void dsHS(){
        dl.removeAllElements();
        for(HocSinh as:hs){
            dl.addElement(as.getTen());
        }
        view4.getListPH().setModel(dl);
    }
    
    public void dsHSEvent(){
        view4.getListPH().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                view4.getTxtHS().setText(view4.getListPH().getSelectedValue().toString());
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
    
    private String maTK(){
        String s1 = null, s2,s3;
        try {
            File f=new File("user.txt");
            Scanner sc=new Scanner(f);
            while(sc.hasNext()){
                s1=sc.nextLine();
                s2=sc.nextLine();
                s3=sc.nextLine();
            }
        } catch (Exception e) {
        }
        return s1;
    }
}
