import javax.swing.table.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class VendasView extends JInternalFrame implements ActionListener {

    public static Container ctnVendas;
    public static JLabel lblId, lblTotal;
    public static JTextField txtId;
    public static JLabel[] lblCliente;
    public static JTextField[] txtCliente;
    public static String strCliente[]={"CPF:","Nome:","Endereço:", "Bairro:"};
    public static JLabel[] lblProduto;
    public static JTextField[] txtProduto;
    public static String strProduto[]={"Código:","Nome:","Valor Unitário:", "Quantidade:"};
    
    public static JButton btnAdicionar;
    
    public static String strTopoItens[] = {"ID", "Nome", "Valor Unitário", "Quantidade", "Valor Parcial"};
    public static JScrollPane scrItens; //barra de rolagem da tabela
    public static JTable tblItens;//tabela
    public static DefaultTableModel mdlItens;//Classe que gerencia o conteudo da tabela
    
    public static String strTopoProd[] = {"Código", "Nome", "Valor Unitário", "Estoque"};
    public static JScrollPane scrProd; //barra de rolagem da tabela
    public static JTable tblProd;//tabela
    public static DefaultTableModel mdlProd;//Classe que gerencia o conteudo da tabela
    
    

    public VendasView() {

        super("Gerenciamento de Vendas");

        ctnVendas = new Container();
        ctnVendas.setLayout(null);
        this.add(ctnVendas);

        lblId = new JLabel("Id da Venda: ");
        lblId.setBounds(30, 75, 150, 20);
        ctnVendas.add(lblId);
        txtId = new JTextField("");
        txtId.setBounds(160, 75, 150, 20);
        ctnVendas.add(txtId);

        lblCliente = new JLabel[4];
        txtCliente = new JTextField[4];
        lblProduto = new JLabel[4];
        txtProduto = new JTextField[4];
        
        for(int i=0; i<strCliente.length; i++){
            lblCliente[i] = new JLabel(strCliente[i]);
            lblCliente[i].setBounds(30, 120 + (i * 30), 150, 20);
            ctnVendas.add(lblCliente[i]);
            
            txtCliente[i] = new JTextField();
            txtCliente[i].setBounds(160, 120 + (i * 30), 150, 20);
            ctnVendas.add(txtCliente[i]);
            
        }
        
        for(int i=0; i<strProduto.length; i++){
            lblProduto[i] = new JLabel(strProduto[i]);
            lblProduto[i].setBounds(350, 75 + (i * 30), 150, 20);
            ctnVendas.add(lblProduto[i]);
            
            txtProduto[i] = new JTextField();
            txtProduto[i].setBounds(480, 75 + (i * 30), 150, 20);
            ctnVendas.add(txtProduto[i]);
            
        }
        
        btnAdicionar = new JButton("Adicionar", new ImageIcon("img/icons/new.png"));
        btnAdicionar.setBounds(350,200,280,35);
        ctnVendas.add(btnAdicionar);
        
        tblItens = new JTable();
        scrItens = new JScrollPane(tblItens);
        mdlItens = (DefaultTableModel) tblItens.getModel();

        //Inserindo elementos no topo da tabela
        for (int i = 0; i < strTopoItens.length; i++) {
            mdlItens.addColumn(strTopoItens[i]);
        }

        scrItens.setBounds(30, 250, 600, 180);
        ctnVendas.add(scrItens);
        
        tblProd = new JTable();
        scrProd = new JScrollPane(tblProd);
        mdlProd = (DefaultTableModel) tblProd.getModel();

        //Inserindo elementos no topo da tabela
        for (int i = 0; i < strTopoProd.length; i++) {
            mdlProd.addColumn(strTopoProd[i]);
        }

        scrProd.setBounds(680, 75, 550, 260);
        ctnVendas.add(scrProd);
        
        lblTotal = new JLabel("R$" + "0.00");
        lblTotal.setFont(new Font("Arial Black",Font.BOLD,40));
        lblTotal.setBounds(1000,330,250,80);
        ctnVendas.add(lblTotal);
        
        this.setClosable(true);
        this.setIconifiable(true);
        this.setSize(MainView.dskJanelas.getWidth(), MainView.dskJanelas.getHeight());
        this.show();
    }

    public void actionPerformed(ActionEvent evt) {

    }
}
