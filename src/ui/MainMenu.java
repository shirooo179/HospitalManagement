package ui;

import Service.AuthService;

import java.util.Scanner;

public class MainMenu {
    public static void show() {
        Scanner sc = new Scanner(System.in);
        while (AuthService.isLoggedIn()) {
            System.out.println("\n===== MENU CHÍNH =====");
            System.out.println("1. Quản lý bệnh nhân");
            System.out.println("2. Quản lý bác sĩ");
            System.out.println("3. Quản lý lịch hẹn");
            System.out.println("4. Đăng xuất");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> System.out.println("Quản lý bệnh nhân");
                case 2 -> System.out.println("Quản lý bác sĩ");
                case 3 -> System.out.println("Quản lý lịch hẹn");
                case 4 -> {
                    AuthService.dangXuat();
                    System.out.println("Đăng xuất thành công.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
