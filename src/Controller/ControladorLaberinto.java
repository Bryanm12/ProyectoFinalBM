package Controller;

import Model.ModeloLaberinto;
import View.VistaLaberinto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorLaberinto {
    private VistaLaberinto vista;
    private ModeloLaberinto modelo;

    public ControladorLaberinto(VistaLaberinto vista) {
        this.vista=vista;
        this.vista.setGenerateButtonListener(new GenerarButtonListener());
    }

    class GenerarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int filas = vista.getFilas();
            int columnas = vista.getColumnas();
            modelo = new ModeloLaberinto(filas, columnas);
            vista.mostrarMatriz(modelo);
        }
    }
}

