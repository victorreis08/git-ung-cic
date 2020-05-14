
import javax.swing.*;  //elementos gráficos de tela
import javax.swing.table.*; //gerenciamento de tabelas
import java.awt.*; //Container
import java.awt.event.*; //ActionListener (botoes)
import java.io.*; //gravação em disco

public class AgenciaView extends JFrame implements ActionListener {

    //Declaração dos objetos
    public static Container ctnTela;
    public static JLabel lblBanner, lblTitulo, lblDestino, lblImgDestino,
            lblPessoas, lblAerea, lblClasse,
            lblVoo, lblValorVoo, lblAdic, lblValorAdic,
            lblTotal, lblValorTotal;

    public static JComboBox cmbDestino, cmbAerea, cmbClasse;
    public static JTextField txtPessoas;

    public static JScrollPane scrItens;
    public static JTable tblItens;
    public static DefaultTableModel mdlItens;

    public static JCheckBox chkExtras[];

    public static ImageIcon imgAdicionais[];
    public static JButton btnAdicionais[];

    public static JButton btnCalcular, btnLimpar, btnFechar;

    //Declaração de variaveis auxiliares
    public static Font fntTitulo = new Font("Tahoma", Font.BOLD, 26);
    public static Font fntTexto = new Font("Tahoma", Font.BOLD, 20);
    public static Font fntCampos = new Font("Tahoma", Font.PLAIN, 20);

    public static String extras[] = {"Bagagem Adic.", "Refeição Extra", "Champagne"};
    public static String legenda[] = {"Nome", "Qtde", "Valor"};

