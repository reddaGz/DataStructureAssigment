package Assigment3.number2;

public class StudentArray {
    private Student[] a;
    private int nElement;

    public StudentArray(int max) {//maximum capacity
        a = new Student[max];
    }

    public Student find(int id) {
       for(int i=0;i<nElement;i++){
           if(a[i]!=null && a[i].getId()==id)
               return a[i];
       }
       return null;
    }
  //next index
    public void insert(int id, String name, int mark) {
        if(nElement==a.length)
            throw new IndexOutOfBoundsException("no space");
       for(int i=0;i<a.length;i++){
           if(a[i]!=null && a[i].getId()==id)
               throw new IllegalArgumentException("Duplication not allowed");
           if(a[i]==null){
               a[i]=new Student(id,name,mark);
               nElement++;
               break;
           }
       }
    }
    public boolean delete(int id) {
        int index=0;
        int i;
        for (i = 0; i < a.length; i++) {
            if(a[i]!=null && a[i].getId() == id ) {
                index=i;
                break;
            }
        }
        if(i==a.length)
            return false;
        for(int j=index+1;j<a.length;j++){//Shifting the data to remove the hole of the array;
            a[j-1]=a[j];
        }
        nElement--;
        return  true;
    }
    public void displayAll() { // displays array contents
        for(int i=0;i<nElement;i++) {
            if(a[i]!=null)
               System.out.print(a[i].getId()+" \n");
        }
    }
    public Student maxMark(){
        int index=0;
        int max=a[0].getMark();
        for(int i=0;i<nElement;i++){
            if(max<a[i].getMark())
                index=i;
        }
      return a[index];
    }
    public Student miniMark(){
        int index=0;
        int min=a[0].getMark();
        for(int i=0;i<nElement;i++){
            if(min>a[i].getMark())
                index=i;
        }
        return a[index];
    }

    public static void main(String[] args) {
        int n=4;
        StudentArray student=new StudentArray(n);
        student.insert(1111,"Redda",99);
        student.insert(1112,"Kidus",90);
        student.insert(1113,"Rahwa",69);
        student.insert(1114,"Kasech",42);
        //student.insert(1115,"Kasech",42);
        student.displayAll();
        System.out.print("---------------------------\n");
        student.delete(1112);

        student.displayAll();
        System.out.print("----------------------------\n");
        Student y=student.find(1111);
          if(y==null)
              System.out.print("not available");
          else
              y.displayStudent();
        System.out.print("----------------------------\n");
         student.maxMark().displayStudent();

        System.out.print("----------------------------\n");
         student.miniMark().displayStudent();
  }
}
