
package kuis2;

public class LoginMVC {
    LoginView loginview = new LoginView();
    LoginModel loginmodel = new LoginModel();
    LoginDAO logindao = new LoginDAO();
    LoginController logincontroller = new LoginController(loginview, loginmodel, logindao);
}
