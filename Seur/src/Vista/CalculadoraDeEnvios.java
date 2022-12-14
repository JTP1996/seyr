package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import Modelo.CalcularImporte;
import java.awt.Color;
import java.awt.SystemColor;

public class CalculadoraDeEnvios {

	private JFrame frame;
	private JTextField txtOrigen;
	private JTextField txtDestino;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraDeEnvios window = new CalculadoraDeEnvios();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculadoraDeEnvios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(86, 156, 169));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblCiudadOrigen = new JLabel("Ciudad Origen:\r\n");
		lblCiudadOrigen.setForeground(SystemColor.desktop);
		lblCiudadOrigen.setBounds(25, 14, 86, 16);
		lblCiudadOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblCiudadDestino = new JLabel("Ciudad Destino:\r\n");
		lblCiudadDestino.setBounds(25, 86, 90, 16);
		lblCiudadDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtOrigen = new JTextField();
		txtOrigen.setBackground(SystemColor.inactiveCaption);
		txtOrigen.setBounds(115, 11, 232, 22);
		txtOrigen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtOrigen.setColumns(10);
		
		txtDestino = new JTextField();
		txtDestino.setBackground(SystemColor.inactiveCaption);
		txtDestino.setBounds(119, 83, 228, 22);
		txtDestino.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDestino.setColumns(10);
		
		JRadioButton rdbtnNacional = new JRadioButton("Nacional");
		rdbtnNacional.setForeground(SystemColor.desktop);
		rdbtnNacional.setBackground(new Color(95, 158, 160));
		buttonGroup.add(rdbtnNacional);
		rdbtnNacional.setBounds(119, 40, 73, 25);
		rdbtnNacional.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnExtranjero = new JRadioButton("Extranjero");
		rdbtnExtranjero.setBackground(new Color(95, 158, 160));
		buttonGroup.add(rdbtnExtranjero);
		rdbtnExtranjero.setBounds(229, 40, 85, 25);
		rdbtnExtranjero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnExtranjero1 = new JRadioButton("Extranjero");
		rdbtnExtranjero1.setBackground(new Color(95, 158, 160));
		buttonGroup_1.add(rdbtnExtranjero1);
		rdbtnExtranjero1.setBounds(262, 112, 85, 25);
		rdbtnExtranjero1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnNacional1 = new JRadioButton("Nacional");
		rdbtnNacional1.setBackground(new Color(95, 158, 160));
		buttonGroup_1.add(rdbtnNacional1);
		rdbtnNacional1.setBounds(119, 112, 73, 25);
		rdbtnNacional1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTipoEnvio = new JLabel("Tipo de Envio:");
		lblTipoEnvio.setBounds(25, 168, 92, 16);
		lblTipoEnvio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.inactiveCaption);
		comboBox.setBounds(121, 165, 226, 22);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paq 10 - Envio antes de las 10h", "paq 24 - Envio antes de 24h"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblPeso = new JLabel(" Peso :");
		lblPeso.setBounds(25, 201, 40, 16);
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JSpinner spinner = new JSpinner();
		spinner.setBackground(SystemColor.inactiveCaption);
		spinner.setBounds(121, 198, 45, 22);
		spinner.setModel(new SpinnerNumberModel(1, 1, 25, 1));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblResultado = new JLabel("");
		lblResultado.setBounds(10, 236, 85, 25);
		frame.getContentPane().add(lblResultado);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBackground(SystemColor.inactiveCaption);
		btnCalcular.setBounds(268, 226, 103, 25);
		btnCalcular.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			{
				
			CalcularImporte calc = new CalcularImporte();
			
			boolean ON = false;
			boolean DN = false;
			
			if (rdbtnNacional.isSelected()){
				ON = true;
			}
			if (rdbtnNacional1.isSelected()) {
				DN = true;
			}
			
			String tipo = (String) comboBox.getSelectedItem();

            int peso = (int) spinner.getValue();

            double res = calc.CalcImporte(ON, DN, tipo, peso);
            res = Math.round(res * 100.0) / 100.0;

            lblResultado.setText(""+res+"€");
			
			}
		});
		frame.getContentPane().setLayout(null);
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(btnCalcular);
		frame.getContentPane().add(rdbtnExtranjero);
		frame.getContentPane().add(lblCiudadOrigen);
		frame.getContentPane().add(txtOrigen);
		frame.getContentPane().add(lblCiudadDestino);
		frame.getContentPane().add(txtDestino);
		frame.getContentPane().add(rdbtnNacional);
		frame.getContentPane().add(rdbtnNacional1);
		frame.getContentPane().add(rdbtnExtranjero1);
		frame.getContentPane().add(lblTipoEnvio);
		frame.getContentPane().add(lblPeso);
		frame.getContentPane().add(spinner);
		frame.getContentPane().add(comboBox);
		
	
	}
}
