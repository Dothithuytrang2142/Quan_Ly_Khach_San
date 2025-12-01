import java.util.ArrayList;
import java.util.List;

public class QuanLyKhachSan {
    private List<Phong> dsPhong = new ArrayList<>(); // aggregation
    private List<NhanVien> dsNhanVien = new ArrayList<>();
    private List<KhachHang> dsKhachHang = new ArrayList<>();
    private List<DatPhong> dsDatPhong = new ArrayList<>();
    private List<HoaDon> dsHoaDon = new ArrayList<>();

    public List<Phong> getDsPhong() {
         return dsPhong; 
        }
    public List<NhanVien> getDsNhanVien() {
         return dsNhanVien; 
        }
    public List<KhachHang> getDsKhachHang() { 
        return dsKhachHang; 
    }
    public List<DatPhong> getDsDatPhong() {
         return dsDatPhong; 
        }
    public List<HoaDon> getDsHoaDon() {
         return dsHoaDon; 
        }
    public void themPhong(Phong p) {
         if (p!=null) dsPhong.add(p); 
        }
    public void themNhanVien(NhanVien n) {
         if (n!=null) dsNhanVien.add(n); 
        }
    public void themKhachHang(KhachHang k) {
        if (k!=null) dsKhachHang.add(k); 
    }
    public void themDatPhong(DatPhong d) {
         if (d!=null) dsDatPhong.add(d); 
        }
    public void themHoaDon(HoaDon h) {
         if (h!=null) dsHoaDon.add(h); 
        }

    public Phong timPhongTheoSo(String soPhong) {
        for (Phong p : dsPhong) if (p.getSoPhong().equalsIgnoreCase(soPhong)) return p;
        return null;
    }

    public void xuatTatCaPhong() {
        System.out.println("Danh sach phong:");
        for (Phong p : dsPhong) p.xuatThongTin();
    }

    public void xuatTatCaHoaDon() {
        System.out.println("Danh sach hoa don:");
        for (HoaDon h : dsHoaDon) h.inHoaDon();
    }
}
