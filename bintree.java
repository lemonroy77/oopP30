import java.util.Scanner;
class Stack{
	BinTree[] s=new BinTree[10];
	int top;
	boolean isEmpty(){return top==0;}
	void push(BinTree x){ s[top]=x; top++; }
	BinTree pop(){top--;return s[top];}
}
class ReadData{
	String data;//存储建树用数据，如"ab##c##"
	int pos;//data.charAt(pos)【相当于】data[i]
	ReadData(String s){ data=s; }
	char getChar(){
		char x=data.charAt(pos);
		pos++;
		return x;
	}
}
class BinTree{
	char data; BinTree L,R;
	BinTree(char x){ data=x; }
	BinTree(){ ; }
	BinTree create( ReadData r){//建树=造根，根有两种情况：空、非空
		//空-->return null;
		//非空 ->造结点t + 给t的所有域赋值
		
		char x=r.getChar();//Scanner中没有此功能，故需要创建一个对象，提供此项服务
		if(x=='#') return null; //创建空树
		//走至此处，即造非空树：非空 ->造结点t + 给t的所有域赋值
		BinTree t=new BinTree(x);
		t.L=create(r);//造一棵树交给t的孩子t.c[i]
		t.R=create(r);
		return t;
	}
	void pre(){// C版：pre(t)  java版：t.pre()
		System.out.print(this.data+"、");//this必定不为空
		if(this.L!=null)this.L.pre();
		if(this.R!=null)this.R.pre();
	}
	void preN(){
		Stack st=new Stack();
		BinTree t=this;
		while(t!=null ||st.isEmpty()==false)
		if(t!=null){//输出t、保存回溯点、进左子树
			System.out.print(this.data+" "); 
			st.push(t); t=t.L;
		}else{ t=st.pop(); t=t.R;}
	}
	void inN(){
		Stack st=new Stack();
		BinTree t=this;
		while(t!=null ||st.isEmpty()==false)
		if(t!=null){//保存回溯点、进左子树、输出t
			st.push(t); t=t.L;
		}else{ t=st.pop();System.out.print(this.data+" ");  t=t.R;}
	}
	void in(){
		if(this.L!=null)this.L.in();
		System.out.print(this.data+"、");
		if(this.R!=null)this.R.in();
	}
	void post(){
		if(this.L!=null)this.L.post();
		if(this.R!=null)this.R.post();
		System.out.print(this.data+"、");
	}
}
class App{
	public static void main(String[] args){
		System.out.print("请输入建树数据，#表示null：\n");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();//读一行，直至回车
		ReadData r=new ReadData(s);//把建树数据传入r
		BinTree t=new BinTree();
		t=t.create(r);
		System.out.print("\n pre="); t.pre();
		System.out.print("\n  in="); t.in();
		System.out.print("\npost="); t.post();
	}
}//AB##C##
    
