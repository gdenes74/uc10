package telas;

import data.Filme;
import data.FilmeDao;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class TelaInicial extends javax.swing.JFrame {

    public TelaInicial() {
        initComponents();
        this.PreencherTbl("");
    }

    public void LimparTexto() {
        //limpar os campos
        txtNome.setText("");
        txtData.setText("");
        txtCategoria.setText("");
        txtPesquisar.setText("");
        txtPesquisar.setText("");
        //posicionar o cursor para um próximo
        txtNome.requestFocus();
        PreencherTbl("");
    }

    public String reverterData(String data) {
        String dia = data.substring(8);
        String mes = data.substring(5, 7);
        String ano = data.substring(0, 4);
        String sqlDate = dia + "/" + mes + "/" + ano;
        return sqlDate;
    }

    private void PreencherTbl(String filtro) {
		 
        FilmeDao dao = new FilmeDao();
        boolean status = dao.conectar();
        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            List<Filme> listaFilmes = dao.listagem(filtro);
            DefaultTableModel tabelaFilmes = (DefaultTableModel) tblFilmes.getModel();
            tblFilmes.setRowSorter(new TableRowSorter(tabelaFilmes));
            tabelaFilmes.setNumRows(0);
				
				
            for (Filme f : listaFilmes) {
                Object[] object = new Object[]{
						 f.getId(),      //adicionado//
                    f.getNome(),
                    this.reverterData(String.valueOf(f.getData())),
                    f.getCategoria()
                };
					 
					 
                tabelaFilmes.addRow(object);
            }
            dao.desconectar();
        }
    }

    private void consultar(String nome) {
        FilmeDao dao = new FilmeDao();
        boolean status = dao.conectar();
        if (status == true) {
            Filme filme = dao.consultar(nome);
            System.out.println(dao.consultar(nome));
            if (filme == null) {
                JOptionPane.showMessageDialog(null, "Filme não localizado");
            } else {
                txtNome.setText(filme.getNome());
                txtData.setText(this.reverterData(String.valueOf(filme.getData())));
                txtCategoria.setText(filme.getCategoria());
            }
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel1 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      jLabel5 = new javax.swing.JLabel();
      btCadastrar = new javax.swing.JButton();
      btExcluir = new javax.swing.JButton();
      txtNome = new javax.swing.JTextField();
      txtData = new javax.swing.JTextField();
      txtCategoria = new javax.swing.JTextField();
      btConsultar = new javax.swing.JButton();
      btAtualizar = new javax.swing.JButton();
      btLimpar = new javax.swing.JButton();
      jLabel6 = new javax.swing.JLabel();
      txtPesquisar = new javax.swing.JTextField();
      jPanel2 = new javax.swing.JPanel();
      jScrollPane1 = new javax.swing.JScrollPane();
      tblFilmes = new javax.swing.JTable();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
      jLabel1.setText(" CENAFLIX ");
      jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

      jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
      jLabel2.setText("CADASTRO DE FILME");

      jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
      jLabel3.setText("Nome do Filme:");

      jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
      jLabel4.setText("Data de Lançamento:");

      jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
      jLabel5.setText("Categoria:");

      btCadastrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      btCadastrar.setText("Cadastrar");
      btCadastrar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btCadastrarActionPerformed(evt);
         }
      });

      btExcluir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      btExcluir.setText("Excluir");
      btExcluir.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btExcluirActionPerformed(evt);
         }
      });

      txtNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
      txtNome.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtNomeActionPerformed(evt);
         }
      });

      txtData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
      txtData.setToolTipText("Digite data DD/MM/AAAA");

      txtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

      btConsultar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      btConsultar.setText("Consultar");
      btConsultar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btConsultarActionPerformed(evt);
         }
      });

      btAtualizar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      btAtualizar.setText("Atualizar");
      btAtualizar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btAtualizarActionPerformed(evt);
         }
      });

      btLimpar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
      btLimpar.setText("Limpar");
      btLimpar.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btLimparActionPerformed(evt);
         }
      });

      jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
      jLabel6.setText("Pesquisar:");

      txtPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
      txtPesquisar.addCaretListener(new javax.swing.event.CaretListener() {
         public void caretUpdate(javax.swing.event.CaretEvent evt) {
            txtPesquisarCaretUpdate(evt);
         }
      });

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel2)
                  .addGap(178, 178, 178))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addGap(197, 197, 197))))
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(jLabel4)
                     .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                     .addComponent(txtData)
                     .addComponent(txtCategoria)
                     .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                  .addComponent(btCadastrar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btConsultar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btAtualizar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                  .addComponent(btLimpar)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(btExcluir)
                  .addGap(36, 36, 36))))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addGap(18, 18, 18)
            .addComponent(jLabel2)
            .addGap(21, 21, 21)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel6)
               .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(35, 35, 35)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(btConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
      );

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 0, Short.MAX_VALUE)
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 0, Short.MAX_VALUE)
      );

      tblFilmes.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Id", "Nome filme", "Data lançamento", "Categoria"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }
      });
      tblFilmes.addMouseListener(new java.awt.event.MouseAdapter() {
         public void mouseClicked(java.awt.event.MouseEvent evt) {
            tblFilmesMouseClicked(evt);
         }
      });
      jScrollPane1.setViewportView(tblFilmes);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
         .addGroup(layout.createSequentialGroup()
            .addGap(36, 36, 36)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGap(45, 45, 45))))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        Filme filme = new Filme();
        FilmeDao dao = new FilmeDao();
        boolean status = dao.conectar();
        int resposta;

        String nome = txtNome.getText();
        String dataRecebida = txtData.getText();
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy");
        String categoria = txtCategoria.getText();
        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo nome deve ser preenchido. ");
        } else {
            filme.setNome(nome);
            boolean verNome = nome.matches("[a-zA-Z0-9 ]{1,30}");
            if (verNome == false) {
                JOptionPane.showMessageDialog(null, "Preencha o nome somente com letras e/ou números: ");
            } else {
                if (dataRecebida.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O campo data deve ser preenchido. ");
                } else {
                    boolean verData = dataRecebida.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}");
                    if (verData == false) {
                        JOptionPane.showMessageDialog(null, "O campo data deve ser preenchido no formato DD/MM/AAAA. ");
                    } else {
                        if (categoria.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "O campo categoria deve ser preenchido. ");
                        } else {
                            filme.setCategoria(categoria);
                            boolean verCate = categoria.matches("[a-zA-Z0-9 ]{2,10}");
                            if (verCate == false) {
                                JOptionPane.showMessageDialog(null, "Preencha o campo Categoria com letras e/ou números. ");
                            } else {
                                try {
                                    Date dataConvertida = conversor.parse(dataRecebida);
                                    java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime());
                                    filme.setData(sqlDate);
                                } catch (ParseException ex) {
                                    System.out.println("Erro na conversão da data");
                                }

                                if (status == false) {
                                    JOptionPane.showMessageDialog(null, "Erro de conexão");
                                } else {
                                    resposta = dao.salvar(filme);
                                    if (resposta == 1) {

                                        JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso");
                                        LimparTexto();
                                    } else if (resposta == 1062) {
                                        JOptionPane.showMessageDialog(null, "Nome do filme já foi cadastrado");
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados");
                                        System.out.println(filme.getNome());
                                    }
                                    dao.desconectar();
                                }
                            }
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_btCadastrarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed

    }//GEN-LAST:event_txtNomeActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        FilmeDao dao = new FilmeDao();
        Filme filme = new Filme();
        boolean status = dao.conectar();

        if (status == false) {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        } else {
            status = dao.excluir(txtNome.getText());
            if (status == true) {
                JOptionPane.showMessageDialog(null, "Filme excluído com sucesso!");

                LimparTexto();
            } else {
                JOptionPane.showMessageDialog(null, "Erro na exclusão do filme!");
            }
            dao.desconectar();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        String nome;
        nome = txtPesquisar.getText();
        FilmeDao dao = new FilmeDao();
        boolean status = dao.conectar();
        if (status == true) {
            Filme filme = dao.consultar(nome);
            System.out.println(dao.consultar(nome));
            if (filme == null) {
                JOptionPane.showMessageDialog(null, "Filme não localizado");
            } else {
                txtNome.setText(filme.getNome());
                txtData.setText(this.reverterData(String.valueOf(filme.getData())));
                txtCategoria.setText(filme.getCategoria());
            }
            dao.desconectar();
        } else {
            JOptionPane.showMessageDialog(null, "Erro de conexão");
        }
     }//GEN-LAST:event_btConsultarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        LimparTexto();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        Filme filme = new Filme();
        FilmeDao dao = new FilmeDao();
        boolean status = dao.conectar();
        int resposta;
		  
		  int selectedRow = tblFilmes.getSelectedRow();
		  int id = Integer.parseInt(tblFilmes.getValueAt(selectedRow, 0).toString());

        String nome = txtNome.getText();
        String dataRecebida = txtData.getText();
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy");
        String categoria = txtCategoria.getText();
		  
		  
		  
        if (nome.isEmpty()) {
			  
            JOptionPane.showMessageDialog(null, "O campo nome deve ser preenchido. ");
				
        } else {
			  
          filme.setNome(nome);
          boolean verNome = nome.matches("[a-zA-Z0-9 ]{1,30}");
         if (verNome == false) {
				
         JOptionPane.showMessageDialog(null, "Preencha o nome com letras e/ou numeros: ");
			
         } else {
				
         if (dataRecebida.isEmpty()) {
				
         JOptionPane.showMessageDialog(null, "O campo data deve ser preenchido. ");
			
         } else {
				
         boolean verData = dataRecebida.matches("[0-9]{2}[/][0-9]{2}[/][0-9]{4}");
			
         if (verData == false) {
				
         JOptionPane.showMessageDialog
		  (null, "O campo data deve ser preenchido no formato DD/MM/AAAA. ");
			
        } else {
				
         if (categoria.isEmpty()) {
				
         JOptionPane.showMessageDialog
		  (null, "O campo categoria deve ser preenchido. ");
			
         } else {
				
         filme.setCategoria(categoria);
         boolean verCate = categoria.matches("[a-zA-Z0-9 ]{2,10}");
			
         if (verCate == false) {
				
         JOptionPane.showMessageDialog
		  (null, "Preencha o campo Categoria com letras e/ou números. ");
			
        } else {
				
         try {
				
            Date dataConvertida = conversor.parse(dataRecebida);
            java.sql.Date sqlDate = new java.sql.Date(dataConvertida.getTime());
            filme.setData(sqlDate);
												
          } catch (ParseException ex) {
				 
			 System.out.println("Erro na conversão da data");
			 
          }

          if (status == false) {
				 
           JOptionPane.showMessageDialog(null, "Erro de conexão");
			  
           } else {
				 filme.setId(id);
             resposta = dao.atualizar(filme);
				 System.out.println(filme.getNome() + filme.getCategoria());
            if (resposta == 1) {

            JOptionPane.showMessageDialog(null, "Dados incluidos com sucesso");
            LimparTexto();
				
            } else if (resposta == 1062) {
					
				JOptionPane.showMessageDialog(null, "Nome do filme já foi cadastrado");
				
            } else {
					
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir dados");
            System.out.println(filme.getNome());
				
            }
                                    
				dao.desconectar();
            }
            }
            }
            }
           }
            
			}
        }    }//GEN-LAST:event_btAtualizarActionPerformed

    private void txtPesquisarCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtPesquisarCaretUpdate
        this.PreencherTbl(txtPesquisar.getText());
    }//GEN-LAST:event_txtPesquisarCaretUpdate

    private void tblFilmesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFilmesMouseClicked
        
		 int linha = tblFilmes.getSelectedRow();
        this.consultar((String) tblFilmes.getValueAt(linha, 1));
		  
    }//GEN-LAST:event_tblFilmesMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btAtualizar;
   private javax.swing.JButton btCadastrar;
   private javax.swing.JButton btConsultar;
   private javax.swing.JButton btExcluir;
   private javax.swing.JButton btLimpar;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tblFilmes;
   private javax.swing.JTextField txtCategoria;
   private javax.swing.JTextField txtData;
   private javax.swing.JTextField txtNome;
   private javax.swing.JTextField txtPesquisar;
   // End of variables declaration//GEN-END:variables
}
