import java.util.Scanner;

class FederalIncomeTaxClient{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    // Prompt the user to enter filing status
    System.out.print(
      "(0-single filer, 1-married jointly or qualifying widow(er), "
      + "\n2-married separately, 3-head of household)\n" +
      "Enter the filing status: ");
    int status = input.nextInt();

    // Prompt the user to enter taxable income
    System.out.print("Enter the taxable income: ");
    double income = input.nextDouble();

    FederalIncomeTax client = new FederalIncomeTax(status, income);

    System.out.println("The tax of the client is " + client.getTax());
  }
}
