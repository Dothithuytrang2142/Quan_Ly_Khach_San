import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DatPhong {
    private String maDatPhong;
    private Date ngayNhan;
    private Date ngayTra;
    private int soNguoi;
    private Phong phong; // composition

    public DatPhong() {}

    public DatPhong(String maDatPhong, Date ngayNhan, Date ngayTra, int soNguoi, Phong phong) {
        this.maDatPhong = maDatPhong;
        this.ngayNhan = ngayNhan;
        this.ngayTra = ngayTra;
        this.soNguoi = soNguoi;
        this.phong = phong;
    }

    public String getMaDatPhong() { 
        return maDatPhong; 
    }
    public void setMaDatPhong(String maDatPhong) { this.maDatPhong = maDatPhong; }

    public Date getNgayNhan() { 
        return ngayNhan; 
    }
    public void setNgayNhan(Date ngayNhan) {
         this.ngayNhan = ngayNhan;
         }

    public Date getNgayTra() {
         return ngayTra; 
        }
    public void setNgayTra(Date ngayTra) { 
        this.ngayTra = ngayTra;
     }

    public int getSoNguoi() { 
        return soNguoi; 
    }
    public void setSoNguoi(int soNguoi) { 
        this.soNguoi = soNguoi; 
    }

    public Phong getPhong() { 
        return phong; 
    }
    public void setPhong(Phong phong) {
         this.phong = phong; 
        }

    public int tinhSoNgay() {
        long diff = ngayTra.getTime() - ngayNhan.getTime();
        if (diff <= 0) return 0;
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public double tinhTienPhong() {
        int soNgay = tinhSoNgay();
        // tính: số ngày * giá phòng
        return soNgay * (phong != null ? phong.getGiaPhong() : 0.0);
    }

    public void xuatThongTin() {
        System.out.println("Dat phong: " + maDatPhong + " | Phong: " + (phong!=null?phong.getSoPhong():"-")
                + " | Ngay nhan: " + ngayNhan + " | Ngay tra: " + ngayTra
                + " | So ngay: " + tinhSoNgay() + " | Tien phong: " + tinhTienPhong());
    }
}
