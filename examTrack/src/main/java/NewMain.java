
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Karolina Bargiel
 * Software Engineering lab 2
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        generateExamForStudent(); // function that generates the txt file with the Example exam 
        generateExamForProfessor();// function that generates the txt file with the Example exam and answeres
        readTheExam(); // function that reads the exam from txt file and prints them to console
        
    /**}
     *
     */
    }
    public static void generateExamForStudent()
    {
          
        Exam example_Exam = new Exam(); // intializaion of an instance of class Exam
        
        example_Exam.nameOfTheExam ="Software Engineering Exam"; // I give the name to the Exam
        example_Exam.lecturer.identificationNumber = 1; // give the leturer an identifivation number
        example_Exam.lecturer.name = "Prof. Bruno"; // and the name of ther proessor
        
         Person student = new Person ();
         student.name ="Karolina"; // name the student
         
        ArrayList<ClosedQuestion> closedQuestionexample = new ArrayList <ClosedQuestion>();// initliazing an arrayList of Closed qustions and the unsing function getExampleClosedQuestion to give the value to array
                closedQuestionexample = getexampleClosedQuestions();
                
        ArrayList<ShortQuestion> shortQuestionexample = new ArrayList <ShortQuestion>();//repeating a steps for short questions
                shortQuestionexample = getexampleShortQuestions();
                
        ArrayList<LongQuestion> longQuestionexample = new ArrayList <LongQuestion>();// reapeting a steps for long questions
               longQuestionexample = getexampleLongQuestions();
                
        example_Exam.Clist = closedQuestionexample; //adding the questions to the 3 lists in exam object 
        example_Exam.Slist = shortQuestionexample;// reapiting the above step for list of short questions
        example_Exam.Llist = longQuestionexample;// resptiing the above for list of long questions
        PrintWriter writer = null; // I intilize new print writer , surround the stsatment by try and catch just in case the txt file coudn't be created
        try {
            writer = new PrintWriter("examForStudent.txt", "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        writer.println(example_Exam.nameOfTheExam); // I write onto examForStudent.txt file the name of the exam, lecturers name and stduent name
        writer.println(example_Exam.lecturer.name);
        writer.println(student.name);
        
        for (int x=0; x<example_Exam.Clist.size(); x++) // I loop through the list of closed questions and put the question and 4 possible answers to the examForStudent.txt
            {
         writer.print(example_Exam.Clist.get(x).identification_number +"."); 
         writer.println(example_Exam.Clist.get(x).question);
         writer.println(example_Exam.Clist.get(x).answer_A);
         writer.println(example_Exam.Clist.get(x).answer_B);
         writer.println(example_Exam.Clist.get(x).answer_C);
            }
        
          for (int x=0; x<example_Exam.Slist.size(); x++)// I loop through the list of short questions and repeat the above step
            {
         writer.print(example_Exam.Slist.get(x).identification_number +".");
         writer.println(example_Exam.Slist.get(x).question);
         writer.println(".............");
            }
           for (int x=0; x<example_Exam.Llist.size(); x++) // I do the same for long question
            {
         writer.print(example_Exam.Llist.get(x).identification_number +".");
         writer.println(example_Exam.Llist.get(x).question);
         writer.println(".........................................");
         writer.println(".........................................");
         writer.println(".........................................");
            }
      
        
        writer.close();

       
    }
    
     public static void generateExamForProfessor() // this function is a mirror function to the discribed and commented above. Just this time the ain of the fuction is to generate a txt exam for professor which means besides the questions under each point there will also be a correct/suggested answer. 
    {
          
        Exam example_Exam = new Exam();
        
        example_Exam.nameOfTheExam ="Software Engineering Exam";
        example_Exam.lecturer.identificationNumber = 1;
        example_Exam.lecturer.name = "Prof Bruno";
         Person student = new Person ();
         student.name ="XXXX";
         
        ArrayList<ClosedQuestion> closedQuestionexample = new ArrayList <ClosedQuestion>();
                closedQuestionexample = getexampleClosedQuestions();
                
        ArrayList<ShortQuestion> shortQuestionexample = new ArrayList <ShortQuestion>();
                shortQuestionexample = getexampleShortQuestions();
                
        ArrayList<LongQuestion> longQuestionexample = new ArrayList <LongQuestion>();
               longQuestionexample = getexampleLongQuestions();
                
        example_Exam.Clist = closedQuestionexample;
        example_Exam.Slist = shortQuestionexample;
        example_Exam.Llist = longQuestionexample;
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("examForProf.txt", "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        writer.println(example_Exam.nameOfTheExam);
        writer.println(example_Exam.lecturer.name);
        writer.println(student.name);
        
        for (int x=0; x<example_Exam.Clist.size(); x++)
            {
         writer.print(example_Exam.Clist.get(x).identification_number +".");
         writer.println(example_Exam.Clist.get(x).question);
         writer.println(example_Exam.Clist.get(x).answer_A);
         writer.println(example_Exam.Clist.get(x).answer_B);
         writer.println(example_Exam.Clist.get(x).answer_C);
         writer.println("Correct answer" + example_Exam.Clist.get(x).correct_answer);
            }
        
          for (int x=0; x<example_Exam.Slist.size(); x++)
            {
         writer.print(example_Exam.Slist.get(x).identification_number +".");
         writer.println(example_Exam.Slist.get(x).question);
         writer.println("...............");
         writer.println("Correct answer" +example_Exam.Slist.get(x).exampleanswer);
            }
           for (int x=0; x<example_Exam.Llist.size(); x++)
            {
         writer.print(example_Exam.Llist.get(x).identification_number +".");
         writer.println(example_Exam.Llist.get(x).question);
         writer.println(".......................................................................");
         writer.println(".......................................................................");
         writer.println(".......................................................................");
         writer.println("Example answer/markscheme" +example_Exam.Llist.get(x).markscheme);
            }
      
        
        writer.close();

        
    }
  
     public static  ArrayList<ClosedQuestion> getexampleClosedQuestions() // this function returns the example list of closed questions , which are then used in a document
    {
        
        ArrayList<ClosedQuestion> exampleList= new ArrayList<ClosedQuestion>(); // I firstly declare an array of Closed Questions, and then the 3 example questions
        ClosedQuestion cQ1 = new ClosedQuestion();
        ClosedQuestion cQ2 = new ClosedQuestion();
        ClosedQuestion cQ3 = new ClosedQuestion();
        
        cQ1.identification_number = 1; // I assign values to each of the example question
        cQ1.question = "Is a zebra black or white?";
        cQ1.answer_A = "A) Black";
        cQ1.answer_B ="B) White";
        cQ1.answer_C ="C) Both";
        cQ1.correct_answer = cQ1.answer_C; // the correct answer is answer C
        
        cQ2.identification_number = 2;
        cQ2.question = "Is A bigger than B?";
        cQ2.answer_A = "A)NO";
        cQ2.answer_B ="B)YES";
        cQ2.answer_C ="C)I don't know";
        cQ2.correct_answer = cQ2.answer_A;
        
        cQ3.identification_number = 3;
        cQ3.question = "2+1 is...";
        cQ3.answer_A = "A) 3";
        cQ3.answer_B ="B) 4";
        cQ3.answer_C ="C) 5";
        cQ3.correct_answer = cQ3.answer_A;
        
        
        exampleList.add(cQ1); // I add 3 questions to my list of closed questions
        exampleList.add(cQ2);
        exampleList.add(cQ3);
        return exampleList; // and return the example list
        
      
    }
     
      public static  ArrayList<ShortQuestion> getexampleShortQuestions() // I mirror the above reasoning for Short Questions
    {
        
        ArrayList<ShortQuestion> exampleListS= new ArrayList<ShortQuestion>();
        ShortQuestion sQ1 = new ShortQuestion();
        ShortQuestion sQ2 = new ShortQuestion();
        ShortQuestion sQ3 = new ShortQuestion();
        
        sQ1.identification_number = 4;
        sQ1.question = "The name of Columbus is...";
        sQ1.exampleanswer ="Christopher";
        
        
        sQ2.identification_number = 5;
        sQ2.question = "The sky is...";
        sQ2.exampleanswer ="Blue";
        
        sQ3.identification_number = 6;
        sQ3.question = "The grass is?";
        sQ3.exampleanswer ="Green";
 
        
        exampleListS.add(sQ1);
        exampleListS.add(sQ2);
        exampleListS.add(sQ3);
        
        return exampleListS; 
        
      
    }
      public static  ArrayList<LongQuestion> getexampleLongQuestions() // I mirror the above reasoning for long questions
    {
        
        ArrayList<LongQuestion> exampleListL= new ArrayList<LongQuestion>();
        LongQuestion lQ1 = new LongQuestion();
        LongQuestion lQ2 = new LongQuestion();
        LongQuestion lQ3 = new LongQuestion();
        
        lQ1.identification_number = 7;
        lQ1.question = "What is Software Engieering?";
        lQ1.markscheme ="Depends, on the factors";
        
        lQ2.identification_number = 8;
        lQ2.question = "Elaborate on the defintion of agile SD?";
        lQ1.markscheme ="Depends";  
        
        lQ3.identification_number = 9;
        lQ3.question = "How to study efficently?";
        lQ3.markscheme ="Depends";
        
        exampleListL.add(lQ1);
        exampleListL.add(lQ2);
        exampleListL.add(lQ3);
       
        return exampleListL; 
        
      
    }

    private static void readTheExam() throws FileNotFoundException, IOException { // Fuction whcih read the exam from a file and then print it to the console
        File file = new File("examForStudent.txt");  // I declare a new file which is called "examForStudent.txt"
  
            BufferedReader br = new BufferedReader(new FileReader(file));  // I declare a new Buffered Reader
           
            
            System.out.println("Welcome to your exam, answer the below questions"); // I print the first statement 
            String st; 
           
            while ((st = br.readLine()) != null) // And loop through the file printing every line to the console as long as the line is not empty. I know I can do it as in my examForStudnet.txt file there are not empty lines till the end of document
            {
             System.out.println(st); 

            }
            
          
  

    }

}

    

