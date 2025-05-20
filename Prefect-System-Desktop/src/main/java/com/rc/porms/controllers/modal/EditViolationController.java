package com.rc.porms.controllers.modal;

import com.rc.porms.EmployeeInfoMgtApplication;
import com.rc.porms.PrefectInfoMgtApplication;
import com.rc.porms.StudentInfoMgtApplication;
import com.rc.porms.appl.facade.employee.EmployeeFacade;
import com.rc.porms.appl.facade.prefect.offense.OffenseFacade;
import com.rc.porms.appl.facade.prefect.violation.ViolationFacade;
import com.rc.porms.appl.facade.student.StudentFacade;
import com.rc.porms.appl.model.employee.Employee;
import com.rc.porms.appl.model.offense.Offense;
import com.rc.porms.appl.model.student.Student;
import com.rc.porms.appl.model.violation.Violation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class EditViolationController{
    public Text error;
    public Text error1;
    public Text error2;
    public Text error3;
    public Text error4;

    public Text error5;
    public Text error6;


    @FXML
    private TextField studentIdField;
    @FXML
    private TextField studentNameField;
    @FXML
    private ComboBox offenseComboBox;
    @FXML
    private TextField warningNumField;
    @FXML
    private TextField csHoursField;
    @FXML
    private TextField disciplinaryField;
    @FXML
    private DatePicker dateField;
    @FXML
    private TextField employeeIdField;
    @FXML
    private TextField employeeNameField;

    private OffenseFacade offenseFacade;
    private ViolationFacade violationFacade;
    private Violation violation;
    private StudentFacade studentFacade;
    private EmployeeFacade employeeFacade;

    @FXML
    public void initialize() {
        PrefectInfoMgtApplication appl = new PrefectInfoMgtApplication();
        offenseFacade = appl.getOffenseFacade();

        List<Offense> offenses = offenseFacade.getAllOffense();

        List<String> offenseName = offenses.stream()
                .map(Offense::getDescription)
                .collect(Collectors.toList());

        offenseComboBox.getItems().addAll(offenseName);
    }

    @FXML
    protected void saveUpdateClicked(ActionEvent event) {

        LocalDate currentDate = LocalDate.now();
        LocalDate selectedDate = dateField.getValue();

        studentIdField.setStyle("");
        dateField.setStyle("");

        // Check if the violation date is in the future
        if (selectedDate != null && selectedDate.isAfter(currentDate)) {
            dateField.setStyle("-fx-border-color: red;");
            error4.setText("Invalid input: Violation date cannot be in the future.");
            error4.setFill(Color.RED);
            return;
        } else {
            error4.setText("");
        }

        // Check if required fields are filled
        if (studentIdField.getText().isEmpty() || employeeIdField.getText().isEmpty() || dateField.getValue() == null) {
            studentIdField.setStyle("-fx-border-color: red;");
            error.setText("Please fill in all required fields.");
            error.setFill(Color.RED);
            return;
        } else {
            error.setText("");
        }

        // Check if Warning Number and CS Hours are numeric
        if (!isNumeric(warningNumField.getText()) || !isNumeric(csHoursField.getText())) {
            error2.setText("Warning Number and CS Hours must be numeric.");
            error2.setFill(Color.RED);
            return;
        } else {
            error2.setText("");
        }

        // Check if disciplinary field is empty
        if (disciplinaryField.getText().isEmpty()) {
            error3.setText("Please fill the text.");
            error3.setFill(Color.RED);
            return;
        } else {
            error3.setText("");
        }

        // Check if disciplinary field exceeds 32 characters
        if (disciplinaryField.getText().length() > 32) {
            error5.setText("Character limit is 32 characters only.");
            error5.setFill(Color.RED);
            return;
        } else {
            error5.setText(" ");
        }

        // Check if disciplinary field contains only alphanumeric characters
        if (!disciplinaryField.getText().matches("[a-zA-Z0-9]+")) {
            error6.setText("Alphanumeric characters only.");
            error6.setFill(Color.RED);
            return;
        } else {
            error6.setText(" ");
        }


        PrefectInfoMgtApplication app = new PrefectInfoMgtApplication();
        violationFacade = app.getViolationFacade();

        offenseFacade = app.getOffenseFacade();
        String selectedOffense = (String) offenseComboBox.getValue();
        Offense offense = offenseFacade.getOffenseByName(selectedOffense);

        StudentInfoMgtApplication appl = new StudentInfoMgtApplication();
        studentFacade = appl.getStudentFacade();
        Student student = studentFacade.getStudentByNumber(studentIdField.getText());


        EmployeeInfoMgtApplication ap = new EmployeeInfoMgtApplication();
        employeeFacade = ap.getEmployeeFacade();
        Employee employee = employeeFacade.getEmployeeById(employeeIdField.getText());

        Violation editViolation = new Violation();
        editViolation.setId(violation.getId());
        editViolation.setStudent(student);
        editViolation.setOffense(offense);
        editViolation.setApprovedBy(employee);



        LocalDateTime localDateTime = LocalDateTime.now();
        editViolation.setDateOfNotice(Timestamp.valueOf(localDateTime));


        editViolation.setWarningNum(Integer.parseInt(warningNumField.getText()));
        editViolation.setCommServHours(Integer.parseInt(csHoursField.getText()));
        editViolation.setDisciplinaryAction(disciplinaryField.getText());

        try {
            violationFacade.updateViolation(editViolation);
            showAlert(Alert.AlertType.INFORMATION, "Success", "Violation updated successfully.");
        } catch (Exception ex) {
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred while updating the violation.");

            //after save, go back to offense list
            try {
                Stage previousStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                previousStage.close();

                Stage dashboardStage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/views/ViolationList.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                dashboardStage.setScene(scene);

                dashboardStage.initStyle(StageStyle.UNDECORATED);

                dashboardStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    public void setViolation(Violation violation) {
        this.violation = violation;
        violation.getId();
        studentIdField.setText(violation.getStudent().getStudentId());
        offenseComboBox.setValue(violation.getOffense().getDescription());

        //date picker format setter
        Timestamp offenseTimestamp = violation.getDateOfNotice();
        LocalDate offenseLocalDate = offenseTimestamp.toLocalDateTime().toLocalDate();
        dateField.setValue(offenseLocalDate);

        warningNumField.setText(String.valueOf(violation.getWarningNum()));
        csHoursField.setText(String.valueOf(violation.getCommServHours()));
        disciplinaryField.setText(violation.getDisciplinaryAction());
        employeeIdField.setText(violation.getApprovedBy().getEmployeeNo());
    }

    @FXML
    protected void handleCancelEditViolation(MouseEvent event) {
        try {
            Stage previousStage4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            previousStage4.close();

            Stage dashboardStage4 = new Stage();
            FXMLLoader loader4 = new FXMLLoader();
            loader4.setLocation(getClass().getResource("/views/ViolationList.fxml"));
            Parent root4 = loader4.load();
            Scene scene4 = new Scene(root4);
            dashboardStage4.setScene(scene4);
            dashboardStage4.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void handleStudentIdChanged(KeyEvent event) {

        if(!studentIdField.getText().isEmpty()){
            StudentInfoMgtApplication appl = new StudentInfoMgtApplication();
            studentFacade = appl.getStudentFacade();
            Student student = studentFacade.getStudentByNumber(studentIdField.getText());
            if (student != null) {
                String fullName = student.getLastName() + ", " + student.getFirstName() + " " + student.getMiddleName();
                studentNameField.setText(fullName);
            } else {
                studentNameField.clear();
            }
        }
    }

    @FXML
    protected void handleEmployeeIdChanged(KeyEvent event) {

        if(!employeeIdField.getText().isEmpty()){
            EmployeeInfoMgtApplication appl = new EmployeeInfoMgtApplication();
            employeeFacade = appl.getEmployeeFacade();
            Employee employee = employeeFacade.getEmployeeById(employeeIdField.getText());
            if (employee != null) {
                String fullName = employee.getLastName() + ", " + employee.getFirstName() + " " + employee.getMiddleName();
                employeeNameField.setText(fullName);
            } else {
                employeeNameField.clear();
            }
        }
    }
    private boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}