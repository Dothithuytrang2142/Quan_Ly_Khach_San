import java.util.Date;

public class ThanhToanThe extends ThanhToan {
    private String soThe;
    private String maXacThuc;
    private double soTienTrenThe; // giả định số dư thẻ

    public ThanhToanThe() { this.hinhThucThanhToan = "The"; }

    public ThanhToanThe(String maGiaoDich, Date ngayThanhToan, String soThe, String maXacThuc, double soTienTrenThe) {
        super(maGiaoDich, ngayThanhToan, "The");
        this.soThe = soThe;
        this.maXacThuc = maXacThuc;
        this.soTienTrenThe = soTienTrenThe;
    }

    public String getSoThe() { return soThe; }
    public void setSoThe(String soThe) { this.soThe = soThe; }

    public String getMaXacThuc() { return maXacThuc; }
    public void setMaXacThuc(String maXacThuc) { this.maXacThuc = maXacThuc; }

    public double getSoTienTrenThe() { return soTienTrenThe; }
    public void setSoTienTrenThe(double soTienTrenThe) { this.soTienTrenThe = soTienTrenThe; }

    @Override
    public boolean xacNhanThanhToan(double soTien) {
        // đơn giản: check số dư
        return soTienTrenThe >= soTien;
    }

    @Override
    public double soTienThanhToan() {
        return soTienTrenThe;
    }

    @Override
    public void readData();

    @Override
    public void writeData();

    public void xuatThongTin() {
        System.out.println("Thanh toan the - Ma GD: " + maGiaoDich + " | So the: " + soThe + " | So du: " + soTienTrenThe + " | Ngay: " + ngayThanhToan);
    }
}
