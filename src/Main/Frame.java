package Main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Frame extends JFrame {

    JPanel container, header, contact_Information;
    JButton button_add, button_delete, button_update, button_search, button_displayAll;
    JLabel label_name, label_email, label_phone, label_icon_header, label_Icon;
    JTextField textField_name, textField_email, textField_phone;
    JTable table;
    contactList list = new contactList();
    MyActionListener actionListener = new MyActionListener(this);
    readAndWrite r = new readAndWrite(list);

    Frame () {  //constructor
        container = new JPanel();
        header = new JPanel();
        contact_Information = new JPanel();
        label_name = new JLabel("Name : ");
        label_email = new JLabel("Email : ");
        label_phone = new JLabel("Number : ");
        label_icon_header =  new JLabel("My Contacts");
        label_Icon = new JLabel();
        textField_name = new JTextField();
        textField_email = new JTextField();
        textField_phone = new JTextField();
        button_add = new JButton("Add");
        button_delete = new JButton("Delete");
        button_update = new JButton("Update");
        button_search = new JButton("Search");
        button_displayAll = new JButton("Display All");
    }

    public void shown() {
        setSize(1100, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        add(container);
        setLayout(null);
        setLocationRelativeTo(null);
        container.setBackground(new Color(0, 204, 204));
        container.setBounds(0, 100 ,1100 ,550);
        add(header);
        header.setBounds(0, 0, 1100, 100);
        header.setLayout(null);
        container.setLayout(null);
        header.setBackground(Color.LIGHT_GRAY);
        header.add(label_icon_header);
        header.add(label_Icon);
        label_icon_header.setBounds(250, 0, 500, 100);
        label_icon_header.setFont(new Font("Segue UI", Font.BOLD, 37));
        label_Icon.setIcon(new ImageIcon(getClass().getResource("/images/icon_2.png")));
        label_Icon.setBounds(100, -14, 100, 100);

        container.add(contact_Information);
        contact_Information.setLayout(null);
        contact_Information.setBackground(new Color(0, 204, 204));
        contact_Information.setBounds(30, 30, 400, 400);

        //border for contact_Information (panel)
        contact_Information.setBorder(BorderFactory.createTitledBorder( "Contact Information"));

        contact_Information.add(label_name);
        contact_Information.add(textField_name);
        label_name.setBounds(40, 50, 150, 30);
        textField_name.setBounds(150, 50, 200, 30);

        contact_Information.add(label_email);
        contact_Information.add(textField_email);
        label_email.setBounds(40, 110, 150, 30);
        textField_email.setBounds(150, 110, 200, 30);

        contact_Information.add(label_phone);
        contact_Information.add(textField_phone);
        label_phone.setBounds(40, 170, 150, 30);
        textField_phone.setBounds(150, 170, 200, 30);

        label_phone.setFont(new Font("Segue UI", Font.BOLD, 18));
        label_name.setFont(new Font("Segue UI", Font.BOLD, 18));
        label_email.setFont(new Font("Segue UI", Font.BOLD, 18));

        //add button
        contact_Information.add(button_add);
        button_add.setBounds(50, 235, 100, 30);
        button_add.setBackground(Color.LIGHT_GRAY);

        //delete button
        contact_Information.add(button_delete);
        button_delete.setBounds(200, 235, 100, 30);
        button_delete.setBackground(Color.LIGHT_GRAY);

        //update_button
        contact_Information.add(button_update);
        button_update.setBounds(50, 285, 100, 30);
        button_update.setBackground(Color.LIGHT_GRAY);

        //search button
        contact_Information.add(button_search);
        button_search.setBounds(200, 285, 100, 30);
        button_search.setBackground(Color.LIGHT_GRAY);

        //displayAll button
        contact_Information.add(button_displayAll);
        button_displayAll.setBounds(90, 330, 150, 30);
        button_displayAll.setBackground(Color.LIGHT_GRAY);

        //table in container (panel)
        Object[][] data = {};
        table = new JTable(data, headerOfTable);
        table.setModel(tableModel);  //model of table
        table.setBackground(new Color(204, 204, 204));
        container.add(table);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(460, 30, 600, 400);
        container.add(scroll);

        //connect events with buttons
        button_add.addActionListener(actionListener);      //actionListener object because events on actionListener class
        button_delete.addActionListener(actionListener);
        button_update.addActionListener(actionListener);
        button_search.addActionListener(actionListener);
        button_displayAll.addActionListener(actionListener);
        r.readDataFromFile();
    }
    String[] headerOfTable = {"Name", "Email", "Number"};
    DefaultTableModel tableModel = new DefaultTableModel(headerOfTable, 0); //headerOfTable is a number of column  and zero is initial no.of rows

}

