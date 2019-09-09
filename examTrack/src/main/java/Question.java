/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Question { // It is an abstract class which declares type Question in general . Each question has an identification number and a text of the question itself. 
   // I also created two constructurs one which let me create an empty object and the other which will take the atributes and assign them to object. 
    
    int identification_number;
    String question;
    Question ()
    {
        
    }
    Question (int identification_number1, String question1)
    {
        this.identification_number = identification_number1;
        this.question = question1;
    }
    
}
