import java.util.Scanner;

class SeqList {
    double[] a;
    int len;

    SeqList() {
        a = new double[20];
    }

    SeqList(int max) {
        a = new double[max];
    }

    void input() {
        System.out.println("请输入一组数，-1结束：");
        double x;
        Scanner sc = new Scanner(System.in);
        x = sc.nextDouble();
        int i = 0;
        while (x != -1) {
            a[i] = x;
            i++;
            x = sc.nextDouble();
        }
        len = i;
    }

    void out() {
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + "、");
        }
    }

    void insert(double x, int index) {
        if (index < 0 || index > len) {
            System.out.println("插入位置不合法！");
            return;
        }
        if (len == a.length) { // 容量不足，需要扩容
            double[] newArray = new double[2 * a.length];
            for (int i = 0; i < index; i++) {
                newArray[i] = a[i];
            }
            for (int i = len - 1; i >= index; i--) {
                newArray[i + 1] = a[i];
            }
            newArray[index] = x;
            a = newArray;
        } else {
            for (int i = len - 1; i >= index; i--) {
                a[i + 1] = a[i];
            }
            a[index] = x;
        }
        len++;
    }

    void delete(int index) {
        if (index < 0 || index >= len) {
            System.out.println("删除位置不合法！");
            return;
        }
        for (int i = index; i < len - 1; i++) {
            a[i] = a[i + 1];
        }
        len--;
    }

    double get(int index) {
        if (index < 0 || index >= len) {
            System.out.println("索引越界！");
            return -1; // 或者抛出自定义异常等其他错误处理方式
        }

        return a[index];
    }

    void sortAsc() {
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[i]) {
                    // 交换位置
                    double temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    void sortDesc() {
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (a[j] > a[i]) {
                    // 交换位置
                    double temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}

class App {
    public static void main(String[] args) {
        SeqList s = new SeqList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一组数，-1结束：");
        double x = scanner.nextDouble();
        while (x != -1) {
            s.insert(x, s.len);
            x = scanner.nextDouble();
        }
        System.out.println("顺序表内容：");
        s.out();
        System.out.print("\n请输入要插入的元素值：");
        double insertValue = scanner.nextDouble();
        System.out.print("请输入要插入的位置：");
        int insertIndex = scanner.nextInt();
        s.insert(insertValue, insertIndex);
        System.out.println("\n插入后顺序表内容：");
        s.out();
        System.out.print("\n请输入要删除的位置：");
        int deleteIndex = scanner.nextInt();
        s.delete(deleteIndex);
        System.out.println("\n删除后顺序表内容：");
        s.out();
        System.out.print("\n请输入要查询的位置：");
        int queryIndex = scanner.nextInt();
        double queryResult = s.get(queryIndex);
        System.out.println("查询结果：" + queryResult);
        s.sortAsc();
        System.out.println("\n升序排序后顺序表内容：");
        s.out();
        s.sortDesc();
        System.out.println("\n降序排序后顺序表内容：");
        s.out();
    }
}