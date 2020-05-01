
package kuis2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController {
    LoginView loginview;
    LoginModel loginmodel;
    LoginDAO logindao;
    
    public LoginController(LoginView loginview, LoginModel loginmodel, LoginDAO logindao){
        this.logindao = logindao;
        this.loginmodel = loginmodel;
        this.loginview = loginview;
        
        loginview.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginview.getUsername();
                String password = loginview.getPassword();
                if(username.isEmpty() || password.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Harap Isi Semua Field");
            }else{
                    loginmodel.setLoginModel(username, password);
                    logindao.Login(loginmodel);
                    IntiMVC mvc = new IntiMVC();
                }
            }
        });
    }
}
