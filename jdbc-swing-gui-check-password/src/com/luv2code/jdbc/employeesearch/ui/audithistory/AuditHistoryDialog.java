package com.luv2code.jdbc.employeesearch.ui.audithistory;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.luv2code.jdbc.employeesearch.core.AuditHistory;
import com.luv2code.jdbc.employeesearch.core.Employee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditHistoryDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JLabel employeeAuditHistoryLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AuditHistoryDialog dialog = new AuditHistoryDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void populate(Employee tempEmployee, List<AuditHistory> auditHistoryList) {
		
		employeeAuditHistoryLabel.setText(tempEmployee.getFirstName() + " " + tempEmployee.getLastName());
		
		AuditHistoryTableModel model = new AuditHistoryTableModel(auditHistoryList);
		
		table.setModel(model);
		
		// set up table renderer for date
		TableCellRenderer tableCellRenderer = new DateTimeCellRenderer();
		table.getColumnModel().getColumn(AuditHistoryTableModel.DATE_TIME_COL).setCellRenderer(tableCellRenderer);		
	}
	
	/**
	 * Create the dialog.
	 */
	public AuditHistoryDialog() {
		setTitle("Audit History");
		setModal(true);
		setBounds(100, 100, 651, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			{
				JLabel lblAuditHistoryFor = new JLabel("Audit History for employee:");
				panel.add(lblAuditHistoryFor);
			}
			{
				employeeAuditHistoryLabel = new JLabel("New label");
				panel.add(employeeAuditHistoryLabel);
			}
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}		
	}

	private final class DateTimeCellRenderer extends DefaultTableCellRenderer {
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

		public Component getTableCellRendererComponent(JTable table,
		        Object value, boolean isSelected, boolean hasFocus,
		        int row, int column) {
		    if( value instanceof Date) {
		        value = f.format(value);
		    }
		    return super.getTableCellRendererComponent(table, value, isSelected,
		            hasFocus, row, column);
		}
	}
	
}
