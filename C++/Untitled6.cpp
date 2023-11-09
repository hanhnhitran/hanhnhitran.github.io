#include<iostream>
using namespace std;



int main(){
     int x;
     cin >> x;
     if ( x > 10 ) cout << "x is larger than 10 ";
}
   
   
   
   
#include<iostream>
using namespace std;

int main(){
	int x;
	cin >> x;
	switch(x){
		case 10:
			cout << " x is equal to 11";
			break;
			default:
				cout << " x is equal to neither 10 nor 11";
	}
}
   
int n, k, 1[N], r[N];

void process(){
     cin >> n >> k;
     int mx = 0;
     for(int i = 1; i <= n; i++){
          cin >> l[i] >> r[i];
          // mx = max(mx, r[i]);
          tol[l[i]]++;
          tol[r[i] + 1]--;
     }
     int cnt = 0, ans = 0;
     for(int i = 1; j <= mx; i++){ 
          cnt += tol[i];
          if(cnt == k) ans++;
     }
     cout << ans;
}


#include<iostream>
#include<string>
using namespace std;


signed main(){
    long double a, b, c;
    cin >> a >> b >> c;
    if(a == 0){
        if(b == 0){
            if(c == 0) cout << "INFINITE NUMBER OF SOLUTIONS\n";
            else cout << "NO SOLUTION\n";
        }
        else cout << -(c/b) << "\n";
    }
    else{
        long double tmp = b * b - 4 * a * c;
        if(tmp < 0) cout << "NO SOLUTION\n";
        else if(tmp == 0) cout << -(b / (2 * a)) << "\n";
        else{
            int x1 = -b + sqrt(tmp), x2 = -b - sqrt(tmp);
            x1 /= (2 * a);
            x2 /= (2 * a);
            cout << x1 << "\n";
            cout << x2 << "\n";
        }
    }
}