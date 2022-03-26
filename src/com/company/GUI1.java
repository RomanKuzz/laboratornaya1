package com.company;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GUI1 extends JFrame {
    private JButton impButton;
    private JButton expButton;
    private JButton exitButton;
    private JPanel panel;

    public GUI1() throws Exception {

        Calculator calculator = new Calculator();
        Read r = new Read();
        Write w = new Write(); //экземпляры классов

        setContentPane(panel);
        setTitle("Lab2");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900, 600); //гуи

        impButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fs = new JFileChooser(); //выбор файлов
                fs.setDialogTitle("choose a file"); //надпись
                int result = fs.showOpenDialog(null); //зап файла
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile(); //выбран файл
                    try {
                        r.imp(file); //метод из чтения
                        calculator.calculations(r.getArr());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "файл не найден", "ошибка", JOptionPane.PLAIN_MESSAGE);
                        ex.printStackTrace();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "файл не найден", "ошибка", JOptionPane.PLAIN_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });

        expButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fs = new JFileChooser(); //выбор файлов
                fs.setDialogTitle("save a file"); //надпись
                int result = fs.showSaveDialog(null); //сохранение файла
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile(); //вы
                    try {
                        w.exp(calculator, file); //метод из записи
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "файл не найден", "ошибка", JOptionPane.PLAIN_MESSAGE);
                        ex.printStackTrace();
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
