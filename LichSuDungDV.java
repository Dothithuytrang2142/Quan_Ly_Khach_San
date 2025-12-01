public class LichSuDungDV {
    private String maLSDV;
    private DichVu dichVu; // composition
    private int soLuong;
    private String ngaySuDung;

    public LichSuDungDV() {}

    public LichSuDungDV(String maLSDV, DichVu dichVu, int soLuong, String ngaySuDung) {
        this.maLSDV = maLSDV;
        this.dichVu = dichVu;
        this.soLuong = soLuong;
        this.ngaySuDung = ngaySuDung;
    }

    public String getMaLSDV() {
         return maLSDV; 
        }
    public void setMaLSDV(String maLSDV) { 
        this.maLSDV = maLSDV; 
    }
    public DichVu getDichVu() {
         return dichVu;
         }
    public void setDichVu(DichVu dichVu) {
         this.dichVu = dichVu;
         }

    public int getSoLuong() { 
        return soLuong; 
    }
    public void setSoLuong(int soLuong) { 
        this.soLuong = soLuong; 
    }

    public String getNgaySuDung() { 
        return ngaySuDung;
    }
    public void setNgaySuDung(String ngaySuDung) {
         this.ngaySuDung = ngaySuDung;
     }

    public double tinhTien() {
        return (dichVu != null ? dichVu.getGiaDV() * soLuong : 0.0);
    }

    public void xuatThongTin() {
        System.out.println("LSDV: " + maLSDV + " | DV: " + (dichVu!=null?dichVu.getTenDV():"-")
                + " | SL: " + soLuong + " | Ngay: " + ngaySuDung + " | Thanh tien: " + tinhTien());
    }
}
