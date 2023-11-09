#include<iostream>
using namespace std;
const int N = 1005;
int n, a[N];
bool board[N][N];
signed main(){
	cin >> n;
	for(int i = 1; i <= n; i++) cin >> a[i];
	sort(a + 1, a + n + 1);
	int len = 2 * a[n] - 1;
	for(int i = 1; i <= n; i++){
		for(int j = 0; j < a[i]; j++){
			board[a[n] - j][a[n] - a[i] + j + 1] = 1;
			board[a[n] - j][a[n] + a[i] - j - 1] = 1;
			board[a[n] + j][a[n] - a[i] + j + 1] = 1;
			board[a[n] + j][a[n] + a[i] - j - 1] = 1;
		}
	}
	for(int i = 1; i <= len; i++){
		for(int j = 1; j <= len; j++){
			if(board[i][j] == 0) cout << ' ';
			else cout << '*';
		}
		cout << "\n";
	}
}

