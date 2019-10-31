import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class bt3 {
    private JFrame frame;
    private JPanel panelTop;
    private JEditorPane editor;
    private JScrollPane scroll;
    private JTextField field;
    private JButton button;
    private URL url;

    public bt3(String title) {
        initComponents();
        frame.setTitle(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.add(BorderLayout.NORTH, panelTop);
        panelTop.add(field);
        panelTop.add(button);
        frame.add(BorderLayout.CENTER, scroll);
        frame.setVisible(true);
    }
    private void initComponents() {
  
        frame = new JFrame();
        panelTop = new JPanel();
        try {
            url = new URL("http://www.google.com");
        }
        catch(MalformedURLException mue) {
            JOptionPane.showMessageDialog(null,mue);
        }
        try {
            editor = new JEditorPane(url);
            editor.setEditable(false);
        }
        catch(IOException ioe) {
            JOptionPane.showMessageDialog(null,ioe);
        }
        scroll = new JScrollPane(editor, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        field = new JTextField();
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               field.setText(url.toString());
           }
        });
        button = new JButton("Go");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    editor.setPage(field.getText());
                }
                catch(IOException ioe) {
                    JOptionPane.showMessageDialog(null, ioe);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new bt3("Simple web bt3");
            }
        });
    }
}