package Main;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener implements ActionListener {  //this class include all events

    private Frame frame;
    private readAndWrite write;
    validation valid = new validation();

    public MyActionListener(Frame frame) {
        this.frame = frame;
        this.write = new readAndWrite(frame.list);   // (frame.list) is an object from (Frame) class to access contacts arrayList
    }

    private void clearFiled() {
        frame.textField_name.setText("");
        frame.textField_email.setText("");
        frame.textField_phone.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean saveToFile = false; // Flag to determine when to save data

        if (e.getSource() == frame.button_add) {
            String name = frame.textField_name.getText();
            String email = frame.textField_email.getText();
            String number = frame.textField_phone.getText();
            if (valid.isValidName(name)) {
                valid.showErrorMessage(frame, "Name");
                return;   // return statement to exit from method if name is invalid
            }

            if (!valid.isValidEmail(email)) {
                valid.showErrorMessage(frame, "Email");
                return;
            }

            if (!valid.isValidPhoneNumber(number)) {
                valid.showErrorMessage(frame, "Number");
                return;
            }

            Contact newContact = new Contact(name, email, number);
            frame.list.contacts.add(newContact);

            clearFiled();
            saveToFile = true; // Set flag to save data after all operations

        } else if (e.getSource() == frame.button_delete) {
            if (frame.table.getSelectedRow() != -1) { // Check if a row is selected
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(frame,
                        "Do you want to Delete This data",
                        "Delete",
                        dialogButton);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    int indexOfRow = frame.table.getSelectedRow(); // return index of selected row
                    frame.tableModel.removeRow(indexOfRow);
                    frame.list.contacts.remove(indexOfRow);
                }
                //clear fields
                clearFiled();
                saveToFile = true; // Set flag to save data after all operations
            } else {   // not selected row
                JOptionPane.showMessageDialog(frame,
                        "Please select a row to delete",
                        "No Row Selected",
                        2);
            }
        } else if (e.getSource() == frame.button_update) {
            if (frame.table.getSelectedRow() != -1) {
                String name = frame.textField_name.getText();
                String email = frame.textField_email.getText();
                String number = frame.textField_phone.getText();
                if (valid.isValidName(name)) {
                    valid.showErrorMessage(frame, "Name");
                    return;   // return statement to exit from method if name is invalid
                }

                if (!valid.isValidEmail(email)) {
                    valid.showErrorMessage(frame, "Email");
                    return;
                }

                if (!valid.isValidPhoneNumber(number)) {
                    valid.showErrorMessage(frame, "Number");
                    return;
                }

                frame.list.contacts.get(frame.table.getSelectedRow()).setName(name);  // add taken data from fields to arraylist
                frame.list.contacts.get(frame.table.getSelectedRow()).setEmail(email);
                frame.list.contacts.get(frame.table.getSelectedRow()).setPhoneNumber(number);

                Object[] rowData = {name, email, number};
                frame.tableModel.removeRow(frame.table.getSelectedRow());
                frame.tableModel.addRow(rowData);

                clearFiled(); //clear fields after update
                saveToFile = true; // Set flag to save data after all operations
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Please select a row to update",
                        "No Row Selected",
                        JOptionPane.WARNING_MESSAGE);
            }

        } else if (e.getSource() == frame.button_search) {
            String input = JOptionPane.showInputDialog(this, "Search contact name : ");
            for (int i = 0; i < frame.list.contacts.size(); i++) {
                if (frame.list.contacts.get(i).getName().equalsIgnoreCase(input)) {
                    JOptionPane.showMessageDialog(frame, "Found", "search name", JOptionPane.WARNING_MESSAGE);
                    frame.tableModel.addRow(frame.list.ReturnData(i));
                    return;   // exit after found name
                }
            }
            // if name not found show message ==>
            JOptionPane.showMessageDialog(frame, "Not Found", "search found", 2);
        }

        else if(e.getSource() == frame.button_displayAll) {
            if(!frame.list.contacts.isEmpty()) {   //check if arrayList is empty
                for (int i = 0; i < frame.list.contacts.size(); i++) {
                    String name = frame.list.contacts.get(i).getName();
                    String email = frame.list.contacts.get(i).getEmail();
                    String number = frame.list.contacts.get(i).getPhoneNumber();
                    Object[] rowData = {name, email, number};
                    frame.tableModel.addRow(rowData);
                }
            }
            else {     // arrayList is empty
                JOptionPane.showMessageDialog(frame,
                        "No Found any Contact",
                        "display message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        // Save data only if the flag is set
        if (saveToFile) {
            write.saveDataToFile();
        }
    }
}
