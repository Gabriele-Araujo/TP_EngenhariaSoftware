/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Administrador.AdmPagamentos;

import Interfaces.Default.*;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.Aluno;
import objetos.Pagamento;
import objetos_dao.AlunoDAO;
import objetos_dao.PagamentoDAO;


/**
 *
 * @author Marco Antônio
 */
public class OpPagamentos extends javax.swing.JPanel {

    Aluno tempAluno;
    
    public OpPagamentos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelFicha = new javax.swing.JPanel();
        nomeAluno = new javax.swing.JTextField();
        TelefoneCadAlun1 = new javax.swing.JLabel();
        TelefoneCadAlun2 = new javax.swing.JLabel();
        dataPagamento = new com.toedter.calendar.JDateChooser();
        TelefoneCadAlun3 = new javax.swing.JLabel();
        valorPagamento = new javax.swing.JFormattedTextField();
        btnRegistrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePagamento = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAlunos = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        pesquisarAlun = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();

        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        Titulo.setFont(new java.awt.Font("Impact", 0, 30)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Registro de mensalidades");

        jTabbedPane1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        nomeAluno.setEditable(false);
        nomeAluno.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nomeAluno.setPreferredSize(new java.awt.Dimension(74, 32));

        TelefoneCadAlun1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        TelefoneCadAlun1.setText("Aluno:");

        TelefoneCadAlun2.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        TelefoneCadAlun2.setText("Data:");

        dataPagamento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        TelefoneCadAlun3.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        TelefoneCadAlun3.setText("Valor:");

        valorPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));

        btnRegistrar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFichaLayout = new javax.swing.GroupLayout(painelFicha);
        painelFicha.setLayout(painelFichaLayout);
        painelFichaLayout.setHorizontalGroup(
            painelFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFichaLayout.createSequentialGroup()
                .addGap(171, 171, 171)
                .addGroup(painelFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelFichaLayout.createSequentialGroup()
                        .addComponent(TelefoneCadAlun1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelFichaLayout.createSequentialGroup()
                        .addGroup(painelFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TelefoneCadAlun2)
                            .addComponent(TelefoneCadAlun3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(123, 123, 123)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        painelFichaLayout.setVerticalGroup(
            painelFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFichaLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(painelFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelefoneCadAlun1))
                .addGap(18, 18, 18)
                .addGroup(painelFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TelefoneCadAlun2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRegistrar))
                .addGap(18, 18, 18)
                .addGroup(painelFichaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(valorPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TelefoneCadAlun3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrar", painelFicha);

        tablePagamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablePagamento.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tablePagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Data", "Valor", "Multa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePagamento.setRowHeight(28);
        jScrollPane2.setViewportView(tablePagamento);

        btnExcluir.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluir)
                        .addGap(40, 40, 40))))
        );

        jTabbedPane1.addTab("Controle", jPanel1);

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableAlunos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableAlunos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tableAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Aluno", "CPF", "Email", "Telefone", "Dia de Pagamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAlunos.setRowHeight(28);
        tableAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableAlunos);

        btnPesquisar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        pesquisarAlun.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        pesquisarAlun.setPreferredSize(new java.awt.Dimension(74, 32));

        btnLimpar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pesquisarAlun, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpar)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(pesquisarAlun, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            DefaultTableModel TF = (DefaultTableModel) tableAlunos.getModel();
            TF.setNumRows(0);
            
            for(Aluno a : new AlunoDAO().getLista()){
                if (a.getCPF().contains(pesquisarAlun.getText()) || 
                    a.getNome().contains(pesquisarAlun.getText()) || 
                    a.getEmail().contains(pesquisarAlun.getText()) || 
                    a.getTelefone().contains(pesquisarAlun.getText())) {
                    
                    TF.addRow(new Object[]{
                        a.getNome(),
                        a.getCPF(),
                        a.getEmail(),
                        a.getTelefone(),
                        a.getDia_pagamento()
                    });
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(OpPagamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        Limpar();
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        
        try {
            if(!(tablePagamento.getSelectedRow() >= 0) ||
                tempAluno == null)
                throw new Exception("Verifique se o pagamento foi selecionado corretamente");
            
            Pagamento pagamento = new PagamentoDAO().getPagamento(tempAluno.getCPF(), new Date(new SimpleDateFormat("dd/MM/yyyy").parse(tablePagamento.getValueAt(tablePagamento.getSelectedRow(), 0).toString()).getTime()));
            
            ExcPagamentoAlerta EPA = new ExcPagamentoAlerta(pagamento, this);
            EPA.setVisible(true); 
            
            AtualizaTabelaPagamento();
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        try{
            if( tempAluno == null ||
                dataPagamento.getDate() == null ||
                valorPagamento.getText().isBlank())
                throw new Exception("Verifique se os campos estão preenchidos corretamente");
            
            boolean multa = false;
            if(dataPagamento.getDate().getDay() > new java.util.Date().getDay() )
                multa = true;
            Pagamento pagamento = new Pagamento(Float.valueOf(valorPagamento.getValue().toString()), new Date(dataPagamento.getDate().getTime()), tempAluno, multa);
            
            new PagamentoDAO().adiciona(pagamento);            
            AtualizaTabelaPagamento();
            throw new Exception("Pagamento registrado com sucesso");
        
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        ((DefaultTableModel)tablePagamento.getModel()).setNumRows(0);
        btnExcluir.setEnabled(false);
        btnRegistrar.setEnabled(false);
        
        AtualizaTabelaAluno();
    }//GEN-LAST:event_formAncestorAdded

    private void tableAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAlunosMouseClicked
        
        if(tableAlunos.getSelectedRow() >= 0){
        
            try {
                tempAluno = new AlunoDAO().getAluno((String) tableAlunos.getValueAt(tableAlunos.getSelectedRow(), 1));
                nomeAluno.setText(tempAluno.getNome());
                
                btnExcluir.setEnabled(true);
                btnRegistrar.setEnabled(true);
                
                DefaultTableModel TF = (DefaultTableModel) tablePagamento.getModel();
                TF.setNumRows(0);
                
                for(Pagamento p : new PagamentoDAO().getPagamentos(tempAluno)){
                    TF.addRow(new Object[]{
                        new SimpleDateFormat("dd/MM/yyyy").format(p.getData()),
                        "R$ " + String.format("%.2f", p.getValor()),
                        p.isMulta(),
                    });
                }
            } catch (Exception ex) {
                Logger.getLogger(OpPagamentos.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        
        }
    }//GEN-LAST:event_tableAlunosMouseClicked

    public void AtualizaTabelaAluno(){
        try {
            DefaultTableModel TF = (DefaultTableModel) tableAlunos.getModel();
            TF.setNumRows(0);
            
            for(Aluno a : new AlunoDAO().getLista()){
                TF.addRow(new Object[]{
                    a.getNome(),
                    a.getCPF(),
                    a.getEmail(),
                    a.getTelefone(),
                    a.getDia_pagamento()
                });
            }
        } catch (Exception ex) {
            Logger.getLogger(OpPagamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AtualizaTabelaPagamento(){
        try {
            DefaultTableModel TF = (DefaultTableModel) tablePagamento.getModel();
            TF.setNumRows(0);
            
            for(Pagamento p : new PagamentoDAO().getPagamentos(tempAluno)){
                TF.addRow(new Object[]{
                    new SimpleDateFormat("dd/MM/yyyy").format(p.getData()),
                    String.format("%.2f", p.getValor()),
                    p.isMulta(),
                });        
            }
        } catch (Exception ex) {
            Logger.getLogger(OpPagamentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Limpar(){
        btnExcluir.setEnabled(false);
        btnRegistrar.setEnabled(false);
        ((DefaultTableModel)tablePagamento.getModel()).setNumRows(0);
        dataPagamento.setDate(null);
        valorPagamento.setValue(000.00);

        AtualizaTabelaAluno();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TelefoneCadAlun1;
    private javax.swing.JLabel TelefoneCadAlun2;
    private javax.swing.JLabel TelefoneCadAlun3;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnRegistrar;
    private com.toedter.calendar.JDateChooser dataPagamento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField nomeAluno;
    private javax.swing.JPanel painelFicha;
    private javax.swing.JTextField pesquisarAlun;
    private javax.swing.JTable tableAlunos;
    private javax.swing.JTable tablePagamento;
    private javax.swing.JFormattedTextField valorPagamento;
    // End of variables declaration//GEN-END:variables
}
