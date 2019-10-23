class HeapSort {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        heapSort(nums);
        return nums;
    }

    void heapSort(int[] nums) {
        int size = nums.length;
        for (int i = size/2-1; i > -1; i--) {
            heapify(nums, size, i);
        }
    
        for (int i = size; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapify(nums, i, 0);        
        }
    }

    void heapify(int[] nums, int size, int i) {
        int largest = i;
        int leftIndex = 2 * i + 1, rightIndex = 2 * i + 2;

        if (leftIndex < size && nums[leftIndex] > nums[largest]) {       
            largest = leftIndex;
        }

        if (rightIndex < size && nums[rightIndex] > nums[largest]) {
            largest = rightIndex;
        }

        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;
            heapify(nums, size, largest);
        }
    }
}
