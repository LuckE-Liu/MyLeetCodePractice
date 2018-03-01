import java.util.ArrayList;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int sumLength = l1 + l2;
        int median;
        int nums1Index = 0;
        int nums2Index = 0;
        int currIndex = 0;
        int trueEnd = 0;
        int fakeEnd = 0;
        int index = sumLength / 2;

        if (sumLength % 2 == 0) {
            if (l1 == 0 || l2 == 0) {
                return l1 == 0 ? ((nums2[index - 1] + nums2[index]) / 2) : ((nums1[index - 1] + nums1[index]) / 2);
            }
            while (currIndex <= index) {
                if (nums1Index == l1) {
                    if (currIndex == index) {
                        fakeEnd = 1;
                        currIndex++;
                    }
                    break;
                }
                if (nums2Index == l2) {
                    if (currIndex == index) {
                        fakeEnd = 2;
                        currIndex++;
                    }
                    break;
                }
                if (nums1[nums1Index] >= nums2[nums2Index]) {
                    trueEnd = fakeEnd;
                    fakeEnd = 2;
                    nums2Index++;

                } else {
                    trueEnd = fakeEnd;
                    fakeEnd = 1;
                    nums1Index++;
                }
                currIndex++;
            }
            if (currIndex == index + 1) {

                if (fakeEnd == 1) {
                    if (nums1Index < l1) {
                        if (trueEnd == 1) {
                            return (double)((nums1[nums1Index - 1] + nums1[nums1Index - 2]) / 2);
                        } else {
                            return (double)((nums1[nums1Index - 1] + nums2[nums2Index - 1]) / 2);
                        }
                    } else {
                        return (double)(nums1[nums1Index - 1] + nums2[nums2Index]) / 2;
                    }
                } else {
                    if (nums2Index < l2) {
                        if (trueEnd == 2) {
                            return (double)((nums2[nums2Index - 1] + nums2[nums2Index - 2]) / 2);
                        } else {
                            return (double)(nums1[nums1Index - 1] + nums2[nums2Index] - 1)/2;
                        }
                    } else {
                        return (double)(nums2[nums2Index - 1] + nums1[nums1Index] ) / 2;
                    }
                }
            } else {
                if (fakeEnd == 1) {
                    System.out.println(nums2Index);
                    nums2Index = index - currIndex + nums2Index;
                    return (double)(nums2[nums2Index] + nums2[nums2Index - 1]) / 2;
                } else {
                    System.out.println("numb1" + nums1Index);
                    System.out.println(fakeEnd);
                    nums1Index = index - currIndex + nums1Index;
                    return (double)(nums1[nums1Index] + nums1[nums1Index - 1]) / 2;
                }
            }
        } else {
            if (l1 == 0 || l2 == 0) {
                return l1 == 0 ? (nums2[index]) : (nums1[index]);
            }
            while (currIndex <= index) {
                if (nums1Index == l1) {
                    if (currIndex == index) {
                        fakeEnd = 1;
                        currIndex++;
                    }
                    break;
                }
                if (nums2Index == l2) {
                    if (currIndex == index) {
                        fakeEnd = 2;
                        currIndex++;
                    }
                    break;
                }
                if (nums1[nums1Index] >= nums2[nums2Index]) {
                    trueEnd = fakeEnd;
                    fakeEnd = 2;
                    nums2Index++;
                } else {
                    trueEnd = fakeEnd;
                    trueEnd = 1;
                    nums1Index++;
                }
                currIndex++;
            }

            if (currIndex == index + 1) {
                if (fakeEnd == 1) {
                    return (double)nums1[nums1Index - 1];
                } else {
                    return (double)nums2[nums2Index - 1];
                }
            } else {
                if (fakeEnd == 1) {
                    nums2Index = index - currIndex + nums2Index;
                    return (double)nums2[nums2Index];
                } else {
                    nums1Index = index - currIndex + nums1Index;
                    return (double)nums1[nums1Index];
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3}));
    }
}
