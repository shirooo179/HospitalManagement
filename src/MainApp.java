import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserRegistration userReg = new UserRegistration();
        UserLogin userLogin = new UserLogin();

        while (true) {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ NGƯỜI DÙNG ---");
            System.out.println("1. Đăng ký tài khoản");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Xử lý ký tự xuống dòng

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên đăng nhập: ");
                    String regUsername = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    String regPassword = scanner.nextLine();

                    if (userReg.registerUser(regUsername, regPassword)) {
                        System.out.println("Đăng ký thành công!");
                    } else {
                        System.out.println("Đăng ký thất bại. Vui lòng thử lại.");
                    }
                    break;

                case 2:
                    System.out.print("Nhập tên đăng nhập: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    String loginPassword = scanner.nextLine();

                    userLogin.loginUser(loginUsername, loginPassword);
                    break;

                case 3:
                    System.out.println("Đã thoát khỏi hệ thống.");
                    System.exit(0);

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
            }
        }
    }
}
