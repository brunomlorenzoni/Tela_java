
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class MenuCadastral extends JFrame{
    
    private JMenuBar menuBar;	
	private JMenu menuSistema;
	private JMenu menuCadastro;
	private JMenu menuProcessos;	
	private JMenuItem menuItemSistemaUsuario;
	private JMenuItem menuItemSistemaSair;	
	private JMenuItem menuItemCadastroAluno;	
	private JMenuItem menuItemProcessosMatricula;
	
	public MenuCadastral() {
		setTitle("Sistema de gerencimento Menu Cadastral v21.08.17");
		setSize(1600, 950);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		menuCriar();
		setVisible(true);
	}
	
	private final void menuCriar() {
                        
		menuBar = new JMenuBar();		
			menuSistema = new JMenu("Sistema");
                                
				menuItemSistemaUsuario = new JMenuItem("Usuário");
				menuItemSistemaSair = new JMenuItem("Sair");
				menuSistema.add(menuItemSistemaUsuario);
				menuSistema.add(menuItemSistemaSair);
                                menuItemSistemaUsuario.setEnabled(false);
                                menuItemSistemaSair.setEnabled(false);
				
			menuCadastro = new JMenu("Cadastro");
				menuItemCadastroAluno = new JMenuItem("Aluno");
				menuCadastro.add(menuItemCadastroAluno);
				
			menuProcessos = new JMenu("Processo");
				menuItemProcessosMatricula = new JMenuItem("Matricula");
				menuProcessos.add(menuItemProcessosMatricula);
                                menuItemProcessosMatricula.setEnabled(false);
                                
				
		menuBar.add(menuSistema);
		menuBar.add(menuCadastro);
		menuBar.add(menuProcessos);
		
		setJMenuBar(menuBar);		
	}
}
