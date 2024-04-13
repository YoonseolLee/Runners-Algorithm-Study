class 모의고사 {
  public int[] solution(int[] answers) {
    int count1 =0;

    for(int i=0;i<answers.length;i++){
      int m =i%5+1;
      if(answers[i]==m){
        count1 ++;
      }
    }

    int count2 =0;
    int take =0;
    int take2 =0;
    for(int i= 0;i<answers.length;i++){
      int m =i%8;
      if(m%2==0){
        take =2;
        if(take==answers[i]){
          count2++;
        }
      }else{
        take2 =take2+1;
        if(take2==2){
          take2++;
        }else if(take2>5){
          take2= take2-5;
        }
        if(answers[i]==take2){
          count2++;
        }
      }
    }

    int count3 =0;
    int num =0;
    for(int i=0;i<answers.length;i++){
      int m=i%10;
      if(m==0||m==1){
        num=3;
      }else if(m==2||m==3){
        num=1;
      }else if(m==4||m==5){
        num=2;
      }else if(m==6||m==7){
        num=4;
      }else if(m==8||m==9){
        num=5;
      }
      if(answers[i]==num){
        count3 ++;
      }


    }

    if(count1>count2&&count1>count3){
      int[] answer = {1};
      return answer;
    }else if(count2>count1&&count2>count3){
      int[] answer = {2};
      return answer;
    }else if(count3>count1&&count3>count2){
      int[] answer = {3};
      return answer;
    }else if(count1==count2&&count1>count3){
      int[] answer = {1,2};
      return answer;
    }else if(count2==count3&&count2>count1){
      int[] answer = {2,3};
      return answer;
    }else if(count1==count3&&count1>count2){
      int[] answer = {1,3};
      return answer;}
    else{
      int[] answer = {1,2,3};
      return answer;
    }


  }
}