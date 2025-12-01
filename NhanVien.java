public class NhanVien extends Nguoi {
    private String maNV;
    private double luong;
    private String chucVu;

    public NhanVien() {}

    public NhanVien(String maNV, String hoTen, String chucVu, double luong, String diaChi, String email, String gioiTinh) {
        super(hoTen, maNV, diaChi, email, gioiTinh);
        this.maNV = maNV;
        this.chucVu = chucVu;
        this.luong = luong;
    }

    public String getMaNV() {
         return maNV; 
        }
    public void setMaNV(String maNV) { this.maNV = maNV; }

    public double getLuong() {
         return luong; 
        }
    public void setLuong(double luong) {
         this.luong = luong; 
        }

    public String getChucVu() {
         return chucVu; 
        }
    public void setChucVu(String chucVu) { 
        this.chucVu = chucVu; 
    }

    @Override
    public void xuatThongTin() {
        System.out.println("Nhan vien: " + maNV + " | " + hoTen + " | " + chucVu + " | Luong: " + luong);
    }
}
