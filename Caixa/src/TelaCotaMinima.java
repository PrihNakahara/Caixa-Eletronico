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

public class TelaCotaMinima extends JFrame {

	private JPanel contentPane;
	private JTextField txtCota;
	public IcaixaEletronico icaixaEletronico;
	private JButton btnSair;
	/**
	 * Create the frame.
	 */
	public TelaCotaMinima(IcaixaEletronico icaixaEletronico) {
		this.icaixaEletronico = icaixaEletronico;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 321, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblValorCotaMnima = new JLabel("Valor Cota Mínima:");
		lblValorCotaMnima.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorCotaMnima.setBounds(19, 34, 137, 27);
		contentPane.add(lblValorCotaMnima);

		txtCota = new JTextField();
		txtCota.setBounds(167, 38, 104, 22);
		contentPane.add(txtCota);
		txtCota.setColumns(10);

		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setBounds(10, 140, 284, 63);
		contentPane.add(lblMensagem);

		JButton btnArmazenar = new JButton("Armazenar");
		btnArmazenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valorCota = Integer.parseInt(txtCota.getText());
				String resposta = icaixaEletronico.armazenaCotaMinima(valorCota);
				lblMensagem.setText(resposta);

			}
		});
		btnArmazenar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnArmazenar.setBounds(94, 91, 104, 23);
		contentPane.add(btnArmazenar);

		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCotaMinima frame = new TelaCotaMinima(icaixaEletronico);

				dispose();
			}
		});
		btnSair.setBounds(104, 227, 89, 23);
		contentPane.add(btnSair);
	}
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCotaMinima frame = new TelaCotaMinima(icaixaEletronico);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
