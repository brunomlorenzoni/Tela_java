
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class classe_1 extends JFrame{
    
    private JTextField txfEmail;
    private JTextField txfSenha;
    private JLabel lblEmail;
    private JButton btnValidar;
    private JTable tblEmails;
    private DefaultTableModel model;
    private JScrollPane scroll;
    
    
    
    public classe_1(){
        
        setSize(800, 800);
        setTitle("tela teste!!");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        
        
        componentesCriar();
        
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
               
                setDefaultCloseOperation
                (
                JOptionPane.showConfirmDialog(null, "Deseja fechar o sistema?", "informação", JOptionPane.YES_NO_OPTION)
                        == JOptionPane.YES_OPTION
                        ? EXIT_ON_CLOSE
                        : DO_NOTHING_ON_CLOSE
                );              
            }
            });
    }
    
    private void componentesCriar(){
        
        lblEmail = new JLabel("email:");
        lblEmail.setBounds(10,10,50,25);
        getContentPane().add(lblEmail);
        
        txfEmail = new JTextField();
        txfEmail.setBounds(65, 10, 150, 25);
        getContentPane().add(txfEmail);
        
        txfSenha = new JTextField();
        txfSenha.setBounds(300, 10, 150, 25);
        getContentPane().add(txfSenha);
        
        
        btnValidar = new JButton(new AbstractAction("validar") {
         
            public void actionPerformed(ActionEvent e) {
                System.out.println("validação");
                
                final String email = txfEmail.getText();
                final String senha = txfSenha.getText();
                
                
                if(email.equalsIgnoreCase("Administrador") && senha.equalsIgnoreCase("Administrador")){
                    model.addRow(new String[] {String.valueOf(model.getRowCount()+1), email, senha});
                    txfEmail.setText(null);
                    txfEmail.requestFocus();
                    txfSenha.setText(null);
                    txfSenha.requestFocus();
                    JOptionPane.showMessageDialog(null, "cadastrado com sucesso");
                }else if(email.equalsIgnoreCase("Adm") && senha.equalsIgnoreCase("Adm123")){
                    model.addRow(new String[] {String.valueOf(model.getRowCount()+1), email, senha});
                    txfEmail.setText(null);
                    txfEmail.requestFocus();
                    txfSenha.setText(null);
                    txfSenha.requestFocus();
                }else if(email.equalsIgnoreCase("Administrator") && senha.equalsIgnoreCase("7410")){
                   model.addRow(new String[] {String.valueOf(model.getRowCount()+1), email, senha});
                    txfEmail.setText(null);
                    txfEmail.requestFocus();
                    txfSenha.setText(null);
                    txfSenha.requestFocus();
                }else if(email.equalsIgnoreCase("Root") && senha.equalsIgnoreCase("un3scr3m0ta+()")){
                   model.addRow(new String[] {String.valueOf(model.getRowCount()+1), email, senha});
                    txfEmail.setText(null);
                    txfEmail.requestFocus();
                    txfSenha.setText(null);
                    txfSenha.requestFocus();
                }
                else {
                    JOptionPane.showMessageDialog(null, "login ou senha invalido");
                }
           
            }
        });
        btnValidar.setBounds(65, 40, 250, 25);
        getContentPane().add(btnValidar);
        
        model = new DefaultTableModel();
        model.addColumn("indice");
        model.addColumn("login");
        model.addColumn("Senha");
        
        tblEmails = new JTable(model);
        scroll = new JScrollPane(tblEmails);
        scroll.setBounds(10, 70, 775, 300);
        getContentPane().add(scroll);
        
    }
    
    public static void main(String[] args) {
        
        new classe_1().setVisible(true);
        
    }
}
