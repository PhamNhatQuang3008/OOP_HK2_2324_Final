
public class SelectionSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Selection sort.
     * @param data
     * @param order: true sắp xếp theo thứ tự tăng dần, false sắp xếp theo thứ tự giảm dần.
     */
    @Override
    public void sort(double[] data, boolean order) {
        /* TODO */
        if(order) {
            sortAscending(data);
        } else {
            sortDescending(data);
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự tăng dần,
     * sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        /* TODO */

        for(int i= 0 ;i<data.length-1;i++) {
            int min = i;
            for(int j = i+1;j < data.length;j++) {
                if(data[j] < data[min]) {
                    min = j;
                    // Gán giá trị nhỏ nhất cho phần từ ban đầu : data[i] //
                    double temp = data[min];
                    data[min] = data[i];
                    data[i] = temp;
                }

            }
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Selection sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        /* TODO */
        for(int i= 0 ;i<data.length-1;i++) {
            int max = i;
            for(int j = i+1;j < data.length;j++) {
                if(data[j] > data[max]) {
                    max = j;
                    // Gán giá trị nhỏ nhất cho phần từ ban đầu : data[i] //
                    double temp = data[max];
                    data[max] = data[i];
                    data[i] = temp;
                }

            }
        }
    }
}
