package BaiTapLession12;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            AssetManager manager = new AssetManager();

            while (true) {
                System.out.println("\n===== QUẢN LÝ TÀI SẢN =====");
                System.out.println("1. Nhập tài sản");
                System.out.println("2. Xuất báo cáo");
                System.out.println("3. Tìm kiếm");
                System.out.println("4. Sửa giá mua");
                System.out.println("5. Thoát");
                System.out.print("Chọn: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("1. Máy tính");
                        System.out.println("2. Thiết bị mạng");
                        int type = Integer.parseInt(sc.nextLine());

                        System.out.print("Mã tài sản: ");
                        String code = sc.nextLine();
                        System.out.print("Tên: ");
                        String name = sc.nextLine();
                        System.out.print("Giá mua: ");
                        double price = Double.parseDouble(sc.nextLine());

                        if (type == 1) {
                            System.out.print("RAM (GB): ");
                            int ram = Integer.parseInt(sc.nextLine());
                            System.out.print("CPU: ");
                            String cpu = sc.nextLine();
                            manager.addAsset(
                                    new Computer(code, name, price, ram, cpu)
                            );
                        } else {
                            System.out.print("Số cổng: ");
                            int ports = Integer.parseInt(sc.nextLine());
                            manager.addAsset(
                                    new NetworkDevice(code, name, price, ports)
                            );
                        }
                        break;

                    case 2:
                        manager.showAll();
                        break;

                    case 3:
                        System.out.println("1. Tìm theo mã");
                        System.out.println("2. Tìm theo giá lớn hơn");
                        int opt = Integer.parseInt(sc.nextLine());

                        if (opt == 1) {
                            System.out.print("Nhập mã: ");
                            Asset a = manager.searchAsset(sc.nextLine());
                            if (a != null) {
                                System.out.println(a);
                            } else {
                                System.out.println("Không tìm thấy!");
                            }
                        } else {
                            System.out.print("Nhập giá: ");
                            manager.searchAsset(Double.parseDouble(sc.nextLine()));
                        }
                        break;

                    case 4:
                        System.out.print("Nhập mã cần sửa: ");
                        Asset edit = manager.searchAsset(sc.nextLine());
                        if (edit != null) {
                            System.out.print("Giá mới: ");
                            edit.setPurchasePrice(
                                    Double.parseDouble(sc.nextLine())
                            );
                            System.out.println("Cập nhật thành công!");
                        } else {
                            System.out.println("Không tìm thấy tài sản!");
                        }
                        break;

                    case 5:
                        System.out.println("Thoát chương trình!");
                        return;
                    default:
                        System.out.println("Lựa chọn ko hợp lệ! ");
                }
            }
        }
    }

