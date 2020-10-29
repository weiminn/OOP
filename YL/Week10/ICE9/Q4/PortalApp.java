// test class for the bank portal application

public class PortalApp {
    public static void main(String[] args) {
        PortalController ctrl = new PortalController();
        PortalMenu menu = new PortalMenu(ctrl);
        menu.processTransfer();
    }
}