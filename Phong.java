public class Phong {
    private String soPhong;
    private String loaiPhong;
    private double giaPhong;
    private boolean tinhTrang; // false = trống, true = có người

    public Phong() {}

    public Phong(String soPhong, String loaiPhong, double giaPhong) {
        this.soPhong = soPhong;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.tinhTrang = false;
    }

    public String getSoPhong() { 
        return soPhong; 
    }
    public void setSoPhong(String soPhong) {
         this.soPhong = soPhong; 
        }

    public String getLoaiPhong() {
         return loaiPhong; 
        }
    public void setLoaiPhong(String loaiPhong) {
         this.loaiPhong = loaiPhong; 
        }

    public double getGiaPhong() { 
        return giaPhong; 
    }
    public void setGiaPhong(double giaPhong) {
         this.giaPhong = giaPhong; 
        }

    public boolean isTinhTrang() {
         return tinhTrang;
         }
    public void setTinhTrang(boolean tinhTrang) { 
        this.tinhTrang = tinhTrang; 
    }

    public void xuatThongTin() {
        System.out.println("Phong " + soPhong + " | " + loaiPhong + " | Gia: " + giaPhong + " | " + (tinhTrang ? "Co nguoi" : "Trong"));
    }
}
