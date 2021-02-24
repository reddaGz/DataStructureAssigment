package Assigment3.number2;

class Student {
    private int id;
    private String name;
    private int mark;

    //--------------------------------------------------------------
    public Student(int id, String name, int mark) { // constructor to initialize the values
        this.id = id;
        this.name = name;
        this.mark = mark;
    }

    //--------------------------------------------------------------
    public void displayStudent() {
      System.out.print("Id: "+id+" Name: "+name+" Mark: "+mark+"\n");
    }

    public int getId() {
        return id;
    }

    public int getMark() {
        return mark;
    }
}

    //-------------------------------------------------------------- public int getId() // get the Id
