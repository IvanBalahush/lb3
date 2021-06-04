package laba3_pzos;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Класс в котором создается окно (ширина, высота и т.д.) и элементы окна(кнопки, радио)
 * @author Иван Балагуш
 */
public class Drawing extends JFrame{
        /** Поля - элементы данного окна
         * Кнопка, надпись, и три радио-кнопки с выбором действия*/
        private JButton button = new JButton("Рисовать");
        private JLabel label = new JLabel("Выберите функцию :");
        private JRadioButton radio1 = new JRadioButton("Sin(x)");
        private JRadioButton radio2 = new JRadioButton("Cos(x)");
        private JRadioButton radio3 = new JRadioButton("x^2");
        /** Конструктор - создание нового объекта*/
        public Drawing() {
            super("Balahush I. laba 3");
            setLocationRelativeTo(null);
            this.setBounds(300,300,600,500);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Container container = this.getContentPane();
            container.setLayout (new FlowLayout(FlowLayout.CENTER));
            container.add(label);
            ButtonGroup group  = new ButtonGroup();
            group.add(radio1);
            group.add(radio2);
            group.add(radio3);
            button.addActionListener(new ButtonEventListener());
            container.add(radio1);
            container.add(radio2);
            container.add(radio3);
            container.add(button);
        }
        /** Класс, создающий объекты вспомагательных классов, рисует выбранный график*/
        class ButtonEventListener  implements ActionListener{
            public  void actionPerformed(ActionEvent e){
                /** Выбран радио sin(x)*/
                if(radio1.isSelected() ){
                    setLayout(new BorderLayout());
                    add(new DrawSinX(), BorderLayout.CENTER);
                }
                /** Выбран радио cos(x)*/
                if(radio2.isSelected() ){
                    setLayout(new BorderLayout());
                    add(new DrawCosX(), BorderLayout.CENTER);
                }
                /** Выбран радио x^2*/
                if(radio3.isSelected() ){
                    setLayout(new BorderLayout());
                    add(new DrawDeg(), BorderLayout.CENTER);
                }
            }
        }

/** Класс, рисующий sin(x)*/
    public static class  DrawSinX extends JPanel {
        double f(double x) {
            return Math.sin(x);
        }
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Polygon p = new Polygon();
            g.drawLine(10, 100, 380, 100);
            g.drawLine(200, 30, 200, 190);

            g.drawLine(380, 100, 370, 90);
            g.drawLine(380, 100, 370, 110);
            g.drawLine(200, 30, 190, 40);
            g.drawLine(200, 30, 210, 40);

            g.drawString("X", 360, 80);
            g.drawString("Y", 220, 40);

            g.setColor(Color.red);
            g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
            g.drawString("-2\u03c0", 95, 115);
            g.drawString("2\u03c0", 305, 115);
            g.drawString("0", 200, 115);
            g.drawString("-\u03c0", 155, 115);
            g.drawString("\u03c0", 257, 115);
            for (int x = -170; x <= 170; x++) {
                p.addPoint(x + 200, 100 - (int) (50 * f((x / 100.0) * 2
                        * Math.PI)));
            }
            g.setColor(Color.MAGENTA);
            g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
        }
    }
    /** Класс, рисующий cos(x)*/
        public static class  DrawCosX extends JPanel {
            double g(double x) {
                return Math.cos(x);
            }
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Polygon p = new Polygon();

                g.drawLine(10, 100, 380, 100);
                g.drawLine(200, 30, 200, 190);

                g.drawLine(380, 100, 370, 90);
                g.drawLine(380, 100, 370, 110);
                g.drawLine(200, 30, 190, 40);
                g.drawLine(200, 30, 210, 40);

                g.drawString("X", 360, 80);
                g.drawString("Y", 220, 40);

                g.setColor(Color.red);
                g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
                g.drawString("-2\u03c0", 95, 115);
                g.drawString("2\u03c0", 305, 115);
                g.drawString("0", 200, 115);
                g.drawString("-\u03c0", 155, 115);
                g.drawString("\u03c0", 257, 115);

                for (int x = -170; x <= 170; x++) {
                    p.addPoint(x + 200, 100 - (int) (50 * g((x / 100.0) * 2
                            * Math.PI)));
                }
                g.setColor(Color.red);
                g.drawPolyline(p.xpoints, p.ypoints, p.npoints);

            }
        }
    /** Класс, рисующий x^2*/
        public static class  DrawDeg extends JPanel {
            double g(double x) {
                return Math.pow(x,2);
            }
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Polygon p = new Polygon();

                g.drawLine(10, 100, 380, 100);
                g.drawLine(200, 30, 200, 190);

                g.drawLine(380, 100, 370, 90);
                g.drawLine(380, 100, 370, 110);
                g.drawLine(200, 30, 190, 40);
                g.drawLine(200, 30, 210, 40);

                g.drawString("X", 360, 80);
                g.drawString("Y", 220, 40);

                g.setColor(Color.red);
                g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
                g.drawString("-2\u03c0", 95, 115);
                g.drawString("2\u03c0", 305, 115);
                g.drawString("0", 200, 115);
                g.drawString("-\u03c0", 155, 115);
                g.drawString("\u03c0", 257, 115);

                for (int x = -170; x <= 170; x++) {
                    p.addPoint(x + 200, 100 - (int) (50 * g((x / 100.0) * 2
                            * Math.PI)));
                }
                g.setColor(Color.blue);
                g.drawPolyline(p.xpoints, p.ypoints, p.npoints);

            }
        }

/** Класс в котором создается и отображается окно */
    public static void main(String[] args) {
        Drawing graphics = new Drawing();
        graphics.setVisible(true);
    }
}


