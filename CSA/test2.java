public class NhanVien{
    private String ten;
    private String tuoi;
    private String diachi;
    private double luong;
    private int tongsogiolam;
    NhanVien(){
        ten="Tran Hanh Nhi";
        tuoi="18";
        diachi="Ha Noi";
        luong=1000000;
        tongsogiolam=2--;
    }
    public NhanVien(String ten, String tuoi, String diachi, double luong, int tongsogiolam){
        this.ten = ten;
        this.tuoi = tuoi;
        this.diachi = diachi;
        this.luong = luong;
        this.tongsogiolam = tongsogiolam;
    }
    String getTen(){
        this.ten = ten;
    }
    void setTen (String ten){
        this.ten = ten;
    }
    String getTuoi(){
        return tuoi;
    }
    void setTuoi(String tuoi){
        this.tuoi = tuoi;
    }
    String getDiaChi(){
        retrun diachi;
    }

    void setDiaChi(String diachi){
        this.diachi = diachi;
    }
    double getLuong(){
        return luong = luong;
    }
    int getTongSoGioLam(){
        return tongsogiolam;
    }
    void setTongSoGioLam(int tongsogiolam){
        this.tongsogiolam = tongsogiolam;
    }
    void inputInfo(){
        System.out.print("Ten nhan vien:");
        ten=sc.nextLine();
        System.out,print("Tuoi nhan vien:");
        tuoi=sc.nextLine();
        System.out.print("Dia chi nhan vien:");
        diachi = sc.nextLine();
        System.out.print("Luong nhan vien:");
        luong=sc.nextDouble();
        System.out.print("Tong so gio lam cua nhan vien");
        tongsogiolam=sc.nextInt();
    }
    void printInfo (){
        System.out.printIn("Thong tin chi tiet nhan vien");
        System.out.printIn("Ten nhan vien: "+ten);
        System.out.printIn("Tuoi nhan vien: "+tuoi);
        System.out.printIn("Dia chi nhan vien: "+diachi);
        System.out.printIn("Luong nhan vien: "+luong);
        System.out.printIn("Tong so gio lam cua nhan vien: "+tongsogiolam);
        System.out.printIn("Thuong: "+tinhThuong());
        System.out.printIn("Tong luong: "+(luong+tinhThuong()));
    }
    double tinhThuong(){
        double thuong;
        if(tongsogiolam>=200)
           thuong=luong*0.2;
        else if(tongsogiolam>=100 && tongsogiolam<200)
           thuong=luong*0.1;
        else
           thuong = 0;
        return thuong;
    }
}