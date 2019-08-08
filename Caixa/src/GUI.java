import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	
	IcaixaEletronico caixaEletronico = new CaixaEletronico();
	/**
	 * Create the frame.
	 */
		
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Efetuar Saque");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				TelaSacar frame = new TelaSacar(caixaEletronico);
				frame.setVisible(true);		
			}
		});
		btnNewButton.setBounds(10, 29, 189, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Módulo do Cliente:");
		lblNewLabel.setBounds(10, 11, 117, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Modulo do Administrador:");
		lblNewLabel_1.setBounds(10, 58, 153, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnRelatorioDeCedulas = new JButton("Relatório de Cédulas");
		btnRelatorioDeCedulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRelatorioCedulas frame = new TelaRelatorioCedulas(caixaEletronico);
				frame.setVisible(true);
			}
		});
		btnRelatorioDeCedulas.setBounds(10, 77, 189, 23);
		contentPane.add(btnRelatorioDeCedulas);
		
		JButton btnValorTotalDisponivel = new JButton("Valor total disponível");
		btnValorTotalDisponivel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				TelaTotalDisponivel frame = new TelaTotalDisponivel(caixaEletronico);
				frame.setVisible(true);
			}
		});
		btnValorTotalDisponivel.setBounds(10, 104, 189, 23);
		contentPane.add(btnValorTotalDisponivel);
		
		JButton btnReposioDeCedulas = new JButton("Reposição de Cédulas");
		btnReposioDeCedulas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaReposicaoCedulas frame = new TelaReposicaoCedulas(caixaEletronico);
				frame.setVisible(true);
			}
		});
		btnReposioDeCedulas.setBounds(10, 130, 189, 23);
		contentPane.add(btnReposioDeCedulas);
		
		JButton btnCotaMinima = new JButton("Cota Mínima");
		btnCotaMinima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCotaMinima frame = new TelaCotaMinima(caixaEletronico);
				frame.setVisible(true);
			}
		});
		btnCotaMinima.setBounds(10, 157, 189, 23);
		contentPane.add(btnCotaMinima);
		
		JLabel lblModuloDoAmbos = new JLabel("Módulo de Ambos:");
		lblModuloDoAmbos.setBounds(10, 187, 153, 14);
		contentPane.add(lblModuloDoAmbos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			TelaSair frame = new TelaSair(caixaEletronico);
			frame.setVisible(true);
			dispose();
		}
		});
		btnSair.setBounds(10, 200, 189, 23);
		contentPane.add(btnSair);
	}
}
