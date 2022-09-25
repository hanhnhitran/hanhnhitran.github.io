// #include<iostream>
using namespace std;
 int main (){
 	int A, B;
 	cout << " ";
 }


// #include <stdio.h>
// #include <conio.h>
int Fibonacci(int n)({
	if(n == 1 || n == 2)
	return 1;
	return Fibonacci(n-1) + Fibonacci(n-2); 
}
int main(){
	int n;
	cout << "enter n: ";
	cin >> n;

    cout << " num Fabonancci" << n << " is" << Fibonacci();
    return 0;
)}
	

 

//  cho 1 so tnhien n >1 tim so nguyen to khong viet qua n trong cac truong hop sau
 int main(){
	 int n;
	 cout << "\nhap n ="
	 cin >> n;
	 if(n < 2){
		 cout << n << "kphai so NT";
		 return 0;
	 }
	 int count = 0;
	 for(int i = 2; i <= sqrt(n); i++){
		 if(n % 1 == 0){
			 count++;
		 }
	 }
	 if(count == 0){
		 cout << n << "la so NT";
	 }else{
		 cout << n << "kphai so NT"
	 }
}



char hoten[30];
char ngaysinh[9];

char s[10] =  {'T', 'H', 'C','S', '', 'A', '\0'};
char s[10] = "THCS A";

// #include<iostream>
using namespace std;

int main(){
    char arCh[50];
    cout << "Input character sequences;";
    cin >> arCh;
    cout << "Character sequences recieved";
    cout <<arCh;
    system("pause");
}


//Ham strlen(s)
//Trả về chiều dài chuỗi s
char cLine[40] = "Have a nice day!";
int iLenght;
iLenght = strlen(cLine);


//Ham strcat(s, t)
//Nối chuỗi s2 vào cuối chuỗi s1.
char str1[25] = "Hello";
char str2[11] = "world";
strcat(str1, str2); //Hello World


int tg;
for(int i = 0; i < n - 1; i++){
    for(int j = i + 1; j < n; j++){
        if(a[i] < a [j]{
            tg = a[a];
            a[i] = a[j];
            a[j] = tg;
        })
    }
}


// #include <iostream>
using namespace std;
 
int main(){
    int n;
    do{
        cin >> n;
        if(n <= 0){
            cout << "\nNhap lai n = ";
        }
    }while(n <= 0);
    int sum = 0;
    for(int i = 1;i <= n;i++){
        if(n % i == 0){
            sum += i;
        }
    }
    cout << "\nSum = " << sum << '\n';
}


#include<iostream>
using namespace std;
int main(){
    int L, R, i, tong;
    cout <<" Hay nhap vao doan so nguyen duong L va R";
    cin >> L>> R;
    while(L <=R){
        for (i=L; i<=R; i++)
           for(j=1; j<=i; j++)
              if(i%j==0)
                tong=tong+j;
    }
}


