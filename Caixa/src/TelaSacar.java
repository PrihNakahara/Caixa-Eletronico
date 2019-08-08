import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaSacar extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;

	public IcaixaEletronico icaixaEletronico;
	private JButton btnSair;

	/**
	 * Create the frame.
	 */
	public TelaSacar(IcaixaEletronico icaixaEletronico) {
		this.icaixaEletronico = icaixaEletronico;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Valor do Saque:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 42, 106, 24);
		contentPane.add(lblNewLabel);

		txtValor = new JTextField();
		txtValor.setBounds(156, 44, 135, 24);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		JLabel lblResposta = new JLabel("");
		lblResposta.setHorizontalAlignment(SwingConstants.LEFT);
		lblResposta.setVerticalAlignment(SwingConstants.TOP);
		lblResposta.setBounds(10, 111, 308, 134);
		contentPane.add(lblResposta);

		JButton btnSacar = new JButton("Sacar");
		btnSacar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Integer valor = Integer.parseInt(txtValor.getText());
				String resposta = icaixaEletronico.sacar(valor);
				lblResposta.setText(resposta);
			}
		});
		btnSacar.setBounds(115, 77, 89, 23);
		contentPane.add(btnSacar);

		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSacar frame = new TelaSacar(icaixaEletronico);
				dispose();
			}
		});
		btnSair.setBounds(115, 256, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblSaqueDeValores = new JLabel("Efetuar Saque");
		lblSaqueDeValores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSaqueDeValores.setBounds(115, 11, 106, 19);
		contentPane.add(lblSaqueDeValores);
	}
	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSacar frame = new TelaSacar(icaixaEletronico);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
