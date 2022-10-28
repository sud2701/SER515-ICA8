package src;

/*

Author - Sudheer Reddy Kunduru
skundur1@asu.edu
1226291354

 */


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class urinals {
    public static void main(String[] args){

    }
    public boolean isValid(String inpstr){
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
                    if(i-1>=0) {
                        if (inpstr.charAt(i) == '1' && inpstr.charAt(i - 1) == '1')
                            return false;
                    }
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

    public int countUrinals(String inpstr){
        boolean b=isValid(inpstr);
        if(b==false){
            return -1;
        }
        int len=inpstr.length();
        if(len==0){
            return -1;
        }
        if(len==1 || len==2){
            return 1;
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
            else{
                count+=1;
            }
        }
        return count;
    }

    public String getKeyboardString(){
        Scanner x=new Scanner(System.in);
        return x.nextLine();
    }

    public ArrayList<String> getFileString() throws IOException {
        ArrayList<String> strings=new ArrayList<>();
        String str;
        BufferedReader br=new BufferedReader(new FileReader("urinal.dat"));
        str=br.readLine();
        while(str!=null || str!="-1"){
            strings.add(str);
        }
        return strings;
    }

}

