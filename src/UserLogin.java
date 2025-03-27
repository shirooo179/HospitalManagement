import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLogin {
    public boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Đăng nhập thành công! Chào mừng " + username);
                return true;
            } else {
                System.out.println("Tài khoản hoặc mật khẩu không chính xác.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Lỗi khi đăng nhập: " + e.getMessage());
            return false;
        }
    }
}
