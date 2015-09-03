/**
 * 
 */
package controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.StringTokenizer;

import model.WoodItem; 
/**
 * @author Esteban
 *
 */
public class HardwoodSeller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String FILENAME = "input.txt";
		HardwoodSeller hws = new HardwoodSeller();
		hws.readInputFile(FILENAME);

	}
	
	public void readInputFile(String inputFilePath){
		BufferedReader br=null;
		StringReader srd=null;
		String line1=null;
		String line2=null;
		String buyer =null;
		String address=null;
		String date=null;
		String item=null;
		String[] Items=new String[10];
		String hardWoodType =null;
		int feet=0;
		Double price=0.0;
		Double baseDeliveryTime=0.0;
		Double deliveryTime=0.0;
		Double totalPrice=0.0;
		Double estimatedDeliveryTime=0.0;
		WoodItem woodItem[]=new WoodItem[10];
		
		try
		{
			br= new BufferedReader(new FileReader(inputFilePath));
			line1=br.readLine();
			line2=br.readLine();
			StringTokenizer stringToken = new StringTokenizer(line1, ";");
			System.out.println("Buyer Name: "+buyer);
			System.out.println("Address of Delivery: "+address);
			System.out.println("List of Ordered Woods");
			System.out.println("HardWoodType"+"\t"+"BF Purchased"+"\t"+"Price");
			while (stringToken.hasMoreTokens())
			{
				buyer = stringToken.nextElement().toString();
				address = stringToken.nextElement().toString();
				date = stringToken.nextElement().toString();				
			}
			StringTokenizer stringToken2 =new StringTokenizer(line2, ";");
			int i=0;
			while(stringToken2.hasMoreTokens())
			{
				Items[i]=stringToken2.nextElement().toString();
				i++;
			}
			/*for(int j=0;j<i;j++)
			{
				System.out.println(Items[j]);
			}*/
			for(int j=0;j<i;j++)
			{
				item=Items[j];
				StringTokenizer stringToken3 =new StringTokenizer(item, ":");
				while(stringToken3.hasMoreTokens())
				{
					hardWoodType=stringToken3.nextElement().toString();
					feet=Integer.parseInt(stringToken3.nextElement().toString());
					//System.out.println(hardWoodType+"    "+feet);
					WoodItem wi=new WoodItem();
					price=wi.getPrice(hardWoodType)*(double)feet;
					baseDeliveryTime=wi.getBaseDeliveryTime(hardWoodType);
					HardwoodSeller hws1=new HardwoodSeller();
					deliveryTime=hws1.deliveryTime(baseDeliveryTime, feet);
					System.out.println(hardWoodType+"\t\t"+feet+"\t\t"+price);
				}
				
				totalPrice=totalPrice+price;
				if(estimatedDeliveryTime<deliveryTime)
				{
					estimatedDeliveryTime=deliveryTime;
				}
			}
			
			System.out.println("Total Price: " + totalPrice);
			System.out.println("Estimated Delivery Time: "+estimatedDeliveryTime);
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Double deliveryTime(Double baseDeliveryTime, int feet){
		
		Double deliveryETA = 0.0;
		if(feet>=1 && feet<=100)
			deliveryETA=1*baseDeliveryTime;
		else if(feet>=101 && feet <=200)
			deliveryETA=2*baseDeliveryTime;
		else if(feet>=201 && feet <=300)
			deliveryETA=3*baseDeliveryTime;
		else if(feet>=301 && feet <=400)
			deliveryETA=4*baseDeliveryTime;
		else if(feet>=401 && feet <=500)
			deliveryETA=5*baseDeliveryTime;
		else if(feet>=501 && feet <=1000)
			deliveryETA=5.5*baseDeliveryTime;			
		return deliveryETA;
	}
	
}
