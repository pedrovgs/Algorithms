// Often there is need for getting prime numbers, and when the number is large enough, there are time-outs.
// One of the most efficient and easy way of getting Prime numbers is using Sieve's Algorithm for Prime numbers.
// I have used it infinitely many times and it is one of the most handy algorithm that you MUST have up your sleeve.

// It is simple yet an elegant method of thinking, just based on logical math. 
// We know Primes are those numbers who don't have any factor except 1 and the number itself.
// This is the point we use in this algorithm. Pseudocode follows below:

// boolean array[10000000];
// set all of the values in array[] as true
// loop from i=2 to less than squareRoot of the number(n) you want
// check if array[i] is true, and if it is loop from j=i*2 to j=j*(i+n) and put all array[j] to false
// all done, now when you loop through the array, only primes are marked with true, all others are labeled as false

//Code for this

boolean array[] = new boolean[1000000+1];
    for(int i=2;i<=1000000;i++){
        array[i]=true;
    }
        for(int j=2;j*j<=1000000;j++){
            if(array[j]){
                for(int k=j*2;k<=1000000;k+=j){
                    array[k]=false;
                }
            }
        }
        
  // this code labels all the prime numbers in your array as true and other as false, now you can use your list of primes
  // after this you can get prime in O(n) time (worst case)
