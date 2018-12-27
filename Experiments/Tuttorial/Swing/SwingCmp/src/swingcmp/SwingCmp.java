/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingcmp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author Vladimir Hrechko
 */
public class SwingCmp implements ActionListener {
    
    JTextField FirstTxt, SecondTxt;
    JLabel     FistLbl,  SecondLbl, ResultLbl;
    JButton    Btn;
    
    SwingCmp(){
        JFrame mainFrame = new JFrame("Сравнение файлов");
        mainFrame.setLayout(new FlowLayout());
        mainFrame.setSize(200, 190);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FirstTxt = new JTextField(14);
        SecondTxt = new JTextField(14);
        FirstTxt.setActionCommand("File_1");
        SecondTxt.setActionCommand("File_2");
        
        Btn = new JButton("Сравнить");
        Btn.addActionListener(this);
        
        FistLbl = new JLabel("First file: ");
        SecondLbl = new JLabel("Second file: ");
        ResultLbl = new JLabel("");
        
        mainFrame.add(FistLbl);
        mainFrame.add(FirstTxt);
        mainFrame.add(SecondLbl);
        mainFrame.add(SecondTxt);
        mainFrame.add(Btn);
        mainFrame.add(ResultLbl);
        
        mainFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        int i =0, j = 0;
        
        if(FirstTxt.getText().equals("")){
            ResultLbl.setText("Не указан путь к первому файлу");
            return;
        }
        if(SecondTxt.getText().equals("")){
            ResultLbl.setText("Не указан путь ко второму файлу");
            return;
        }
        
        try(FileInputStream f1 = new FileInputStream(FirstTxt.getText());
            FileInputStream f2 = new FileInputStream(SecondTxt.getText())){
            do{
                i = f1.read();
                j = f2.read();
                if(i != j) break;
            }while(i != -1 && j != -1);
            if(i != j)
                ResultLbl.setText("Файлы разные");
            else
                ResultLbl.setText("Файлы одинаковые");
        }catch(IOException exc){
            ResultLbl.setText("Ошибка открытия файла");
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new SwingCmp();
            }
        });
        
    }
    
}
