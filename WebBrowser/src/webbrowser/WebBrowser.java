
package webbrowser;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class WebBrowser {
    private JFrame frame;
    private JPanel topPanel;
    private JEditorPane editor;
    private JScrollPane scroll;
    private JTextField field;
    private JButton go;
    private URL url;
    public WebBrowser(String title){
        initComponents();
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.add(BorderLayout.NORTH, topPanel);
        topPanel.add(field);
        topPanel.add(go);
        frame.add(BorderLayout.CENTER, scroll);
        frame.setVisible(true);
    }
    private void initComponents(){
        frame = new JFrame();
        topPanel = new JPanel();
        try{
            url = new URL("https://www.google.com");
        }catch(MalformedURLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        try{
            editor = new JEditorPane(url);
            editor.setEditable(false);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
        scroll = new JScrollPane(editor, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        field = new JTextField();
        SwingUtilities.invokeLater(new Runnable() {
            public void run(){
                field.setText(url.toString());
            }
        });
        go = new JButton("GO");
        go.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    editor.setPage(field.getText());
                }catch(IOException e1){
                    JOptionPane.showMessageDialog(null, e1);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new WebBrowser("TenK");
            }
        });
    }
    
}
