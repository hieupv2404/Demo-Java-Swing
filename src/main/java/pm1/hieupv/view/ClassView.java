package pm1.hieupv.view;

import pm1.hieupv.model.Class;
import pm1.hieupv.service.impl.ClassServiceImpl;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;

public class ClassView extends JFrame implements ActionListener, ListSelectionListener {
    private ClassServiceImpl classServiceImpl;
    private List<Class> classList;
    private JTable classTable;
    private JScrollPane classScrollPane;
    private JButton addButton;
    private JButton editButton;
    private JButton clearButton;
    private JButton deleteButton;
    private JButton searchButton;

    private JLabel mslLabel;
    private JLabel nameLabel;
    private JLabel gvcnLabel;
    private JLabel appLabel;
    private JLabel tableLabel;

    private JTextField mslText;
    private JTextField nameText;
    private JTextField gvcnText;

    public JTextField getMslText() {
        return mslText;
    }

    public ClassView setMslText(JTextField mslText) {
        this.mslText = mslText;
        return this;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public ClassView setNameText(JTextField nameText) {
        this.nameText = nameText;
        return this;
    }

    public JTextField getGvcnText() {
        return gvcnText;
    }

    public ClassView setGvcnText(JTextField gvcnText) {
        this.gvcnText = gvcnText;
        return this;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public ClassView setAddButton(JButton addButton) {
        this.addButton = addButton;
        return this;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public ClassView setEditButton(JButton editButton) {
        this.editButton = editButton;
        return this;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public ClassView setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
        return this;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public ClassView setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
        return this;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }


    public List<Class> getClassList() {
        return classList;
    }

    public ClassView setClassList(List<Class> classList) {
        this.classList = classList;
        return this;
    }

    public JTable getClassTable() {
        return classTable;
    }

    public ClassView setClassTable(JTable classTable) {
        this.classTable = classTable;
        return this;
    }

    public JScrollPane getClassScrollPane() {
        return classScrollPane;
    }

    public ClassView setClassScrollPane(JScrollPane classScrollPane) {
        this.classScrollPane = classScrollPane;
        return this;
    }

    private String[] columnNames = new String[]{
            "Mã số lớp", "Tên lớp", "Giáo viên CN"};
    private Object[][] data = new Object[][]{};

    public ClassView() {
        initComponents();
    }

    private void initComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // tao phim button

        addButton = new JButton("Thêm");
        editButton = new JButton("Lưu");
        clearButton = new JButton("Huỷ");
        deleteButton = new JButton("Xoá");
        searchButton = new JButton("Tìm");

        // tao bang student
        Component table;
        classScrollPane = new JScrollPane();

        classTable = new JTable(){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };

        // tao cac label
        Font font = new Font("Courier", Font.BOLD,12);
        mslLabel = new JLabel("Mã số lớp:");
        mslLabel.setFont(font);
        nameLabel = new JLabel("Tên lớp:");
        nameLabel.setFont(font);
        gvcnLabel = new JLabel("Giáo viên CN:");
        gvcnLabel.setFont(font);
        Font fontAppLabel = new Font("Courier", Font.BOLD,20);
        appLabel = new JLabel("THÔNG TIN LỚP HỌC");
        appLabel.setFont(fontAppLabel);
        tableLabel = new JLabel("Danh sách lớp học");
        tableLabel.setFont(font);

        //tao truong nhap du lieu
        mslText = new JTextField();
        nameText = new JTextField();
        gvcnText = new JTextField();

        // cai dat cot va du lieu bang
        classTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        classScrollPane.setViewportView(classTable);
//        classScrollPane.setPreferredSize(new Dimension(500,300));

        // tao spring springLayout
        SpringLayout springLayout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(800, 600);
        panel.setLayout(springLayout);

        panel.add(classScrollPane);

        // add them button, components cho panel.
        panel.add(mslLabel);
        panel.add(mslText);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(gvcnLabel);
        panel.add(gvcnText);
        panel.add(appLabel);
        panel.add(tableLabel);

        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(searchButton);

        // cai dat vi tri cho cac component
//        springLayout.putConstraint(SpringLayout.NORTH, appLabel, 10, SpringLayout.WEST, panel);
//        springLayout.putConstraint(SpringLayout.WEST, appLabel, 100, SpringLayout.WEST, panel);
//        springLayout.putConstraint(SpringLayout.EAST, appLabel, 100, SpringLayout.EAST, panel);
        springLayout.putConstraint(SpringLayout.WEST, appLabel, 300, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, appLabel, 15, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.EAST, appLabel, -200, SpringLayout.EAST, panel);

//        springLayout.putConstraint(SpringLayout.WEST, mslLabel, 40, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.EAST, mslLabel, -20, SpringLayout.WEST, mslText);
        springLayout.putConstraint(SpringLayout.NORTH, mslLabel, 50, SpringLayout.NORTH, panel);
//        springLayout.putConstraint(SpringLayout.WEST, nameLabel, 40, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.EAST, nameLabel, -20, SpringLayout.WEST, nameText);
        springLayout.putConstraint(SpringLayout.NORTH, nameLabel, 80, SpringLayout.NORTH, panel);
//        springLayout.putConstraint(SpringLayout.WEST, gvcnLabel, 40, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.EAST, gvcnLabel, -20, SpringLayout.WEST, gvcnText);
        springLayout.putConstraint(SpringLayout.NORTH, gvcnLabel, 110, SpringLayout.NORTH, panel);


//        springLayout.putConstraint(SpringLayout.WEST, gpaLabel, 10, SpringLayout.WEST, panel);
//        springLayout.putConstraint(SpringLayout.NORTH, gpaLabel, 200, SpringLayout.NORTH, panel);

        springLayout.putConstraint(SpringLayout.WEST, mslText, 150, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, mslText, 50, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, nameText, 150, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, nameText, 80, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.WEST, gvcnText, 150, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, gvcnText, 110, SpringLayout.NORTH, panel);
//        springLayout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
//        springLayout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 100, SpringLayout.NORTH, panel);

        springLayout.putConstraint(SpringLayout.EAST, mslText, -50, SpringLayout.EAST, panel);
        springLayout.putConstraint(SpringLayout.EAST, nameText, -50, SpringLayout.EAST, panel);
        springLayout.putConstraint(SpringLayout.EAST, gvcnText, -50, SpringLayout.EAST, panel);

        springLayout.putConstraint(SpringLayout.SOUTH, tableLabel, -10, SpringLayout.NORTH, classScrollPane);
        springLayout.putConstraint(SpringLayout.WEST, tableLabel, 0, SpringLayout.WEST, classScrollPane);

        springLayout.putConstraint(SpringLayout.WEST, classScrollPane, 40, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, classScrollPane, 220, SpringLayout.NORTH, panel);
        springLayout.putConstraint(SpringLayout.EAST, classScrollPane, -50, SpringLayout.EAST, panel);

        springLayout.putConstraint(SpringLayout.WEST, addButton, 400, SpringLayout.WEST, panel);
        springLayout.putConstraint(SpringLayout.NORTH, addButton, 150, SpringLayout.NORTH, panel);
//        springLayout.putConstraint(SpringLayout.EAST, addButton, -55, SpringLayout.EAST, editButton);

        springLayout.putConstraint(SpringLayout.WEST, editButton, 65, SpringLayout.WEST, addButton);
        springLayout.putConstraint(SpringLayout.NORTH, editButton, 150, SpringLayout.NORTH, panel);
//        springLayout.putConstraint(SpringLayout.EAST, editButton, -65, SpringLayout.EAST, deleteButton);


        springLayout.putConstraint(SpringLayout.WEST, deleteButton, 55, SpringLayout.WEST, editButton);
        springLayout.putConstraint(SpringLayout.NORTH, deleteButton, 150, SpringLayout.WEST, panel);
//        springLayout.putConstraint(SpringLayout.EAST, deleteButton, -55, SpringLayout.EAST, clearButton);

        springLayout.putConstraint(SpringLayout.WEST, clearButton, 55, SpringLayout.WEST, deleteButton);
        springLayout.putConstraint(SpringLayout.NORTH, clearButton, 150, SpringLayout.NORTH, panel);
//        springLayout.putConstraint(SpringLayout.EAST, clearButton, -55, SpringLayout.EAST, searchButton);


        springLayout.putConstraint(SpringLayout.WEST, searchButton, 55, SpringLayout.WEST, clearButton);
        springLayout.putConstraint(SpringLayout.NORTH, searchButton, 150, SpringLayout.NORTH, panel);
//        springLayout.putConstraint(SpringLayout.EAST, searchButton, -50, SpringLayout.EAST, classScrollPane);




        // add vao jframe
        this.add(panel);
        this.pack();
        this.setTitle("THÔNG TIN LỚP HỌC");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);


        //disable edit and delete button
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);

        // enable add button
        addButton.setEnabled(true);
    }



    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void getAllClass(List<Class> classList){
        int size = classList.size();
//        Object[][] classese =new Object[size][Student.class.getDeclaredFields().length];
        Object[][] classese =new Object[size][3];

        for(int i=0; i<size; i++)
        {
            classese[i][0] = classList.get(i).getMsl();
            classese[i][1] = classList.get(i).getName();
            classese[i][2] = classList.get(i).getGvcn();

        }
        this.classList = classList;
        classTable.setModel(new DefaultTableModel(classese,columnNames));
    }

