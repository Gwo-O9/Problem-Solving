/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(isBadVersion(1)) return 1; //if ver1 is bad version, return 1;
        int low = 1; int high = n;
        while(low+1 < high) { // using binary search
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) high = mid; // if mid is true, replace high with mid
            else low = mid; //if mid is false, replace mid with low
        }
        return high; //when the while loop ends, low is goodVersion and high is badVersion. 
    }
}
