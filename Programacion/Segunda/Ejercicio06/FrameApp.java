/*
Manipulamos las características del Frame
 */
package Segunda.Ejercicio06;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;

public class FrameApp extends Frame{
    MenuBar porDefecto, alternativo;
    String tituloInicial;
    int cursores[] = {Cursor.CROSSHAIR_CURSOR, Cursor.DEFAULT_CURSOR, Cursor.E_RESIZE_CURSOR, Cursor.HAND_CURSOR, Cursor.MOVE_CURSOR, Cursor.NE_RESIZE_CURSOR, Cursor.NW_RESIZE_CURSOR, Cursor.N_RESIZE_CURSOR, Cursor.TEXT_CURSOR, Cursor.WAIT_CURSOR};
    int posCursor = 0;
    Color colores[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.DARK_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW};
    int posColor = 0;
    String fuentes[] = {"Helvetica", "TimesRoman", "Courier", "Dialog", "DialogInput", "Arial"};
    int posLetra = 0;
    public static void main (String arg[]){
        FrameApp app = new FrameApp();
    }
    public FrameApp(){
        super("Trabajando con Frames");
        tituloInicial = this.getTitle();
        setup();
        setupMenu();
        
        this.pack();
        this.setSize(400, 400);
        this.setVisible(true);
    }
    public void paint(Graphics g){
        g.drawString("Cambia el color al pulsar Foreground", 100, 150);
    }
    public void setup(){
        Panel principal = new  Panel();
        principal.setLayout(new GridLayout(4, 1));
        principal.add(new Label("Cambian las ccaracterísticas de la ventana", Label.CENTER));
        Panel panel1 = new Panel();
        panel1.add(new Button("Título"));
        panel1.add(new Button("MenuBar"));
        panel1.add(new Button("Resizable"));
        principal.add(panel1);
        principal.add(new Label("Salidas en la ventana", Label.CENTER));
        
        Panel panel2 = new Panel();
        panel2.add(new Button("Cursor"));
        panel2.add(new Button("Background"));
        panel2.add(new Button("Foreground"));
        panel2.add(new Button("Font"));
        principal.add(panel2);
        this.add("South", principal);
    }
    private void setupMenu() {
        porDefecto = new MenuBar();
        Menu fileMenu = new Menu("File");
        fileMenu.add(new MenuItem("Exit"));
        porDefecto.add(fileMenu);
        this.setMenuBar(porDefecto);
        alternativo = new MenuBar();
        Menu archivoMenu = new Menu("Archivo");
        archivoMenu.add(new MenuItem("Salir"));
        alternativo.add(archivoMenu);
    }
    public boolean handleEvent(Event ev){
        if(ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(ev.id == Event.ACTION_EVENT){
            if(ev.target instanceof Button)
                if(ev.arg.equals("Título")){
                    if(this.getTitle().equals(tituloInicial))
                        this.setTitle("Título Alternativo");
                    else
                        this.setTitle(tituloInicial);
                    return true;
                }else if(ev.arg.equals("MenuBar")){
                    if(this.getMenuBar().equals(porDefecto))
                        this.setMenuBar(alternativo);
                    else
                        this.setMenuBar(porDefecto);
                    return true;
                }else if(ev.arg.equals("Resizable")){
                    this.setResizable(!this.isResizable());
                    return true;
                }else if(ev.arg.equals("Cursor")){
                    this.setCursor(cursores[(posCursor++)%cursores.length]);
                    return true;
                }else if(ev.arg.equals("Background")){
                    this.setBackground(colores[(posColor++)%colores.length]);
                    return true;
                }else if(ev.arg.equals("Foreground")){
                    this.setForeground(colores[(posColor++)%colores.length]);
                    return true;
                }else if(ev.arg.equals("Font")){
                    this.setFont(new Font(fuentes[(posLetra++)%fuentes.length], Font.ITALIC, 15));
                    repaint();
                    return true;
                }
        }
        return false;
    }
}