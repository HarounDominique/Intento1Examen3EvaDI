import componentes.Boton;
import componentes.Ficha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class App extends JFrame {

    Boolean active = false;
    JPanel miPanel;
    JPanel miPanel2;
    Ficha miFicha;
    Boton miBoton;
    //Ficha[] misFichas = new Ficha[9];
    ArrayList<Ficha> misFichas = new ArrayList<>();
    ArrayList<Color> misColores = new ArrayList<>();

    public App() throws IOException, ClassNotFoundException {
        misColores.add(Color.RED);
        misColores.add(Color.BLACK);
        misColores.add(Color.YELLOW);
        misColores.add(Color.PINK);
        misColores.add(Color.CYAN);
        misColores.add(Color.GRAY);
        misColores.add(Color.ORANGE);
        misColores.add(Color.GREEN);
        misColores.add(Color.MAGENTA);

        miPanel = new JPanel();
        miPanel2 = new JPanel();
        ObjectInputStream flujoEntrada = new ObjectInputStream(new FileInputStream("miBoton.obj"));
        Boton miBoton = (Boton)flujoEntrada.readObject();
        //miBoton = new Boton("Start");
        miPanel.setLayout(new GridLayout(3,3));
        this.add(miPanel, BorderLayout.CENTER);
        this.add(miBoton, BorderLayout.SOUTH);

        for(int i = 1; i<10; i++){
            miPanel.add(miFicha = new Ficha(i));
            misFichas.add(miFicha);
            miFicha.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(active){
                        int numeroAleatorio = (int) (Math.random() * 9) + 1;
                        Ficha miFichaAux = (Ficha)e.getSource();
                        miFichaAux.setIndex(numeroAleatorio);
                        miFichaAux.setText(String.valueOf(miFichaAux.getIndex()));
                        miFichaAux.setColorFondo(misColores.get(numeroAleatorio-1));
                    }
                }
            });
        }

        miBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(active){
                    miBoton.setText("Start");
                    miBoton.setBackground(Color.green);
                   active = false;
                }else{
                    miBoton.setText("Stop");
                    miBoton.setBackground(Color.gray);
                    active = true;
                }

                for(int i = 0; i<9; i++){
                    if(active){
                        misFichas.get(i).mostrarNumero();
                    }else{
                        misFichas.get(i).ocultarNumero();
                        misFichas.get(i).setColorFondo(Color.BLUE);
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
