
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;



class Exam { // class ecam which is a main class in a system. Contains of name of the exam , lecturer which supervises the exam and 3 array lists of 3 diffrent types of questions
    
    String nameOfTheExam;
    Person lecturer = new Person (); 
  ArrayList<ClosedQuestion> Clist = new ArrayList<ClosedQuestion>();
  ArrayList<ShortQuestion> Slist = new ArrayList<ShortQuestion>();
  ArrayList<LongQuestion> Llist = new ArrayList<LongQuestion>();
   
 

    Exam()
    
    {
    }
  
 
}





