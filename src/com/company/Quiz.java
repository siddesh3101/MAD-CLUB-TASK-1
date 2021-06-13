package com.company;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

abstract class Topic {
    abstract public void TopicName();
    abstract public void Questions();


}

interface result{
    void correct();
    void incorrect();
    String finalscore();

}


public class Quiz {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("~General Instructions before starting the quiz:\ni)The quiz comprises of 2 topics.\nii)Each topic contains four multiple choice question.\n" +
                "iii)Out of this options only one option is correct.\niv)For each right answer you will be awarded 1 marks.\n" +
                "v)Attempting all the questions is compulsory.There is no negative marking in the quiz.\n" +
                "vi)All the answers are case sensitive so kindly keep your capslock on.\n" +
                "vii)If the correct answer is option A then Type: A and hit enter. ");
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("~If you have read the instructions and if ready to begin then press 0.");
        String response = sc.nextLine();
        int digit1;
        while (true) {
            if (response.length() == 1) {
                try {
                    digit1 = Integer.parseInt(response);
                    break;


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            System.out.println("(" + response + ") " + "unrecognizable " + " Please enter 0 to continue Thank you. ");
            response = sc.nextLine();
        }
        System.out.println("Chose the topic for todays quiz from:\n1)General Knowledge on India.\n2)Sports.");

        String Q1 = "Which among the following is the National capital of india?\n" +
                "(A)Punjab\n(B)Kerala\n(C)Maharashtra\n(D)New Delhi\n";
        String Q2 = "Who was the first woman Prime Minister of India?\n" +
                "(A)Smriti Irani\n(B)Kasturba Gandhi\n(C)Indira Gandhi\n(D)Priyanka Gandhi";
        String Q3 = "Which of the following is the capital of Arunachal Pradesh?\n" +
                "(A)Dispur\n(B)Itanagar\n(C)Imphal\n(D)Panaji";
        String Q4 = "Which among the following is the largest state of india?\n" +
                "(A)Rajasthan\n(B)Maharashtra\n(C)Goa\n(D)Madhya Pradesh.";
        String Q5 = "Who is the winner of the US Open 2019 Men's title?\n" +
                "(A)Roger Federer\n(B)Rafael Nadal\n(C)Daniil Medvedev\n(D)Novak Djokovic";
        String Q6 = "What is the new name of Feroz Shah Kotla ground?\n" +
                "(A)Arun Jaitley Stadium\n(B)Sheila Dikshit Stadium\n(C)Gautam Gambhir Stadium\n(D)Ajit Wadekar Stadium";
        String Q7 = "Which of the following region has won the Ranji Trophy tournament 2019?\n" +
                "(A)Saurashtra\n(B)Mumbai\n(C)Vidarbha\n(D)Rajasthan";
        String Q8 = "Which of the following trophy/ is not related to Cricket in India?\n" +
                "(A)Syed Mushtaq Ali Trophy\n(B)Deodhar Trophy\n(C)Santosh Trophy\n(D)Madhya Pradesh.";

        QuestionModule[] questionsindia = {
                new QuestionModule(Q1,"D"),
                new QuestionModule(Q2, "C"),
                new QuestionModule(Q3, "B"),
                new QuestionModule(Q4, "A")};

        QuestionModule[] questionssports = {
                new QuestionModule(Q5, "B"),
                new QuestionModule(Q6, "A"),
                new QuestionModule(Q7, "C"),
                new QuestionModule(Q8, "C")};


        int digit;
        String response1 = sc.nextLine();
        while (true) {
            if (response1.length() == 1) {
                try {
                    digit = Integer.parseInt(response1);
                    break;


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("(" + response1 + ") " + "unrecognizable " + " Please enter 1 0r 2 to continue Thank you. ");
            response = sc.nextLine();
        }
        GKonindia gk = new GKonindia();
        Sports sports = new Sports();
        switch (response) {
            case "0":
                System.out.println("Press 1 or 2 to continue.");
            case "1":
                gk.TopicName();
                gk.Questions();
                taketest(questionsindia);
                break;
            case "2":
                sports.TopicName();
                sports.Questions();
                taketest(questionssports);

        }

        //takeTest(questionsindia);
        System.out.println("Do you wish to continue." +
                "Press 0 for yes and 1 for no.");
//        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        if (input1 == 0) {
            main(args);
        } else {
            System.exit(100);
        }
    }




    static class GKonindia extends Topic {
        @Override
        public void TopicName() {
            System.out.println("General Knowledge is your selected topic all the best.");
        }

        @Override
        public void Questions() {
            System.out.println("~General Knowledge on india~");
        }
    }

    static class Sports extends Topic {
        @Override
        public void TopicName() {
            System.out.println("Sports is your selected topic all the best.");
        }

        @Override
        public void Questions() {
            System.out.println("~Sports~");
        }

    }

    static class questionmodel implements result {
        int score = 0;

        @Override
        public void correct() {
            System.out.println("Your answer is correct.");
            score++;
        }

        @Override
        public void incorrect() {
            System.out.println("You answer is wrong.");
        }

        @Override
        public String finalscore() {
            System.out.println("Your final score is: " + score + "/" + "4");
            return "Thank you for participating in quiz";
        }
    }
    public static void taketest(QuestionModule[] questions){
        int n1=4;
        ArrayList<Integer> nums1 = new ArrayList<Integer>(n1);
        for (int i = 0;i<n1;i++){
            nums1.add(i);
        }
        Random rc1 = new Random();
        questionmodel q1 = new questionmodel();

        for (int i = 0; i < questions.length; i++) {
            int index = rc1.nextInt(nums1.size());
            int a = nums1.remove(index);
            System.out.println(questions[a].promt);
            Scanner keyboard = new Scanner(System.in);
            String answer = keyboard.nextLine();
            if (answer.equals(questions[a].answer)) {
                q1.correct();

            } else {
                q1.incorrect();
                System.out.println("Correct option is " + questions[a].answer);
            }


        }
        System.out.println(q1.finalscore());
    }
}
