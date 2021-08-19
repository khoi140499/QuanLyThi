/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Users;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;

/**
 *
 * @author khoi
 */
public class ctlLogin {
    private Login log;

    public ctlLogin() {
    }

    public ctlLogin(Login log) {
        this.log = log;
    }
    public void dNhap(){
        log.getBtnDN().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Users a=new Users(log.getTxtTenDN().getText(), log.getTxtMatKhau().getText());
                if(a.checkLogin().equals("1")==true){
                    log.setVisible(false);
                try {
                    File f=new File("user.txt");
                    PrintWriter pr=new PrintWriter(f);
                    if(log.getCkLuu().isSelected()==true){
                        pr.println(log.getTxtTenDN().getText());
                        pr.println(log.getTxtMatKhau().getText());
                        pr.println("true");
                        pr.close();
                    }   
                    else if(log.getCkLuu().isSelected()==true){
                        pr.println(log.getTxtTenDN().getText());
                        pr.println(log.getTxtMatKhau().getText());
                        pr.println("false");
                        pr.close();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                }
            }
        });
    }
}
