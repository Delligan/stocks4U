
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Char-dell
 */
public class StockIO
{

    //attributes
    private String fileName;

    //constructors
    //default
    public StockIO()
    {
        fileName = "Stocks.txt";
    }

    //let user pick the name 
    public StockIO(String fileName)
    {
        setFileName(fileName);
    }

    //behavior
    public ArrayList<Stock> getData()
    {
        ArrayList<Stock> data = new ArrayList<Stock>();

        try
        {
            //load the array list with the data from the file
            BufferedReader inFile = new BufferedReader(new FileReader(fileName));
            String inputLine = "";
            StringTokenizer tokens;
            
            //get first line
            inputLine = inFile.readLine();
            
            //cycle through the file and read line by line 
            while (inputLine != null)
            {
               //break the Line into parts -- 
                tokens = new StringTokenizer(inputLine, ",");
                String company = tokens.nextToken();
                double shares = Double.parseDouble(tokens.nextToken());
                double pPrice = Double.parseDouble(tokens.nextToken());
                double cPrice = Double.parseDouble(tokens.nextToken());
                
                // create Stock object and add to arrayList 
                Stock stk = new Stock(company, shares, pPrice, cPrice);
                data.add(stk);
                
                //read the next line in the file
                inputLine = inFile.readLine();
                
                //close file
                inFile.close();
            }   
            
            
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Error. Unable to write to the file:" + ex.getMessage(), fileName, JOptionPane.ERROR_MESSAGE);

        }
        //return the arraylist
        return data;
    }

    public void saveData(ArrayList<Stock> data)
    {
        //Apple,100, 55.0,80.

        //create a line to the file
        BufferedWriter outFile;
        try
        {
            outFile = new BufferedWriter(new FileWriter(fileName));

            //write the stocks by cyclingthrough the data
            for (int i = 0; i < data.size(); i++)
            {
                Stock stk = data.get(i);
                outFile.write(stk.getCompanyName() + ',');
                outFile.write("" + stk.getNumberofShares() + ',');
                outFile.write("" + stk.getPurchasePrice() + ',');
                outFile.write("" + stk.getCurrentPrice());
                outFile.newLine(); //Enter Key Drop to next line               
            }
            outFile.close();
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Error. Unable to write to the file:" + ex.getMessage(), fileName, JOptionPane.ERROR_MESSAGE);
        }

    }

    //getters and setter    //getters and setter
    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        if (fileName.length() > 0)
        {
            this.fileName = fileName;
        } else
        {
            this.fileName = "Stocks.txt";
        }

    }
    /*
    
    
     */
}
