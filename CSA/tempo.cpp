#include<iostream>
#include<string>
using namespace std;

class NhanVien{
    public:
      string Ten;
      int Tuoi;
      string Diachi;
      int TienLuong, Tongsogiolam;
    void inputInfo(){
        cout << "Nhap ten nhan vien: ";
        getline(cin, Ten);
        cout << "Nhap tuoi nhan vien: ";
        cin >> Tuoi;
        cout << "Nhap dia chi nhan vien: ";
        cin.ignore();
        getline(cin, Diachi);
        cout << "Nhap luong nhan vien: ";
        cin >> TienLuong;
        cout << "Nhap so gio lam cua nhan vien: ";
        cin >> Tongsogiolam;
    }
    void printInfo(){
        cout << "Ten nhan vien: " << Ten << "\n";
        cout << "Tuoi nhan vien: " << Tuoi << "\n";
        cout << "Dia chi nhan vien: " << Diachi << "\n";
        cout << "Luong nhan vien: " << TienLuong << "\n";
        cout << "Tong so gio lam cua nhan vien: " << Tongsogiolam << "\n";
    }
    double tinhThuong(){
        if(Tongsogiolam >= 200) return (double)TienLuong * (double)0.2;
        else if(Tongsogiolam >= 100) return (double)TienLuong * (double)0.1;
        else return 0.0;
    }
};

int main() {
    NhanVien a;
    a.inputInfo();
    a.printInfo();
    cout << a.tinhThuong() << "\n";
}


