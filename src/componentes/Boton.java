package componentes;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Boton extends JButton implements Serializable {
    String titulo;
    Color colorFondo;

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        this.setText(this.titulo);
    }

    public Boton(String titulo) {
        this.titulo = titulo;
        this.setText(this.titulo);
        this.colorFondo = Color.GREEN;
        this.setBackground(colorFondo);
    }
}
