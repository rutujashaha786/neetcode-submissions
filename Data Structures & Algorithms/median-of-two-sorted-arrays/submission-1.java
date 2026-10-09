class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;

        int med1Idx = n/2;
        int med2Idx = (n/2) - 1;

        int median1 = 0;
        int median2 = 0;

        int k = 0;

        int i = 0;
        int j = 0;

        while(i < n1 && j < n2 && k < n/2 + 1){
            if(nums1[i] < nums2[j]){
                // res[k] = nums1[i];
                if(k == med1Idx){
                    median1 =  nums1[i];
                }
                else if(k == med2Idx){
                    median2 =  nums1[i];
                }
                i++;
                k++;
            }
            else{
                // res[k] = nums2[j];
                if(k == med1Idx){
                    median1 =  nums2[j];
                }
                else if(k == med2Idx){
                    median2 =  nums2[j];
                }
                j++;
                k++;
            }
        }

        while(i < n1 && k < n/2 + 1){
            // res[k] = nums1[i];
            if(k == med1Idx){
                median1 =  nums1[i];
            }
            else if(k == med2Idx){
                median2 =  nums1[i];
            }
            i++;
            k++;
        }

        while(j < n2 && k < n/2 + 1){
            // res[k] = nums2[j];
            if(k == med1Idx){
                median1 =  nums2[j];
            }
            else if(k == med2Idx){
                median2 =  nums2[j];
            }
            j++;
            k++;
        }


        if(n % 2 == 1){
            return median1;
        }
        else{
            return (median1 + median2) / 2.0;
        }
    }
}
