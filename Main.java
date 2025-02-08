
import java.util.ArrayList;
import java.util.Scanner;

// Lớp Contact để lưu thông tin liên hệ
class Contact {
    private String name;
    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone;
    }
}

// Lớp ContactManager để quản lý danh bạ
class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phone) {
        contacts.add(new Contact(name, phone));
        System.out.println("✅ Đã thêm liên hệ thành công!");
    }

    public void removeContact(String name) {
        contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(name));
        System.out.println("✅ Đã xóa liên hệ (nếu tồn tại)!");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("📭 Danh bạ trống.");
        } else {
            System.out.println("📞 Danh bạ của bạn:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }
}

// Lớp chính chứa menu điều khiển
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {
            System.out.println("\n📱 QUẢN LÝ DANH BẠ 📱");
            System.out.println("1. Thêm liên hệ");
            System.out.println("2. Xóa liên hệ");
            System.out.println("3. Hiển thị danh bạ");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phone = scanner.nextLine();
                    manager.addContact(name, phone);
                    break;
                case 2:
                    System.out.print("Nhập tên cần xóa: ");
                    String removeName = scanner.nextLine();
                    manager.removeContact(removeName);
                    break;
                case 3:
                    manager.displayContacts();
                    break;
                case 4:
                    System.out.println("👋 Thoát chương trình...");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️ Lựa chọn không hợp lệ! Vui lòng thử lại.");
            }
        }
    }
}
