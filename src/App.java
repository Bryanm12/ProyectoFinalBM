import javax.swing.SwingUtilities;

import Controller.ControladorLaberinto;
import View.VistaLaberinto;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
        VistaLaberinto vista = new VistaLaberinto();
        ControladorLaberinto controller = new ControladorLaberinto(vista);
            vista.setVisible(true);
        });
}
}