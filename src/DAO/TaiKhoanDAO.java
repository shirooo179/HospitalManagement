package DAO;

import Model.TaiKhoan;
import utils.DatabaseUtil;

import java.sql.*;

public class TaiKhoanDAO {

    public TaiKhoan timTheoTenDangNhap(String tenNguoiDung) {
        String sql = "SELECT * FROM taikhoan WHERE tenDangNhap = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tenNguoiDung);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setId(rs.getInt("id"));
                tk.setTenNguoiDung(rs.getString("tenDangNhap"));
                tk.setMatKhau(rs.getString("matkhau"));
                tk.setVaiTro(rs.getString("vaitro"));
                return tk;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean dangKy(TaiKhoan tk) {
        String sql = "INSERT INTO taikhoan (tenDangNhap, matkhau, vaitro) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tk.getTenNguoiDung());
            stmt.setString(2, tk.getMatKhau());
            stmt.setString(3, tk.getVaiTro());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
