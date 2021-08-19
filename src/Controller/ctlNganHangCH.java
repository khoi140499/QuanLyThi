/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GiaoVien;
import Model.NganHangCH;
import View.QLNganHang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author khoi
 */
public class ctlNganHangCH {
    private QLNganHang view;
    private ArrayList<GiaoVien> gv=new GiaoVien().loadGV();
    private String s1="";
    private ArrayList<NganHangCH> nh=new ArrayList();
    private ArrayList<NganHangCH> nh1=new NganHangCH().loadNH();
    public ctlNganHangCH() {
    }

    public ctlNganHangCH(QLNganHang view) {
        this.view = view;
    }
    
    public void themNH(){
        view.getBtnThemNH().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser jf=new JFileChooser();
                if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                    try {
                        File f=jf.getSelectedFile();
                        view.getTxtFileChon().setText(f.getName());
                        Scanner sc=new Scanner(f);
                        while (sc.hasNext()) {
                            NganHangCH a=new NganHangCH(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
                            nh.add(a);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
                
                for(GiaoVien as:gv){
                    if(as.getMatk().equalsIgnoreCase(maTK())==true){
                        s1=as.getMonday();System.out.println(as.getMonday());
                    }
                }
                NganHangCH a=new NganHangCH(s1);
                a.themNH(nh);
            }
        });
    }
    
    public void xoaNH(){
        view.getBtnXoaNH().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for(GiaoVien as:gv){
                    if(as.getMatk().equalsIgnoreCase(maTK())==true){
                        s1=as.getMonday();
                    }
                }
                NganHangCH a=new NganHangCH(s1);
                a.xoaNH();
            }
        });
    }
    
    public void suaNH(){
         view.getBtnSuaNH().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                 for(GiaoVien as:gv){
                     if(as.getMatk().equalsIgnoreCase(maTK())==true){
                         s1=as.getMonday();
                     }
                 }
                 for(NganHangCH as:nh1){
                     if(as.getMon().equalsIgnoreCase(s1)==true){
                         NganHangCH a=new NganHangCH(as.getCauhoi(), as.getDaA(), as.getDaB(),
                                 as.getDaC(), as.getDaD(), as.getDaDung());
                         nh.add(a);
                     }
                 }
                 JFileChooser jf=new JFileChooser();
                 if(jf.showSaveDialog(null)==JFileChooser.APPROVE_OPTION){
                     try {
                         File f=jf.getSelectedFile();
                         PrintWriter pr=new PrintWriter(f);
                         for(NganHangCH as:nh){
                             pr.println(as.toString());
                         }
                         pr.close();
                     } catch (Exception e) {
                         System.out.println(e);
                     }
                 }
             }
         });
    }
    
    public void taiLen(){
        view.getBtnTaiLen().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                  JFileChooser jf=new JFileChooser();
                  if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
                      try {
                          File f=jf.getSelectedFile();
                          Scanner sc=new Scanner(f);
                          while(sc.hasNext()){
                              NganHangCH a=new NganHangCH(sc.nextLine(), sc.nextLine(), sc.nextLine(),
                                      sc.nextLine(), sc.nextLine(), sc.nextLine());
                              nh.add(a);
                          }
                          for(GiaoVien as:gv){
                              if(as.getMatk().equalsIgnoreCase(maTK())==true){
                                  s1=as.getMonday();
                              }
                          }
                          NganHangCH a=new NganHangCH();
                          a.updateNH(nh, s1);
                      } catch (Exception e) {
                          System.out.println(e);
                      }
                  }
            }
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
