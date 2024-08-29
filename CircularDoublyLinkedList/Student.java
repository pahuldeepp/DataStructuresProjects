
public class Student {
    private String StudentName;
    private String StudentNumber;
public Student(){
    StudentNumber="Unknown";
    StudentName="Unknown";
}
public Student(String StudentNumber,String StudentName){
    this.StudentName=StudentName;
    this.StudentNumber=StudentNumber;
}
public String getStudentNumber(){
    return StudentNumber;
}
public String getStudentName(){
    return StudentName;
}
public void setStudentName(String StudentName){
    this.StudentName=StudentName;
}
public void setStudentNumber(String StudentNumber){
    this.StudentNumber=StudentNumber;
}
public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Student)) return false;

    Student other = (Student) o;

    return StudentNumber.equalsIgnoreCase(other.StudentNumber) &&
           StudentName.equalsIgnoreCase(other.StudentName);
}


public String toString(){
    return StudentNumber+" : "+StudentName;
}
}