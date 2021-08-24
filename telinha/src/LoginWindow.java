

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginWindow extends JDialog {
	
	private static final String PATH_FLAGS = "C:\\Users\\rh02\\Desktop\\NetBeans\\telinha\\";
	private static final String FILE_USER = "login.txt";
	private static final String FULL_PATH = PATH_FLAGS+FILE_USER;
	private static final String SEPARATOR = ";";
	
	private JLabel lblNomeSistema;
	private JLabel lblUsuario;
	private JLabel lblSenha;
        private JLabel lblPerfil;
	private JTextField txfUsuario;
        private JTextField txfPerfil;
	private JPasswordField txfSenha;
	private JButton btnEntrar;	
        
	private final HashMap<String, String> hmpUsuarios = new HashMap<String, String>();
	{
		hmpUsuarios.put("Administrador", "Administrador");
		hmpUsuarios.put("Adm", "Adm123");
		hmpUsuarios.put("Administrator", "7410");
		hmpUsuarios.put("Root", "un3scr3m0ta+()");
	}
        
        private final HashMap<String, Integer> hmpPerfil = new HashMap<>();
        {
            hmpPerfil.put("Administrador", 1);
            hmpPerfil.put("Cadastral", 2);
            hmpPerfil.put("Financeiro", 3);
            hmpPerfil.put("Suporte", 4);
        }
	
	public LoginWindow() {
		setSize(400, 210);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Autenticação do Sistema");
		setLocationRelativeTo(null);
		setLayout(null);
		componentesCriar();
	}
	
	private void componentesCriar() {
		
		lblNomeSistema = new JLabel("Sistema");
		lblNomeSistema.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		lblNomeSistema.setBounds(170, 10, 100, 25);
		getContentPane().add(lblNomeSistema);
                
		lblUsuario = new JLabel("Usuário:");
		lblUsuario.setBounds(50, 40, 100, 25);
		getContentPane().add(lblUsuario);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(50, 70, 100, 25);
		getContentPane().add(lblSenha);
		
                lblPerfil = new JLabel("Perfil");
                lblPerfil.setBounds(50, 100, 100, 25);
                getContentPane().add(lblPerfil);
                
		txfUsuario = new JTextField();
		txfUsuario.setBounds(115, 40, 200, 25);
		getContentPane().add(txfUsuario);
		
		txfSenha = new JPasswordField();
		txfSenha.setBounds(115, 70, 200, 25);
		getContentPane().add(txfSenha);
                
                txfPerfil = new JTextField();
                txfPerfil.setBounds(115, 100, 200, 25);
                getContentPane().add(txfPerfil);
		
		btnEntrar = new JButton(new AbstractAction("ENTRAR") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				autenticacaoValidar();
			}
		});
		btnEntrar.setBounds(115,130,200,25);
		getContentPane().add(btnEntrar);
	}
	
	private void autenticacaoValidar() {
		final String usuarioDigitado = txfUsuario.getText();
		final String senhaDigitada = txfSenha.getText();
                final String perfilDigitado = txfPerfil.getText();
		
		if (usuarioDigitado.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campo USUÁRIO obrigatório!");
		}
		else if (senhaDigitada.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campo SENHA obrigatório!");					
		}
                else if (perfilDigitado.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Campo PERFIL obrigatório");
                }
		else {
			final Integer perfil = hmpPerfil.get(perfilDigitado);
			final String senha = hmpUsuarios.get(usuarioDigitado);
                        
			if (senha != null && senha.equalsIgnoreCase(senhaDigitada) && perfil == 1){
                            new MenuAdministrador();
                            dispose();
                        }else if (senha != null && senha.equalsIgnoreCase(senhaDigitada) && perfil == 2){
                            new MenuCadastral();
                            dispose();
                        }else if (senha != null && senha.equalsIgnoreCase(senhaDigitada) && perfil == 3){
                            new MenuFinanceiro();
                            dispose();
                        }else if (senha != null && senha.equalsIgnoreCase(senhaDigitada) && perfil == 4){
                            new MenuSuporte();
                            dispose();
                        }
			else {
                            JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
                        }
		}
	}
	
	public final void lerFlags() {
		
		try {
			InputStream stream = new FileInputStream(FULL_PATH);
			InputStreamReader sreader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(sreader);
			
			String row = null;
			while ((row = buffer.readLine()) != null) {
				final String[] pedacos = row.split(SEPARATOR);
				txfUsuario.setText(pedacos[0]);
				txfSenha.setText(pedacos[1]);
                                txfPerfil.setText(pedacos[2]);
				if (pedacos[3].equals("true")) {
					autenticacaoValidar();
				}
                                
				break;
			}
			buffer.close();
		}
		catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Arquivo não encontrado no diretório: "+FULL_PATH);
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Falha ao ler o arquivo ("+FILE_USER+"): "+e.getMessage());
		}		
	}

	public static void main(String[] args) {		
		LoginWindow l = new LoginWindow();
		l.setVisible(true);
		l.lerFlags();
	}

}
