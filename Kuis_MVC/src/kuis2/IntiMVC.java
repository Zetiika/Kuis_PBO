
package kuis2;

public class IntiMVC {
    IntiView intiview = new IntiView();
    IntiModel intimodel = new IntiModel();
    IntiDAO intidao = new IntiDAO();
    IntiController inticontroller = new IntiController(intiview, intimodel, intidao);
}
