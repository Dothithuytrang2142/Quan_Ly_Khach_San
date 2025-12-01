import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            // 1. Tao quan ly khach san
            QuanLyKhachSan ql = new QuanLyKhachSan();

            // 2. Them phong
            Phong phong1 = new Phong("101", "Phong don", 300000);
            Phong phong2 = new Phong("102", "Phong doi", 500000);
            ql.themPhong(phong1);
            ql.themPhong(phong2);

            // 3. Them nhan vien
            NhanVien nv1 = new NhanVien("NV01", "Tran Thi Lan", "Le tan", 7000000, 
                                        "Ha Noi", "nv1@hotel.com", "Nu");
            ql.themNhanVien(nv1);

            // 4. Them khach hang
            KhachHang kh1 = new KhachHang("KH01", "Dinh Bao Khang", "123456789", 
                                          "Viet Nam", "Vip", "HN", "a@g.com", "Nam");
            ql.themKhachHang(kh1);

            // 5. Tao dat phong 1
            Date ngayNhan1 = sdf.parse("01/12/2025 14:30");
            Date ngayTra1 = sdf.parse("05/12/2025 11:00");
            DatPhong dp1 = new DatPhong("DP01", ngayNhan1, ngayTra1, 2, phong2);
            ql.themDatPhong(dp1);

            // 6. Tao dat phong 2 (CHO HD02) - FIX: Tao dat phong moi
            Date ngayNhan2 = sdf.parse("06/12/2025 12:00");
            Date ngayTra2 = sdf.parse("07/12/2025 10:00");
            DatPhong dp2 = new DatPhong("DP02", ngayNhan2, ngayTra2, 1, phong1); // Dung phong1
            ql.themDatPhong(dp2);

            // 7. Tao dich vu & lich su dich vu
            DichVu dv1 = new DichVu("DV01", "An toi", 80000);
            DichVu dv2 = new DichVu("DV02", "Giat ui", 50000);

            LichSuDungDV l1 = new LichSuDungDV("LSDV01", dv1, 2, "02/12/2025");
            LichSuDungDV l2 = new LichSuDungDV("LSDV02", dv2, 1, "03/12/2025");

            // 8. Tao hoa don 1
            HoaDon hd1 = new HoaDon("HD01", new Date(), dp1);
            hd1.addLichSuDungDV(l1);
            hd1.addLichSuDungDV(l2);

            // 9. Thanh toan hoa don 1
            double tongTienHD1 = hd1.tinhTongTien();
            ThanhToanTienMat ttTienMat = new ThanhToanTienMat("GD01", new Date(), tongTienHD1);
            hd1.setThanhToan(ttTienMat);
            
            boolean thanhCong = hd1.thanhToan();
            System.out.println("Thanh toan HD01: " + (thanhCong ? "Thanh Cong" : "That Bai"));

            // 10. Them hoa don vao quan li
            ql.themHoaDon(hd1);

            // 11. In ra de kiem tra
            System.out.println("\n--- Danh sach phong ---");
            ql.xuatTatCaPhong();

            System.out.println("\n--- Danh sach khach hang & nhan vien ---");
            for (KhachHang k : ql.getDsKhachHang()) k.xuatThongTin();
            for (NhanVien n : ql.getDsNhanVien()) n.xuatThongTin();

            System.out.println("\n--- Danh sach dat phong ---");
            for (DatPhong d : ql.getDsDatPhong()) d.xuatThongTin();

            System.out.println("\n--- In hoa don va kiem tra thanh toan ---");
            ql.xuatTatCaHoaDon();

            // 12. Tao 1 hoa don thanh toan bang the (that bai neu du nho)
            HoaDon hd2 = new HoaDon("HD02", new Date(), dp2); // Dung dp2
            hd2.addLichSuDungDV(l1);
            
            double tongTienHD2 = hd2.tinhTongTien();
            System.out.println("\nTong tien HD02: " + tongTienHD2);
            
            ThanhToanThe ttThe = new ThanhToanThe("GD02", new Date(), "1234-5678-9012", "999", 100000.0);
            hd2.setThanhToan(ttThe);
            
            boolean thanhCongHD2 = hd2.thanhToan();
            System.out.println("Thanh toan HD02: " + (thanhCongHD2 ? "Thanh Cong" : "That Bai"));
            
            ql.themHoaDon(hd2);

            System.out.println("\n--- In tat ca hoa don (co HD02 thanh toan bang the) ---");
            ql.xuatTatCaHoaDon();

            System.out.println("\n=== Ket thuc ===");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
