/*
Manipulamos un archivo de texto
 */
package Segunda.Ejercicio07;

import java.awt.Event;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditorApp extends Frame{
    MenuBar menubar;
    TextArea texto;
    FileDialog abrirFichero;
    FileDialog guardarFichero;
    public static void main (String arg[]){
        EditorApp app = new EditorApp();
    }
    public EditorApp(){
        super("Editor de textos");
        
        setup();
        
        this.pack();
        this.setSize(texto.minimumSize());
        this.setVisible(true);
    }
    public void paint(Graphics g){
        g.drawString("Cambia el color al pulsar Foreground", 100, 150);
    }
    public void setup(){
        setupMenu();
        texto=new TextArea(25, 50);
        this.add("Center", texto);
        abrirFichero = new FileDialog(this, "Abrir Fichero", FileDialog.LOAD);
        guardarFichero = new FileDialog(this, "Guardar Fichero", FileDialog.SAVE);
    }
    private void setupMenu() {
        menubar = new MenuBar();
        Menu fileMenu = new Menu("Archivo");
        fileMenu.add(new MenuItem("Nuevo"));
        fileMenu.add(new MenuItem("Abrir"));
        fileMenu.addSeparator();
        fileMenu.add(new MenuItem("Guardar"));
        fileMenu.addSeparator();
        fileMenu.add(new MenuItem("Salir"));
        menubar.add(fileMenu);
        this.setMenuBar(menubar);
    }
    public boolean handleEvent(Event ev){
        if(ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }else if(ev.id == Event.ACTION_EVENT){
            if(ev.target instanceof MenuItem)
                if(ev.arg.equals("Salir")){
                    System.exit(0);
                    return true;
                }else if(ev.arg.equals("Nuevo")){
                    texto.setText(" ");
                    return true;
                }else if(ev.arg.equals("Abrir")){
                    abrirFichero.setVisible(true);
                    String inFile = abrirFichero.getDirectory() + abrirFichero.getFile();
                try {
                    leerFichero(inFile);
                }catch (IOException e){}
                    return true;
                }else if(ev.arg.equals("Guardar")){
                    guardarFichero.setVisible(true);
                    String outFile = guardarFichero.getDirectory() + guardarFichero.getFile();
                    guardarFichero(outFile);
                    return true;
                }
        }
        return false;
    }
    private void leerFichero(String inFile) throws IOException{
        DataInputStream inStream;
        try{
        inStream = new DataInputStream(new FileInputStream(inFile));
        String nuevo_texto="";
        String linea;
        while((linea = inStream.readLine())!=null)
            nuevo_texto += linea + "\n";
        texto.setText(nuevo_texto);
        }catch(FileNotFoundException e){}
    }
    private void guardarFichero(String outFile){
        DataOutputStream outStream;
        try{
        outStream = new DataOutputStream(new FileOutputStream(outFile));
        outStream.writeBytes(texto.getText());
        }catch(FileNotFoundException e){}
        catch(IOException e){}
    }
}