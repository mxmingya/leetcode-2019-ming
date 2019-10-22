class MergeSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        sortArray(nums, 0, nums.length-1);
        return nums;
    }

    void sortArray(int[] nums, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left == right) {
            return;
        }

        sortArray(nums, left, mid);
        sortArray(nums, mid+1, right);

        // right = left + 1;
        merge(nums, left, mid, right);
    }

    void merge(int[] nums, int left, int mid, int right) {
        int i = left, j = mid+1, index = left;
        int[] buffer = new int[nums.length];
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                buffer[index] = nums[i];
                i++;
            } else {
                buffer[index] = nums[j];
                j++;
            }
            index++;
        }

        while (i <= mid) {
            buffer[index] = nums[i];
            i++;
            index++;
        }
        while (j <= right) {
            buffer[index] = nums[j];
            j++;
            index++;
        }
        // copy
        for (int k = left; k <= right; k++) {
            nums[k] = buffer[k];
        }
    }


}
