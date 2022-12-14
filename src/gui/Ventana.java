package gui;

import modelo.Manguera;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame
{
    private Container panel;
    private JTextField entrada, volumen, salida;
    private JButton btnEntrada, btnVolumen, btnSalida;
    private JProgressBar barra;
    private Manguera llena ;

    public Ventana()
    {
        super("Lab: Deposito de agua");
        setSize(360, 200);
        setLayout(null);
        panel = getContentPane();

        //fila 1
        JLabel e = new JLabel("Entrada");
        e.setBounds(10, 10, 100, 30);
        JLabel v = new JLabel("Volumen");
        v.setBounds(120, 10, 100, 30);
        JLabel s = new JLabel("Salida");
        s.setBounds(240, 10, 100, 30);
        panel.add(e);
        panel.add(v);
        panel.add(s);


        //fila 2
        JTextField entrada = new JTextField("");
        entrada.setBounds(10, 40, 100, 30);
        panel.add(entrada);
        volumen = new JTextField("");
        volumen.setBounds(120, 40, 100, 30);
        panel.add(volumen);
        salida = new JTextField("");
        salida.setBounds(240, 40, 100, 30);
        panel.add(salida);

        //fila 3
        btnEntrada = new JButton("Abrir / Cerrar");
        btnVolumen = new JButton("Actualizar");
        btnSalida = new JButton("Abrir / Cerrar");
        btnEntrada.setBounds(10, 190,320,50);
        btnVolumen.setBounds(120, 190,320,50);
        btnSalida.setBounds(240, 190,320,50);
        panel.add(btnEntrada);
        panel.add(btnVolumen);
        panel.add(btnSalida);


        barra = new JProgressBar(0, 100);
        barra.setBounds(10, 130,320,30);
        barra.setStringPainted(true);
        barra.setValue(50);
        panel.add(barra);
        llena = new Manguera("Entrada", barra);
        btnEntrada.addActionListener(actionEvent ->
        {
            if(llena.getState() == Thread.State.RUNNABLE)
            {
                try
                {
                    llena.wait();
                }catch (InterruptedException ex)
                {

                }

            }
            llena.start();
        });
        setVisible(true);

    }
}
