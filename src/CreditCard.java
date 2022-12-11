public class CreditCard
{
    private String accountHolder;
    private String personalPIN;
    private int balanceOwed;

    public CreditCard(String name, String personalPIN)
    {
        accountHolder = name;
        this.personalPIN = personalPIN;
        balanceOwed = 0;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setPersonalPIN(String personalPIN) {
        this.personalPIN = personalPIN;
    }

    public String getAccountHolder()
    {
        return accountHolder;
    }

    public int getBalanceOwed()
    {
        return balanceOwed;
    }

    /** Increases balanceOwed by the amount
     *
     *  @param amount  The amount of the credit card charge
     */
    public void chargeCard(int amount)
    {
        balanceOwed += amount;
    }

    /** Reduces balanceOwed by the amount
     *
     *  @param amount  The amount to reduce the balance
     */
    public void reduceBalance(int amount)
    {
        if (balanceOwed - amount < 0) balanceOwed = 0;
        else balanceOwed -= amount;
    }

    /** Checks to see if toCheckPIN matches personalPIN exactly;
     *  if so, return true, if not, return false.
     *
     *  @param toCheckPIN  The PIN to compare with personalPIN
     *
     *  @return  True if the PIN numbers match, otherwise return false
     */
    public boolean checkPIN(String toCheckPIN)
    {
        if (toCheckPIN.equals(personalPIN)) return true;
        else return false;
    }

    public String toString()
    {
        String str = "CreditCard holder: " + accountHolder;
        str += "\nBalance Owed: " + balanceOwed;
        str += "\nPIN: " + personalPIN;
        return str;
    }
}