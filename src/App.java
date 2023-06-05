import componentes.Boton;
import componentes.Ficha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class App extends JFrame {

    JPanel miPanel;
    JPanel miPanel2;
    Ficha miFicha;
    Boton miBoton;
    ArrayList<Ficha> misFichas = new ArrayList<>();

    public App() {
        miPanel = new JPanel();
        miPanel2 = new JPanel();
        miBoton = new Boton("Start");
        miPanel.setLayout(new GridLayout(3,3));
        this.add(miPanel, BorderLayout.CENTER);
        this.add(miBoton, BorderLayout.SOUTH);

        for(int i = 1; i<10; i++){
            miPanel.add(miFicha = new Ficha(i));
            misFichas.add(miFicha);
        }

        miBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(miBoton.getActivo()){
                    miBoton.setText("Start");
                    miBoton.setBackground(Color.green);
                    miBoton.setActivo(false);
                }else{
                    miBoton.setText("Stop");
                    miBoton.setBackground(Color.gray);
                    miBoton.setActivo(true);
                }

                for(int i = 0; i<9; i++){
                    if(!misFichas.get(i).getActivo()){
                        misFichas.get(i).setActivo(true);
                        misFichas.get(i).mostrarNumero();
                    }else{
                        misFichas.get(i).setActivo(false);
                        misFichas.get(i).ocultarNumero();
                    }
                }
            }
        });





        this.setVisible(true);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /*
    public static void main(String[] args) {
        JPanel miPanel = new JPanel();
        App miVentana = new App();
        miPanel.setLayout(new GridLayout(3,3));
        miVentana.add(miPanel);


        miVentana.setVisible(true);
        miVentana.setSize(600, 600);
        miVentana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

     */
}
