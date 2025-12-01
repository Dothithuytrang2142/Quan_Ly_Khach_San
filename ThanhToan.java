import java.util.Date;

public abstract class ThanhToan implements IThanhToan {
    protected String maGiaoDich;
    protected Date ngayThanhToan;
    protected String hinhThucThanhToan; // "TienMat" / "The"

    public ThanhToan() {}

    public ThanhToan(String maGiaoDich, Date ngayThanhToan, String hinhThucThanhToan) {
        this.maGiaoDich = maGiaoDich;
        this.ngayThanhToan = ngayThanhToan;
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getMaGiaoDich() {
         return maGiaoDich; 
        }
    public void setMaGiaoDich(String maGiaoDich) {
         this.maGiaoDich = maGiaoDich; 
        }

    public Date getNgayThanhToan() {
         return ngayThanhToan; 
        }
    public void setNgayThanhToan(Date ngayThanhToan) {
         this.ngayThanhToan = ngayThanhToan; 
        }

    public String getHinhThucThanhToan() {
         return hinhThucThanhToan; 
        }
    public void setHinhThucThanhToan(String hinhThucThanhToan) {
         this.hinhThucThanhToan = hinhThucThanhToan; 
        }

    @Override
    public void readData();

    @Override
    public void writeData();

    @Override
    public abstract boolean xacNhanThanhToan(double soTien);

    @Override
    public abstract double soTienThanhToan();
}
