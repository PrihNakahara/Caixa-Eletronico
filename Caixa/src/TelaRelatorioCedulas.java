import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRelatorioCedulas extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblResposta;

	public IcaixaEletronico icaixaEletronico;
	private JButton btnSair;

	public TelaRelatorioCedulas(IcaixaEletronico icaixaEletronico) {
		this.icaixaEletronico = icaixaEletronico;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Relatório de Cédulas");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(107, 11, 135, 22);
		contentPane.add(lblNewLabel);

		lblResposta = new JLabel("");
		lblResposta.setHorizontalAlignment(SwingConstants.CENTER);
		lblResposta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResposta.setVerticalAlignment(SwingConstants.TOP);
		lblResposta.setBounds(10, 53, 308, 146);
		contentPane.add(lblResposta);

		String p = icaixaEletronico.pegaRelatorioCedulas();
		lblResposta.setText(p);

		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaRelatorioCedulas frame = new TelaRelatorioCedulas(icaixaEletronico);
				dispose();
			}
		});
		btnSair.setBounds(122, 210, 89, 23);
		contentPane.add(btnSair);
	}

	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorioCedulas frame = new TelaRelatorioCedulas(icaixaEletronico);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
