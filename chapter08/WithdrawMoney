
public double withdrawMoney(String accountIn, double amountIn)
{
    BankAccount acc = getItem(accountNumberIn);
    if(acc != null){
        if (acc.getBalance() >= amountIn) {
                acc.withdraw(amountIn);
                return acc.getBalance();
        }else{
                return -1; // throw new insufficient funds exception (custom exception, will be caught/handled by the method caller)
                break;
        }
    } else {
        return /* there is no account! PANIC! */ -2; // throw new no such account exception (custom exception, will be caught/handled by the method caller)
    }
}
