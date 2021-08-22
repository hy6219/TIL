package sorting.search.binary;

public class BinarySearch {
    public int binarySearch(int[] arr, int finder){
        int size=arr.length;
        int mid=size/2;
        int val=arr[mid];
        int[] temp=new int[mid];

        //크기가 1인데 찾는 데이터라면 바로 리턴 인덱스
        if(size==1 && finder==val){
            return mid;
        }
        //크기가 1인데 찾는 데이터가 아닌 경우
        if(size==1 && finder!=val){
            return -1;
        }
        //크기가 0인 경우
        if(size==0){
            return -1;
        }
        //size>=2
        if(val==finder){
            return mid;
        }else{
            if(finder<val){
                System.arraycopy(arr,0,temp,0,mid);
                return binarySearch(temp,finder);
            }else{
                System.arraycopy(arr,mid,temp,0,mid);
                return binarySearch(temp,finder);
            }
        }

    }
}
