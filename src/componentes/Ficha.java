package componentes;

import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ficha extends JButton {
    int index;
    Color colorFondo;
    Boolean activo = false;

    public Ficha() {
        this.setBackground(Color.BLUE);
        this.colorFondo = Color.BLUE;
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 20));
    }
    public Ficha(int index) {
        this.setBackground(Color.BLUE);
        this.colorFondo = Color.BLUE;
        this.index = index;
        //this.setText(String.valueOf(index));
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 20));
    }
    public Ficha(int index, Color color) {
        this.setBackground(Color.BLUE);
        this.colorFondo = color;
        this.index = index;
        //this.setText(String.valueOf(index));
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Arial", Font.BOLD, 20));
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public Color getColorFondo() {
        return this.colorFondo;
    }
    public void setColorFondo(Color colorFondo) {
        this.setBackground(colorFondo);
    }
    // Declaracion de los métodos de la clase componentes.Ficha
    public void mostrarNumero() {
        this.setText(String.valueOf(index));
    }
    public void ocultarNumero() {
        this.setText("");
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public static void main(String[] args) {
        try(ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("miFicha.obj"))){
            Ficha miFicha = new Ficha();
            flujoSalida.writeObject(miFicha);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
