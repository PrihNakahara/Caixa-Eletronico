import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class TelaTotalDisponivel extends JFrame {

	private JPanel contentPane;
	private JLabel lblTotal;
	private JLabel lblResposta;

	public IcaixaEletronico icaixaEletronico;
	private JButton btnSair;


	/**
	 * Create the frame.
	 */
	public TelaTotalDisponivel(IcaixaEletronico icaixaEletronico) {
		this.icaixaEletronico = icaixaEletronico;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 314, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTotal = new JLabel("Valor Total Disponível");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(80, 11, 158, 23);

		lblResposta = new JLabel("");
		lblResposta.setHorizontalAlignment(SwingConstants.CENTER);
		lblResposta.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblResposta.setBounds(76, 61, 146, 63);
		contentPane.add(lblResposta);

		String t = icaixaEletronico.pegaValorTotalDisponivel();
		lblResposta.setText(t);

		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaTotalDisponivel frame = new TelaTotalDisponivel(icaixaEletronico);
				dispose();
			}
		});
		btnSair.setBounds(103, 152, 89, 23);
		contentPane.add(btnSair);

	}
	
	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaTotalDisponivel frame = new TelaTotalDisponivel(icaixaEletronico);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
