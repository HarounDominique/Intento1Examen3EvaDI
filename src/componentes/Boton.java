package componentes;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    public Boton() {
        this.titulo = "Start";
        this.setText(this.titulo);
        this.colorFondo = Color.GREEN;
        this.setBackground(colorFondo);
    }

    public static void main(String[] args) {
        Boton miBoton = new Boton();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("miBoton.obj"))) {
            oos.writeObject(miBoton);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
