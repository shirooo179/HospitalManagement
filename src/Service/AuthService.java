package Service;

import DAO.TaiKhoanDAO;
import Model.TaiKhoan;

public class AuthService {
    private static TaiKhoan currentUser;
    private static final TaiKhoanDAO dao = new TaiKhoanDAO();

    public static boolean dangNhap(String ten, String matKhau) {
        TaiKhoan tk = dao.timTheoTenDangNhap(ten);
        if (tk != null && tk.getMatKhau().equals(matKhau)) {
            currentUser = tk;
            return true;
        }
        return false;
    }

    public static boolean dangKy(String ten, String matKhau, String vaitro) {
        if (dao.timTheoTenDangNhap(ten) != null) return false;
        TaiKhoan tk = new TaiKhoan(ten, matKhau, vaitro);
        return dao.dangKy(tk);
    }

    public static void dangXuat() {
        currentUser = null;
    }

    public static TaiKhoan getCurrentUser() {
        return currentUser;
    }

    public static boolean isLoggedIn() {
        return currentUser != null;
    }
}
