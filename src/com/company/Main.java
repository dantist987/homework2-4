package com.company;

public class Main {

    public static void main(String[] args) throws LimitException {

        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(20000);

        while (bankAccount.getAmount() > 0) {
            int sumToWithdraw = 6000;
            try {
                bankAccount.withDraw(sumToWithdraw);
                System.out.println("Снято " + sumToWithdraw + ". Остаток " + bankAccount.getAmount() + ".");
            } catch (LimitException e) {
                sumToWithdraw = (int) bankAccount.getAmount();
                System.out.println("Недостаточно средств. Снимаем остаток " + e.getRemainingAmount() + ".");
                bankAccount.withDraw(sumToWithdraw);
            }

        }
    }

}
