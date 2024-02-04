package Main;
import javax.swing.*;

public class validation {

    public boolean isValidName(String name) {
        return name.isEmpty() || !name.matches("^[A-Za-z]+(?:[\\s'-][A-Za-z]+)*$");
    }

    public boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$");
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^(010|012|011|015)\\d{8}$");
    }

    public void showErrorMessage(Frame frame, String fieldName) {    // method to show error message when I add invalid name or email or number
        JOptionPane.showMessageDialog(frame, "Invalid "+fieldName, "Validation Error", 0);
    }

}
