import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Foro extends JFrame implements ActionListener{

    // Oracle The Java Tutorials. (s.f.). Trail: Creating a GUI With Swing.
    //      https://docs.oracle.com/javase/tutorial/uiswing/

    private JButton cambiarPosicionBoton, calcularRaizBoton, contadorBoton;
    private JPanel Jpanel,primerPanel, segundoPanel, tercerPanel;
    private JTextField valorRaizText, resultadoRaizText, valorContador;

    public Foro(){
        cambiarPosicion();
        calcularRaizCuadrada();
        contador();

        add(Jpanel);
    }

    private void cambiarPosicion(){
        primerPanel.setBounds(0, 0, 500, 200);

        cambiarPosicionBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int aleatorioWidth = (int)(aleatorio() * 350)+1;
                int aleatorioHeight = (int)(aleatorio() * 100)+1;
                cambiarPosicionBoton.setBounds(aleatorioWidth, aleatorioHeight,140, 25);
            }
        });

        add(primerPanel);
    }

    private void calcularRaizCuadrada(){
        segundoPanel.setBounds(0, 200, 500, 200);
        resultadoRaizText.setEnabled(false);
        calcularRaizBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double raiz = Math.sqrt(Double.parseDouble(valorRaizText.getText()));
                resultadoRaizText.setText(String.valueOf(raiz));
            }
        });
        add(segundoPanel);
    }

    private void contador(){
        tercerPanel.setBounds(0, 400, 500, 200);
        valorContador.setEnabled(false);
        contadorBoton.addActionListener(new ActionListener() {

            int contador = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                contador++;
                valorContador.setText(String.valueOf(contador));
            }
        });
        add(tercerPanel);
    }

    public double aleatorio(){
        return Math.random();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Foro foro = new Foro();
                foro.setTitle("Foro 3 Semana");
                foro.setBounds(0, 0, 500, 600);
                foro.setVisible(true);
            }
        });
    }
}
