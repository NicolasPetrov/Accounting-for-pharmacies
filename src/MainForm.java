import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    public MainForm() {
        setTitle("Accounting for Pharmacies");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Medications", new MedicationPanel());
        tabbedPane.addTab("Vendors", new VendorPanel());

        add(tabbedPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainForm().setVisible(true));
    }
}

class MedicationPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    public MedicationPanel() {
        setLayout(new BorderLayout());

        String[] columnNames = {"ID", "Name", "Stock", "Price"};
        Object[][] data = {
                {1, "Paracetamol", 50, 1.5},
                {2, "Aspirin", 20, 2.0}
        };

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");
        btnPanel.add(btnAdd);
        btnPanel.add(btnEdit);
        btnPanel.add(btnDelete);

        add(btnPanel, BorderLayout.SOUTH);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMedication();
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editMedication();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMedication();
            }
        });
    }

    private void addMedication() {
        String id = JOptionPane.showInputDialog("Enter ID:");
        String name = JOptionPane.showInputDialog("Enter Name:");
        String stock = JOptionPane.showInputDialog("Enter Stock:");
        String price = JOptionPane.showInputDialog("Enter Price:");

        model.addRow(new Object[]{Integer.parseInt(id), name, Integer.parseInt(stock), Double.parseDouble(price)});
    }

    private void editMedication() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String id = JOptionPane.showInputDialog("Enter ID:", model.getValueAt(selectedRow, 0));
            String name = JOptionPane.showInputDialog("Enter Name:", model.getValueAt(selectedRow, 1));
            String stock = JOptionPane.showInputDialog("Enter Stock:", model.getValueAt(selectedRow, 2));
            String price = JOptionPane.showInputDialog("Enter Price:", model.getValueAt(selectedRow, 3));

            model.setValueAt(Integer.parseInt(id), selectedRow, 0);
            model.setValueAt(name, selectedRow, 1);
            model.setValueAt(Integer.parseInt(stock), selectedRow, 2);
            model.setValueAt(Double.parseDouble(price), selectedRow, 3);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.");
        }
    }

    private void deleteMedication() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }
}

class VendorPanel extends JPanel {
    private JTable table;
    private DefaultTableModel model;

    public VendorPanel() {
        setLayout(new BorderLayout());

        String[] columnNames = {"Vendor ID", "Name", "Contact"};
        Object[][] data = {
                {1, "ABC Pharma", "contact@abcpharma.com"},
                {2, "XYZ Meds", "info@xyzmeds.com"}
        };

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);

        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");
        btnPanel.add(btnAdd);
        btnPanel.add(btnEdit);
        btnPanel.add(btnDelete);

        add(btnPanel, BorderLayout.SOUTH);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addVendor();
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editVendor();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteVendor();
            }
        });
    }

    private void addVendor() {
        String id = JOptionPane.showInputDialog("Enter Vendor ID:");
        String name = JOptionPane.showInputDialog("Enter Name:");
        String contact = JOptionPane.showInputDialog("Enter Contact Information:");

        model.addRow(new Object[]{Integer.parseInt(id), name, contact});
    }

    private void editVendor() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String id = JOptionPane.showInputDialog("Enter Vendor ID:", model.getValueAt(selectedRow, 0));
            String name = JOptionPane.showInputDialog("Enter Name:", model.getValueAt(selectedRow, 1));
            String contact = JOptionPane.showInputDialog("Enter Contact Information:", model.getValueAt(selectedRow, 2));

            model.setValueAt(Integer.parseInt(id), selectedRow, 0);
            model.setValueAt(name, selectedRow, 1);
            model.setValueAt(contact, selectedRow, 2);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.");
        }
    }

    private void deleteVendor() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }
}