

public class BinarySearch implements Search {
    private static BinarySearch instance;
    private Sorter sorter;

    private BinarySearch() {
        /* TODO */
        this.sorter = new BubbleSort();
    }

    /**
     * Tạo đối tượng BinarySearch.
     * @return
     */
    public static BinarySearch getInstance() {
        /* TODO */
        if(instance == null) {
            instance = new BinarySearch();
        }
        return instance;
    }

    public void setSorter(Sorter sorter) {
        /* TODO */
        this.sorter = sorter;
    }

    @Override
    public int search(double[] data, double value) {
        sort(data);
        return binarySearch(data, value);
    }

    private int binarySearch(double[] data, double value) {
        // Thuật toán tìm kiếm nhị phân //
        int left = 0;
        int right = data.length - 1;
        while (left < right) {
            //(Lấy phần nguyên của gtri mid )//
            int mid = left + (right - left) / 2;
            if (data[mid] == value) {
                return mid;
            }
            if (data[mid] < value) {
                left = mid + 1;
                // Thu hẹp mảng để tiếp tục bổ đôi //
            }
            if (data[mid] > value) {
                right = mid - 1;
            }
        }
        return -1;
    }
        /* TODO */


    private void sort(double[] data) {
        /* TODO */
        sorter.sort(data , true);
    }
}
