package com.driver;

public class Email {

    private String emailId;
    private String password;
    private boolean isUpperCase;
    private boolean isLowerCase;
    private boolean isDigit;
    private boolean isSpecialChar;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if(oldPassword.equals(this.password)){
            if(isValidPass(newPassword))
            {
                System.out.println("Password changed successfully!");
                this.password=newPassword;
            }
            else{
                System.out.println("The new password is not valid!");
            }
        }
        else{
            System.out.println("The given password does not match current password!");
        }
    }
    public boolean isValidPass(String pass)
    {
        int n =pass.length();
        if(n<8)
            return false;
        //check upperCase
        for(int i=0;i<n;i++)
        {
            char c = pass.charAt(i);
            if(pass.charAt(i)>='A' && pass.charAt(i)<='Z')
            {
                isUpperCase=true;
            }
            else if(pass.charAt(i)>='a' && pass.charAt(i)<='z')
            {
                isLowerCase=true;
            }
            else if(pass.charAt(i)>='0' && pass.charAt(i)<='9')
            {
                isDigit=true;
            }
            else
            {
                isSpecialChar=true;
            }
        }

        return isSpecialChar && isDigit && isUpperCase && isLowerCase;
    }
}