    public void findById(List<Class> classList){
        int size = classList.size();
//        Object[][] classese =new Object[size][Student.class.getDeclaredFields().length];
        Object[][] classese =new Object[size][3];

        for(int i=0; i<size; i++)
        {
            classese[i][0] = classList.get(i).getMsl();
            classese[i][1] = classList.get(i).getName();
            classese[i][2] = classList.get(i).getGvcn();

        }
        classTable.setModel(new DefaultTableModel(classese,columnNames));
    }

    public void fillClassFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = classTable.getSelectedRow();
        if (row >= 0) {
            mslText.setText(classTable.getModel().getValueAt(row, 0).toString());
            nameText.setText(classTable.getModel().getValueAt(row, 1).toString());
            gvcnText.setText(classTable.getModel().getValueAt(row, 2).toString());
            // enable Edit and Delete buttons
            editButton.setEnabled(true);
            deleteButton.setEnabled(true);
            // disable Add button
            addButton.setEnabled(false);
        }
    }

    public void clearClassInfo() {
        mslText.setText("");
        nameText.setText("");
        gvcnText.setText("");

        // disable Edit and Delete buttons
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        // enable Add button
        addButton.setEnabled(true);
    }

    public Class getClassInfo(){
        if(!validateMasl() || !validateName() || !validateGvcn() )
            return null;
        try {
            Class aClass = new Class();
            if (mslText.getText() != null && !"".equals(mslText.getText())) {
                aClass.setMsl(mslText.getText());
            }
            aClass.setName(nameText.getText().trim());
            aClass.setGvcn(gvcnText.getText().trim());
            return aClass;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    public Class getClassInfoSearch(){
        try {
            Class aClass = new Class();
            aClass.setMsl(mslText.getText().trim());
            aClass.setName(nameText.getText().trim());
            aClass.setGvcn(gvcnText.getText().trim());
            return aClass;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    private boolean validateName() {
        String name = nameText.getText();
        if (name == null || "".equals(name.trim())) {
            nameText.requestFocus();
            showMessage("Tên lớp không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateMasl() {
        String maSv = mslText.getText();
        if (maSv == null || "".equals(maSv.trim())) {
            mslText.requestFocus();
            showMessage("Mã số lớp không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateGvcn() {
        String gvcn = gvcnText.getText();
        if (gvcn == null || "".equals(gvcn.trim())) {
            gvcnText.requestFocus();
            showMessage("Tên giáo viên không được trống.");
            return false;
        }
        return true;
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    public void addClassListener(ActionListener listener){
        addButton.addActionListener(listener);
    }

    public void editClassListener(ActionListener listener){
        editButton.addActionListener(listener);
    }

    public void deleteClassListener(ActionListener listener){
        deleteButton.addActionListener(listener);
    }

    public void clearClassListener(ActionListener listener){
        clearButton.addActionListener(listener);
    }

    public void searchClassListener(ActionListener listener){
        searchButton.addActionListener(listener);
    }

    public  void chooseClassListener(MouseAdapter mouseAdapter){
        classTable.addMouseListener(mouseAdapter);
    }

}
