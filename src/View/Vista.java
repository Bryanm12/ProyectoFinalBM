package View;
import java.awt.*;
import java.awt.event.*;

public class Vista extends Frame {
    private Button[][] botones;
    private int filas;
    private int columnas;

    public Vista() {
        super("Laberinto");
        setSize(400, 400);
        setLayout(new GridLayout(0, 1));


        pedirFilasYColumnas();
        

        botones = new Button[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new Button();
                botones[i][j].setBackground(Color.GRAY);
                botones[i][j].addActionListener(new ColorBotonListener(i, j));
                add(botones[i][j]);
            }
        }

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void pedirFilasYColumnas() {

        Dialog dialogo = new Dialog(this, "Ingrese filas y columnas", true);
        dialogo.setLayout(new FlowLayout());
        dialogo.setSize(300, 150);

        Label lblFilas = new Label("Filas: ");
        TextField txtFilas = new TextField(10);
        Label lblColumnas = new Label("Columnas: ");
        TextField txtColumnas = new TextField(10);
        Button btnOk = new Button("OK");

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    filas = Integer.parseInt(txtFilas.getText());
                    columnas = Integer.parseInt(txtColumnas.getText());
                    dialogo.dispose(); 
                    inicializarBotones(); 
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }
            }
        });

        dialogo.add(lblFilas);
        dialogo.add(txtFilas);
        dialogo.add(lblColumnas);
        dialogo.add(txtColumnas);
        dialogo.add(btnOk);

        dialogo.setVisible(true); 
    }

    private void inicializarBotones() {
    
        removeAll();
        setLayout(new GridLayout(filas, columnas));


        botones = new Button[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new Button();
                botones[i][j].setBackground(Color.GRAY);
                botones[i][j].addActionListener(new ColorBotonListener(i, j));
                add(botones[i][j]);
            }
        }


        setSize(400, 400);
        setVisible(true);
    }

    private class ColorBotonListener implements ActionListener {
        private int fila;
        private int columna;

        public ColorBotonListener(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        public void actionPerformed(ActionEvent e) {
            botones[fila][columna].setBackground(Color.BLUE);
        }
    }
}