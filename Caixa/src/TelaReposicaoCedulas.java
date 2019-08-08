import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.temporal.TemporalAccessor;
import java.awt.TextField;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class TelaReposicaoCedulas extends JFrame {

	private JPanel contentPane;
	private JTextField txtResposta;

	public IcaixaEletronico icaixaEletronico;
	private JButton btnSair;


	/**
	 * Create the frame.
	 */
	public TelaReposicaoCedulas(IcaixaEletronico icaixaEletronico) {
		this.icaixaEletronico = icaixaEletronico;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Valor de cédula: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 31, 168, 44);
		contentPane.add(lblNewLabel);

		JTextPane txtValorCedula = new JTextPane();
		txtValorCedula.setBounds(188, 41, 98, 23);
		contentPane.add(txtValorCedula);

		JLabel lblQuantidadeDeCdulas = new JLabel("Quantidade de cédulas:");
		lblQuantidadeDeCdulas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblQuantidadeDeCdulas.setBounds(10, 69, 178, 36);
		contentPane.add(lblQuantidadeDeCdulas);

		JTextPane txtQtCedula = new JTextPane();
		txtQtCedula.setBounds(188, 75, 98, 23);
		contentPane.add(txtQtCedula);

		JLabel lblMensagem = new JLabel("");
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setBounds(10, 167, 294, 49);
		contentPane.add(lblMensagem);

		JButton btnRepor = new JButton("Repor");
		btnRepor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRepor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Integer valorCedula = Integer.parseInt(txtValorCedula.getText());
				Integer qtCedula = Integer.parseInt(txtQtCedula.getText());
				String resposta = icaixaEletronico.reposicaoCedulas(valorCedula, qtCedula);
				lblMensagem.setText(resposta);

				// colocar mensagem para repor mais notas...
			}
		});
		btnRepor.setBounds(112, 133, 89, 23);
		contentPane.add(btnRepor);

		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaReposicaoCedulas frame = new TelaReposicaoCedulas(icaixaEletronico);

				dispose();
			}
		});
		btnSair.setBounds(109, 227, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblReposioDeCdulas = new JLabel("Reposição de Cédulas");
		lblReposioDeCdulas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReposioDeCdulas.setBounds(84, 6, 142, 24);
		contentPane.add(lblReposioDeCdulas);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReposicaoCedulas frame = new TelaReposicaoCedulas(icaixaEletronico);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
