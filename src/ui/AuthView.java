package ui;

import Service.AuthService;

import java.util.Scanner;

public class AuthView {
    private static final Scanner sc = new Scanner(System.in);

    public static void show() {
        while (true) {
            System.out.println("\n--- HỆ THỐNG QUẢN LÝ BỆNH VIỆN ---");
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> dangKy();
                case 2 -> {
                    if (dangNhap()) {
                        MainMenu.show(); // Hiển thị menu chính sau khi login
                    }
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void dangKy() {
        System.out.print("Tên người dùng: ");
        String ten = sc.nextLine();
        System.out.print("Mật khẩu: ");
        String mk = sc.nextLine();
        System.out.print("Vai trò: ");
        String vaitro = sc.nextLine();
        if (AuthService.dangKy(ten, mk, vaitro)) {
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Tên đã tồn tại hoặc lỗi hệ thống.");
        }
    }

    private static boolean dangNhap() {
        System.out.print("Tên người dùng: ");
        String ten = sc.nextLine();
        System.out.print("Mật khẩu: ");
        String mk = sc.nextLine();
        if (AuthService.dangNhap(ten, mk)) {
            System.out.println("Đăng nhập thành công!");
            return true;
        } else {
            System.out.println("Sai thông tin đăng nhập!");
            return false;
        }
    }
}
