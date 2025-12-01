
import java.util.Date;

public class ThanhToanTienMat extends ThanhToan {
    private double tienThu;

    public ThanhToanTienMat() { 
        this.hinhThucThanhToan = "TienMat"; 
    }

    public ThanhToanTienMat(String maGiaoDich, Date ngayThanhToan, double tienThu) {
        super(maGiaoDich, ngayThanhToan, "TienMat");
        this.tienThu = tienThu;
    }

    public double getTienThu() { return tienThu; }
    public void setTienThu(double tienThu) { this.tienThu = tienThu; }

    @Override
    public boolean xacNhanThanhToan(double soTien) {
        // Tiền thu >= số tiền cần thanh toán => thành công
        return tienThu >= soTien;
    }

    @Override
    public double soTienThanhToan() {
        return tienThu;
    }

    // SỬA: Implement hoặc xóa phương thức abstract
    @Override
    public void readData() {
        // Implement nếu cần đọc từ file
    }

    @Override
    public void writeData() {
        // Implement nếu cần ghi vào file
    }
    
    public void xuatThongTin() {
        System.out.println("Thanh toan tien mat - Ma GD: " + maGiaoDich 
            + " | Tien thu: " + tienThu 
            + " | Ngay: " + ngayThanhToan);
    }
}