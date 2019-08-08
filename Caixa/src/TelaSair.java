import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaSair extends JFrame {

	private JPanel contentPane;
	private JLabel lblSaldo;
	public IcaixaEletronico icaixaEletronico;
	private JLabel lblSaldoFinal;
	private JLabel lblExtratoDeSaque;

	public TelaSair(IcaixaEletronico icaixaEletronico) {
		this.icaixaEletronico = icaixaEletronico;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblSaldo = new JLabel("");
		lblSaldo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSaldo.setBounds(10, 66, 294, 86);
		contentPane.add(lblSaldo);

		String respostaSaldo = icaixaEletronico.pegarSaldo();
		lblSaldo.setText(respostaSaldo);

		lblSaldoFinal = new JLabel("");
		lblSaldoFinal.setVerticalAlignment(SwingConstants.TOP);
		lblSaldoFinal.setBounds(10, 163, 294, 87);
		contentPane.add(lblSaldoFinal);
		String respSaldoTotal = icaixaEletronico.pegaValorTotalDisponivel();
		lblSaldoFinal.setText("Valor Total Disponível: "+respSaldoTotal);
		
		lblExtratoDeSaque = new JLabel("Extrato de Saque e Saldo");
		lblExtratoDeSaque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExtratoDeSaque.setBounds(73, 11, 178, 24);
		contentPane.add(lblExtratoDeSaque);

	}
	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSair frame = new TelaSair(icaixaEletronico);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}