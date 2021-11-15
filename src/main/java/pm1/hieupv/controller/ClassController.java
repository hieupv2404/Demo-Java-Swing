package pm1.hieupv.controller;

import pm1.hieupv.model.Class;
import pm1.hieupv.service.impl.ClassServiceImpl;
import pm1.hieupv.view.ClassView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class ClassController {
    private ClassServiceImpl classServiceImpl;
    private ClassView classView;

    public ClassController(ClassView classView) throws SQLException {
        this.classServiceImpl = new ClassServiceImpl();
        this.classView = classView;

        // add event cho view
        classView.addClassListener(new AddClassListener());
        classView.clearClassListener(new ClearClassListener());
        classView.editClassListener(new EditClassListener());
        classView.deleteClassListener(new DeleteClassListener());
        classView.searchClassListener(new SearchClassListener());
        classView.chooseClassListener(new ChooseClassListener());
    }
    public void showClassView() {
        List<Class> classList = null;
        try {
            classList = classServiceImpl.findAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        classView.setVisible(true);
        classView.getAllClass(classList);
    }

    public void selectClass() throws SQLException {
        int index = classView.getClassTable().getSelectedRow();
        List<Class> classList = classServiceImpl.selectClass(index);
        classView.setVisible(true);
    }

    class AddClassListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Class aClass = classView.getClassInfo();
            if(aClass !=null)
            {
                try {
                    if(!classServiceImpl.save(aClass))
                        classView.showMessage("Thêm thành công!");
                    else
                        classView.showMessage("Thêm không thành công vì trùng mã lớp!");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                classView.getAllClass(classServiceImpl.findAll());
                classView.getMslText().setEditable(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class ClearClassListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            classView.clearClassInfo();
            try {
                classView.getAllClass(classServiceImpl.findAll());
                classView.getMslText().setEditable(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class EditClassListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Class aClass = classView.getClassInfo();
            if(aClass !=null)
            {
                try {
                    if(!classServiceImpl.update(aClass))
                    {
                        classView.showMessage("Sửa thành công!");
                    }
                    else{
                        classView.showMessage("Sửa không thành công do không tồn tại mã lớp học!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                classView.getAllClass(classServiceImpl.findAll());
                classView.getMslText().setEditable(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class DeleteClassListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Class aClass = classView.getClassInfo();
            if(aClass !=null)
            {
                try {
                    if (!classServiceImpl.delete(aClass))
                    {
                        classView.showMessage("Xoá thành công!");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            try {
                classView.clearClassInfo();
                classView.getAllClass(classServiceImpl.findAll());
                classView.getMslText().setEditable(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class SearchClassListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Class aClass = classView.getClassInfoSearch();
            if (aClass != null)
            {
                try {
                    classView.getAllClass(classServiceImpl.findByProperty(aClass));
                    classView.getMslText().setEditable(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    class ChooseClassListener extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            int index = classView.getClassTable().getSelectedRow();
            Class aClass = classView.getClassList().get(index);
            classView.getMslText().setText(String.valueOf(aClass.getMsl()));
            classView.getNameText().setText(aClass.getName());
            classView.getGvcnText().setText(aClass.getGvcn());
            classView.getMslText().setEditable(false);


            classView.getAddButton().setEnabled(false);
            classView.getEditButton().setEnabled(true);
            classView.getDeleteButton().setEnabled(true);
            classView.getClearButton().setEnabled(true);
        }
    }

 }



