import java.util.Arrays;
import java.util.Random;

public class TestBinarySearch {

    /* Yêu cầu:
    - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
    - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
    - Tạo đối tượng có kiểu dữ liệu BinarySearch. Dùng đối tượng này test thuật toán tìm kiếm nhị phân với
      mảng dữ liệu đã sinh ra, và sử dụng 3 thuật toán sắp xếp khác nhau như đã cho.

      Các kết quả test được in ra terminal theo định dạng: ví dụ
      Using Bubble Sort Algorithm:
      Before sorting: [5.0 4.0 3.0 2.0 1.0]
      After sorting: [1.0 2.0 3.0 4.0 5.0]
      Binary search giá trị 3.0: 2

      Using Insertion Sort Algorithm:
      Before sorting: [5.0 4.0 3.0 2.0 1.0]
      After sorting: [1.0 2.0 3.0 4.0 5.0]
      Binary search giá trị 6.0:-1

    - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_BinarySearch.txt.
    - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
      <TenSinhVien_MaSinhVien_BinarySearch>.zip (Ví dụ, NguyenVanA_123456_BinarySearch.zip),
      nộp lên classroom
     */
    public static void main(String[] args) {
        Random x = new Random();
        int a = 20 + x.nextInt(11);
        double data[] = new double[a];
        for (int i = 0; i < a; i++) {
            data[i] = x.nextDouble() * 100;
        }
        BinarySearch binary = BinarySearch.getInstance(); // Tạo đối tượng mới binary //
        binary.setSorter(new InsertionSort());
        testBinarySearch(binary , data , "InsertionSort");
        binary.setSorter(new BubbleSort());
        testBinarySearch(binary , data , "BubbleSort");
        binary.setSorter(new SelectionSort());
        testBinarySearch(binary , data , "SelectionSort");
    }


    public static void testBinarySearch(BinarySearch binary , double [] data , String thuatoansapxep) {
        double[] dataBandau = Arrays.copyOf(data, data.length);
        System.out.println("Using " + thuatoansapxep + " Algorithm : ");
        System.out.println("Before sorting" + Arrays.toString(dataBandau));
        int index = binary.search(data, dataBandau[0]);// Tìm kiếm nhị phân phần tử bất kì ( chọn ptu [0] ) //
        System.out.println("After sorting " + Arrays.toString(data));
        System.out.println("Binary search for value " + dataBandau[0] + " : " + index);
    }
}

