import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class CalculadoraGrasaCorporal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtKg;
	private JTextField txtAltura;
	private JTextField txtEdad;
	private JTextField txtSexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraGrasaCorporal frame = new CalculadoraGrasaCorporal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadoraGrasaCorporal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Introduzca su nombre:");
		lblNewLabel.setBounds(20, 35, 190, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Indique su sexo (Hombre o Mujer):");
		lblNewLabel_1.setBounds(20, 85, 200, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(172, 32, 96, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Introduzca su peso en KG:");
		lblNewLabel_2.setBounds(21, 144, 200, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Introduzca su altura en metros :");
		lblNewLabel_3.setBounds(20, 207, 240, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Introduzca su edad:");
		lblNewLabel_4.setBounds(20, 261, 200, 14);
		contentPane.add(lblNewLabel_4);
		
		txtKg = new JTextField();
		txtKg.setBounds(182, 141, 86, 20);
		contentPane.add(txtKg);
		txtKg.setColumns(10);
		
		txtAltura = new JTextField();
		txtAltura.setBounds(214, 204, 86, 20);
		contentPane.add(txtAltura);
		txtAltura.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(140, 258, 86, 20);
		contentPane.add(txtEdad);
		txtEdad.setColumns(10);
		
		JTextArea txtS = new JTextArea();
		txtS.setBounds(20, 319, 472, 141);
		contentPane.add(txtS);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(229, 82, 86, 20);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);
		
		JButton btnMostrar = new JButton("Mostrar");
		
		btnMostrar.setBounds(387, 31, 89, 23);
		contentPane.add(btnMostrar);
		
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre=txtNombre.getText();
				int sexo=0; 
				if (txtSexo.getText().equalsIgnoreCase("Hombre")) {
					sexo=1;
				}else if (txtSexo.getText().equalsIgnoreCase("Mujer")) {
					sexo=0;
				}
				
				double peso=Double.parseDouble(txtKg.getText());
				double altura=Double.parseDouble(txtAltura.getText());
				int edad=Integer.parseInt(txtEdad.getText());
				double imc=peso/(altura*altura);
				double grasaCorporal=1.2*imc+0.23*edad-10.8*sexo-5.4;
				if (txtSexo.getText().equalsIgnoreCase("Hombre")|| txtSexo.getText().equalsIgnoreCase("Mujer")) {
					txtS.append(nombre+" su indice de masa corporal es "+imc+"."+"\n");
					txtS.append("Su índice de grasa corporal es "+grasaCorporal+".");	
				}else {
					txtS.append("Error.Introduzca el sexo correctamente.");
				}
				
			}
		});
	
	}
}
