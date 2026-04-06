import java.util.Scanner;
public class randomPasswordGenerator {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter how many random passwords you want to generate : ");
        int total=sc.nextInt();
        System.out.print("Enter the length of the passowrds you want : ");
        int length=sc.nextInt();

        if(length<3){
            
            System.out.println("Password length should be more than 3");
            return;
        }
        StringBuilder[]randomPasswords=new StringBuilder[total];
        for(int i=0;i<total;i++){
            StringBuilder randomPassword=new StringBuilder();
            randomPassword.append(getNumber());
            randomPassword.append(getLowercase());
            randomPassword.append(getUppercase());
            for(int j=3;j<length;j++){
                randomPassword.append(passwordGen());
            }
            char[] arr = randomPassword.toString().toCharArray();
            for (int k = 0; k < arr.length; k++) {
                int randIndex = (int)(Math.random() * arr.length);
                char temp = arr[k];
                arr[k] = arr[randIndex];
                arr[randIndex] = temp;
            }
            randomPasswords[i]=new StringBuilder(new String(arr));
        }
        printPassword(randomPasswords);
    }
    public static void printPassword(StringBuilder [] pass){
        for(int i=0;i<pass.length;i++){
            System.out.println(pass[i]);
        }
    }
    public static char passwordGen() {
        int rand=(int)(Math.random()*62);//0-9 =>10;'a'-'z'=>26;'A'-'Z'=>26 tottal=>62
        if(rand<=9){
            return(char)(rand+48);//bcoz ascii vlue of 0 is 48
            // return password;
        }else if(rand<=35){
            return (char)(rand+62);//bcoz ascii vlue of 'a' is 97 but we add 97-35=62
            // return password;

        }else{//i.e. between 36-61
            return (char)(rand+29);//bcoz ascii vlue of 'A' is 65 but we add 65-36=29
            // return password;
        }
        // return password;
        
    }
    public static char getUppercase(){
        return (char)('A'+(int)(Math.random()*26));
    }
    public static char getLowercase(){
        return (char)('a'+(int)(Math.random()*26));
    }
    public static  char getNumber(){
        return (char)('0'+(int)(Math.random()*10));
    }
}
