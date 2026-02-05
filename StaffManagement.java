package BaiTapLession12;

import java.util.ArrayList;
import java.util.Scanner;

public class StaffManagement {
        static ArrayList<Staff> staffList = new ArrayList<>();
        static Scanner sc = new Scanner(System.in);
        static int autoId = 1;

        public static void main(String[] args) {
            while (true) {
                System.out.println("\n===== STAFF MANAGEMENT =====");
                System.out.println("1. Thêm mới nhân viên");
                System.out.println("2. Hiển thị danh sách");
                System.out.println("3. Cập nhật theo ID");
                System.out.println("4. Xóa theo ID");
                System.out.println("5. Thoát");
                System.out.print("Chọn: ");

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addStaff();
                        break;
                    case 2:
                        displayStaff();
                        break;
                    case 3:
                        updateStaff();
                        break;
                    case 4:
                        deleteStaff();
                        break;
                    case 5:
                        System.out.println("Thoát chương trình!");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        }

        static void addStaff() {
            System.out.println("1. Giảng viên");
            System.out.println("2. Nhân viên hành chính");
            System.out.print("Chọn loại: ");
            int type = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập tên: ");
            String name = sc.nextLine();

            System.out.print("Nhập lương cơ bản: ");
            double baseSalary = Double.parseDouble(sc.nextLine());

            if (type == 1) {
                System.out.print("Nhập số giờ giảng: ");
                int hours = Integer.parseInt(sc.nextLine());
                staffList.add(new Lecturer(autoId++, name, baseSalary, hours));
            } else if (type == 2) {
                System.out.print("Nhập thưởng: ");
                double bonus = Double.parseDouble(sc.nextLine());
                staffList.add(new AdminStaff(autoId++, name, baseSalary, bonus));
            } else {
                System.out.println("Loại không hợp lệ!");
            }
        }

        static void displayStaff() {
            if (staffList.isEmpty()) {
                System.out.println(" Danh sách trống!");
                return;
            }

            for (Staff s : staffList) {
                System.out.println(s);
                if (s instanceof ICapability) {
                    ((ICapability) s).checkPerformance();
                }
                System.out.println("---------------------");
            }
        }

        static void updateStaff() {
            System.out.print("Nhập ID cần sửa: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Staff s : staffList) {
                if (s.getId() == id) {
                    System.out.print("Tên mới: ");
                    s.setName(sc.nextLine());

                    System.out.print("Lương cơ bản mới: ");
                    s.setBaseSalary(Double.parseDouble(sc.nextLine()));

                    if (s instanceof Lecturer) {
                        System.out.print("Giờ giảng mới: ");
                        ((Lecturer) s).setTeachingHours(Integer.parseInt(sc.nextLine()));
                    } else if (s instanceof AdminStaff) {
                        System.out.print("Thưởng mới: ");
                        ((AdminStaff) s).setBonus(Double.parseDouble(sc.nextLine()));
                    }

                    System.out.println("Cập nhật thành công!");
                    return;
                }
            }
            System.out.println("Không tìm thấy ID!");
        }

        static void deleteStaff() {
            System.out.print("Nhập ID cần xóa: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Staff s : staffList) {
                if (s.getId() == id) {
                    staffList.remove(s);
                    System.out.println("Đã xóa!");
                    return;
                }
            }
            System.out.println("Không tìm thấy ID!");

            }
        }
    


