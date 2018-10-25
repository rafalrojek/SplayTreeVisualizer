package pl.edu.wat.wcy.isi.GUI;

import pl.edu.wat.wcy.isi.Model.SplayTreeNode;
import pl.edu.wat.wcy.isi.Operations.*;
import javax.swing.*;
import java.util.Random;

public class SplayTree {
    private JPanel windowPanel;
    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField numberTextField;
    private JCheckBox entableAnimationCheckBox;
    private JButton prevButton;
    private JButton playButton;
    private JButton nextButton;
    private JButton addRandomButton;
    private JButton deleteAllButton;
    private JPanel treePanel;
    private JTextField minTextField;
    private JTextField maxTextField;
    private JTextField sizeTextField;
    private JPanel buttonsPanel;
    private JPanel settingsPanel;
    private JTextArea textArea1;

    private SplayTree() {
        addButton.addActionListener(e -> {
            try {
                new Insert(Integer.parseInt(numberTextField.getText()));
            }catch (NumberFormatException ex) { System.out.print("Nie wpisano liczby!");
            } finally {endDrawTree(); }
        });

        deleteButton.addActionListener(e -> {
            try {
                new Delete(Integer.parseInt(numberTextField.getText()));
            }catch (NumberFormatException ex) { System.out.print("Nie wpisano liczby!");
            } finally { endDrawTree(); }
        });

        searchButton.addActionListener(e -> {
            try {
                new Get(Integer.parseInt(numberTextField.getText()));
            }catch (NumberFormatException ex) { System.out.print("Nie wpisano liczby!");
            } finally {endDrawTree(); }
        });

        addRandomButton.addActionListener(e -> {
            int size, min, max;
            try {
                size = Integer.parseInt(sizeTextField.getText());
                min = Integer.parseInt(minTextField.getText());
                max = Integer.parseInt(maxTextField.getText());

                Random random = new Random();
                while (size-- >= 0) {
                    new Insert(random.nextInt(max - min)+min);
                }
            }catch (NumberFormatException ex) { System.out.print("Nie wpisano liczby!");
            }finally {endDrawTree(); }
        });

        deleteAllButton.addActionListener(e -> SplayTreeNode.deleteAll());

    }

    private void endDrawTree() {
        SplayTreeNode.setAllColorsBlack();
        treePanel.repaint();
        numberTextField.setText("");
        sizeTextField.setText("");
        minTextField.setText("");
        maxTextField.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SplayTree");
        frame.setContentPane(new SplayTree().windowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void createUIComponents() {
            treePanel = new TreeJPanel();
    }
}
