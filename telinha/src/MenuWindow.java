

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuWindow extends JFrame {
	
	private JMenuBar menuBar;	
	private JMenu menuSistema;
	private JMenu menuCadastro;
	private JMenu menuProcessos;	
	private JMenuItem menuItemSistemaUsuario;
	private JMenuItem menuItemSistemaSair;	
	private JMenuItem menuItemCadastroAluno;	
	private JMenuItem menuItemProcessosMatricula;
	
	public MenuWindow() {
		setTitle("Sistema de gerencimento v21.08.17");
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
				
			menuCadastro = new JMenu("Cadastro");
				menuItemCadastroAluno = new JMenuItem("Aluno");
				menuCadastro.add(menuItemCadastroAluno);
				
			menuProcessos = new JMenu("Processo");
				menuItemProcessosMatricula = new JMenuItem("Matricula");
				menuProcessos.add(menuItemProcessosMatricula);
				
		menuBar.add(menuSistema);
		menuBar.add(menuCadastro);
		menuBar.add(menuProcessos);
		
		setJMenuBar(menuBar);		
	}

}