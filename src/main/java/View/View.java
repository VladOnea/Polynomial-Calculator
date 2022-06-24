package View;

import Model.Operations;
import Model.Polynomial;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class View extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldFP;
    private JTextField textFieldSP;
    private JTextField textFieldResult;
    private JTextField textFieldRemainder;
    private Polynomial P = null, Q = null;


    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View.View frame = new View.View();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    public View() {
        setTitle("Model.Polynomial Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 612, 354);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblFP = new JLabel("First Polynomial:");
        lblFP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblFP.setBounds(10, 41, 238, 13);
        contentPane.add(lblFP);

        textFieldFP = new JTextField();
        textFieldFP.setBounds(10, 64, 238, 29);
        contentPane.add(textFieldFP);
        textFieldFP.setColumns(10);

        JLabel lblSP = new JLabel("Second   Polynomial:");
        lblSP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblSP.setBounds(10, 124, 238, 13);
        contentPane.add(lblSP);

        textFieldSP = new JTextField();
        textFieldSP.setBounds(10, 147, 238, 29);
        contentPane.add(textFieldSP);
        textFieldSP.setColumns(10);

        JButton btnAdd = new JButton("+");
        btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnAdd.setBackground(Color.YELLOW);
        btnAdd.setBounds(352, 21, 85, 36);
        contentPane.add(btnAdd);
        btnAdd.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                P= new Polynomial(textFieldFP.getText());
                Q= new Polynomial(textFieldSP.getText());
                Polynomial result = Operations.add(P, Q);
               // System.out.println(P);
                //System.out.println(Q);
                textFieldResult.setText(result.toString());
            }
        });

        JButton btnSubstraction = new JButton("-");
        btnSubstraction.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnSubstraction.setBackground(Color.CYAN);
        btnSubstraction.setBounds(475, 21, 85, 36);
        contentPane.add(btnSubstraction);
        btnSubstraction.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                P= new Polynomial(textFieldFP.getText());
                Q= new Polynomial(textFieldSP.getText());
                Polynomial result = Operations.sub(P, Q);
                textFieldResult.setText(result.toString());
            }
        });

        JButton btnMultiply = new JButton("*");
        btnMultiply.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnMultiply.setBackground(Color.ORANGE);
        btnMultiply.setBounds(352, 81, 85, 36);
        contentPane.add(btnMultiply);
        btnMultiply.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                P= new Polynomial(textFieldFP.getText());
                Q= new Polynomial(textFieldSP.getText());
                Polynomial result = Operations.multiply(P, Q);
                textFieldResult.setText(result.toString());
            }
        });

        JButton btnDivision = new JButton("/");
        btnDivision.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnDivision.setBackground(Color.RED);
        btnDivision.setBounds(475, 81, 85, 36);
        contentPane.add(btnDivision);
        btnDivision.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                P= new Polynomial(textFieldFP.getText());
                Q= new Polynomial(textFieldSP.getText());
                //  Model.Polynomial result = Model.Operations.Division(P, Q);
                //  Model.Polynomial
                //  textFieldResult.setText(result.toString());
            }
        });

        JButton btnIntegration = new JButton("\u222B");
        btnIntegration.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnIntegration.setBackground(Color.GREEN);
        btnIntegration.setBounds(352, 143, 85, 36);
        contentPane.add(btnIntegration);
        btnIntegration.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                P= new Polynomial(textFieldFP.getText());
                Polynomial result = Operations.integration(P);
                textFieldResult.setText(result.toString()+"+constant");
            }
        });

        JButton btnDerivative = new JButton("d/dx");
        btnDerivative.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        btnDerivative.setBackground(Color.MAGENTA);
        btnDerivative.setBounds(475, 143, 85, 36);
        contentPane.add(btnDerivative);
        btnDerivative.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                P= new Polynomial(textFieldFP.getText());
                Polynomial result = Operations.derivative(P);
                textFieldResult.setText(result.toString());
            }
        });

        JLabel lblResult = new JLabel("Result:");
        lblResult.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblResult.setBounds(10, 213, 238, 13);
        contentPane.add(lblResult);

        textFieldResult = new JTextField();
        textFieldResult.setColumns(10);
        textFieldResult.setBounds(10, 236, 238, 29);
        contentPane.add(textFieldResult);

        JLabel lblRemainder = new JLabel("Remainder:");
        lblRemainder.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lblRemainder.setBounds(322, 213, 238, 13);
        contentPane.add(lblRemainder);

        textFieldRemainder = new JTextField();
        textFieldRemainder.setColumns(10);
        textFieldRemainder.setBounds(322, 236, 238, 29);
        contentPane.add(textFieldRemainder);

        JButton btnClearFP = new JButton("Clear");
        btnClearFP.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnClearFP.setBounds(259, 68, 61, 21);
        contentPane.add(btnClearFP);
        btnClearFP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldFP.setText("");
            }
        });


        JButton btnClearSP = new JButton("Clear");
        btnClearSP.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        btnClearSP.setBounds(259, 151, 61, 21);
        contentPane.add(btnClearSP);
        btnClearSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldSP.setText("");
            }
        });
    }
}

