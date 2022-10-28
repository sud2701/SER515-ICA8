package src;

/*

Author - Sudheer Reddy Kunduru
skundur1@asu.edu
1226291354

 */


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Urinals {
    public static void main(String[] args) throws IOException {
        urinalUsage();

    }
    public static boolean isValid(String inpstr){
        int len=inpstr.length();
        if(len==0 || len > 20){
            return false;
        }
        for(int i=0;i<len;i++){
            if(inpstr.charAt(i)=='0' || inpstr.charAt(i)=='1'){
                if(i==0){
                    if(i+1<len) {
                        if (inpstr.charAt(i) == '1' && inpstr.charAt(i + 1) == '1')
                            return false;
                    }
                }
                else if(i==len-1){
                        if (inpstr.charAt(i) == '1' && inpstr.charAt(i - 1) == '1')
                            return false;
                }
                else{
                    if(inpstr.charAt(i)=='1' && (inpstr.charAt(i+1)=='1' || inpstr.charAt(i-1)=='1'))
                        return false;
                }
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static int countUrinals(String inpstr){
        boolean b=isValid(inpstr);
        if(!b){
            return -1;
        }
        int len=inpstr.length();
        if(len==0){
            return -1;
        }
        if(len==1){
            if(inpstr.equals("0"))
                return 1;
            else return 0;
        }
        if(len==2){
            if(inpstr.equals("00"))
                return 1;
            else return 0;
        }
        int count=0;
        char[] letters = new char[len];
        for(int j=0;j<len;j++){
            letters[j]=inpstr.charAt(j);
        }
        for(int i=0;i<len;i++){
            if(letters[i]=='0'){
                if(i==0){
                        if (letters[i + 1] == '0') {
                            count += 1;
                            letters[i] = 1;
                        }
                }
                else if(i==(len-1)){
                        if (letters[i - 1] == '0') {
                            count += 1;
                            letters[i] = 1;
                        }
                }
                else{
                    if(letters[i+1]=='0' && letters[i-1]=='0'){
                        count+=1;
                        letters[i]=1;
                    }
                }
            }
        }
        return count;
    }

    public static String getKeyboardString(){
        Scanner x=new Scanner(System.in);
        return x.nextLine();
    }

    public static ArrayList<String> getFileString(String filename) throws IOException {
        ArrayList<String> strings= new ArrayList<>();
        String str;
        System.out.println("Inside getFileString");
        BufferedReader br=new BufferedReader(new FileReader(filename));
        str=br.readLine();
        while(str!=null && !str.equals("-1")){
            strings.add(str);
            str=br.readLine();
        }
        return strings;
    }

    public static void urinalUsage() throws IOException {
        int counter=0;
        System.out.println("Welcome to the Program!!");
        System.out.println("These are your choices: ");
        System.out.println("1. Enter input via keyboard");
        System.out.println("2. Read input from a keyboard");
        System.out.println("Please enter your choice: ");
        Scanner x = new Scanner(System.in);
        int ch=x.nextInt();
        switch(ch){
            case 1 :
                while(true) {
                    System.out.println("Please enter the string: ");
                    int c = countUrinals(getKeyboardString());
                    if (c == -1) {
                        System.out.println(c + "(Invalid Input String)");
                    } else {
                        System.out.println("Number of Urinals: " + c);
                    }
                    System.out.println("Do you wish to continue??[0(No)/ 1(Yes)]");
                    int choice=x.nextInt();
                    if(choice==0)
                        break;
                }
                break;
            case 2:
                String filename;
                System.out.println("Reading inputs from the file.....");
                ArrayList<String> inputs=getFileString("src/urinal.dat");
                filename="outputs/rules"+ counter +".txt";
                File file = new File(filename);
                while(file.exists()){
                    counter+=1;
                    filename="outputs/rules"+ counter +".txt";
                    file=new File(filename);
                }
                FileWriter f=new FileWriter(filename,true);
                for (String input : inputs) {
                    System.out.println("Input - " + input + " Output - " + countUrinals(input));
                    f.append(String.valueOf(countUrinals(input)));
                    f.append("\n");
                }
                f.close();
                System.out.println("Made changes to "+filename);
                break;
            default:
                System.out.println("Please enter a valid choice: ");
                break;
        }
    }

}

