package View;

import javax.swing.*;
import Model.ModeloLaberinto;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class VistaLaberinto extends JFrame{
    private JTextField txtFilas;
    private JTextField txtColumnas;
    private JButton generarBoton;
    private JPanel matrizPanel;
    private JButton[] actionBotones;
    private JButton[][] matrizBotones; 
    private Timer timer;
    private int currentStep = 0;
    private List<int[]> path = new ArrayList<>();
    private boolean[][] visited;

    public VistaLaberinto() {
        setTitle("Laberinto");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        inputPanel.add(new JLabel("Número de filas:"));
        txtFilas = new JTextField();
        inputPanel.add(txtFilas);

        inputPanel.add(new JLabel("Número de columnas:"));
        txtColumnas = new JTextField();
        inputPanel.add(txtColumnas);

        generarBoton = new JButton("Generar Matriz");
        inputPanel.add(generarBoton);

        add(inputPanel, BorderLayout.CENTER);
    }

    public void setGenerateButtonListener(ActionListener listener) {
        generarBoton.addActionListener(listener);
    }

    public int getFilas() {
        try {
            return Integer.parseInt(txtFilas.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido de filas", "Error", JOptionPane.ERROR_MESSAGE);
            return 0; 
        }
    }

    public int getColumnas() {
        try {
            return Integer.parseInt(txtColumnas.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un número válido de columnas", "Error", JOptionPane.ERROR_MESSAGE);
            return 0; 
        }
    }

    public void mostrarMatriz(ModeloLaberinto modelo) {
        JFrame matrizFrame = new JFrame("Matriz");
        matrizFrame.setSize(400, 400);
        matrizFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        matrizFrame.setLayout(new BorderLayout());
    
        matrizPanel = new JPanel();
        matrizPanel.setLayout(new GridLayout(modelo.getFilas(), modelo.getColumnas()));
        matrizBotones = new JButton[modelo.getFilas()][modelo.getColumnas()];
    
        for (int i = 0; i < modelo.getFilas(); i++) {
            for (int j = 0; j < modelo.getColumnas(); j++) {
                JButton cell = new JButton();
                cell.setBackground(Color.WHITE); 
                cell.setOpaque(true);
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cell.addActionListener(new CellButtonListener());
                matrizBotones[i][j] = cell; 
                matrizPanel.add(cell);
            }
        }
    
        matrizFrame.add(matrizPanel, BorderLayout.CENTER);
    
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4)); 
    
        
        JButton buttonRecursivo = new JButton("Método Recursivo");
        buttonRecursivo.addActionListener(new recursivoMetodoButtonListener());
        buttonPanel.add(buttonRecursivo);
    
        
        JButton buttonDinamico = new JButton("Método Dinámico");
        buttonDinamico.addActionListener(new programacionDinamicaButtonListener());
        buttonPanel.add(buttonDinamico);
    
        
        JButton buttonBFS = new JButton("Método BFS");
        buttonBFS.addActionListener(new BFSButtonListener());
        buttonPanel.add(buttonBFS);
    
        
        JButton buttonDFS = new JButton("Método DFS");
        buttonDFS.addActionListener(new DFSButtonListener());
        buttonPanel.add(buttonDFS);
    
       
        JButton buttonLimpiar = new JButton("Limpiar");
        buttonLimpiar.addActionListener(new ClearButtonListener());
        buttonPanel.add(buttonLimpiar);
    
        matrizFrame.add(buttonPanel, BorderLayout.SOUTH);
    
        matrizFrame.setVisible(true);
    }

    private class CellButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton cell = (JButton) e.getSource();
            cell.setBackground(Color.BLACK); 
        }
    }

    private class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (matrizBotones != null) {
                for (int i = 0; i < matrizBotones.length; i++) {
                    for (int j = 0; j < matrizBotones[i].length; j++) {
                        matrizBotones[i][j].setBackground(Color.WHITE);
                    }
                }
            }
        }
    }

    private class recursivoMetodoButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (matrizBotones != null) {
                path.clear();
                visited = new boolean[matrizBotones.length][matrizBotones[0].length];
                currentStep = 0;
                recorrerMatriz(0, 0); 
                timer = new Timer(500, new TimerListener()); 
                timer.start();
            }
        }
    }

    private void recorrerMatriz(int fila, int columna) {
        if (fila < 0 || fila >= matrizBotones.length || columna < 0 || columna >= matrizBotones[0].length || visited[fila][columna] || matrizBotones[fila][columna].getBackground() != Color.WHITE) {
            return;
        }

        visited[fila][columna] = true;
        path.add(new int[]{fila, columna});

        if (fila == matrizBotones.length - 1 && columna == matrizBotones[0].length - 1) {
            return; 
        }

        recorrerMatriz(fila, columna + 1); 
        recorrerMatriz(fila + 1, columna); 
        recorrerMatriz(fila, columna - 1); 
        recorrerMatriz(fila - 1, columna); 
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentStep < path.size()) {
                int[] coordenadas = path.get(currentStep);
                int fila = coordenadas[0];
                int columna = coordenadas[1];
                matrizBotones[fila][columna].setBackground(Color.GREEN);
                currentStep++;
            } else {
                if (timer != null) {
                    timer.stop();
                }
            }
        }
    }

    private class programacionDinamicaButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (matrizBotones != null) {
                path.clear();
                int filas = matrizBotones.length;
                int columnas = matrizBotones[0].length;
                int[][] cache = new int[filas][columnas];
                int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        cache[i][j] = Integer.MAX_VALUE; 
                    }
                }
                cache[0][0] = 0;

                boolean pathExists = fillCache(filas, columnas, cache, directions);

                if (pathExists) {
                    path = reconstructPath(filas - 1, columnas - 1, cache, directions);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay camino disponible.");
                }

                currentStep = 0;
                timer = new Timer(500, new TimerListener()); 
                timer.start();
            }
        }

        private boolean fillCache(int filas, int columnas, int[][] cache, int[][] directions) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (cache[i][j] != Integer.MAX_VALUE) {
                        for (int[] dir : directions) {
                            int ni = i + dir[0];
                            int nj = j + dir[1];
                            if (ni >= 0 && ni < filas && nj >= 0 && nj < columnas) {
                                if (matrizBotones[ni][nj].getBackground() == Color.WHITE && cache[i][j] + 1 < cache[ni][nj]) {
                                    cache[ni][nj] = cache[i][j] + 1;
                                }
                            }
                        }
                    }
                }
            }
            return cache[filas - 1][columnas - 1] != Integer.MAX_VALUE;
        }

        private List<int[]> reconstructPath(int fila, int columna, int[][] cache, int[][] directions) {
            List<int[]> path = new ArrayList<>();
            while (fila != 0 || columna != 0) {
                path.add(new int[]{fila, columna});
                for (int[] dir : directions) {
                    int ni = fila - dir[0];
                    int nj = columna - dir[1];
                    if (ni >= 0 && ni < cache.length && nj >= 0 && nj < cache[0].length) {
                        if (cache[fila][columna] == cache[ni][nj] + 1) {
                            fila = ni;
                            columna = nj;
                            break;
                        }
                    }
                }
            }
            path.add(new int[]{0, 0});
            Collections.reverse(path);
            return path;
        }
    }

    private class BFSButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (matrizBotones != null) {
                path.clear();
                visited = new boolean[matrizBotones.length][matrizBotones[0].length];
                currentStep = 0;
                bfs(0, 0);
                timer = new Timer(500, new TimerListener());
                timer.start();
            }
        }

        private void bfs(int startRow, int startCol) {
            int filas = matrizBotones.length;
            int columnas = matrizBotones[0].length;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 

            Queue<int[]> queue = new LinkedList<>();
            Map<String, int[]> parentMap = new HashMap<>();

            queue.add(new int[]{startRow, startCol});
            visited[startRow][startCol] = true;
            parentMap.put(startRow + "," + startCol, null);

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentCol = current[1];

                if (currentRow == filas - 1 && currentCol == columnas - 1) {
                    path = reconstructPath(currentRow, currentCol, parentMap);
                    return;
                }

                for (int[] dir : directions) {
                    int newRow = currentRow + dir[0];
                    int newCol = currentCol + dir[1];

                    if (newRow >= 0 && newRow < filas && newCol >= 0 && newCol < columnas &&
                        !visited[newRow][newCol] && matrizBotones[newRow][newCol].getBackground() == Color.WHITE) {
                        visited[newRow][newCol] = true;
                        queue.add(new int[]{newRow, newCol});
                        parentMap.put(newRow + "," + newCol, new int[]{currentRow, currentCol});
                    }
                }
            }
        }

        private List<int[]> reconstructPath(int endRow, int endCol, Map<String, int[]> parentMap) {
            List<int[]> path = new ArrayList<>();
            int[] current = new int[]{endRow, endCol};

            while (current != null) {
                path.add(current);
                current = parentMap.get(current[0] + "," + current[1]);
            }

            Collections.reverse(path);
            return path;
        }
    }

    private class DFSButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (matrizBotones != null) {
                path.clear();
                visited = new boolean[matrizBotones.length][matrizBotones[0].length];
                currentStep = 0;
                dfs(0, 0); 
                timer = new Timer(500, new TimerListener()); 
                timer.start();
            }
        }

        private void dfs(int startRow, int startCol) {
            int filas = matrizBotones.length;
            int columnas = matrizBotones[0].length;
            int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 

            Stack<int[]> stack = new Stack<>();
            stack.push(new int[]{startRow, startCol});
            visited[startRow][startCol] = true;
            path.add(new int[]{startRow, startCol});

            while (!stack.isEmpty()) {
                int[] current = stack.pop();
                int currentRow = current[0];
                int currentCol = current[1];

                if (currentRow == filas - 1 && currentCol == columnas - 1) {
                    return;
                }


                for (int[] dir : directions) {
                    int newRow = currentRow + dir[0];
                    int newCol = currentCol + dir[1];

                    if (newRow >= 0 && newRow < filas && newCol >= 0 && newCol < columnas &&
                        !visited[newRow][newCol] && matrizBotones[newRow][newCol].getBackground() == Color.WHITE) {
                        visited[newRow][newCol] = true;
                        stack.push(new int[]{newRow, newCol});
                        path.add(new int[]{newRow, newCol});
                    }
                }
            }
        }
    }

    public void setActionButtonListener(int index, ActionListener listener) {
        if (index >= 0 && index < actionBotones.length) {
            actionBotones[index].addActionListener(listener);
        }
    }
}