    public AgenciaView() {

        super(":: Agência de Turismo - UNGCIC - Burlando a quarentena ::");

        //Construção e configuração dos objetos
        ctnTela = new Container();
        ctnTela.setLayout(null);
        this.add(ctnTela);

        lblBanner = new JLabel(new ImageIcon("images/bannerN.jpg"));
        lblBanner.setBounds(0, 0, 1000, 100);
        ctnTela.add(lblBanner);

        lblTitulo = new JLabel("Monte seu pacote");
        lblTitulo.setFont(fntTitulo);
        lblTitulo.setBounds(280, 110, 300, 30);
        ctnTela.add(lblTitulo);

        lblDestino = new JLabel("Destino:");
        lblDestino.setFont(fntTexto);
        lblDestino.setBounds(10, 150, 150, 25);
        ctnTela.add(lblDestino);

        lblImgDestino = new JLabel(new ImageIcon("images/dest0.jpg"));
        lblImgDestino.setBounds(10, 210, 200, 60);
        ctnTela.add(lblImgDestino);

        cmbDestino = new JComboBox(AgenciaControl.objPacote.destinos);
        cmbDestino.setFont(fntCampos);
        cmbDestino.setBounds(10, 180, 200, 25);
        ctnTela.add(cmbDestino);

        cmbDestino.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                lblImgDestino.setIcon(new ImageIcon("images/dest"
                        + cmbDestino.getSelectedIndex() + ".jpg"));
            }
        }
        );

        lblPessoas = new JLabel("Qtde. Pessoas:");
        lblPessoas.setFont(fntTexto);
        lblPessoas.setBounds(10, 275, 200, 25);
        ctnTela.add(lblPessoas);

        txtPessoas = new JTextField("1");
        txtPessoas.setFont(fntCampos);
        txtPessoas.setBounds(10, 305, 200, 25);
        ctnTela.add(txtPessoas);

        lblAerea = new JLabel("Companhia:");
        lblAerea.setFont(fntTexto);
        lblAerea.setBounds(10, 335, 200, 25);
        ctnTela.add(lblAerea);

        cmbAerea = new JComboBox(AgenciaControl.objPacote.aereas);
        cmbAerea.setFont(fntCampos);
        cmbAerea.setBounds(10, 365, 200, 25);
        ctnTela.add(cmbAerea);

        lblClasse = new JLabel("Classe:");
        lblClasse.setFont(fntTexto);
        lblClasse.setBounds(10, 395, 200, 25);
        ctnTela.add(lblClasse);

        cmbClasse = new JComboBox(AgenciaControl.objPacote.classes);
        cmbClasse.setFont(fntCampos);
        cmbClasse.setBounds(10, 425, 200, 25);
        ctnTela.add(cmbClasse);

        lblVoo = new JLabel("Valor do Vôo:");
        lblVoo.setFont(fntTexto);
        lblVoo.setBounds(10, 530, 200, 25);
        ctnTela.add(lblVoo);

        lblValorVoo = new JLabel("R$ 0,00");
        lblValorVoo.setFont(fntCampos);
        lblValorVoo.setBounds(150, 530, 200, 25);
        ctnTela.add(lblValorVoo);

        lblAdic = new JLabel("Valor Adicionais:");
        lblAdic.setFont(fntTexto);
        lblAdic.setBounds(320, 530, 200, 25);
        ctnTela.add(lblAdic);

        lblValorAdic = new JLabel("R$ 0,00");
        lblValorAdic.setFont(fntCampos);
        lblValorAdic.setBounds(500, 530, 200, 25);
        ctnTela.add(lblValorAdic);

        lblTotal = new JLabel("Valor Total:");
        lblTotal.setFont(fntTitulo);
        lblTotal.setBounds(10, 580, 200, 30);
        ctnTela.add(lblTotal);

        lblValorTotal = new JLabel("R$ 0,00");
        lblValorTotal.setFont(fntTitulo);
        lblValorTotal.setBounds(180, 583, 200, 25);
        ctnTela.add(lblValorTotal);

        tblItens = new JTable();
        scrItens = new JScrollPane(tblItens);
        mdlItens = (DefaultTableModel) tblItens.getModel();

        scrItens.setBounds(250, 180, 250, 270);
        ctnTela.add(scrItens);

        for (int i = 0; i < legenda.length; i++) {
            mdlItens.addColumn(legenda[i]);
        }

        imgAdicionais = new ImageIcon[8];
        btnAdicionais = new JButton[8];

        chkExtras = new JCheckBox[3];

        for (int i = 0; i < 3; i++) {
            chkExtras[i] = new JCheckBox(extras[i]);
            //chkExtras[i].setFont(fntTexto);
            chkExtras[i].setBounds(540+(i*165), 180, 150, 30);
            ctnTela.add(chkExtras[i]);
        }

        int xInicial = 540;
        int auxY = 0;

        for (int i = 0; i < btnAdicionais.length; i++) {
            imgAdicionais[i] = new ImageIcon("images/ad" + i + ".jpg");
            btnAdicionais[i] = new JButton(imgAdicionais[i]);
            btnAdicionais[i].addActionListener(this);

            String desc = AgenciaControl.objPacote.adicionais[i];
            btnAdicionais[i].setToolTipText(desc);

            if (i < 4) {
                btnAdicionais[i].setBounds(xInicial + (i * 110), 230, 100, 100);
            } else {
                if (i == 4) {
                    xInicial = 540;
                }

                btnAdicionais[i].setBounds(xInicial + (auxY * 110), 350, 100, 100);
                auxY++;
            }

            ctnTela.add(btnAdicionais[i]);
        }

        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);
        btnCalcular.setBounds(10, 465, 200, 50);
        ctnTela.add(btnCalcular);

        btnLimpar = new JButton("Limpar Pacote");
        btnLimpar.addActionListener(this);
        btnLimpar.setBounds(540, 465, 430, 50);
        ctnTela.add(btnLimpar);

        btnFechar = new JButton("Fechar Pacote");
        btnFechar.addActionListener(this);
        btnFechar.setBounds(670, 555, 300, 50);
        ctnTela.add(btnFechar);

        //Configuração da Janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 650);
        this.setResizable(false);
        this.setVisible(true);

    }//fechando construtor

    public void actionPerformed(ActionEvent evt) { //ação dos botoes

        if(evt.getSource() == btnCalcular){
            boolean op1,op2,op3;
            int auxDest, auxComp, auxNPess, auxClasse;
            float auxTotVoo = 0;
            
            op1 = chkExtras[0].isSelected();
            op2 = chkExtras[1].isSelected();
            op3 = chkExtras[2].isSelected();
            
            auxDest = cmbDestino.getSelectedIndex();
            auxComp = cmbAerea.getSelectedIndex();
            auxNPess = Integer.parseInt(txtPessoas.getText());
            auxClasse = cmbClasse.getSelectedIndex();
            
            auxTotVoo = AgenciaControl.objPacote.atualizarVoo(auxDest, auxNPess, auxComp, auxClasse, op1, op2, op3);
            
            lblValorVoo.setText("R$ " + auxTotVoo);            
            
        } else if(evt.getSource() == btnLimpar){
            
            chkExtras[0].setSelected(false);
            chkExtras[1].setSelected(false);
            chkExtras[1].setSelected(false);
            
            cmbDestino.setSelectedIndex(0);
            cmbAerea.setSelectedIndex(0);
            cmbClasse.setSelectedIndex(0);            
            txtPessoas.setText("1");
            
            lblValorVoo.setText("R$ 0.00");
            
            AgenciaControl.objPacote.limparDados();
            
        }
        
        
    }//fchando actPerformed    

}//fechando classe
