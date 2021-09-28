#include <stdio.h>
#include<time.h>
#include <stdlib.h>
#include<math.h>
int inputArray[26];
void iEEE(float n){
    int intarray[26];
    int deciarray[26];
    for(int i=0;i<=25;i++){
        intarray[i]=0;
        deciarray[i]=0;
        inputArray[i]=0;
    }
    if(n>0){
        inputArray[0] =0;
    }else{
        inputArray[0]=1;
        n*=-1;
    }
    int intarrayIndex=0;
    int leftInteger=(int) n;
    float rightInteger= n-leftInteger;
    for(int i=25;i>=0;i--){
        if(leftInteger>>i&1){
            intarray[intarrayIndex]=1;
        }else{
            intarray[intarrayIndex]=0;
        }
        intarrayIndex++;
    }
    int preInde=0;
    int lI=-1;
    for(int i=0;i<=25;i++){
        if(intarray[i]==1){
            lI=25-i;
            preInde=i;
            preInde++;
            break;
        }
    }
    int laterIndex=0;
    while(laterIndex <=25){
        rightInteger=rightInteger*2.0 - (int)(rightInteger*2.0);
        if((int)(rightInteger*2.0) &1){
            deciarray[laterIndex]=1;
        }else{
            deciarray[laterIndex]=0;
        }
        laterIndex++;
    }
  
    int rI=-1;
    for(int i=0;i<=25;i++){
        if(deciarray[i]==1){
            rI=i+1;
            break;
        }
    }

    int expon=-1;
    if(lI==-1){
        expon= -rI;
    }else{
        expon= lI;
    }
    int exp=57+expon;
    int currIndex=1;
    for(int i=7;i>=0;i--){
        if(exp>>i&1){
            inputArray[currIndex++]=1;
        }else{
            inputArray[currIndex++]=0;
        }
    }
    int curr=9;
    if(expon>0){
        for(int j=curr,k=0;k<lI;k++,curr++,preInde++){
            inputArray[curr]=intarray[preInde];
        }

        for(int i=curr,k=0;k<rI;i++,k++,curr++){
            inputArray[i]=deciarray[k];
        }

    }else{
        for(int i=curr,k=abs(expon);k<rI;i++,k++,curr++){
            inputArray[i]=deciarray[k];
        }
    }

}

void caller(float n, float m){

    iEEE(n);
    
    for(int i=0;i<=25;i++){
        printf("%d ",inputArray[i]);
    }
    printf("\n%f",n);
    printf("\n\n");

    iEEE(m);
    for(int i=0;i<=25;i++){
        printf("%d ",inputArray[i]);
    }
    printf("\n%f",m);
    printf("\n\n");

    iEEE(n+m);
    for(int i=0;i<=25;i++){
        printf("%d ",inputArray[i]);
    }
    printf("\n%f",n+m);
    printf("\n\n");
}

int main() {
    //26 bit 
    // 57 + 255 is range
    // 1 bit sign // 8 bit exp // 17 bit exp
    // srand(time(0));
    // int random[]={-1,1};
	// float m=3.5*57;
    // float n=((rand() % 255) + 57)*random[rand()%2];
    // caller(n,m);
    int num=4;
    num=printf("2");
    printf("%d",num);
	return 1;
}

