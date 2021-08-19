/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GiaoVien;
import Model.HocSinh;
import Model.PhanHoi;
import View.PhanHoiGV;
import View.PhanHoiHS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.DefaultListModel;

/**
 *
 * @author khoi
 */
public class ctlPhanHoi {
    private PhanHoiHS view;
    private PhanHoiGV view1;
    private ArrayList<GiaoVien> gv=new GiaoVien().loadGV();
    private ArrayList<HocSinh> hs=new HocSinh().loadHS();
    private DefaultListModel dl=new DefaultListModel();
    private DefaultListModel dll=new DefaultListModel();
    private DefaultListModel dll1=new DefaultListModel();
    private ArrayList<PhanHoi> ph=new PhanHoi().loadPH();
    private String s1="";
    private String s2="";
    public ctlPhanHoi() {
    }

    public ctlPhanHoi(PhanHoiHS view) {
        this.view = view;
    }

    public ctlPhanHoi(PhanHoiGV view1) {
        this.view1 = view1;
    }
    
    public void guiPHHS(){
        view.getBtnHui().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(GiaoVien as:gv){
                    if(as.getTen().equalsIgnoreCase(view.getTxtGV().getText())){
                        s1=as.getMatk();
                    }
                }
                PhanHoi a=new PhanHoi(maTK(), s1, view.getTxtTraLoi().getText(), 1);
                a.guiPH();
                view.getTxtTraLoi().setText("");
            }
        });
    }
    
    public void guiPHGV(){
        view1.getBtnHui().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(HocSinh as:hs){
                    if(as.getTen().equalsIgnoreCase(view1.getTxtHS().getText())){
                        s2=as.getMatk();
                    }
                }
                PhanHoi a=new PhanHoi(maTK(), s2, view1.getTxtTraLoi().getText(), 1);
                a.guiPH();
                view1.getTxtTraLoi().setText("");
            }
        });
    }
    
    public void xemPH(){
        HashSet<String> hs=new HashSet<>();
        for(PhanHoi as:ph){
            if(as.getMann().equalsIgnoreCase(maTK())==true && String.valueOf(as.getTt()).equals("1")==true){
               hs.add(as.getMang());
            }
        }
        for(String as:hs){
            for(GiaoVien as1:gv){
                if(as.toString().equalsIgnoreCase(as1.getMatk())==true){
                    dl.addElement(as1.getTen());
                }
            }
        }
        view.getListCanPH().setModel(dl);
    }
    
    public void xemPHGV(){
        HashSet<String> hss=new HashSet<>();
        for(PhanHoi as:ph){
            if(as.getMann().equalsIgnoreCase(maTK())==true && String.valueOf(as.getTt()).equals("1")==true){
               hss.add(as.getMang());
            }
        }
        for(String as:hss){
            for(HocSinh as1:hs){
                if(as.toString().equalsIgnoreCase(as1.getMatk())==true){
                    dl.addElement(as1.getTen());
                }
            }
        }
        view1.getListCanPH().setModel(dl);
    }
    
    public void clickXemPH(){
        view1.getListCanPH().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                String s3="";
                view1.getTxtHS().setText(view1.getListCanPH().getSelectedValue().toString());
                for(HocSinh as:hs){
                    if(as.getTen().equalsIgnoreCase(view1.getTxtHS().getText())==true){
                        s3=as.getMatk();
                    }
                }
                dll.removeAllElements();
                for(PhanHoi as:ph){
                    if(as.getMang().equalsIgnoreCase(s3)==true && 
                            as.getMann().equalsIgnoreCase(maTK())==true
                            && String.valueOf(as.getTt()).equals("1")==true){
                        dll.addElement(as.toString());
                        System.out.println(as.toString());
                    }
                }
                view1.getTxtTN().setModel(dll);
                
                PhanHoi a=new PhanHoi(s3, maTK());
                a.updatePH();
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
    
    public void clickXemPHHS(){
        view.getListCanPH().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                String s3="";
                dll1.removeAllElements();
                view.getTxtGV().setText(view.getListCanPH().getSelectedValue().toString());
                for(GiaoVien as:gv){
                    if(as.getTen().equalsIgnoreCase(view.getTxtGV().getText())==true){
                        s3=as.getMatk();
                    }
                }
                for(PhanHoi as:ph){
                    if(as.getMang().equalsIgnoreCase(s3)==true &&
                            as.getMann().equalsIgnoreCase(maTK())==true
                            && String.valueOf(as.getTt()).equals("1")==true){
                        dll1.addElement(as.toString());
                    }
                }
                view.getTxtTN().setModel(dll1);
                
                PhanHoi a=new PhanHoi(s3, maTK());
                a.updatePH();
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
