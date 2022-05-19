#include <bits/stdc++.h>
using namespace std;
const int N=100000000;
bool seive[N+1];

void seiveOfe(){
	for(int i=0;i<N;i++){
		seive[i] = 0;
	}
	seive[0]=1;
	seive[1]=1;
	for(int i=2;i*i<=N;i++){
		if(seive==0){
			for(int j=i*i;j<=N;j+=i){
				seive[j]=1;
			}
		}
	}
}
void solve(){
	memset(seive,0,sizeof(seive));
	seiveOfe();
	vector<int> vi;
	for(int i=2;i<=N;i++){
		if(seive[i]==0){
			vi.push_back(i);
		}
		if(i==99998953) break;
	}
	for(int i=0;i<vi.size();i+=100){
		cout<<vi[i]<<" ";
	}
}

int main(){

	int tc = 1;
	// cin >> tc;
	while(tc--){
		solve();
	}

}