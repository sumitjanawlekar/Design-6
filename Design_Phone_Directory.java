// Time Complexity : O(1), All get(), check(), and release() operations are done in constant time
// Space Complexity : O(n), n is the total numbers of available numbers (exxactly O(2n) space, queue and map ) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner Explanation of your code in plan English
//1. Create a hashSet and a queue, put all the numbers from 0 to maxnumber -1 in both of them (Set can be used to see if the number
        //is availble in O(1) time and queue can be used to allocate OR get() the next available number in O(1) time)
//2. Do the following for following operations
        //1. get() -> poll() the first element from the queue, remove that polled number from the set and return the number
        //2. check() -> return if given number exists in the set
        //3. Release() -> check if set already contains that number, if not add it to the set and the queue. If already present do nothing

// Your code here along with comments explaining your approach

class PhoneDirectory {

    //Set to maintain the available phone directory
    Set<Integer> availableNum;
    //queue to allocate an active number
    Queue<Integer> allocateNum;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        availableNum = new HashSet<>();
        allocateNum = new LinkedList<>();
        
        //add available phoneNumber in the set and queue
        for (int i=0; i<maxNumbers; i++){
            availableNum.add(i);
            allocateNum.add(i);
        }
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        //get the first number from queue
        //delete it from the set
        //return the number
        int num = -1;
        if(!allocateNum.isEmpty()){
            num =  allocateNum.poll();
            availableNum.remove(num);
        }
        return num;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return availableNum.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(!availableNum.contains(number)){
            availableNum.add(number);
            allocateNum.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */