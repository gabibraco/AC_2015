import java.awt.BorderLayout;
	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.WindowConstants;

public class rotarimagen {

	
	/**
	 * Ejemplo de giro de grafico.
	 * Una ventana con una foto y dos botones para girar en sentido horario y antihorario.
	 * @author chuidiang
	 *
	 */
	

	    /** Componente que lleva la foto */
	    private Lienzo l;

	    /**
	     * Crea una instancia de esta clase.
	     * @param args
	     */
	    public static void main(String[] args) {
	        new rotarimagen();
	    }

	    /**
	     * Crea la ventana, los botones y lo pone todo en marcha.
	     */
	    public rotarimagen() {
	        // Construccion de la ventana.
	        JFrame v = new JFrame("Girar grafico");
	        
	        // El componente con la foto
	        l = new Lienzo("lena.jpg");
	        v.getContentPane().add(l);
	        
	        // el panel con los botones
	        JPanel botonesRotacion = new JPanel(new FlowLayout());
	        JButton botonSentidoHorario = new JButton("+0.1");
	        JButton botonSentidoAntiHorario = new JButton("-0.1");
	        botonesRotacion.add(botonSentidoAntiHorario);
	        botonesRotacion.add(botonSentidoHorario);
	        v.getContentPane().add(botonesRotacion, BorderLayout.NORTH);

	        // las acciones de los botones
	        botonSentidoAntiHorario.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                l.setRotacion(l.getRotacion() - 0.1);
	                l.repaint();
	            }

	        });
	        botonSentidoHorario.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                l.setRotacion(l.getRotacion() + 0.1);
	                l.repaint();
	            }

	        });

	        // visualizarlo todo.
	        v.pack();
	        v.setVisible(true);
	        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    }
	}


