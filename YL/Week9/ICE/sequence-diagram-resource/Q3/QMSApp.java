
public class QMSApp {
    public static void main(String[] args) {
        CheckScoreCtrl ctrl = new CheckScoreCtrl();
        CheckScoreMenu menu = new CheckScoreMenu(ctrl);
        menu.readOption();
    }
}