// #include <stdio.h>
// #include<conio.h>
int Fibonacci(int n)({
    if(n == 1 || n ==2)
    return 1;
    return Fibonacci(n-1)+ Fibonacci(n-2);
}
int main(){
    int n;
    cout << "enter n";
    cin >> n;

    cout <, " num Fibonacci" << n << "is" << Fibonacci();
    return 0;
}




int main (){
    int n:
    cout << "\nhap n ="
    cin >> n;
    if(n<2){
        cout << n << " kphai so NT";
        return 0;
    }
    int count = 0;
    for(int i = 2; i<= sqrt(n); i++){
        if(n % 1 == 0){
            count ++;
        }
    }
    if(count == 0){
        cout << n << " la so NT";
    }else{
        cout<< n << " kphai so NT"
    }
}



char str1[25] = "Hello";
char str2[11] = "world";
strcat(str1, str2);



// #include <bits/stdc++.h>
// #include<fstream>
using namspace std;
int main(){
    ifstream input(#);
    fstream output;
    output.open("#");
    string str;
    input >> str; // lay gia tri bien str tu file input
    cout<<str;  // in str ra man hinh console
    output<<"Hello world";  // in Hello World vao file input
    input.close(); //dong file input
    output.close();   //dong file output
    return 0;
}



//eof()
string line;
while(!input.eof()) // hi chua toi cuoi file thi tiep tuc doc
{
    getline(input,line);
    output<<line;
}


// #include < bits/stdc++.h>
// #include<fstream>
using namespace std;
int main{
    // tao doi tuong input de doc du lieu dau vao tu file input.txt
    ifstream input("#")
    fstream output; // tao bien output de ghidu lieu vao file output.txt

    output.open("#", ios::out);
    if(input.is_open() && output.is_open()){
        cout << " Open succesful !!"<< endl;
    }
    else{
        cout <<" Open failed !!"<< endl;
    }
    input.close(); //dong file input
    output.close(); //dong file output
    return 0;
}

//ket qua mo thanh cong tai file console.log -> Mo thanh cong


int Fibonacci (int n){
    int f0 = 0;
    int f1 = 1;
    int fn = 1;
    int i;

    if (n < 0){
        return -1;
    }else if ( n==0 || n == 1){
        return n;
    }else{
        for ( i = 2; i < n; i++){
            f0 = f1;
            f1 = fn;
            fn = f0 + f1;
        }
    }
    return fn;
}


// Ham main

int main (){
    int i;
    cout << " 10 so dau tien cua day Fibinacci: \n";
    for ( i=0; i <10; i++){
        cout << Fibonacci(i) << "";
    }
}


//ktra so NT
// #include<iostream>
// #include<cmath>

using namespace std;

//check so Nt trong C++
// @param n: so nguyen duong
//@return 1 la so nguyen to, 0 kphai la so nguyen to 

int isPrimeNumber(int n){
    //so nguyen n < 2 khong phai la so nguyen to
    if (n< 2){
        return 0;
    }
    // check so nguyen to khi n>=2
    int squareRoot = (int) sqrt(n);
    int i;
    for(i = 2; i<= squareRoot; i++){
        if(n % i == 0){
            return 0;
        }
    }
    return 1;
}

//Ham main

int main(){
    int i;
    cout << " cac so nguyen to nho hon 100 la: \n";
    for( i = 0; i<100; i++){
        if(isPrimeNumber(i)){
            cout << i << "";
        }
    }
}



//Tinh giai thua KHÔNG dung phuong phap de quy

// #include<iostream>
using namespace std;
//tinh giai thua
//@param n: so nguyen duong
//@return giai thua cua so n

long tinhGiaithua(int n){
    int i;
    long giai_thua = 1;
    if ( n== 0 || n++1){
        return giai_thua;
    }else{
        for( i = 2; i<= n; i++){
            giai_thua *=i;
        }
        return giai_thua;
    }
}

//Ham main

int main(){
    int a = 5;
    int b = 0;
    int c = 10;
    cout << " Giai thua cua" << a << "la" << tinhGiaithua(a) << endl;
    cout << " Giai thua cua" << a << "la" << tinhGiaithua(a) << endl;
    cout << " Giai thua cua" << a << "la" << tinhGiaithua(a) << endl;
}


//Chuyen doi he co so 10 sang he co so B
// #include <iostream>

using namespace std;

const char CHAR_55 = 55;
const char CHAR_48 = 48;

int convertNumber(int n, int b){
    if ( n<0 || b < 2 || b > 16){
        printf("He co so hoac gia tri chuyen doi khong hop le!");
        return 0;
    }
    int i;
    char arr[20];
    int count = 0;
    int m;
    int remainder = n;
    while ( remainder > 0){
        if ( b > 10){
            m = remainder % break;if ( m>=10){
                arr[count] = (char)(m + CHAR_55);
                count++;
            }else{
                arr[cout] = (char) ( m + CHAR_48);
                count++;
            }
        }else{
            arr[count] = (char)((remainder % b) + CHAR_48);
            count++;
        }
        remainder = remainder / b;
    }
    //hien thi he so
    for(i = count - 1; i >= 0; i--){
        printf("%c", arr[i]);
    }
    return 1;
}

//Ham main
int main(){
    int n =12;
    ptintf("So %d trong he co so 2 = ", n);
    convertNumber(n,2);
    printf("\nSo %d trong he co so 16= ", n);
    coonvertNumber(n, 16);
    return 1;
}

// #include <iostream>
// #include<cmath>


using namespace std;
void giaiPTBac 2(float a, float b, float c){
    if(a==0){
        if(b==0){
            printf("phuong trinh vo no")
        }else{
            printf("Phuong trinh co 1 no: x = %f", (-c/b));
        }
        return;
    }
    //tinh delta
    float delta = b*b - 4*a*c;
    float x1;
    float f2;
    //tinh nghiem
    if(delta > 0){
        x1 = (float)((-b + sqrt(delta)) / (2*a));
        x2 = (float)((-b - sqrt(delta)) / (2*a));
        printf("Phuong trinh co 2 nghiem la: x1=%f va x2 = %f", x1,x2);
    }else if ( delta == 0){
        x1 = (-b / (2 * a));
        printf("Phuong trinh co nghiem kep: x1 = x2 = %f", x1);
    }else {
        printf("Phuong trinh vo nghiem!");
    }
}



int main(){
    float a,b,c;
    cout << " nhap he so bac 2, a=";
    cin >> a;
    cout << " nhap he so bac 1, b=";
    cin >> b;
    cout << " nhap so hang tu do, c=";
    cin >> c;
    giaiBPTBac 2(a, b, c,);
    return 1;
}



#include<bits/stdc++.h>
using namespace std;

string s, t; 

int main(){
    cin >> s >> t;
    int ans = 0;
    for(int i = 0; i < s.length(); i++){
        if(i + t.length() >= s.length()) break;
        bool ck = 1;
        for(int j = 0; j < t.length(); j++){
            if(s[i + j] != t[j]){
                ck = 0;
                break;
            }
        }
        if(ck){
            ans++;
            i += t.length() - 1;
        }
    }
    cout << ans << "\n";
}


#include<bits/stdc++.h>
using namespace std;

int ux, vx, uy, vy;

int main(){
    cin >> ux >> vx >> uy >> vy;
    if(ux < uy){
        if(vx <= vy) cout << -1 << "\n";
        else cout << (uy - ux) / (vx - vy) << "\n";
    }
    else{
        if(vy <= vx) cout << -1 << "\n";
        else cout << (ux - uy) / (vy - vx) << "\n";
    }
}