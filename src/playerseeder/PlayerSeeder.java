/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playerseeder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Daroface
 */
public class PlayerSeeder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ArrayList<String> playersList;
        File reader;
        BufferedReader buffer;
        String fileName;
        Scanner input;
        String line;
        Random randomNumber = new Random();
        int amountOfPlayers;
        int number;
        int position;
        playersList = new ArrayList<>();
        while(true)
        {
            System.out.println("Insert file name");
            input = new Scanner(System.in);
            fileName = input.nextLine(); 
            try
            {
                if(fileName.equals("0"))
                {
                    break;
                }
                amountOfPlayers = 0;
                position = 5;
                reader = new File(fileName);
                buffer = new BufferedReader(
		   new InputStreamReader(
                      new FileInputStream(reader), "Windows-1250"));
                while((line = buffer.readLine()) != null)
                {
                    playersList.add(line);
                    amountOfPlayers += 1;
                }
                for(int i = amountOfPlayers; i > 0; i--)
                {
                    number = randomNumber.nextInt(i);
                    System.out.println(position + ". " + playersList.get(number));
                    playersList.remove(number);
                    position++;
                }
            }
            catch(FileNotFoundException e)
            {
                System.out.println(e.getMessage());
            }
            catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
        // TODO code application logic here
    }
    
}
