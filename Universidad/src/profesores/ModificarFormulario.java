package profesores;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridLayout;
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
class ModificarFormulario extends JDialog {
        private JTextField txtNombre;
        private JTextField txtApellido;
        private JTextField txtCarrera;
        private JTextField txtDireccion;
        private JTextField txtTelefono;
        private GestionProfesores gestion;
        private String codigo;

        public ModificarFormulario(Dialog parent, GestionProfesores gestionEstudiantes, String codigo, Profesor profesor) {
            super(parent, "Modificar Estudiante", true);
            this.gestion = gestionEstudiantes;
            this.codigo = codigo;
            initComponents(profesor);
        }

        private void initComponents( Profesor profesor) {
            JLabel lblNombre = new JLabel("Nombre:");
            JLabel lblApellido = new JLabel("Apellido:");
            JLabel lblCarrera = new JLabel("Carrera:");
            JLabel lblDireccion = new JLabel("Dirección:");
            JLabel lblTelefono = new JLabel("Teléfono:");

            txtNombre = new JTextField(profesor.getNombres(), 15);
            txtApellido = new JTextField(profesor.getApellidos(), 15);
            txtCarrera = new JTextField(profesor.getCarrera(), 15);
            txtDireccion = new JTextField(profesor.getDireccion(), 15);
            txtTelefono = new JTextField(profesor.getTelefono(), 15);

            JButton btnGuardar = new JButton("Guardar");
            btnGuardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    guardarModificacion();
                }
            });

            JButton btnCancelar = new JButton("Cancelar");
            btnCancelar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });

            JPanel panelLabels = new JPanel(new GridLayout(5, 1, 5, 5));
            panelLabels.add(lblNombre);
            panelLabels.add(lblApellido);
            panelLabels.add(lblCarrera);
            panelLabels.add(lblDireccion);
            panelLabels.add(lblTelefono);

            JPanel panelCampos = new JPanel(new GridLayout(5, 1, 5, 5));
            panelCampos.add(txtNombre);
            panelCampos.add(txtApellido);
            panelCampos.add(txtCarrera);
            panelCampos.add(txtDireccion);
            panelCampos.add(txtTelefono);

            JPanel panelForm = new JPanel(new BorderLayout(10, 10));
            panelForm.add(panelLabels, BorderLayout.WEST);
            panelForm.add(panelCampos, BorderLayout.CENTER);

            JPanel panelBotones = new JPanel();
            panelBotones.add(btnGuardar);
            panelBotones.add(btnCancelar);

            setLayout(new BorderLayout(10, 10));
            add(panelForm, BorderLayout.CENTER);
            add(panelBotones, BorderLayout.SOUTH);

            pack();
            setLocationRelativeTo(getParent());
        }

        private void guardarModificacion() {
            String nombres = txtNombre.getText().trim();
            String apellidos = txtApellido.getText().trim();
            String carrera = txtCarrera.getText().trim();
            String direccion = txtDireccion.getText().trim();
            String telefono = txtTelefono.getText().trim();

            // Validar que todos los campos estén llenos
            if (nombres.isEmpty() || apellidos.isEmpty() || carrera.isEmpty()
                    || direccion.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear el estudiante modificado
            Profesor profesor = new Profesor();
            profesor.setNombres(nombres);
            profesor.setApellidos(apellidos);
            profesor.setCarrera(carrera);
            profesor.setDireccion(direccion);
            profesor.setTelefono(telefono);

            // Modificar el estudiante usando la lógica de gestionEstudiantes
            if (gestion.modificarProfesor(codigo, profesor)) {
                JOptionPane.showMessageDialog(this, "Estudiante modificado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar el profesor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
