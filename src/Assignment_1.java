import java.util.Scanner ;                            // import the Scanner class from the java.util package.

public class Assignment_1 
{

    public static void main(String[] args)           // main method.
    {        

            try (Scanner input = new Scanner(System.in)) 
            {
				// Get the number of salespeople.
				System.out.println("Enter the number of salespeople: ") ;  // prompt the user to enter the number of salespeople.
				int numSalespeople = input.nextInt() ;   // read the input from the user and store it in the numSalespeople variable.

				// Get the number of products.
				System.out.println("Enter the number of products: ") ;     // prompt the user to enter the number of products.
				int numProducts = input.nextInt() ;     // read the input from the user and store it in the numProducts variable.
				if(numSalespeople <= 5 && numProducts <= 4)
				{
					// Create a 2D array to store the sales data.
					double[][] sales = new double[numSalespeople][numProducts] ;   // create a 2D array with dimensions numSalespeople x numProducts to store the sales data.

					// Iterate over the salespeople.
					for (int i = 0 ; i < numSalespeople ; i++)   // loop over each salesperson.
					{
					    // Iterate over the products.
					    for (int j = 0 ; j < numProducts ; j++)   // loop over each product.
					    {
					        // Get the sales for the current salesperson and product.
					        System.out.println("Enter the sales for salesperson " + (i + 1) + " and product " + (j + 1) + ": ") ;    // prompt the user to enter the sales for the current salesperson and product.
					        sales[i][j] = input.nextDouble() ;    // read the input from the user and store it in the appropriate cell of the sales array.
					    }
					}

					// Calculate the total sales for each salesperson.
				    double[] totalSales = new double[numSalespeople] ;                 // create an array to store the total sales for each salesperson.
				    for (int i = 0 ; i < numSalespeople ; i++)                          // loop over each salesperson.
				    {
				        totalSales[i] = getSalesTotal(i+1, sales) ;                    //call method getSalesTotal.
				    }

				    // Calculate the total sales for each product.
				    double[] totalProductSales = new double[numProducts] ;             // create an array to store the total sales for each product.        
				    for (int i = 0 ; i < numProducts ; i++)                             // loop over each product.            
				    {
				        totalProductSales[i] = getProductTotal(i+1, sales) ;           //call method getProductTotal.          
				    }

					// Print the total sales for each salesperson.
					System.out.println("Salesperson\tTotal Sales") ;   // print a header for the salesperson sales table.
					for (int i = 0 ; i < numSalespeople ; i++)          // loop over each salesperson.
					{
					    System.out.println((i + 1) + "\t\t" + totalSales[i]) ;      // print the salesperson number and their total sales.
					}
				    
					//note:The '\t' character is used to create a tab between the two values.
					
					// Print the total sales for each product.
					System.out.println("Product\tTotal Sales") ;       // print a header for the product sales table.    
					for (int i = 0 ; i < numProducts ; i++)
					{
					    System.out.println((i + 1) + "\t\t" + totalProductSales[i]) ;       // print the product number and their total sales.   
					}
				} 
				else
				{
					System.out.println("Error!the company doesn't have these numbers!") ;
				}
			}
    }

 // This method calculates the total sales for a particular salesperson.
    public static double getSalesTotal(int salesperson, double[][] sales)
    {
        double totalSales = 0.0;
        for (int i = 0 ; i < sales[salesperson - 1].length ; i++)        // Iterate over all the products and add up the sales for the specified salesperson.
        {
            totalSales += sales[salesperson - 1][i] ;
        }
        return totalSales ;         // Return the total sales.     
    }

    // This method calculates the total sales for a particular product.
    public static double getProductTotal(int product, double[][] sales)
    {
        double totalSales = 0.0;
        for (int i = 0 ; i < sales.length ; i++)     // Iterate over all the salespeople and add up the sales for the specified product.        
        {
            totalSales += sales[i][product - 1] ;
        }
        return totalSales ;         // Return the total sales.
    }
}   //end...