package Lesson004;

public class Animal{
        void perfomBehavior(boolean state){
            class Brain{
                void sleep(){
                    if(state){
                        System.out.println("Sleeping");
                    }else{
                        System.out.println("Not sleeping");
                    }
                }
            }
            Brain brain = new Brain();
            brain.sleep();
        }
    
    }