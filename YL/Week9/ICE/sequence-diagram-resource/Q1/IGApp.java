
public class IGApp {
    public static void main(String[] args) {
        SearchCtrl ctrl = new SearchCtrl();
        SearchMenu menu = new SearchMenu(ctrl);
        menu.readOption();
    }
}
