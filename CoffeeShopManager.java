package BaiTapLession12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeShopManager {
        private static List<Drink> menu = new ArrayList<>();
        private static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            while (true) {
                System.out.println("\n--- HỆ THỐNG QUẢN LÝ QUÁN CÀ PHÊ ---");
                System.out.println("1. Thêm món vào Menu");
                System.out.println("2. Hiển thị Menu");
                System.out.println("3. Áp dụng mã giảm giá (%)");
                System.out.println("4. Xóa món");
                System.out.println("5. Thống kê giá trung bình");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1 -> addDrink();
                    case 2 -> showMenu();
                    case 3 -> applyDiscount();
                    case 4 -> deleteDrink();
                    case 5 -> showAveragePrice();
                    case 0 -> System.exit(0);
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        }

        private static void addDrink() {
            System.out.print("Nhập loại (1. Cafe, 2. Trà): ");
            int type = Integer.parseInt(sc.nextLine());
            System.out.print("ID: "); String id = sc.nextLine();
            System.out.print("Tên món: "); String name = sc.nextLine();
            System.out.print("Giá: "); double price = Double.parseDouble(sc.nextLine());

            if (type == 1) menu.add(new Coffee(id, name, price));
            else menu.add(new FruitTea(id, name, price));
            System.out.println("Thêm thành công!");
        }

        private static void showMenu() {
            System.out.println("\n--- MENU ĐỒ UỐNG ---");
            for (Drink d : menu) {
                System.out.println(d);
                d.prepare();
            }
        }

        private static void applyDiscount() {
            System.out.print("Nhập % giảm giá: ");
            double pct = Double.parseDouble(sc.nextLine());
            for (Drink d : menu) {
                d.applyDiscount(pct);
            }
            System.out.println("Đã áp dụng giảm giá cho toàn bộ menu!");
        }

        private static void deleteDrink() {
            System.out.print("Nhập ID món cần xóa: ");
            String id = sc.nextLine();
            boolean removed = menu.removeIf(d -> d.getId().equalsIgnoreCase(id));
            if (removed) System.out.println("Đã xóa thành công.");
            else System.out.println("Không tìm thấy ID.");
        }

        private static void showAveragePrice() {
            if (menu.isEmpty()) {
                System.out.println("Menu trống!");
                return;
            }
            double total = menu.stream().mapToDouble(Drink::getPrice).sum();
            System.out.printf("Giá trung bình: %,.0f VNĐ\n", total / menu.size());
        }
    }

