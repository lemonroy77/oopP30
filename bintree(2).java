//功能：二叉树及其应用
import java.util.Scanner;
class ReadChar{
    String data; //建树用的字符串
    int pos = 0; //对应字符串中的字符位置
    ReadChar(String x){data = x;}
    char getChar(){
        char x = data.charAt(pos);
        pos ++;
        return x;
    }
}
class BinTree{
    char data;
    BinTree L,R;
    BinTree(char c){data=c;}
    BinTree(){;}
    BinTree create(ReadChar r){//C版建树
        //建树=造根，根有两种情况：空、非空
        char c = r.getChar();
        if(c == '#') return null; //根据数据判断是否为空
        //非空根=造t对象、给t的所有属性赋值
        BinTree t = new BinTree(c);
        t.L = create(r); //造一颗树交给t.L
        t.R = create(r); //造一颗树交给t.R
        return t;
    }
    void pre(){
        System.out.print(this.data + " ");
        if(this.L != null) this.L.pre();
        if(this.R != null) this.R.pre();
    }
    void in(){
        if(this.L != null) this.L.in();
        System.out.print(this.data + " ");
        if(this.R != null) this.R.in();
    }
     class Stack{//通用栈
        Object[] a = new Object[20];
        int top;
        boolean isEmpty(){return top ==0;}
        void push(Object x){//暂不考虑栈满
            a[top] = x;
            top ++;
        }
        Object pop(){ //暂不考虑栈空出栈
            top --;
            return a[top];
        }
    }
    void preN(){
        Stack sk = new Stack();
        BinTree t = this;
        while(t != null || sk.isEmpty() == false){
            if(t != null){
                System.out.print(t.data + " ");
                sk.push(t);
                t = t.L;
            }else{
             t = (BinTree)sk.pop();//出栈时返回Object，需强制转换。
                t = t.R;
            }
        }
    }
}
class App{
    public static void main(String[] args){
        BinTree t = new BinTree();
        Scanner sc = new Scanner(System.in);
        System.out.print("\n输入建树序列，#表示null：");
        String s = sc.nextLine();
        ReadChar r = new ReadChar(s);
        t = t.create(r);
        System.out.print("\n pre:"); t.pre();
        System.out.print("\n preN:"); t.preN();
        System.out.print("\n in:"); t.in();
    }
}
