public class BinarySearch {
	// 当元素多次出现时返回第一第一次出现的位置
	
    public int getPos(int[] A, int n, int val) {
		if( n == 0 || A.length == 0 ){//异常处理
            return -1;
		}
        int left = 0;
		int right = n - 1;
		int mid = 0;
		while(left <= right){
			mid = (left+right)/2;
			if(A[mid] < val){
				left = mid + 1;
			}else if(A[mid] > val){
				right = mid - 1;
			}else{
				while( mid>=0 && A[mid] == val ){  //找到后向前遍历看是否有相同
                    mid--;
				}
                return mid+1;
			}
		}
		return -1;
    }
}