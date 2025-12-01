import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HoaDon {
    private String maHD;
    private Date ngayLap;
    private DatPhong datPhong;
    private List<LichSuDungDV> lichSuDungDVs = new ArrayList<>();
    private ThanhToan thanhToan;
    private double tongTien;
    private boolean daThanhToan; // Thêm trạng thái thanh toán

    public HoaDon() {
        this.daThanhToan = false;
    }

    public HoaDon(String maHD, Date ngayLap, DatPhong datPhong) {
        this.maHD = maHD;
        this.ngayLap = ngayLap;
        this.datPhong = datPhong;
        this.daThanhToan = false;
        this.tongTien = 0.0;
    }

    // Getter/Setter
    public String getMaHD() { 
        return maHD; 
    }
    public void setMaHD(String maHD) { 
        this.maHD = maHD; 
    }

    public Date getNgayLap() {
        return ngayLap;
    }
    public void setNgayLap(Date ngayLap) { 
        this.ngayLap = ngayLap; 
    }

    public DatPhong getDatPhong() {
        return datPhong; 
    }
    public void setDatPhong(DatPhong datPhong) { 
        this.datPhong = datPhong; 
    }

    public List<LichSuDungDV> getLichSuDungDVs() {
        return lichSuDungDVs; 
    }
    
    public void addLichSuDungDV(LichSuDungDV lsdv) {
        if (lsdv != null) {
            lichSuDungDVs.add(lsdv);
            tinhTongTien(); // Cập nhật lại tổng tiền khi thêm DV
        }
    }

    public ThanhToan getThanhToan() {
        return thanhToan; 
    }
    
    public void setThanhToan(ThanhToan thanhToan) { 
        this.thanhToan = thanhToan;
        // Khi set thanh toán, chưa có nghĩa là đã thanh toán xong
        this.daThanhToan = false;
    }

    public double getTongTien() {
        return tongTien;
    }

    public boolean isDaThanhToan() {
        return daThanhToan;
    }

    /**
     * Tính tổng tiền hóa đơn
     * @return tổng tiền
     */
    public double tinhTongTien() {
        double tienPhong = 0.0;
        if (datPhong != null) {
            tienPhong = datPhong.tinhTienPhong();
        }
        
        double tienDV = 0.0;
        for (LichSuDungDV l : lichSuDungDVs) {
            tienDV += l.tinhTien();
        }
        
        this.tongTien = tienPhong + tienDV;
        return this.tongTien;
    }

    /**
     * Thực hiện thanh toán hóa đơn
     * @return true nếu thanh toán thành công
     */
    public boolean thanhToan() {
        if (thanhToan == null) {
            System.out.println("Hoa don " + maHD + " chua co phuong thuc thanh toan!");
            return false;
        }
        
        // Tính tổng tiền trước khi thanh toán
        double soTienCanThanhToan = tinhTongTien();
        
        if (soTienCanThanhToan <= 0) {
            System.out.println("Hoa don " + maHD + " khong co tien de thanh toan!");
            return false;
        }
        
        // Kiểm tra thanh toán
        boolean ketQua = thanhToan.xacNhanThanhToan(soTienCanThanhToan);
        this.daThanhToan = ketQua;
        
        if (ketQua) {
            System.out.println("Hoa don " + maHD + " thanh toan thanh cong!");
        } else {
            System.out.println("Hoa don " + maHD + " thanh toan that bai!");
            System.out.println("So tien can: " + soTienCanThanhToan);
            System.out.println("So tien co: " + thanhToan.soTienThanhToan());
        }
        
        return ketQua;
    }

    /**
     * In thông tin hóa đơn
     */
    public void inHoaDon() {
        System.out.println("\n=== Ma hoa don " + maHD + " ===");
        System.out.println("Ngay lap: " + ngayLap);
        
        if (datPhong != null) {
            datPhong.xuatThongTin();
        } else {
            System.out.println("Khong co thong tin dat phong!");
        }
        
        // In dịch vụ
        if (!lichSuDungDVs.isEmpty()) {
            System.out.println("--- Dich vu ---");
            for (LichSuDungDV l : lichSuDungDVs) {
                l.xuatThongTin();
            }
        } else {
            System.out.println("--- Khong co dich vu nao ---");
        }
        
        // Tính và hiển thị tổng tiền
        double tong = tinhTongTien();
        System.out.println("Tong tien: " + tong);
        
        // Thông tin thanh toán
        if (thanhToan != null) {
            System.out.println("Thanh toan bang: " + thanhToan.getHinhThucThanhToan());
            System.out.println("Trang thai thanh toan: " + (daThanhToan ? "Da thanh toan" : "Chua thanh toan"));
            
            if (daThanhToan) {
                System.out.println("Xac nhan thanh toan: Thanh cong");
            } else {
                // Kiểm tra xem có đủ tiền không
                boolean coTheThanhToan = thanhToan.xacNhanThanhToan(tong);
                System.out.println("Xac nhan thanh toan: " + (coTheThanhToan ? "Co the thanh toan" : "Khong du tien"));
            }
            
            // In chi tiết thanh toán
            if (thanhToan instanceof ThanhToanTienMat) {
                ((ThanhToanTienMat) thanhToan).xuatThongTin();
            } else if (thanhToan instanceof ThanhToanThe) {
                ((ThanhToanThe) thanhToan).xuatThongTin();
            }
        } else {
            System.out.println("Chua co thong tin thanh toan.");
            System.out.println("Trang thai thanh toan: Chua thanh toan");
        }
        
        System.out.println("========================");
    }

    /**
     * In hóa đơn ngắn gọn (dùng cho danh sách)
     */
    public void inHoaDonTomTat() {
        System.out.println("HD: " + maHD + 
                          " | Ngay: " + ngayLap + 
                          " | Tong: " + tinhTongTien() + 
                          " | TT: " + (daThanhToan ? "Da TT" : "Chua TT") +
                          " | PT: " + (thanhToan != null ? thanhToan.getHinhThucThanhToan() : "Chua co"));
    }
}
