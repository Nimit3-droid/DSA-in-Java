package numberTheory;

import java.lang.StringBuilder;


public class genPrimes{
  public static void main(String args[]){
      StringBuilder sb = new StringBuilder();
      
      final int MAX_N = 100000000;
      boolean[] is_not_prime = new boolean[MAX_N + 1];
      int no_of_primes = 0;
      
      sb.append("2\n");
      no_of_primes++;

      for (int p = 3; p*p <= MAX_N; p += 2){
          if (is_not_prime[p] == false){
              for (int i = p*p; i <= MAX_N; i += p){
                  is_not_prime[i] = true;
        }
    }
}

    for (int p = 3; p <= MAX_N; p += 2){
      if (is_not_prime[p] == false){
        if (no_of_primes++ % 100 == 0){
            sb.append(p);
            sb.append('\n');
        }
    }
    }
    
    System.out.print(sb.toString());

    }
}