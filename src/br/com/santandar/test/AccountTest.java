package br.com.santandar.test;

import br.com.santandar.classes.Account;
import br.com.santandar.exception.BusinessException;

import java.util.Scanner;
import java.util.Locale;

public class AccountTest {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        int number;
        String holder;
        float balance;
        float withdrawLimit;

        Scanner scan = new Scanner(System.in);

        System.out.print("Número da conta: ");
        number = scan.nextInt();
        System.out.print("Nome do titular: ");
        scan.nextLine();
        holder = scan.nextLine();
        System.out.print("Saldo inicial: ");
        balance = scan.nextFloat();
        System.out.print("Limite de saque: ");
        withdrawLimit = scan.nextFloat();

        Account account = new Account(number, holder, balance, withdrawLimit);

        System.out.print("\nInforme uma quantia para sacar: ");
        try {
            account.withdraw(scan.nextFloat());
            System.out.printf("Novo saldo: %.2f%n",account.getBalance());
        }
        catch(BusinessException e){
            System.out.println(e.getMessage());
        }
        scan.close();
    }
}
