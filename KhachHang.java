public class KhachHang extends Nguoi {
    private String maKH;
    private String soCMND;
    private String quocTich;
    private String loaiKH;

    public KhachHang() {}

    public KhachHang(String maKH, String hoTen, String soCMND, String quocTich, String loaiKH, String diaChi, String email, String gioiTinh) {
        super(hoTen, maKH, diaChi, email, gioiTinh);
        this.maKH = maKH;
        this.soCMND = soCMND;
        this.quocTich = quocTich;
        this.loaiKH = loaiKH;
    }

    public String getMaKH() {
         return maKH;
         }
    public void setMaKH(String maKH) { 
        this.maKH = maKH; 
    }

    public String getSoCMND() { 
        return soCMND; 
    }
    public void setSoCMND(String soCMND) {
         this.soCMND = soCMND; 
        }

    public String getQuocTich() {
         return quocTich; 
        }
    public void setQuocTich(String quocTich) { 
        this.quocTich = quocTich; 
    }

    public String getLoaiKH() {
         return loaiKH; 
        }
    public void setLoaiKH(String loaiKH) {
         this.loaiKH = loaiKH; 
        }

    @Override
    public void xuatThongTin() {
        System.out.println("Khach hang: " + maKH + " | " + hoTen + " | CMND: " + soCMND + " | " + quocTich + " | Loai: " + loaiKH);
    }
}
