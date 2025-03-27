import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegistration {
    public boolean registerUser(String username, String password) {
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) { // Lỗi trùng lặp tài khoản
                System.out.println("Tài khoản đã tồn tại!");
            } else {
                System.out.println("Lỗi khi đăng ký: " + e.getMessage());
            }
            return false;
        }
    }
}
