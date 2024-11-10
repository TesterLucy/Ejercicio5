/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estudiantes;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Cristian
 */
public class ModificarDialog extends JDialog {
        private JTextField txtCodigo;
        private GestionEstudiantes gestion;

        public ModificarDialog(Frame parent, GestionEstudiantes gestionEstudiantes) {
            super(parent, "Modificar Estudiante", true);
            this.gestion = gestionEstudiantes;
            initComponents();
        }

        private void initComponents() {
            JLabel lblCodigo = new JLabel("Ingrese Código:");
            txtCodigo = new JTextField(15);
            JButton btnBuscar = new JButton("Buscar");

            btnBuscar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buscarEstudiante();
                }
            });

            JPanel panelInput = new JPanel();
            panelInput.add(lblCodigo);
            panelInput.add(txtCodigo);
            panelInput.add(btnBuscar);

            setLayout(new BorderLayout());
            add(panelInput, BorderLayout.NORTH);

            pack();
            setLocationRelativeTo(getParent());
        }

        private void buscarEstudiante() {
            String codigo = txtCodigo.getText().trim();
            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un código.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Estudiante estudiante = gestion.consultarEstudiante(codigo);
            if (estudiante != null) {
                // Abrir formulario de modificación
                ModificarFormulario modificarFormulario = new ModificarFormulario(this, gestion, codigo, estudiante);
                modificarFormulario.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Estudiante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
